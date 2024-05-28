package com.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Region")
@Data
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_name", nullable = false)
    private String regionName;

}
