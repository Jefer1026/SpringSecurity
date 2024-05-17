package org.jog.springsecurity.service;

import org.jog.springsecurity.dto.ProductDTO;
import org.jog.springsecurity.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Long productId);

    Product createOne(ProductDTO productDTO);

    Product updateOne(ProductDTO productDTO, Long productId);

    Product disableOne(Long productId);
}
