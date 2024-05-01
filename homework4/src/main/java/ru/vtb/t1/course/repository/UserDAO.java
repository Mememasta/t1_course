package ru.vtb.t1.course.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Repository;
import ru.vtb.t1.course.model.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private final HikariDataSource dataSource;

    public UserDAO(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(UserDTO userDTO) {
        var createQuery = String.format("INSERT INTO users(id, username) VALUES (%s, '%s')", userDTO.getId(), userDTO.getUsername());
        execute(createQuery);
    }

    public UserDTO findById(Long userId)  {
        var findByIdQuery = String.format("SELECT * FROM users WHERE id = %s", userId);
        var users = executeWithResult(findByIdQuery);
        if (users.isEmpty()) {
            return null;
        } else if (users.size() == 1) {
            return users.get(0);
        }
        throw new RuntimeException("found not unique users");
    }

    public List<UserDTO> findAll() {
        var findAllQuery = "SELECT * FROM users";
        return executeWithResult(findAllQuery);
    }

    public void delete(Long userId) {
        var deleteQuery = String.format("DELETE FROM users WHERE id = %s", userId);
        execute(deleteQuery);
    }

    private void execute(String sql) {
        try (var statement = dataSource.getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<UserDTO> executeWithResult(String sql) {
        List<UserDTO> users = new ArrayList<>();
        try (var statement = dataSource.getConnection().createStatement()) {
            var result = statement.executeQuery(sql);
            while (result.next()) {
                var user = new UserDTO(result.getLong("id"), result.getString("username"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
