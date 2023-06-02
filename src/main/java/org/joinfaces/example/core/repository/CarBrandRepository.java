package org.joinfaces.example.core.repository;

import java.util.List;

import org.joinfaces.example.core.model.CarBrand;

public interface CarBrandRepository {
    
    List<CarBrand> findAll();

}
