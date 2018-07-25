package ru.boldyrev.ma.spring1.bulletinboard.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.boldyrev.ma.spring1.bulletinboard.dto.AdDto;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Ad;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Category;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;

import java.util.List;

public interface AdService {

    List<Ad> getListOfAd();

    AdDto findAdDtoById(String adId);

    void persist(Ad ad);

    void deleteById(String adId);

    List<Ad> getListOfAdByCategoryId(String categoryId);

    List<Ad> getListOfAdByCompanyId(String companyId);

    String getCategoryIdByAdId(String adId);

    String getCompanyIdByAdId(String adId);

    void setName(String name, String adId);

    void setContent(String content, String adId);

    void setPhone(String phone, String adId);

    void setCategory(Category category, String adId);

    void setCompany(Company company, String adId);

    Page<Ad> getListOfAdForPage(Pageable pageable);

    Page<Ad> getListOfAdByCategoryIdForPage(String categoryId, Pageable pageable);

    Page<Ad> getListOfAdByCompanyIdForPage(String companyId, Pageable pageable);
}