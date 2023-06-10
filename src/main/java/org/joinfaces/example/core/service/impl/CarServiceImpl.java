package org.joinfaces.example.core.service.impl;

import java.util.List;
import java.util.UUID;

import org.joinfaces.example.core.dto.CarViewDto;
import org.joinfaces.example.core.model.Car;
import org.joinfaces.example.core.model.CarBrand;
import org.joinfaces.example.core.model.CarModel;
import org.joinfaces.example.core.repository.CarBrandRepository;
import org.joinfaces.example.core.repository.CarModelRepository;
import org.joinfaces.example.core.repository.CarRepository;
import org.joinfaces.example.core.repository.CarViewDtoRepository;
import org.joinfaces.example.core.service.CarService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarBrandRepository carBrandRepository;
    private final CarModelRepository carModelRepository;
    private final CarViewDtoRepository carViewDtoRepository;

    @Override
    public List<Car> getAllCars() {
        return this.carRepository.findByExample(null);
    }

    @Override
    public List<Car> findByExample(Car exampleCar) {
        return this.carRepository.findByExample(exampleCar);
    }

    @Override
    public void saveCar(Car car) {
        this.carRepository.saveCar(car);
    }

    @Override
    public void deleteCar(Car car) {
        this.carRepository.deleteCar(car);
    }

    @Override
    public List<CarBrand> findAllCarBrands() {
        return this.carBrandRepository.findAll();
    }

    @Override
    public List<CarModel> findCarModelsByBrand(CarBrand brand) {
        return this.carModelRepository.findByBrand(brand);
    }

    @Override
    public List<CarViewDto> findByExampleCarViewDto(CarViewDto example) {
        return this.carViewDtoRepository.findByExampleCarViewDto(example);
    }

    @Override
    public List<CarViewDto> getAllCarsViewsDto() {
        return this.carViewDtoRepository.getAllCarsViewsDto();
    }

    @Override
    public Car findCarById(UUID idCar) {
        return this.carRepository.findCarById(idCar);
    }

}
