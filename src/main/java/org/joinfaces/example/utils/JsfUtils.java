package org.joinfaces.example.utils;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class JsfUtils {

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}