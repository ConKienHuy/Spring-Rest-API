package com.spring.restapi.service;

import com.spring.restapi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee getEmployeeById(int id);
    public Employee saveEmployee(Employee employee);
    public void deleteEmployee(int id);
}
