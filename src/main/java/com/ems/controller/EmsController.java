package com.ems.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping(value="/employees/")
public class EmsController {
    
    @Autowired
    EmployeeService es;

    //////----get list of all the employees-----------
	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees(Model model){
		List<Employee> employee=es.getAllEmployees();
		return employee;
	}
	
	/////-------get an employee----------------------
	@RequestMapping(value="/{emp_id}", method=RequestMethod.GET)
	public @ResponseBody Employee getEmployee(Model model, @PathVariable int emp_id){
		Employee employee = es.getEmployee(emp_id);
		return employee;  
	}
	
	
	/////--------add employee
	@RequestMapping(value="/", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Employee addEmployee(Model model, @RequestBody Employee employee ){
		Employee e=es.addEmployee(employee); 
		return e;
	}
	
	
	//----------delete employee
	@RequestMapping(value="/{emp_id}", method=RequestMethod.DELETE)
	public String deleteEmployee(Model model,@PathVariable int emp_id ){
		int i=es.deleteEmployee(emp_id);
		String deleteStr="not deleted";
		if(i==1){
			deleteStr="deleted successfully";
		}
		return deleteStr;    
	}
    
	///-------update employee----
	@RequestMapping(value="/{emp_id}", method=RequestMethod.PUT)
	public @ResponseBody String updateEmployee(Model model, @PathVariable int emp_id, @RequestBody Employee employee ){
		int i=es.updateEmployee(emp_id,employee);
		String updateStr="not updated";
		if(i==1){
			updateStr="updated successfully";
		}
		return updateStr;  
	}

	

}
