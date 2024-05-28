package com.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Operator")
@Data
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operator_name", nullable = false)
    private String operatorName;

}
