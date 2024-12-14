package com.ems.modelmapper;

import com.ems.Dto.EmployeeDto;
import com.ems.entity.Employee;

public class EmployeeModelMapper {
	 public static EmployeeDto toDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getSalary(),
				employee.getJobLevel());
		 
		 
	 }
	 public static Employee toEmployee(EmployeeDto employDto) {
		 
		 return new Employee(
				 employDto.getId(),
				 employDto.getFirstName(),
				 employDto.getLastName(),
				 employDto.getEmail(),
				 employDto.getSalary(),
				 employDto.getJobLevel());
		 
	 }
	

}
