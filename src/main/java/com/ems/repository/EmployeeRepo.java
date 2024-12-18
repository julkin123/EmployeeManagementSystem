package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entity.Employee;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	List<Employee> findByJobLevel(int jobLevel);
	Employee  findByEmail(String email);

}
