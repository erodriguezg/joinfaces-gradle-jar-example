package org.joinfaces.example.infrastructure.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.joinfaces.example.core.dto.CarViewDto;

@Mapper
public interface CarViewDtoMapper {

    @Results(id = "carViewDtoMapperResults", value = {
            @Result(property = "carId", column = "car_id"),
            @Result(property = "brandId", column = "brand_id"),
            @Result(property = "brandName", column = "brand_name"),
            @Result(property = "brandCountry", column = "brand_country"),
            @Result(property = "modelCode", column = "model_code"),
            @Result(property = "modelName", column = "model_name"),
            @Result(property = "color", column = "color"),
            @Result(property = "buyDate", column = "buy_date"),
            @Result(property = "secondHandCar", column = "second_hand_car"),
    })
    @Select("""
            select distinct
                c.id_car as car_id, c.id_brand as brand_id, cb.name_brand as brand_name, cb.country as brand_country,
                c.model_code, cm.model_name, c.color, c.buy_date, c.second_hand_car
            from cars c
            left join car_models cm on (c.id_brand = cm.id_brand and c.model_code = cm.model_code)
            left join car_brands cb on (cm.id_brand = cb.id_brand)
                    """)
    List<CarViewDto> getAllCarsViewsDto();

    List<CarViewDto> findByExampleCarViewDto(CarViewDto example);

}
