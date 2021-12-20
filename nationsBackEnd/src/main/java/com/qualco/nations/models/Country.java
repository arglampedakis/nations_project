package com.qualco.nations.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "countries")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "country_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;

    @Column(name = "name")
    private String name;

    @Column(name = "area", nullable = false)
    private BigDecimal area;

    @Column(name = "national_day")
    private LocalDate nationalDay;

    @Column(name = "country_code2", nullable = false)
    private String countryCode2;

    @Column(name = "country_code3", nullable = false)
    private String countryCode3;

    @Column(name = "region_id", nullable = false)
    private Integer regionId;

}
