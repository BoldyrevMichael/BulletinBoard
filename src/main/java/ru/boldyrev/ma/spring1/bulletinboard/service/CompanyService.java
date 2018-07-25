package ru.boldyrev.ma.spring1.bulletinboard.service;

import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getListOfCompany();

    Company findCompanyById(String companyId);

    Company findCompanyByName(String companyName);

    void persist(Company company);

    void deleteById(String companyId);

    void setName(String name, String companyId);

    void setDescription(String description, String companyId);

    void setAddress(String address, String companyId);
}
