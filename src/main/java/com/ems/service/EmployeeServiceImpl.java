package com.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ems.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	protected Logger logger = Logger.getLogger(this.getClass());

	List<Employee> empList=new ArrayList<Employee>();
	int id=1;
	@Override
	public Employee addEmployee(Employee employee) {
		logger.info("ADD EMPLOYEE");
		employee.setEmpId(id++);
		empList.add(employee);
		return employee;
		
	}

	@Override
	public Employee getEmployee(int emp_id) {
		logger.info("GET EMPLOYEE");
		for (Employee emp : empList) {
			if(emp.getEmpId()==emp_id){
				return emp;
			}
		}
		return null;	
	}

	@Override
	public List<Employee> getAllEmployees() {
		logger.info("GET ALL EMPLOYEES");
		return empList;	
	}

	@Override
	public int deleteEmployee(int emp_id) {
		logger.info("DELETE EMPLOYEE");
		Employee e=getEmployee(emp_id);
		if(e!=null){
			empList.remove(e);
			return 1;
		}	
		logger.error("employee to be deleted not found");
		return 0;
	}

	@Override
	public int updateEmployee(int emp_id, Employee employee) {
		logger.info("UPDATE EMPLOYEE: "+employee.getEmpId());
		Employee e=getEmployee(emp_id);
		System.out.println(e);
		if(e!=null){
			e.setEmpName(employee.getEmpName());
			e.setEmpAddress(employee.getEmpAddress());	
			return 1;
		}
		logger.error("employee to be updated not found");
		return 0;
	}

}
