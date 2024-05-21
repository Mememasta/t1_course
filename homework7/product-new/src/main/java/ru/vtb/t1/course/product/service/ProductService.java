package ru.vtb.t1.course.product.service;

import ru.vtb.t1.course.product.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void save(ProductDTO productDTO);

    List<ProductDTO> findAllByUserId(Long userId);

    ProductDTO findById(Long productId);

}
