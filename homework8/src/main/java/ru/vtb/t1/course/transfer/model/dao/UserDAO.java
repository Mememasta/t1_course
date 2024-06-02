package ru.vtb.t1.course.transfer.model.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserDAO {

    @Id
    private Long id;

    @Column(name = "limits")
    private Long limits;

    @Column(name = "balance")
    private Long balance;

}
