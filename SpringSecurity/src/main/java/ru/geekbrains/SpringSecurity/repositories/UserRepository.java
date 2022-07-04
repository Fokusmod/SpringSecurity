package ru.geekbrains.SpringSecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.SpringSecurity.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

}
