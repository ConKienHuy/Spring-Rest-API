package com.spring.restapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "maNV")
    private String maNV;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    // Contructor

    // Getter, Setter
}
