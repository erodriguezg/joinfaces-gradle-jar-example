package org.joinfaces.example.application.jsf.mbeans;

import java.io.Serializable;
import java.util.List;

import org.joinfaces.example.core.model.Car;
import org.joinfaces.example.core.service.CarService;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class IndexBean implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(IndexBean.class);

    private final CarService carService;

    @Getter
    @Setter
    private List<Car> cars;

    @PostConstruct
    public void init() {
        log.info("===> Init IndexBean");
        this.cars = carService.getAllCars();
    }

    public void openCarDialogAction(Car car) {

        log.info("===> enter to openNewCarDialogAction");

        var options = DialogFrameworkOptions.builder()
        .modal(true)
        .width("640")
        .height("340")
        .contentHeight("100%")
        .contentWidth("100%")
        .headerElement("customheader")
        .build();

        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("car", car);
        PrimeFaces.current().dialog().openDynamic("dialogs/saveCar", options, null);
    }

}
