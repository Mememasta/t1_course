package ru.vtb.t1.course.service;

import org.springframework.stereotype.Service;
import ru.vtb.t1.course.model.ProductDTO;
import ru.vtb.t1.course.repository.ProductRepository;

import java.util.List;

/**
 * @author mchuchalov on 01.05.2024
 */
@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(ProductDTO productDTO) {
        repository.save(productDTO);
    }

    public List<ProductDTO> findAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    public ProductDTO findById(Long productId) {
        return repository.findById(productId);
    }

}
