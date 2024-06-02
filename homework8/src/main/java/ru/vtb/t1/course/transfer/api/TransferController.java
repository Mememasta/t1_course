package ru.vtb.t1.course.transfer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.t1.course.transfer.model.dto.TransferDTO;
import ru.vtb.t1.course.transfer.model.dto.UserDTO;
import ru.vtb.t1.course.transfer.service.TransferService;
import ru.vtb.t1.course.transfer.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/account")
public class TransferController {

    private final UserService userService;
    private final TransferService transferService;

    @GetMapping
    public UserDTO getUser(@RequestParam Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/transfer")
    public void toTransfer(@RequestBody TransferDTO request) {
        transferService.toTransfer(request.from(), request.to(), request.count());
    }

    @PostMapping("/replenish")
    public void replenish(@RequestBody TransferDTO request) {
        transferService.replenish(request.to(), request.count());
    }

}
