package org.joinfaces.example.core.service;

import java.util.List;
import java.util.UUID;

import org.joinfaces.example.core.dto.CarViewDto;
import org.joinfaces.example.core.model.Car;
import org.joinfaces.example.core.model.CarBrand;
import org.joinfaces.example.core.model.CarModel;

public interface CarService {

    Car findCarById(UUID idCar);

    List<CarViewDto> getAllCarsViewsDto();

    List<CarViewDto> findByExampleCarViewDto(CarViewDto example);

    List<Car> getAllCars();

    List<Car> findByExample(Car exampleCar);

    void saveCar(Car car);

    void deleteCar(Car car);

    List<CarBrand> findAllCarBrands();

    List<CarModel> findCarModelsByBrand(CarBrand brand);

}
