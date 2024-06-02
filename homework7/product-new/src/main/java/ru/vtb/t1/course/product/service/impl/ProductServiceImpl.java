package ru.vtb.t1.course.product.service.impl;

import org.springframework.stereotype.Service;
import ru.vtb.t1.course.product.exception.NotFoundException;
import ru.vtb.t1.course.product.mapper.ProductDaoMapper;
import ru.vtb.t1.course.product.model.dao.ProductDAO;
import ru.vtb.t1.course.product.model.dto.ProductDTO;
import ru.vtb.t1.course.product.repository.ProductRepository;
import ru.vtb.t1.course.product.service.ProductService;

import java.util.List;

/**
 * @author mchuchalov on 01.05.2024
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductDaoMapper productDaoMapper;

    public ProductServiceImpl(ProductRepository repository, ProductDaoMapper productDaoMapper) {
        this.repository = repository;
        this.productDaoMapper = productDaoMapper;
    }

    public void save(ProductDTO productDTO) {
        var productDao = new ProductDAO(productDTO.getId(), productDTO.getUserId(), productDTO.getAccountNumber(), productDTO.getBalance(), productDTO.getProductType().name());
        repository.save(productDao);
    }

    public List<ProductDTO> findAllByUserId(Long userId) {
        return repository.findAllByUserId(userId).stream()
                .map(productDaoMapper)
                .toList();
    }

    public ProductDTO findById(Long productId) {
        return repository.findById(productId)
                .map(productDaoMapper)
                .orElseThrow(() -> new NotFoundException("Не найден продукт"));
    }

}
