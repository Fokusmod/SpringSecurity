package ru.geekbrains.SpringSecurity.controllers;


import lombok.RequiredArgsConstructor;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.SpringSecurity.dto.RoleDTO;
import ru.geekbrains.SpringSecurity.dto.UserDTO;
import ru.geekbrains.SpringSecurity.entities.Role;
import ru.geekbrains.SpringSecurity.entities.User;
import ru.geekbrains.SpringSecurity.repositories.RoleRepository;
import ru.geekbrains.SpringSecurity.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @GetMapping("/")
    public String welcomePage() {
        return "Hello world";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Hello Admin";
    }

    @GetMapping("/user")
    public String userPage() {
        return "Hello user";
    }

    @GetMapping("/guest")
    public String guestPage() {
        return "Hello Guest";
    }

    @GetMapping("/admin/showAll")
    public List<UserDTO> showAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getUsername(), user.getRoles().stream()
                        .map(role -> new RoleDTO(role.getName())).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @GetMapping("/showRoles")
    public List<RoleDTO> showPrivileges (){
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(role -> new RoleDTO(role.getName(),role.getPrivileges())).collect(Collectors.toList());
    }
}
