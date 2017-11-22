package com.ems.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.equalTo;



import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmsController.class, secure = false)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    EmployeeService employeeService;
    
    
	@Test
	public void getEmployee() throws Exception {
		Employee e=new Employee(1,"Apurva","Panaji");
	    Mockito.when(employeeService.getEmployee(Mockito.anyInt())).thenReturn(e);
	    mockMvc.perform(MockMvcRequestBuilders.get("/employees/1").accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())	            
	                .andExpect(jsonPath("$.empId", Matchers.is(1)))
	                .andExpect(jsonPath("$.empName", Matchers.is("Apurva")))
	                .andExpect(jsonPath("$.empAddress", Matchers.is("Panaji")));
	}
	
	@Test
	public void getAllEmployees() throws Exception {
		List<Employee> e=new ArrayList<Employee>();
		e.add(new Employee(1,"Apurva","Panaji"));
		e.add(new Employee(2,"Joshua","Margao"));

		Mockito.when(employeeService.getAllEmployees()).thenReturn(e);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{\"empId\":1,\"empName\":\"Apurva\",\"empAddress\":\"Panaji\"},{\"empId\":2,\"empName\":\"Joshua\",\"empAddress\":\"Margao\"}]";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void updateEmployee() throws Exception {
		String jsonContent = "{\"empId\":1,\"empName\":\"Apurva\",\"empAddress\":\"Panaji\"}";

	    Mockito.when(employeeService.updateEmployee(Mockito.anyInt(),Mockito.anyObject())).thenReturn(1);
	    mockMvc.perform(MockMvcRequestBuilders.put("/employees/1")
	    		.contentType(MediaType.APPLICATION_JSON).content(jsonContent))
	    		.andExpect(status().isOk())
	    		.andExpect(content().string(equalTo("updated successfully")));
	                
	}
	
	@Test
	public void deleteEmployee() throws Exception {
		
		Mockito.when(employeeService.deleteEmployee(Mockito.anyInt())).thenReturn(1);
		mockMvc.perform(MockMvcRequestBuilders.delete("/employees/1"))
         .andExpect(status().isOk())
		 .andExpect(content().string(equalTo("deleted successfully")));
	} 
	
	@Test
	public void addEmployee() throws Exception {
		Employee e=new Employee(1,"Apurva","Panaji");
		String jsonContent = "{\"empId\":1,\"empName\":\"Apurva\",\"empAddress\":\"Panaji\"}";

		Mockito.when(employeeService.addEmployee(Mockito.anyObject())).thenReturn(e);
		mockMvc.perform(MockMvcRequestBuilders.post("/employees/")
				.contentType(MediaType.APPLICATION_JSON).content(jsonContent))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$.empId", Matchers.is(1)))
         .andExpect(jsonPath("$.empName", Matchers.is("Apurva")))
         .andExpect(jsonPath("$.empAddress", Matchers.is("Panaji")));

	} 
	
	
}

