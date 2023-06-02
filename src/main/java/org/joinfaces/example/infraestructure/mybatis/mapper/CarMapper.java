package org.joinfaces.example.infraestructure.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.joinfaces.example.core.model.Car;

@Mapper
public interface CarMapper {
    
    List<Car> findByExample(Car exampleCar);

    void saveCar(Car car);

    void deleteCar(Car car);
    
}
