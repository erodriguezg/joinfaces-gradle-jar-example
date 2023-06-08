package org.joinfaces.example.application.jsf.converters;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;

@Component
public class JsonConverter implements Converter<Object> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String SEPARADOR_JSON = "_JSON_";

    private static final String ERROR_DE_CONVERSION_MSG = "Error de conversión";

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String objetSerializedParam) {
        if (objetSerializedParam == null || objetSerializedParam.trim().isEmpty()) {
            return null;
        }
        Pattern p = Pattern.compile("^(.*)" + SEPARADOR_JSON + "(.*)");

        String objetSerialized;
        try {
            objetSerialized = new String(Base64.getUrlDecoder().decode(objetSerializedParam));
        } catch (IllegalArgumentException ex) {
            objetSerialized = objetSerializedParam;
        } catch (RuntimeException ex) {
            throw new ConverterException(ERROR_DE_CONVERSION_MSG, ex);
        }

        Matcher m = p.matcher(objetSerialized);
        if (!m.matches()) {
            return null;
        }
        String className = m.group(1);
        String json = m.group(2);
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            throw new ConverterException(ERROR_DE_CONVERSION_MSG);
        }

        return jsonToObject(json, clazz);

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        String json = objectToJson(o);
        String clazz = o.getClass().getName();
        try {
            return Base64.getUrlEncoder().encodeToString((clazz + SEPARADOR_JSON + json).getBytes());
        } catch (RuntimeException ex) {
            throw new ConverterException(ERROR_DE_CONVERSION_MSG, ex);
        }
    }

    private static String objectToJson(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error de conversión objeto a json", e);
        }
    }

    private static Object jsonToObject(String json, Class<?> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error de conversión json a objeto", e);
        }
    }

}
