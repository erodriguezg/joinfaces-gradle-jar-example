package org.joinfaces.example.application.jsf.converters;

import org.joinfaces.example.utils.RutConverterUtils;
import org.joinfaces.example.utils.RutConverterUtils.RutConverterException;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;

public class RutConverter implements Converter<Integer> {

    private RutConverterUtils rutConverterUtils;

    public RutConverter(RutConverterUtils rutConverterUtils) {
        this.rutConverterUtils = rutConverterUtils;
    }

    public Integer getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return this.rutConverterUtils.asInteger(value);
        } catch (RutConverterException ex) {
            FacesMessage message = new FacesMessage();
            message.setDetail(ex.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
    }

    public String getAsString(FacesContext context, UIComponent component, Integer rut) {
        try {
            return this.rutConverterUtils.asString(rut);
        } catch (RutConverterException ex) {
            FacesMessage message = new FacesMessage();
            message.setDetail(ex.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
    }
}
