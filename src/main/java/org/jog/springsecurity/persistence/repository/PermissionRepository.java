package org.jog.springsecurity.persistence.repository;

import org.jog.springsecurity.persistence.entity.security.GrantedPermissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<GrantedPermissions, Long> {

}

