package ru.vtb.t1.course.service;

import org.springframework.stereotype.Service;
import ru.vtb.t1.course.model.UserDTO;
import ru.vtb.t1.course.repository.UserDAO;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void save(UserDTO userDTO) {
        userDAO.save(userDTO);
    }

    public void deleteById(Long userId) {
        userDAO.delete(userId);
    }

    public UserDTO findById(Long userId) {
        return userDAO.findById(userId);
    }

    public List<UserDTO> findAll() {
        return userDAO.findAll();
    }
}
