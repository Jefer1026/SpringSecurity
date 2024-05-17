package org.jog.springsecurity.service;

import org.jog.springsecurity.persistence.entity.security.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findDefaultRole();
}
