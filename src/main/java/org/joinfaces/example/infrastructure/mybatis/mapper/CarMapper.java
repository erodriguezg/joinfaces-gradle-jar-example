package org.joinfaces.example.infrastructure.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.joinfaces.example.core.model.Car;

@Mapper
public interface CarMapper {

    @Insert("""
            insert into cars
            (id_car, id_brand, model_code, color, buy_date,  second_hand_car)
            values
            (#{idCar},
            #{idBrand}, #{modelCode}, #{color}, #{buyDate}, #{secondHandCar})
            """)
    void insertCar(Car car);

    @Update("""
            update cars
            set id_brand = #{idBrand}, model_code = #{modelCode},
            color = #{color}, buy_date = #{buyDate}, second_hand_car = #{secondHandCar}
            where id_car = #{idCar}
            """)
    void updateCar(Car car);

    @Delete("""
            delete from cars
            where id_car = #{idCar}
            """)
    void deleteCar(Car car);

    @Results(id = "carMapperResults", value = {
            @Result(property = "idCar", column = "id_car"),
            @Result(property = "idBrand", column = "id_brand"),
            @Result(property = "modelCode", column = "model_code"),
            @Result(property = "color", column = "color"),
            @Result(property = "buyDate", column = "buy_date"),
            @Result(property = "secondHandCar", column = "second_hand_car")
    })
    @SelectProvider(type = CarMapper.class, method = "findByExampleProvider")
    List<Car> findByExample(Car exampleCar);

    static String findByExampleProvider(Car exampleCar) {
        var query = new StringBuilder();
        query = query.append("""
                    select * from cars
                    where 1 = 1
                """);
        if (exampleCar != null) {
            if (exampleCar.getIdCar() != null) {
                query = query.append(
                        "and id_car = #{idCar}");
            }
            if (exampleCar.getIdBrand() != null) {
                query = query.append("and id_brand = #{idBrand}");
            }
            if (exampleCar.getModelCode() != null) {
                query = query.append("and model_code = #{modelCode}");
            }
            if (exampleCar.getColor() != null) {
                query = query.append("and upper(color) like upper('%' || #{color} || '%') ");
            }
            if (exampleCar.getSecondHandCar() != null) {
                query = query.append("and second_hand_car = #{secondHandCar}");
            }
        }
        return query.toString();
    }
}
