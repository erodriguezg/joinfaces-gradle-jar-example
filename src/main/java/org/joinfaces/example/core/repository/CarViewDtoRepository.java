package org.joinfaces.example.core.repository;

import java.util.List;

import org.joinfaces.example.core.dto.CarViewDto;

public interface CarViewDtoRepository {

    List<CarViewDto> getAllCarsViewsDto();

    List<CarViewDto> findByExampleCarViewDto(CarViewDto example);

}
