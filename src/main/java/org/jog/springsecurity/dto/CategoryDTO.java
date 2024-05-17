package org.jog.springsecurity.dto;

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
    private String name;


}
