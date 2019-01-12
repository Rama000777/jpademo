package com.sample.jpademo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Embeddable
@Data
public class EmployeeBasicDetails {
    
    @NotNull
    @Size(max = 40)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 40)
    @Column(name = "middle_name")
    private String middleName;

    @Size(max = 40)
    @Column(name = "last_name")
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dateOfBirth;
    
    @NaturalId
    @NotNull
    @Email
    @Size(max = 60)
    @Column(unique = true)
    private String email;

    @Size(max = 15)
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    public EmployeeBasicDetails() {

    }

    public EmployeeBasicDetails(String firstName, String middleName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}