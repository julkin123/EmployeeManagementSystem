package com.ems.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.Dto.EmployeeDto;
import com.ems.Exception.ResourceNotFoundException;
import com.ems.entity.Employee;
import com.ems.modelmapper.EmployeeModelMapper;
import com.ems.repository.EmployeeRepo;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public List<EmployeeDto> getAllEmployee() {

		List<Employee> employees = employeeRepo.findAll();
		List<EmployeeDto> employeeDto = employees.stream().map((employee) -> EmployeeModelMapper.toDto(employee))
				.collect(Collectors.toList());

		return employeeDto;
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {

		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee not exists with given id: " + id));

		return EmployeeModelMapper.toDto(employee);
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = new Employee();
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setJobLevel(employeeDto.getJobLevel());
		employee.setSalary(employeeDto.getSalary());

		this.employeeRepo.save(employee);

		return EmployeeModelMapper.toDto(employee);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee is not Exist with id:" + id));
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setJobLevel(employeeDto.getJobLevel());
		employee.setSalary(employeeDto.getSalary());
		employeeRepo.save(employee);

		return EmployeeModelMapper.toDto(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee not exists with id:" + id));
		employeeRepo.delete(employee);

	}

	@Override
	public List<EmployeeDto> findByJobLevel(int jobLevel) {

		List<Employee> employeeList = employeeRepo.findByJobLevel(jobLevel);
		List<EmployeeDto> employeeListDto = employeeList.stream().map(employee -> EmployeeModelMapper.toDto(employee))
				.collect(Collectors.toList());

		return employeeListDto;
	}

}
