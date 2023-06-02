package org.joinfaces.example.infraestructure.mybatis;

import java.util.List;

import org.joinfaces.example.core.model.Car;
import org.joinfaces.example.core.repository.CarRepository;
import org.joinfaces.example.infraestructure.mybatis.mapper.CarMapper;
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
        this.mapper.saveCar(car);
    }

    @Override
    public void deleteCar(Car car) {
        this.mapper.deleteCar(car);
    }

}
