package com.qualco.nations.dtos;


import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class CountryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer countryId;
    private String name;
    private BigDecimal area;
    private LocalDate nationalDay;
    private String countryCode2;
    private String countryCode3;
    private Integer regionId;

}
