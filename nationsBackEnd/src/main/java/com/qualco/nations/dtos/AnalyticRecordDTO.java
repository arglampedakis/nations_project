package com.qualco.nations.dtos;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class AnalyticRecordDTO {
    private static final long serialVersionUID = 1L;

    private Integer countryId;
    private String continentName;
    private String regionName;
    private String countryName;
    private Integer year;
    private BigDecimal gdp;
    private Integer population;
}
