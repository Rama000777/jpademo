package com.sample.jpademo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @EmbeddedId
    private EmployeeIdentity id;

    @Embedded
    private EmployeeBasicDetails employeeBasicDetails;

    @Embedded
    @AttributeOverrides(value = { @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street")) })
    private Address address;

    public Employee() {

    }

    public Employee(EmployeeIdentity id, EmployeeBasicDetails employeeBasicDetails, Address address) {
        this.id = id;
        this.employeeBasicDetails = employeeBasicDetails;
        this.address = address;
    }
}