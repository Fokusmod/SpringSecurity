package ru.geekbrains.SpringSecurity.dto;

import lombok.Data;
import ru.geekbrains.SpringSecurity.entities.Privilege;

import java.util.Set;

@Data
public class RoleDTO {

    private String name;

    private Set<Privilege> privileges;

    public RoleDTO(String name) {
        this.name = name;
    }

    public RoleDTO(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public RoleDTO(String name, Set<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
    }
}
