package ru.vtb.t1.course.product.model.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserDAO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    public UserDAO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDAO() {

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
