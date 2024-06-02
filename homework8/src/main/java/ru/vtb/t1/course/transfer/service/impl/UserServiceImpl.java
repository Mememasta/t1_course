package ru.vtb.t1.course.transfer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vtb.t1.course.transfer.mapper.UserDAOMapper;
import ru.vtb.t1.course.transfer.mapper.UserDTOMapper;
import ru.vtb.t1.course.transfer.model.dao.UserDAO;
import ru.vtb.t1.course.transfer.model.dto.UserDTO;
import ru.vtb.t1.course.transfer.repository.UserRepository;
import ru.vtb.t1.course.transfer.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Value("${task.default-limit}")
    private Long defaultLimit;

    private final UserRepository repository;
    private final UserDTOMapper userDtoMapper;
    private final UserDAOMapper userDaoMapper;

    @Override
    @Transactional
    public UserDTO getUser(Long id) {
        var user = repository.findById(id)
                .map(userDtoMapper);
        return user.orElseGet(() -> createUser(id));
    }

    @Override
    public void updateUser(UserDTO user) {
        repository.save(userDaoMapper.apply(user));
    }

    @Override
    @Transactional
    public void updateAllLimits() {
        repository.updateAllLimits(defaultLimit);
    }

    private UserDTO createUser(Long id) {
        var user = repository.save(new UserDAO(id, defaultLimit, 0L));
        return userDtoMapper.apply(user);
    }
}
