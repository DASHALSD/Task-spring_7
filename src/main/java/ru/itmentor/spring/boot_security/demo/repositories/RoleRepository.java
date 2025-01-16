package ru.itmentor.spring.boot_security.demo.repositories;

import ru.itmentor.spring.boot_security.demo.models.Role; // Новый импорт
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}