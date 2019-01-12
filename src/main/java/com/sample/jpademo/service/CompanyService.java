package com.sample.jpademo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.jpademo.entity.Company;
import com.sample.jpademo.exception.CompanyFoundException;
import com.sample.jpademo.repository.CompanyRepository;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteCompany(long id) {
        companyRepository.delete(getCompanyById(id));
    }

    @Override
    public Company getCompanyById(long id) {
        Optional<Company> companyFromDB = companyRepository.findById(id);
        if (!companyFromDB.isPresent()) {
            throw  new CompanyFoundException("No Company Found with this ID");
        } 
        return companyFromDB.get();
    }

    @Override
    public Company updateCompany(Company company) {
        Optional<Company> companyFromDb = companyRepository.findById(company.getId());
        Company companyUpdated = null;
        if (companyFromDb.isPresent()) {
            companyUpdated = companyRepository.save(company);
        } else {
            companyUpdated = companyRepository.save(company);
        }
        return companyUpdated;
    }
}
