package com.grinyov.library.converters;

import com.grinyov.library.controllers.AuthorController;
import com.grinyov.library.dao.Dao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by green on 20.10.2015.
 */
public class AuthorConverter implements Converter {

    private static AuthorController authorController;

    public AuthorConverter() {
        authorController = (AuthorController) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("authorController");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return Dao.getInstance().getAuthor(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println(value);
        return "";//((Author)value).getFio();
    }
}