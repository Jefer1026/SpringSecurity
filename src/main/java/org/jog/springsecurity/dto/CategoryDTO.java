package org.jog.springsecurity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2352590907821195582L;

    private Long id;

    @NotBlank
    @Size(min=4)
    private String name;


}
