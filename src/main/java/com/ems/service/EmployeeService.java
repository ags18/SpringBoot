package com.ems.service;

import java.util.List;
import com.ems.model.Employee;

public interface EmployeeService{
	Employee addEmployee(Employee employee);	
	Employee getEmployee(int emp_id);	
	List<Employee> getAllEmployees();
	int deleteEmployee(int emp_id);
	int updateEmployee(int emp_id,Employee employee);
}
