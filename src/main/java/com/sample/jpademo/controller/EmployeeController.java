package com.sample.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.jpademo.entity.Employee;
import com.sample.jpademo.entity.EmployeeIdentity;
import com.sample.jpademo.service.IEmployeeService;

@RestController
@RequestMapping("/v1/")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("employee/{id}/company/{cid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id, @PathVariable("cid") int cid) {
        return new ResponseEntity<>(employeeService.getEmployeeById(new EmployeeIdentity(id, cid)), HttpStatus.OK);
    }

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("employee/{id}/company/{cid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id, @PathVariable("cid") int cid) {
        employeeService.deleteEmployee(new EmployeeIdentity(id, cid));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
