package ru.vtb.t1.course.transfer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private Long limits;
    private Long balance;
}
