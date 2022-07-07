package ru.geekbrains.SpringSecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.SpringSecurity.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
