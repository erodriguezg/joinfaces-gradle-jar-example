package org.joinfaces.example.infraestructure.mybatis;

import java.util.List;

import org.joinfaces.example.core.model.CarBrand;
import org.joinfaces.example.core.model.CarModel;
import org.joinfaces.example.core.repository.CarModelRepository;
import org.joinfaces.example.infraestructure.mybatis.mapper.CarModelMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CarModelMybatis implements CarModelRepository {

    private final CarModelMapper mapper;

    @Override
    public List<CarModel> findByBrand(CarBrand brand) {
        return mapper.findByBrand(brand);
    }

}
