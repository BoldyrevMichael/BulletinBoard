package ru.boldyrev.ma.spring1.bulletinboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.boldyrev.ma.spring1.bulletinboard.entity.AppUser;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Role;
import ru.boldyrev.ma.spring1.bulletinboard.repository.RoleRepository;
import ru.boldyrev.ma.spring1.bulletinboard.repository.AppUserRepository;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    // Имя роли по умолчанию
    private static final String DEFAULT_ROLE_NAME = "user";

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public AppUser findAppUserById(String appUserId) {
        return appUserRepository.getOne(appUserId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppUser> getListOfAppUser() {
        return appUserRepository.findAll();
    }

    @Override
    @Transactional
    public void persist(AppUser appUser) {
        //Role role = roleRepository.findByName(DEFAULT_ROLE_NAME);
        //appUser.setRole(role);
        appUserRepository.save(appUser);
    }

    @Override
    @Transactional
    public void deleteAppUser(AppUser appUser) {
        appUserRepository.delete(appUser);
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser findAppUserByLogin(String clientLogin) {
        return appUserRepository.findAppUserByLogin(clientLogin);
    }
}
