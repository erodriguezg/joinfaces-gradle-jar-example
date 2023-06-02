package org.joinfaces.example.infraestructure.mybatis;

import java.util.List;

import org.joinfaces.example.core.model.CarBrand;
import org.joinfaces.example.core.repository.CarBrandRepository;
import org.joinfaces.example.infraestructure.mybatis.mapper.CarBrandMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CarBrandMybatis implements CarBrandRepository {

    private final CarBrandMapper mapper;

    @Override
    public List<CarBrand> findAll() {
        return this.mapper.findAll();
    }
    
}
