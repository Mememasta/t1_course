package ru.vtb.t1.course.transfer.service;

import ru.vtb.t1.course.transfer.model.dto.UserDTO;

public interface UserService {

    UserDTO getUser(Long id);

    void updateUser(UserDTO user);

    void updateAllLimits();

}
