package org.joinfaces.example.application.jsf.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Component
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class JsfUtilsImpl implements JsfUtils {

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
