package com.spring.restapi.service;

import com.spring.restapi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee getEmployeeById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
