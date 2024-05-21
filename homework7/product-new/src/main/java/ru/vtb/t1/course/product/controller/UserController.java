package ru.vtb.t1.course.product.controller;

import org.springframework.web.bind.annotation.*;
import ru.vtb.t1.course.product.model.dto.UserDTO;
import ru.vtb.t1.course.product.service.impl.UserServiceImpl;

import java.util.List;

/**
 * @author mchuchalov on 01.05.2024
 */
@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
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
