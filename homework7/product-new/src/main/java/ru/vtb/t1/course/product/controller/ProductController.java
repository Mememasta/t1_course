package ru.vtb.t1.course.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtb.t1.course.product.model.dto.ProductDTO;
import ru.vtb.t1.course.product.service.impl.ProductServiceImpl;

import java.util.List;

/**
 * @author mchuchalov on 01.05.2024
 */
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody ProductDTO request) {
        productService.save(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
        public List<ProductDTO> getProductsByUserId(@RequestParam("userId") Long userId) {
        return productService.findAllByUserId(userId);
    }

    @GetMapping("/{productId}")
    public ProductDTO getProductById(@PathVariable("productId") Long productId) {
        return productService.findById(productId);
    }

}
