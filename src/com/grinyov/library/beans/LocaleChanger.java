package com.grinyov.library.beans;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by green on 19.10.2015.
 *
 * Устанавливает и меняет локаль
 */
@ManagedBean(eager=true)
@SessionScoped
public class LocaleChanger implements Serializable {

    private Locale currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public LocaleChanger() {
    }

    public void changeLocale(String localeCode) {
        currentLocale = new Locale(localeCode);
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }


}
