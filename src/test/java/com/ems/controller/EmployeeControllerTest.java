package com.ems.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ems.Dto.EmployeeDto;

import com.ems.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ch.qos.logback.core.net.ObjectWriter;
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeService employeeService;
	private EmployeeDto employee1;
	private EmployeeDto employee2;
	List<EmployeeDto> employeeList=new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		employee1=new EmployeeDto((long) 1,"warren", "Buffett","warren@gmail.com" , 22222, 1);

		employee2=new EmployeeDto((long) 2,"donald", "trump","donald@gmail.com" , 222022, 2);
	employeeList.add(employee1);
	employeeList.add(employee2);
	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateEmployee() throws Exception {
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		com.fasterxml.jackson.databind.ObjectWriter objectWriter=mapper.writer().withDefaultPrettyPrinter();
		String requestJson=objectWriter.writeValueAsString(objectWriter);
		when(employeeService.createEmployee(employee1)).thenReturn(employee1);
		this.mockMvc.perform(post("/api/employee/")
		.contentType(MediaType.APPLICATION_JSON)
		.content(requestJson))
		.andDo(print()).andExpect(status().isCreated());
		
		
	}

	@Test
	void testGetAllEmploees() throws Exception {
		
when(employeeService.getAllEmployee()).thenReturn(employeeList);
		
		this.mockMvc.perform(get("/api/employee/")).andDo(print()).andExpect(status().isOk());
		
		
	}

	@Test
	void testGetEmployeeById() throws Exception {
		
		when(employeeService.getEmployeeById((long)1)).thenReturn(employee1);
		
		this.mockMvc.perform(get("/api/employee/1")).andDo(print()).andExpect(status().isOk());
		
	}

	@Test
	void testUpdateEmployee() throws Exception {
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		com.fasterxml.jackson.databind.ObjectWriter objectWriter=mapper.writer().withDefaultPrettyPrinter();
		String requestJson=objectWriter.writeValueAsString(objectWriter);
		when(employeeService.updateEmployee(employee1,(long) 1)).thenReturn(employee1);
		this.mockMvc.perform(put("/api/employee/1")
		.contentType(MediaType.APPLICATION_JSON)
		.content(requestJson))
		.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testDeleteEmployee() throws Exception {

		employeeService.deleteEmployee((long) 1);
		 
		
		this.mockMvc.perform((delete("/api/employee/1"))).andDo(print()).andExpect(status().isOk());

	}

}
