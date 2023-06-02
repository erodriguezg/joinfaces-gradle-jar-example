package org.joinfaces.example.core.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarModel implements Serializable {

    private Integer idBrand;

    private Integer modelCode;

    private String modelName;

}
