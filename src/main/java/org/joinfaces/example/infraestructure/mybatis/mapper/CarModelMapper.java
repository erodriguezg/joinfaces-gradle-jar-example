package org.joinfaces.example.infraestructure.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.joinfaces.example.core.model.CarBrand;
import org.joinfaces.example.core.model.CarModel;

@Mapper
public interface CarModelMapper {

    List<CarModel> findByBrand(CarBrand brand);
    
}
