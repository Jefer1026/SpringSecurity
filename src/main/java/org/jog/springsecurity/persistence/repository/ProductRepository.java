package org.jog.springsecurity.persistence.repository;

import org.jog.springsecurity.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
