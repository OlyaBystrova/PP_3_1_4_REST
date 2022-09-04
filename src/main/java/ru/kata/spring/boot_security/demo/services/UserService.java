package ru.kata.spring.boot_security.demo.services;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.User;
import java.util.List;

@Service
public interface UserService {

    User findUserByEmail(String email);

    void save(User user);

    void update(User user);

    void deleteById(int id);

    List<User> findAll();

    User passwordCoder(User user);
}
