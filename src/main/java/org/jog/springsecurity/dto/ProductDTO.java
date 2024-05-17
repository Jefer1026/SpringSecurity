package org.jog.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8652913668437711188L;

    private Long id;
    private String name;
    private BigDecimal price;
    private Long categoryId;

}
