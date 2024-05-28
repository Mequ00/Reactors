package com.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Reactor")
@Data
public class Reactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "operator_id", nullable = true)
    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    private Owner owner;

    @Column(name = "thermal_capacity", nullable = false)
    private int thermalCapacity;

    @Column(name = "reactor_name", nullable = false)
    private String reactorName;

    @Column(name = "connection_date", nullable = false)
    private Date connectionDate;

    @Column(name = "shutdown_date", nullable = true)
    private Date shutdownDate;

    @OneToMany(mappedBy = "reactor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LoadFactor> loadFactors;
}
