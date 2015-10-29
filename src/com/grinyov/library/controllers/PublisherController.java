package com.grinyov.library.controllers;

import com.grinyov.library.comparators.ListComparator;
import com.grinyov.library.dao.Dao;
import com.grinyov.library.entity.Publisher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
public class PublisherController implements Serializable, Converter {

    private List<SelectItem> selectItems = new ArrayList<SelectItem>();
    private Map<Long, Publisher> map;
    private List<Publisher> list;

    public PublisherController() {

        map = new HashMap<Long, Publisher>();
        list = Dao.getInstance().getAllPublishers();
        
        Collections.sort(list, ListComparator.getInstance());

        for (Publisher publisher : list) {
            map.put(publisher.getId(), publisher);
            selectItems.add(new SelectItem(publisher, publisher.getName()));
        }

    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public List<Publisher> getPublisherList() {
        return list;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return map.get(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Publisher)value).getId().toString();
    }
}
