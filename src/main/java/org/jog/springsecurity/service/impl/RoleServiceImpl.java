package org.jog.springsecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.springsecurity.persistence.entity.security.Role;
import org.jog.springsecurity.persistence.repository.RoleRepository;
import org.jog.springsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Value("CUSTOMER")
    private String defaultRole;
    @Override
    public Optional<Role> findDefaultRole() {
        return roleRepository.findByName(defaultRole);
    }
}
