package com.interview.honeywell.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Document
@Data
public class Employee {
	
	@Id
	int id;
	String name;
	int age;

}
