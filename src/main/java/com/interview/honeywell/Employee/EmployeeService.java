package com.interview.honeywell.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interview.honeywell.Exception.EmployeeNotFoundException;
import com.interview.honeywell.Exception.IdCannotBeDuplicateException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;

	public Status saveEmployee(Employee e) {

		Employee emp = repo.findEmployeeById(e.getId());
		if (emp == null) {
			Status st = new Status();
			repo.save(e);
			st.setStatus("Saved Successfully");
			return st;
		} else
			throw new IdCannotBeDuplicateException("Duplicate id- " + e.getId());
	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		Employee e = repo.findEmployeeById(id);
		if (e == null)
			throw new EmployeeNotFoundException("Employee with id - " + id + " not found");

		return e;

	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) repo.findAll();
	}

	public Status deleteEmp(Employee e) {
		// TODO Auto-generated method stub
		Employee emp = repo.findEmployeeById(e.getId());
		Status st = new Status();
		if (emp != null) {
			repo.delete(e);
			st.setStatus("Deleted Successfully");
			return st;
		} else {
			st.setStatus("Employee id not found");
			return st;
		}

	}

}