package org.joinfaces.example.core.service;

import java.util.List;

import org.joinfaces.example.core.model.Car;
import org.joinfaces.example.core.model.CarBrand;
import org.joinfaces.example.core.model.CarModel;

public interface CarService {

    List<Car> getAllCars();

    List<Car> findByExample(Car exampleCar);

    void saveCar(Car car);

    void deleteCar(Car car);

    List<CarBrand> findAllCarBrands();

    List<CarModel> findCarModelsByBrand(CarBrand brand);

}
