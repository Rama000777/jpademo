package com.sample.jpademo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Embeddable
public class EmployeeIdentity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "company_id")
    private long companyId;

    @Column(name = "employee_id")
    private long employeeId;

    public EmployeeIdentity() {
        
    }

    public EmployeeIdentity(long companyId, long employeeId) {
        this.companyId = companyId;
        this.employeeId = employeeId;
    }
}