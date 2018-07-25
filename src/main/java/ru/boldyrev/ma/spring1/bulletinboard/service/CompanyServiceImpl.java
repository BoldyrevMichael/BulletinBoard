package ru.boldyrev.ma.spring1.bulletinboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;
import ru.boldyrev.ma.spring1.bulletinboard.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Company> getListOfCompany() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Company findCompanyById(String companyId) {
        return companyRepository.getOne(companyId);
    }

    @Override
    @Transactional(readOnly = true)
    public Company findCompanyByName(String companyName) {
        return companyRepository.findByName(companyName);
    }

    @Override
    @Transactional
    public void persist(Company company) {
        companyRepository.save(company);
    }

    @Override
    @Transactional
    public void deleteById(String companyId) {
        companyRepository.deleteById(companyId);
    }

    @Override
    @Transactional
    public void setName(String name, String companyId) {
        companyRepository.setName(name, companyId);
    }

    @Override
    @Transactional
    public void setDescription(String description, String companyId) {
        companyRepository.setDescription(description, companyId);
    }

    @Override
    @Transactional
    public void setAddress(String address, String companyId) {
        companyRepository.setAddress(address, companyId);
    }
}