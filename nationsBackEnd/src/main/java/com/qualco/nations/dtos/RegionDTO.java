package com.qualco.nations.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class RegionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer regionId;

    private String name;

    private Integer continentId;

}
