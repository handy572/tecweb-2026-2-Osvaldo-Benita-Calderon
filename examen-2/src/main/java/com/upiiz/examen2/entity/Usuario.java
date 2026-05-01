package com.upiiz.examen2.entity;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String rol;

}
