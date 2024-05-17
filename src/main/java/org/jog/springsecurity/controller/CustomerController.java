package org.jog.springsecurity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jog.springsecurity.dto.RegisterUserDTO;
import org.jog.springsecurity.dto.UserDTO;
import org.jog.springsecurity.service.auth.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisterUserDTO> registerOne(@RequestBody @Valid UserDTO userDTO) {

        RegisterUserDTO registerUserDTO = authenticationService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerUserDTO);
    }
}
