package com.sample.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.jpademo.entity.Employee;
import com.sample.jpademo.entity.EmployeeIdentity;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeIdentity> {
        
}