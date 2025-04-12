package com.protek.assignment.service;

import com.protek.assignment.model.Employee;
import com.protek.assignment.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateSalary(String first, String last, double newSalary) {
        Employee e = employeeRepository.findByFirstNameAndLastName(first, last)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        e.setSalary(newSalary);
        return employeeRepository.save(e);
    }

    public void deleteEmployee(String first, String last) {
        employeeRepository.deleteByFirstNameAndLastName(first, last);
    }
}
