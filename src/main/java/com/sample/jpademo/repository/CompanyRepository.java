package com.sample.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.jpademo.entity.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
        
}