package org.joinfaces.example.core.repository;

import java.util.List;

import org.joinfaces.example.core.model.CarBrand;
import org.joinfaces.example.core.model.CarModel;

public interface CarModelRepository {
    List<CarModel> findByBrand(CarBrand brand);
}
