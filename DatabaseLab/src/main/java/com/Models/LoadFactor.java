package com.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "LoadFactor")
@Data
public class LoadFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reactor_id", nullable = false)
    @JsonBackReference
    private Reactor reactor;

    @Column(name = "load_factor")
    private Float loadFactor;

    @Column(name = "year", nullable = false)
    private int year;
}
