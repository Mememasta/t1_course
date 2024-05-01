package ru.vtb.t1.course.model;

public class UserDTO {

    private final Long id;

    private final String username;

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
