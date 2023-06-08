package org.joinfaces.example.application.jsf.mbeans.dialogs;

import java.io.Serializable;
import java.util.List;

import org.joinfaces.example.application.jsf.mbeans.ScopeTypes;
import org.joinfaces.example.core.model.Car;
import org.joinfaces.example.core.model.CarBrand;
import org.joinfaces.example.core.model.CarModel;
import org.joinfaces.example.core.service.CarService;
import org.primefaces.PrimeFaces;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Scope(ScopeTypes.VIEW)
@RequiredArgsConstructor
public class SaveCarBean implements Serializable {

    private final CarService carService;

    @Getter
    @Setter
    private String dialogTitle;

    @Getter
    @Setter
    private Boolean editMode;

    @Getter
    @Setter
    private Car car;

    @Getter
    @Setter
    private List<CarBrand> carBrands;

    @Getter
    @Setter
    private List<CarModel> carModels;

    @PostConstruct
    public void init() {
        this.car = (Car) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("car");
        if (this.car == null) {
            this.car = new Car();
            this.dialogTitle = "New Car";
            this.editMode = false;
        } else {
            this.dialogTitle = "Edit Car";
            this.editMode = true;
        }

        this.carBrands = this.carService.findAllCarBrands();
        loadCarModels();
    }

    public void changeBrand() {
        this.car.setModelCode(null);
        loadCarModels();
    }

    public void accept() {
        this.carService.saveCar(this.car);
        PrimeFaces.current().dialog().closeDynamic(this.car);
    }

    public void cancel() {
        PrimeFaces.current().dialog().closeDynamic(null);
    }

    private void loadCarModels() {
        if (this.car.getIdBrand() != null) {
            var brand = CarBrand.newInstance(this.car.getIdBrand());
            this.carModels = this.carService.findCarModelsByBrand(brand);
        } else {
            this.carModels = null;
        }
    }

}
