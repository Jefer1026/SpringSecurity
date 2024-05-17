package org.jog.springsecurity.persistence.entity.security;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    private Long operationId;

    @Column(name = "operation_name", length = 50, nullable = false)
    private String operationName;

    @Column(length = 50)
    private String path;

    @Column(name ="http_method",length = 50, nullable = false)
    private String httpMethod;

    @Column(name ="permit_all", length = 10, nullable = false)
    private boolean permitAll;

    @ManyToOne
    @JoinColumn(referencedColumnName = "module_id")
    private Module module;
}
