package org.joinfaces.example.core.repository;

import java.util.List;

import org.joinfaces.example.core.model.Car;

public interface CarRepository {

    List<Car> findByExample(Car exampleCar);

    void saveCar(Car car);

    void deleteCar(Car car);

}
