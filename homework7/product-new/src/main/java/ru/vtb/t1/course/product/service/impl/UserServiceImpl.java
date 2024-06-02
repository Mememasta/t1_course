package ru.vtb.t1.course.product.service.impl;

import org.springframework.stereotype.Service;
import ru.vtb.t1.course.product.exception.NotFoundException;
import ru.vtb.t1.course.product.mapper.UserDAOMapper;
import ru.vtb.t1.course.product.model.dao.UserDAO;
import ru.vtb.t1.course.product.model.dto.UserDTO;
import ru.vtb.t1.course.product.repository.UserRepository;
import ru.vtb.t1.course.product.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDAOMapper userDAOMapper;

    public UserServiceImpl(UserRepository userRepository, UserDAOMapper userDAOMapper) {
        this.userRepository = userRepository;
        this.userDAOMapper = userDAOMapper;
    }

    public void save(UserDTO userDTO) {
        var userDao = new UserDAO(userDTO.getId(), userDTO.getUsername());
        userRepository.save(userDao);
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public UserDTO findById(Long userId) {
        return userRepository.findById(userId)
                .map(userDAOMapper)
                .orElseThrow(() -> new NotFoundException("Не найден пользователь"));
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userDAOMapper)
                .toList();
    }
}
