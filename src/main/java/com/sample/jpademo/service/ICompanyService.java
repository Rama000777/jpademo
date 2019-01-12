package com.sample.jpademo.service;

import java.util.List;

import com.sample.jpademo.entity.Company;

public interface ICompanyService {

    public void deleteCompany(long cid);

    public Company updateCompany(Company company);

    public List<Company> getAllCompanies();

    public Company getCompanyById(long cid);

}
