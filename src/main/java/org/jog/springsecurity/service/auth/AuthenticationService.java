package org.jog.springsecurity.service.auth;

import lombok.RequiredArgsConstructor;
import org.jog.springsecurity.dto.RegisterUserDTO;
import org.jog.springsecurity.dto.UserDTO;
import org.jog.springsecurity.persistence.entity.security.User;
import org.jog.springsecurity.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;

    private Map<String, Object> generateExtraClaims(User user) {

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("role", user.getRole().getName());
        extraClaims.put("authorities", user.getAuthorities());

        return extraClaims;
    }

    public RegisterUserDTO registerUser(UserDTO userDTO) {

        User user = userService.registerOne(userDTO);

        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        registerUserDTO.setId(user.getUserId());
        registerUserDTO.setName(user.getName());
        registerUserDTO.setUsername(user.getUsername());
        registerUserDTO.setRole(user.getRole().getName());

        String jwt = jwtService.generateJwt(user, generateExtraClaims(user));
        registerUserDTO.setJwt(jwt);

        return registerUserDTO;
    }


}
