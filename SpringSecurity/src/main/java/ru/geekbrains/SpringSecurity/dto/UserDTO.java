package ru.geekbrains.SpringSecurity.dto;

import lombok.Data;
import ru.geekbrains.SpringSecurity.entities.Role;

import java.util.List;

@Data
public class UserDTO {

    private String name;

    private List<RoleDTO> roles;

    public UserDTO(String name, List<RoleDTO> roles) {
        this.name = name;
        this.roles = roles;
    }
}
