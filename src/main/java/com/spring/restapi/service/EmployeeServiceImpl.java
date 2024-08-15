package com.spring.restapi.service;

import com.spring.restapi.entity.Employee;
import com.spring.restapi.exception.EmployeeNotFoundException;
import com.spring.restapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // this is a java bean
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    } // Constructor injection

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> result = employeeRepo.findById(id);
        Employee employee;
        if(result.isPresent()){
            employee = result.get();
        }
        else throw new EmployeeNotFoundException("Employee with id " + id + " not found");

        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee saveEmployee = employeeRepo.findById(employee.getId())
                .orElse(null);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee with id " + employee.getId() + " not found");
        }
        else{
            saveEmployee.setMaNV(employee.getMaNV());
            saveEmployee.setName(employee.getName());
            saveEmployee.setEmail(employee.getEmail());
        }
        return employeeRepo.save(saveEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        Optional<Employee> result = employeeRepo.findById(id);
        if(!result.isPresent()){
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        employeeRepo.deleteById(id);
    }
}
