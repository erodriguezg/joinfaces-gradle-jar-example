package org.joinfaces.example.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Car implements Serializable {

    @EqualsAndHashCode.Include
    private UUID idCar;

    @NotNull
    private Integer idBrand;

    @NotNull
    private Integer modelCode;

    private String color;

    @NotNull
    private LocalDate buyDate;

    @NotNull
    private Boolean secondHandCar;

    public static Car newInstance(UUID idCar) {
        var car = new Car();
        car.setIdCar(idCar);
        return car;
    }

}
