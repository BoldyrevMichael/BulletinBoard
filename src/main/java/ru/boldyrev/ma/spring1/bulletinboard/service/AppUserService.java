package ru.boldyrev.ma.spring1.bulletinboard.service;

import ru.boldyrev.ma.spring1.bulletinboard.entity.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser findAppUserById(String appUserId);

    List<AppUser> getListOfAppUser();

    void persist(AppUser appUser);

    void deleteAppUser(AppUser appUser);

    AppUser findAppUserByLogin(String appUserLogin);
}