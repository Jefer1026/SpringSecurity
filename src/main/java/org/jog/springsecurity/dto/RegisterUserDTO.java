package org.jog.springsecurity.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class RegisterUserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 3411692285853298907L;


    private Long id;
    private String name;
    private String username;
    private String role;
    private String jwt;
}
