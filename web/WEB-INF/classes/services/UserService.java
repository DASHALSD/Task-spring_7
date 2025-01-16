package ru.itmentor.spring.boot_security.demo.services;

import ru.itmentor.spring.boot_security.demo.repositories.UserRepository;  // Используем правильный пакет
import ru.itmentor.spring.boot_security.demo.models.User;  // Модель пользователя
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;  // Используем репозиторий вместо DAO

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();  // Используем метод из репозитория
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);  // Используем метод из репозитория
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.save(user);  // Используем метод из репозитория
    }

    @Transactional
    @Override
    public void updateUser(long id, User updatedUser) {
        userRepository.save(updatedUser);  // Используем метод из репозитория
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);  // Используем метод из репозитория
    }
}