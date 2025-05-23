package com.protek.assignment.repository;

import com.protek.assignment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    void deleteByFirstNameAndLastName(String firstName, String lastName);
}
