package ru.vtb.t1.course.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtb.t1.course.product.model.dao.ProductDAO;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDAO, Long> {

    List<ProductDAO> findAllByUserId(Long userId);

}
