package com.grinyov.library.controllers;

import com.grinyov.library.enums.SearchType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
/**
 * Created by Grinyov Vitaliy on 15.10.15.
 *
 * Реализация поиска
 */

@ManagedBean
@SessionScoped
public class SearchController implements Serializable {

    private SearchType searchType;
    private static Map<String, SearchType> searchList = new HashMap<String, SearchType>();

    public SearchController() {
        ResourceBundle bundle = ResourceBundle.getBundle("com.grinyov.library.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        searchList.put(bundle.getString("author_name"), SearchType.AUTHOR);
        searchList.put(bundle.getString("book_name"), SearchType.TITLE);
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public Map<String, SearchType> getSearchList() {
        return searchList;
    }
}