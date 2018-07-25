package ru.boldyrev.ma.spring1.bulletinboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Role;
import ru.boldyrev.ma.spring1.bulletinboard.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Role> getListOfRole() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Role findRoleById(String roleId) {
        return roleRepository.getOne(roleId);
    }

    @Override
    @Transactional
    public void persist(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteById(String roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    @Transactional
    public void setName(String roleName, String roleId) {
        roleRepository.setName(roleName, roleId);
    }

    @Override
    @Transactional(readOnly = true)
    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
