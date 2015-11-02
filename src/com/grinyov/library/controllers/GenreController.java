package com.grinyov.library.controllers;

import com.grinyov.library.dao.Dao;
import com.grinyov.library.entity.ext.GenreExt;
import com.grinyov.library.comparators.ListComparator;
import com.grinyov.library.beans.Pager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;


@ManagedBean
@SessionScoped
public class GenreController implements Serializable, Converter {

    private List<SelectItem> selectItems = new ArrayList<SelectItem>();
    private Map<Long, GenreExt> map;
    private List<GenreExt> list;
    private Pager pager;
    private Dao dao;
    @ManagedProperty(value = "#{bookListController}")
    private BookListController bookListController;


    @PostConstruct
    public void init() {
        pager = bookListController.getPager();
        dao = bookListController.getDataHelper();

        map = new HashMap<Long, GenreExt>();
        list = dao.getAllGenres();
        Collections.sort(list, ListComparator.getInstance());

        for (GenreExt genre : list) {
            map.put(genre.getId(), genre);
            selectItems.add(new SelectItem(genre, genre.getName()));
        }

    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public List<GenreExt> getGenreList() {
        return list;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return map.get(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((GenreExt) value).getId().toString();
    }

    public BookListController getBookListController() {
        return bookListController;
    }

    public void setBookListController(BookListController bookListController) {
        this.bookListController = bookListController;
    }
    
    
}
