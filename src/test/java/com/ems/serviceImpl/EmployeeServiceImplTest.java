package com.ems.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.ems.Dto.EmployeeDto;
import com.ems.Exception.ResourceNotFoundException;
import com.ems.entity.Employee;
import com.ems.modelmapper.EmployeeModelMapper;
import com.ems.repository.EmployeeRepo;


class EmployeeServiceImplTest {
	
	@Mock
	
	private EmployeeRepo employeeRepo;
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	AutoCloseable autoCloseable;
	Employee employee;
	
	

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable=MockitoAnnotations.openMocks(this);
		
		employee=new Employee((long) 1,"julkin", "george", "julkin@gmail.com",20000,1);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testGetAllEmployee() {
	 
		
		when(employeeRepo.findAll()).thenReturn(
				new ArrayList<Employee>( Collections.singleton(employee)));
		assertThat(employeeService.getAllEmployee().get(0).getEmail()).isEqualTo(employee.getEmail());
		
		
	}

	@Test
	void testGetEmployeeById() {
	 
		   when(employeeRepo.findById(1L)).thenReturn(Optional.of(employee));
		   assertEquals(employeeService.getEmployeeById((long) 1).getFirstName(), employee.getFirstName());
		
		
		
	}

	@Test
	void testCreateEmployee() {
		
	 
		
		when(employeeRepo.save(employee)).thenReturn(employee);
		
		EmployeeDto employDto=EmployeeModelMapper.toDto(employee);
		

		
		EmployeeDto reulst=employeeService.createEmployee(employDto);
		
		assertThat(reulst).isEqualTo(employDto);
	

		
	
	}

	@Test
	void testUpdateEmployee() {
 
		   when(employeeRepo.findById(1L)).thenReturn(Optional.of(employee)); 
		when(employeeRepo.save(employee)).thenReturn(employee);
		
		EmployeeDto employDto=EmployeeModelMapper.toDto(employee);

		
		EmployeeDto reulst=employeeService.updateEmployee(employDto,(long) 1);
		
		assertThat(reulst).isEqualTo(employDto);
		   verify(employeeRepo, times(1)).findById(1L);
	}

	@Test
	void testDeleteEmployee() {
 
		
	
		employeeRepo.delete(employee);
		 
		
		 verify(employeeRepo,times(1)).delete(employee);
		  
	}
	 @Test
	    void testDeleteEmployee_EmployeeNotFound() {
	        when(employeeRepo.findById(2L)).thenReturn(Optional.empty());

	        ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class, () -> {
	            employeeService.deleteEmployee((long) 2);
	        });

	        assertEquals("employee not exists with id:" + 2, thrown.getMessage());
	        verify(employeeRepo, times(1)).findById(2L); // Ensure findById was called
	        verify(employeeRepo, times(0)).delete(employee); // Ensure delete was not called
	    }
}
