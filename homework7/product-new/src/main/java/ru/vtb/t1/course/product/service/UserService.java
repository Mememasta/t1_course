package ru.vtb.t1.course.product.service;

import ru.vtb.t1.course.product.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    void save(UserDTO userDTO);

    void deleteById(Long userId);

    UserDTO findById(Long userId);

    List<UserDTO> findAll();
}
