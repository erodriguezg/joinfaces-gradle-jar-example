package org.joinfaces.example.infrastructure.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.joinfaces.example.core.model.CarBrand;

@Mapper
public interface CarBrandMapper {

    @Results(id = "carBrandMapperResults", value = {
            @Result(property = "idBrand", column = "id_brand", id = true),
            @Result(property = "nameBrand", column = "name_brand"),
            @Result(property = "country", column = "country")
    })
    @Select("select * from car_brands")
    List<CarBrand> findAll();

}
