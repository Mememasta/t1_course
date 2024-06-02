package ru.vtb.t1.course.product.mapper;

import org.springframework.stereotype.Component;
import ru.vtb.t1.course.product.model.dao.UserDAO;
import ru.vtb.t1.course.product.model.dto.UserDTO;

import java.util.function.Function;

@Component
public class UserDAOMapper implements Function<UserDAO, UserDTO> {
    @Override
    public UserDTO apply(UserDAO userDAO) {
        return new UserDTO(userDAO.getId(), userDAO.getUsername());
    }
}
