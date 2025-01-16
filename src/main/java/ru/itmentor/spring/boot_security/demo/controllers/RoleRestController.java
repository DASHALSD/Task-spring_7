package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.services.UserService;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

    private final UserService userService;

    public RoleRestController(UserService userService) {
        this.userService = userService;
    }

    // Получение ролей пользователя
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserRoles(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user.getRoles()) : ResponseEntity.notFound().build();
    }
}
