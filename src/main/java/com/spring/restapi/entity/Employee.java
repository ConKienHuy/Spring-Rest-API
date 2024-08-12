package com.spring.restapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee")
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

    public Employee(){}

    public Employee(String maNV, String name, String email) {
        this.maNV = maNV;
        this.name = name;
        this.email = email;
    }

    // Getter, Setter
}
