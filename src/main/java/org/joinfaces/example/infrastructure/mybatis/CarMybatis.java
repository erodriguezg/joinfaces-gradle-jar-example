package org.joinfaces.example.infrastructure.mybatis;

import java.util.List;
import java.util.UUID;

import org.joinfaces.example.core.model.Car;
import org.joinfaces.example.core.repository.CarRepository;
import org.joinfaces.example.infrastructure.mybatis.mapper.CarMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CarMybatis implements CarRepository {

    private final CarMapper mapper;

    @Override
    public List<Car> findByExample(Car exampleCar) {
        return this.mapper.findByExample(exampleCar);
    }

    @Override
    public void saveCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("the input car must not be null");
        }
        if (car.getIdCar() == null) {
            car.setIdCar(UUID.randomUUID());
            this.mapper.insertCar(car);
        } else {
            this.mapper.updateCar(car);
        }
    }

    @Override
    public void deleteCar(Car car) {
        this.mapper.deleteCar(car);
    }

    @Override
    public Car findCarById(UUID idCar) {
        return this.mapper.findCarById(idCar);
    }

}
