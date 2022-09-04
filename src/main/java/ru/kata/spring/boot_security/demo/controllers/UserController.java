package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showUserInfo(Model model, Principal principal) {

        StringBuilder roles = new StringBuilder();
        for (Role role : userService.findUserByEmail(principal.getName()).getRoles()) {
            roles.append(role.toString());
            roles.append(" ");
        }
        model.addAttribute("thisUserRole", roles);
        model.addAttribute("thisUser", userService.findUserByEmail(principal.getName()));
        return "user";
    }
}
