package ru.vtb.t1.course.product.model;

public class UserDTO {

    private Long id;

    private String username;

    public UserDTO() {
    }

    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{id=" + this.id + ", username='" + this.username + "'}";
    }
}
