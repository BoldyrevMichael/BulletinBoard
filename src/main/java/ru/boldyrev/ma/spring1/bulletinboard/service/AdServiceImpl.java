package ru.boldyrev.ma.spring1.bulletinboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.boldyrev.ma.spring1.bulletinboard.dto.AdDto;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Ad;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Category;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;
import ru.boldyrev.ma.spring1.bulletinboard.repository.AdRepository;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ad> getListOfAd() {
        return adRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AdDto findAdDtoById(String adId) {
        final Ad ad = adRepository.getOne(adId);
        if (ad != null) return new AdDto(ad);
        return null;
    }

    @Override
    @Transactional
    public void persist(Ad ad) {
        adRepository.save(ad);
    }

    @Override
    @Transactional
    public void deleteById(String adId) {
        adRepository.deleteById(adId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ad> getListOfAdByCategoryId(String categoryId) {
        return adRepository.getListOfAdByCategoryId(categoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ad> getListOfAdByCompanyId(String companyId) {
        return adRepository.getListOfAdByCompanyId(companyId);
    }

    @Override
    @Transactional(readOnly = true)
    public String getCategoryIdByAdId(String adId) {
        return adRepository.getCategoryIdByAdId(adId);
    }

    @Override
    @Transactional(readOnly = true)
    public String getCompanyIdByAdId(String adId) {
        return adRepository.getCompanyIdByAdId(adId);
    }

    @Override
    @Transactional
    public void setName(String name, String adId) {
        adRepository.setName(name, adId);
    }

    @Override
    @Transactional
    public void setContent(String content, String adId) {
        adRepository.setContent(content, adId);
    }

    @Override
    @Transactional
    public void setPhone(String phone, String adId) {
        adRepository.setPhone(phone, adId);
    }

    @Override
    @Transactional
    public void setCategory(Category category, String adId) {
        adRepository.setCategory(category, adId);
    }

    @Override
    @Transactional
    public void setCompany(Company company, String adId) {
        adRepository.setCompany(company, adId);
    }

    @Override
    @Transactional
    public Page<Ad> getListOfAdForPage(Pageable pageable) {
        return adRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Page<Ad> getListOfAdByCategoryIdForPage(String categoryId, Pageable pageable) {
        return adRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    @Transactional
    public Page<Ad> getListOfAdByCompanyIdForPage(String companyId, Pageable pageable) {
        return adRepository.findByCompanyId(companyId, pageable);
    }
}