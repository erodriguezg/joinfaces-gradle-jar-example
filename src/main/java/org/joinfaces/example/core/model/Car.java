package org.joinfaces.example.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Car implements Serializable {

    @EqualsAndHashCode.Include
    private UUID idCar;

    private Integer idBrand;

    private Integer modelCode;

    private String color;

    private LocalDate buyDate;

    private Boolean secondHandCar;

}
