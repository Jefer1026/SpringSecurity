package org.jog.springsecurity.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    private String name;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(referencedColumnName = "category_id")
    private Category category;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public enum ProductStatus {
        ENABLED, DISABLED
    }
}
