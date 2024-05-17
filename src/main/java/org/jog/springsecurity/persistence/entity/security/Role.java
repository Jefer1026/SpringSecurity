package org.jog.springsecurity.persistence.entity.security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(unique = true, nullable = false)
    private String name;


    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    List<GrantedPermissions> permissions;



}
