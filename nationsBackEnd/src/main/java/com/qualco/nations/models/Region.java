package com.qualco.nations.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "regions")
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "region_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regionId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "continent_id", nullable = false)
    private Integer continentId;

}
