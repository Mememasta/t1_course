package ru.vtb.t1.course.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtb.t1.course.product.model.dao.UserDAO;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
}
