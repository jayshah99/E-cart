package com.market.productservice.repository;

import com.example.mongodb.example.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Integer> {
}
