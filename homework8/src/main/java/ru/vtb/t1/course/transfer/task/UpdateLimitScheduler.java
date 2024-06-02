package ru.vtb.t1.course.transfer.task;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.vtb.t1.course.transfer.service.UserService;

@Component
@RequiredArgsConstructor
public class UpdateLimitScheduler {

    private final UserService userService;

    @Scheduled(cron = "${task.crone-expression}")
    public void updateAllLimit() {
        userService.updateAllLimits();
    }

}
