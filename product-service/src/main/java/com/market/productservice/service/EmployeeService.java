package com.market.productservice.service;

import com.example.mongodb.example.model.Employee;
import com.example.mongodb.example.pojo.Response;
import com.example.mongodb.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }


    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Response delete(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return new Response(false, String.format("Employee with id: %s Deleted Successfully", id));
        }

        return new Response(true, String.format("Employee with id: %s not found", id));
    }


    public Employee updateById(Employee employee, int id) {
        Employee employee1 = employeeRepository.findById(id).get();
        employee1.setName(employee.getName());
        employee1.setAddress(employee.getAddress());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        return employeeRepository.save(employee1);
    }
}
