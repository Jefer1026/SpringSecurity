package org.jog.springsecurity.persistence.entity.security;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GrantedPermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grantedPermissionsId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "operation_id")
    private Operation operation;

    @ManyToOne
    @JoinColumn(referencedColumnName = "role_id")
    private Role role;
}
