package ru.boldyrev.ma.spring1.bulletinboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByName(String roleName);

    @Modifying
    @Query("update Role a set a.name = ?1 where a.id = ?2")
    void setName(String roleName, String roleId);
}