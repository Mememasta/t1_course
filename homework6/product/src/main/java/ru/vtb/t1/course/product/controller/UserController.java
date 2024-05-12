package ru.vtb.t1.course.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.t1.course.product.model.UserDTO;
import ru.vtb.t1.course.product.service.UserService;

import java.util.List;

/**
 * @author mchuchalov on 01.05.2024
 */
@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void save(@RequestBody UserDTO request) {
        userService.save(request);
    }

    @GetMapping("/find/all")
    public List<UserDTO> getUsers() {
        return userService.findAll();
    }
}
