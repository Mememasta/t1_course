package ru.vtb.t1.course.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vtb.t1.course.transfer.model.dao.UserDAO;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {

    @Modifying
    @Query("""
        UPDATE UserDAO u SET u.limits = :limits
    """)
    void updateAllLimits(@Param("limits") Long limits);

}
