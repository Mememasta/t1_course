package ru.vtb.t1.course.transfer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vtb.t1.course.transfer.exception.TransferException;
import ru.vtb.t1.course.transfer.service.TransferService;
import ru.vtb.t1.course.transfer.service.UserService;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final UserService userService;

    @Override
    @Transactional
    public void toTransfer(Long fromUserId, Long toUserId, Long count) {
        var fromUser = userService.getUser(fromUserId);
        var toUser = userService.getUser(toUserId);

        var currentLimit = fromUser.getLimits() - count;
        var currentBalance = fromUser.getBalance() - count;
        if (currentLimit < 0) {
            throw new TransferException("Превышен лимит");
        }
        if (currentBalance < 0) {
            throw new TransferException("Недостаточно средств на счете");
        }
        fromUser.setLimits(currentLimit);
        fromUser.setBalance(currentBalance);
        userService.updateUser(fromUser);

        toUser.setBalance(toUser.getBalance() + count);
        userService.updateUser(toUser);
    }

    @Override
    public void replenish(Long toUserId, Long count) {
        var toUser = userService.getUser(toUserId);
        toUser.setBalance(toUser.getBalance() + count);
        userService.updateUser(toUser);
    }
}
