package ru.boldyrev.ma.spring1.bulletinboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boldyrev.ma.spring1.bulletinboard.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findAppUserByLogin(String login);
}