package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.Dto.EmployeeDto;
import com.ems.service.EmployeeService;
@CrossOrigin("http://agile-cooperation-production.up.railway.app")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController { 

	@Autowired
	EmployeeService employeeService;
	@PostMapping("/create/")
 ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employee) {
		
		return new ResponseEntity<EmployeeDto>( employeeService.createEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	ResponseEntity<List<EmployeeDto>> getAllEmploees(){
		
		
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
		
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeById(id),HttpStatus.OK);
		
		
	}
	
	@GetMapping("/sort/{jobLevel}")
	ResponseEntity<List<EmployeeDto>> getEmployeeByJobLevel(@PathVariable int jobLevel){
		
		return new ResponseEntity<List<EmployeeDto>>(employeeService.findByJobLevel(jobLevel),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable Long id){
		
		return new  ResponseEntity<EmployeeDto>(employeeService.updateEmployee(employeeDto, id),HttpStatus.OK);
		
		
	}
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		return new  ResponseEntity<String>("employee deleted",HttpStatus.OK);
	}
	
}
