package ru.boldyrev.ma.spring1.bulletinboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    @Modifying
    @Query("update Company a set a.name = ?1 where a.id = ?2")
    void setName(String name, String companyId);

    @Modifying
    @Query("update Company a set a.description = :description where a.id = :companyId")
    void setDescription(@Param("description") String description, @Param("companyId") String companyId);

    @Modifying
    @Query("update Company a set a.address = :address where a.id = :companyId")
    void setAddress(@Param("address") String address, @Param("companyId") String companyId);

    Company findByName(String companyName);
}