package com.grinyov.library.controllers;

import com.grinyov.library.dao.Dao;
import com.grinyov.library.entity.Author;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;


@ManagedBean(eager = false)
@ApplicationScoped
public class AuthorController implements Serializable, Converter {

    private List<SelectItem> selectItems = new ArrayList<SelectItem>();;
    private Map<Long,Author> authorMap;

    public AuthorController() {
        authorMap = new HashMap<Long, Author>();
        
        for (Author author : Dao.getInstance().getAllAuthors()) {
            authorMap.put(author.getId(), author);
            selectItems.add(new SelectItem(author, author.getFio()));
        }
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return authorMap.get(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Author)value).getId().toString();
    }

    

}