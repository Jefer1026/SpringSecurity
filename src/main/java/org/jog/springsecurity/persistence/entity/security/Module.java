package org.jog.springsecurity.persistence.entity.security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private Long moduleId;


    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String BasePath;
}
