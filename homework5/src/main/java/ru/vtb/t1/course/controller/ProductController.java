package ru.vtb.t1.course.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.t1.course.model.ProductDTO;
import ru.vtb.t1.course.service.ProductService;

import java.util.List;

/**
 * @author mchuchalov on 01.05.2024
 */
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
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
