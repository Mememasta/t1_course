package ru.vtb.t1.course.product.mapper;

import org.springframework.stereotype.Component;
import ru.vtb.t1.course.product.model.dao.ProductDAO;
import ru.vtb.t1.course.product.model.dto.ProductDTO;

import java.util.function.Function;

@Component
public class ProductDaoMapper implements Function<ProductDAO, ProductDTO> {
    @Override
    public ProductDTO apply(ProductDAO productDAO) {
        return new ProductDTO(productDAO.getId(), productDAO.getUserId(), productDAO.getAccountNumber(), productDAO.getBalance(), productDAO.getProductType());
    }
}
