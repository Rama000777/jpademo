package com.sample.jpademo.service;

import java.util.List;

import com.sample.jpademo.entity.Employee;
import com.sample.jpademo.entity.EmployeeIdentity;

public interface IEmployeeService {

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    Employee getEmployeeById(EmployeeIdentity id);

    void deleteEmployee(EmployeeIdentity id);

}
