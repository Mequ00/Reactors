package com.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Type")
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;
}
