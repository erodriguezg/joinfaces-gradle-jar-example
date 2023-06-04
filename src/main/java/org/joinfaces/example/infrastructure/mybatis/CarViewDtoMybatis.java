package org.joinfaces.example.infrastructure.mybatis;

import java.util.List;

import org.joinfaces.example.core.dto.CarViewDto;
import org.joinfaces.example.core.repository.CarViewDtoRepository;
import org.joinfaces.example.infrastructure.mybatis.mapper.CarViewDtoMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CarViewDtoMybatis implements CarViewDtoRepository {

    private final CarViewDtoMapper mapper;

    @Override
    public List<CarViewDto> getAllCarsViewsDto() {
        return this.mapper.getAllCarsViewsDto();
    }

    @Override
    public List<CarViewDto> findByExampleCarViewDto(CarViewDto example) {
        return this.mapper.findByExampleCarViewDto(example);
    }

}
