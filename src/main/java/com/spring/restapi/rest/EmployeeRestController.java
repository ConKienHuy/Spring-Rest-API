package com.spring.restapi.rest;

import com.spring.restapi.entity.Employee;
import com.spring.restapi.exception.EmployeeNotFoundException;
import com.spring.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Java bean
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(@Qualifier("employeeServiceImpl") EmployeeService empService) {
        this.employeeService = empService;
    } // Constructor Injection

    @GetMapping("/employees")
    public List<Employee> employees() {
        return employeeService.findAll();
    } // Get employee list

    @GetMapping("/employees/{id}") // Path variable
    public Employee employeeById(@PathVariable int id) {
        if(id < 0) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        return employeeService.getEmployeeById(id);
    } // Get one employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    } // Creat employee

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updateEmployee) {
        if(id < 0)
        {throw new EmployeeNotFoundException("Employee with id " + id + " not found");}
        Employee saveEmployee = employeeService.getEmployeeById(id);
        saveEmployee.setMaNV(updateEmployee.getMaNV());
        saveEmployee.setName(updateEmployee.getName());
        saveEmployee.setEmail(updateEmployee.getEmail());

        return employeeService.saveEmployee(saveEmployee);
    }// Update employee

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        if(id < 0) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        employeeService.deleteEmployee(id);
    } // Delete employee

}
