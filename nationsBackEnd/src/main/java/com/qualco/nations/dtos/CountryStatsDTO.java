package com.qualco.nations.dtos;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class CountryStatsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer countryId;
    private Integer year;
    private String name;
    private String countryCode3;
    private BigDecimal gdp;
    private Integer population;
}
