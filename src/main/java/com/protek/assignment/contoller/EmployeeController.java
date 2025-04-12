package com.protek.assignment.contoller;

import com.protek.assignment.model.Employee;
import com.protek.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee saved = employeeService.addEmployee(employee);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateSalary(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam double salary) {
        return ResponseEntity.ok(employeeService.updateSalary(firstName, lastName, salary));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        employeeService.deleteEmployee(firstName, lastName);
        return ResponseEntity.noContent().build();
    }
}
