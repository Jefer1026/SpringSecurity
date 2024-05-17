package org.jog.springsecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.springsecurity.dto.UserDTO;
import org.jog.springsecurity.exception.InvalidPasswordException;
import org.jog.springsecurity.exception.ObjectNotFoundException;
import org.jog.springsecurity.persistence.entity.security.Role;
import org.jog.springsecurity.persistence.entity.security.User;
import org.jog.springsecurity.persistence.repository.UserRepository;
import org.jog.springsecurity.service.RoleService;
import org.jog.springsecurity.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User registerOne(UserDTO userDTO) {
        validatePassword(userDTO);

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        Role defaultRole = roleService.findDefaultRole()
                .orElseThrow(() -> new ObjectNotFoundException("Default role not found"));

        user.setRole(defaultRole);

        return userRepository.save(user);
    }

    private void validatePassword(UserDTO userDTO) {

        if (!StringUtils.hasText(userDTO.getPassword()) || !StringUtils.hasText(userDTO.getRepeatedPassword())) {
            throw new InvalidPasswordException("Is necessary password");
        }

        if (!userDTO.getPassword().equals(userDTO.getRepeatedPassword())) {
            throw new InvalidPasswordException("passwords do not match");
        }
    }
}
