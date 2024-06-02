package ru.vtb.t1.course.transfer.mapper;

import org.springframework.stereotype.Component;
import ru.vtb.t1.course.transfer.model.dao.UserDAO;
import ru.vtb.t1.course.transfer.model.dto.UserDTO;

import java.util.function.Function;

@Component
public class UserDTOMapper implements Function<UserDAO, UserDTO> {
    @Override
    public UserDTO apply(UserDAO userDAO) {
        return new UserDTO(userDAO.getId(), userDAO.getLimits(), userDAO.getBalance());
    }
}
