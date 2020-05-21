package com.verizon.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.verizon.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {

}
