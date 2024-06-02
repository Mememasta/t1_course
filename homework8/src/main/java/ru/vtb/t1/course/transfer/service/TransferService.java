package ru.vtb.t1.course.transfer.service;

public interface TransferService {

    void toTransfer(Long fromUserId, Long toUserId, Long count);

    void replenish(Long toUserId, Long count);
}
