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

import com.sample.jpademo.entity.Company;
import com.sample.jpademo.service.ICompanyService;

@RestController
@RequestMapping("/v1/")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @GetMapping("company/{cid}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("cid") long cid) {
        return new ResponseEntity<>(companyService.getCompanyById(cid), HttpStatus.OK);
    }

    @GetMapping("companys")
    public ResponseEntity<List<Company>> getAllCompanys() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PostMapping("company")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.updateCompany(company), HttpStatus.CREATED);
    }

    @PutMapping("company")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.updateCompany(company), HttpStatus.OK);
    }

    @DeleteMapping("company/{cid}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("cid") long cid) {
        companyService.deleteCompany(cid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
