package org.jog.springsecurity.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Min(value = 3)
    private String name;

    @NotBlank
    @DecimalMin(value = "0.01")
    private BigDecimal price;

    @NotBlank
    @Min(value = 1)
    private Long categoryId;

}
