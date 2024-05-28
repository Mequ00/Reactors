package com.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Owner")
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

}
