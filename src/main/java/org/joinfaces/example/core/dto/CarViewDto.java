package org.joinfaces.example.core.dto;

import java.time.LocalDate;
import java.util.UUID;

import org.joinfaces.example.core.model.Car;

import lombok.Data;

@Data
public class CarViewDto {

    private UUID carId;

    private Integer brandId;

    private String brandName;

    private String brandCountry;

    private Integer modelCode;

    private String modelName;

    private String color;

    private LocalDate buyDate;

    private Boolean secondHandCar;

    public Car toNewCar() {
        var car = new Car();
        car.setBuyDate(this.buyDate);
        car.setColor(this.color);
        car.setIdBrand(this.brandId);
        car.setIdCar(this.carId);
        car.setModelCode(this.modelCode);
        car.setSecondHandCar(this.secondHandCar);
        return car;
    }

}
