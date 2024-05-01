package ru.vtb.t1.course.service;

import org.springframework.stereotype.Service;
import ru.vtb.t1.course.model.UserDTO;
import ru.vtb.t1.course.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserDTO userDTO) {
        userRepository.save(userDTO);
    }

    public void deleteById(Long userId) {
        userRepository.delete(userId);
    }

    public UserDTO findById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll();
    }
}
