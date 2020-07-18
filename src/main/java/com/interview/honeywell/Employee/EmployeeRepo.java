package com.interview.honeywell.Employee;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
	 @Query("{id : ?0}")
		Employee findEmployeeById(int id);

}
