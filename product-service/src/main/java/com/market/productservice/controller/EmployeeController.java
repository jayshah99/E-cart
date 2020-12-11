package com.market.productservice.controller;

import com.example.mongodb.example.model.Employee;
import com.example.mongodb.example.pojo.Response;
import com.example.mongodb.example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable(value = "id") int id) {
        return employeeService.delete(id);
    }

    @PutMapping("/{id}")
    public Employee updateById(@RequestBody Employee employee, @PathVariable("id") int id) {
        return employeeService.updateById(employee, id);
    }
}

