package org.jog.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.jog.springsecurity.dto.ProductDTO;
import org.jog.springsecurity.persistence.entity.Product;
import org.jog.springsecurity.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {

        Page<Product> productPage = productService.findAll(pageable);

        return productPage.hasContent() ?
                ResponseEntity.ok(productPage) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findById(@PathVariable Long productId) {

        return productService.findById(productId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createOne(productDTO));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(@PathVariable Long productId,
                                           @RequestBody ProductDTO productDTO) {

        return ResponseEntity.ok(productService.updateOne(productDTO, productId));

    }

    @PutMapping("/{productId}/disabled")
    public ResponseEntity<Product> disable(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.disableOne(productId));
    }
}
