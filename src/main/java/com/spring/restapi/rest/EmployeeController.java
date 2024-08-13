package com.spring.restapi.rest;

import com.spring.restapi.entity.Employee;
import com.spring.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Java bean
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(@Qualifier("employeeServiceImpl") EmployeeService empService) {
        this.employeeService = empService;
    } // Constructor Injection

    @GetMapping("/employees")
    public List<Employee> employees() {
        return employeeService.findAll();
    } // Get employee list

    @GetMapping("/employees/{id}") // Path variable
    public Employee employeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    } // Get one employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    } // Creat employee

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updateEmployee) {
        Employee saveEmployee = employeeService.getEmployeeById(id);
        saveEmployee.setMaNV(updateEmployee.getMaNV());
        saveEmployee.setName(updateEmployee.getName());
        saveEmployee.setEmail(updateEmployee.getEmail());

        return employeeService.saveEmployee(saveEmployee);
    }// Update employee
}
