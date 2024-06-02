package ru.vtb.t1.course.transfer.mapper;

import org.springframework.stereotype.Component;
import ru.vtb.t1.course.transfer.model.dao.UserDAO;
import ru.vtb.t1.course.transfer.model.dto.UserDTO;

import java.util.function.Function;

@Component
public class UserDAOMapper implements Function<UserDTO, UserDAO> {
    @Override
    public UserDAO apply(UserDTO userDTO) {
        return new UserDAO(userDTO.getId(), userDTO.getLimits(), userDTO.getBalance());
    }
}
