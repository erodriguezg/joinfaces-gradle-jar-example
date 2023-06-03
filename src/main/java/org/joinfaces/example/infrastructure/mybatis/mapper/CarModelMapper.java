package org.joinfaces.example.infrastructure.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.joinfaces.example.core.model.CarBrand;
import org.joinfaces.example.core.model.CarModel;

@Mapper
public interface CarModelMapper {

        @Results(id = "carModelMapperResults", value = {
                        @Result(property = "idBrand", column = "id_brand"),
                        @Result(property = "modelCode", column = "model_code"),
                        @Result(property = "modelName", column = "model_name")
        })
        @Select("""
                        select * from car_models
                        where id_brand = #{idBrand}
                        """)
        List<CarModel> findByBrand(CarBrand brand);

}
