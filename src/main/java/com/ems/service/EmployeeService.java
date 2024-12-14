package com.ems.service;

import java.util.List;

import com.ems.Dto.EmployeeDto;

public interface EmployeeService {
	
	List<EmployeeDto> getAllEmployee();
	EmployeeDto getEmployeeById(Long id);
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmployee(EmployeeDto employeeDto,Long id);
	void deleteEmployee(Long id);
	
	List<EmployeeDto> findByJobLevel(int jobLevel);
	
	
	

}
