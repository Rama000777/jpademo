package com.sample.jpademo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.jpademo.entity.Employee;
import com.sample.jpademo.entity.EmployeeIdentity;
import com.sample.jpademo.exception.EmployeeNotFoundException;
import com.sample.jpademo.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    ICompanyService companyService;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(EmployeeIdentity id) {
        employeeRepository.delete(getEmployeeById(id));
    }

    @Override
    public Employee getEmployeeById(EmployeeIdentity id) {
        Optional<Employee> employeeFromDB = employeeRepository.findById(id);
        if (!employeeFromDB.isPresent()) {
            throw new EmployeeNotFoundException("No Employee Found with this ID" + id);
        }
        return employeeFromDB.get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeFromDb = employeeRepository.findById(employee.getId());
        Employee employeeUpdated = null;
        // validate company ID
        companyService.getCompanyById(employee.getId().getCompanyId());
        if (employeeFromDb.isPresent()) {
            employeeUpdated = employeeRepository.save(employee);
        } else {
            employeeUpdated = employeeRepository.save(employee);
        }
        return employeeUpdated;
    }
}