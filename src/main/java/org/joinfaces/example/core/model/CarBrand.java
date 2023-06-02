package org.joinfaces.example.core.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarBrand implements Serializable {
    
    @EqualsAndHashCode.Include
    private Integer idBrand;

    private String nameBrand;

    private String country;

}
