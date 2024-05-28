package com.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Country")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Column(name = "country_name", nullable = false)
    private String countryName;
}

