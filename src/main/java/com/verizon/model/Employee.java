package com.verizon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


@Document(collection = "employee")
public class Employee {
	@Id
	private int empid;
	private String fname;
	private String lname;

}
