package ru.boldyrev.ma.spring1.bulletinboard.service;

import ru.boldyrev.ma.spring1.bulletinboard.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getListOfRole();

    Role findRoleById(String roleId);

    void persist(Role role);

    void deleteById(String roleId);

    void setName(String roleName, String roleId);

    Role findByName(String roleName);
}
