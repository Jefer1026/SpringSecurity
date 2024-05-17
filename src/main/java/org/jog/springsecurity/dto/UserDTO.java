package org.jog.springsecurity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 847967055473086331L;

    @NotBlank
    @Size(min = 4)
    private String name;

    @NotBlank
    @Size(min = 4)
    private String username;

    @NotBlank
    @Size(min = 8)
    private String password;


    @NotBlank
    @Size(min = 8)
    private String repeatedPassword;
}
