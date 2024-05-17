package org.jog.springsecurity.service;

import org.jog.springsecurity.dto.UserDTO;
import org.jog.springsecurity.persistence.entity.security.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    User registerOne(UserDTO userDTO);

}
