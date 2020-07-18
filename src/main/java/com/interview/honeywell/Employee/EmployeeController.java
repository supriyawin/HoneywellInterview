package com.interview.honeywell.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;

@ApiModel(description="Employee Management APIs")
@Slf4j
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	
	@GetMapping("/health")
	public String checkhealth()
	{
		return "Congrats!! Server up and running";
	}
	
	@PostMapping("/employee")
	public Status saveEmployee(@RequestBody Employee e)
	{
		log.info("Saving Employee..."+e.getName());
		if(e.getAge()<0)
		{
			Status st= new Status();
			st.setStatus("Age Cannot be negative");
			return st;
		}
		return empService.saveEmployee(e);
	}
	
	@RequestMapping(path = "/employee/{ID}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int ID) throws Exception {
		log.info("Request to get Employee with id "+ID);
		Employee emp= empService.getEmployee(ID);
		if(emp==null)
			throw new Exception("Id doesn't exists");
		else
			return emp;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{ 
		log.info("Requrning list of Employees ");
		return empService.getAllEmployee();
		
	}
	
	@RequestMapping(path = "/employee/{ID}", method = RequestMethod.DELETE)
	public Status deleteEmployee(@PathVariable int ID)
	{
		
		log.info("deleting employee with id..."+ID);
		Employee e= new Employee();
		e.setId(ID);
		return empService.deleteEmp(e);
	}
	
	

}
