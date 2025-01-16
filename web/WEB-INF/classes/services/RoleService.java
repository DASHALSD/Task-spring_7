package ru.itmentor.spring.boot_security.demo.services;

import ru.itmentor.spring.boot_security.demo.repositories.RoleRepository;  // Используем правильный пакет
import ru.itmentor.spring.boot_security.demo.models.Role;  // Модель роли
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
