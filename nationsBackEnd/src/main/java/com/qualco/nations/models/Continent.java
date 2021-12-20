package com.qualco.nations.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "continents")
public class Continent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "continent_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer continentId;

    @Column(name = "name", nullable = false)
    private String name;

}
