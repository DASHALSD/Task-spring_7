package ru.itmentor.spring.boot_security.demo.services;

import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.repositories.RoleRepository;
import ru.itmentor.spring.boot_security.demo.repositories.UserRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);  // Добавленный метод сохранения пользователя
    }

    public void saveUserWithRoles(User user, List<Long> roleIds) {
        user.setRoles(new HashSet<>(roleRepository.findAllById(roleIds))); // Преобразование List в Set
        userRepository.save(user);
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setPassword(updatedUser.getPassword());
            userRepository.save(user);
        }
    }

    public void updateUser(Long id, User updatedUser, List<Long> roleIds) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setPassword(updatedUser.getPassword());
            user.setRoles(new HashSet<>(roleRepository.findAllById(roleIds))); // Преобразование List в Set
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}