package org.joinfaces.example.core.repository;

import java.util.List;
import java.util.UUID;

import org.joinfaces.example.core.model.Car;

public interface CarRepository {

    Car findCarById(UUID idCar);

    List<Car> findByExample(Car exampleCar);

    void saveCar(Car car);

    void deleteCar(Car car);

}
