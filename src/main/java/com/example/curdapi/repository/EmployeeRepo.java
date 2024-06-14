package com.example.curdapi.repository;

import com.example.curdapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query("SELECT s FROM Employee s WHERE s.email = ?1")
    Employee findByEmail(String email);
}
