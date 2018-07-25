package ru.boldyrev.ma.spring1.bulletinboard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Ad;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Category;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, String> {

    @Query("select a from Ad a where a.category.id = :categoryId")
    List<Ad> getListOfAdByCategoryId(@Param("categoryId") String categoryId);

    @Query("select a from Ad a where a.company.id = :companyId")
    List<Ad> getListOfAdByCompanyId(@Param("companyId") String companyId);

    @Query("select a.category.id from Ad a where a.id = :adId")
    String getCategoryIdByAdId(@Param("adId") String adId);

    @Query("select a.company.id from Ad a where a.id = :adId")
    String getCompanyIdByAdId(@Param("adId") String adId);

    @Modifying
    @Query("update Ad a set a.name = ?1 where a.id = ?2")
    void setName(String name, String adId);

    @Modifying
    @Query("update Ad a set a.content = :content where a.id = :adId")
    void setContent(@Param("content") String content, @Param("adId") String adId);

    @Modifying
    @Query("update Ad a set a.phone = :phone where a.id = :adId")
    void setPhone(@Param("phone") String phone, @Param("adId") String adId);

    @Modifying
    @Query("update Ad a set a.category = :category where a.id = :adId")
    void setCategory(@Param("category") Category category, @Param("adId") String adId);

    @Modifying
    @Query("update Ad a set a.company = :company where a.id = :adId")
    void setCompany(@Param("company") Company company, @Param("adId") String adId);

    Page<Ad> findByCategoryId(String categoryId, Pageable pageable);

    Page<Ad> findByCompanyId(String companyId, Pageable pageable);
}