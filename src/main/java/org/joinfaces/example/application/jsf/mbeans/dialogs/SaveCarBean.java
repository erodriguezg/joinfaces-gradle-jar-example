package org.joinfaces.example.application.jsf.mbeans.dialogs;

import java.io.Serializable;

import org.joinfaces.example.application.jsf.mbeans.ScopeTypes;
import org.joinfaces.example.core.model.Car;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

@Component
@Scope(ScopeTypes.VIEW)
public class SaveCarBean implements Serializable{

    @Getter
    @Setter
    private String dialogTitle;

    @Getter
    @Setter
    private Car car;

    @PostConstruct
    public void init() {
        this.car = (Car) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("car");
        if (this.car == null) {
            this.car = new Car();
            this.dialogTitle = "New Car";
        } else {
            this.dialogTitle = "Edit Car";
        }
    }
    
}
