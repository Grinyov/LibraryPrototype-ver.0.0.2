package com.grinyov.library.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
/**
 * Created by Grinyov Vitaliy on 14.10.15.
 *
 * Контроллер входа в систему
 */
@ManagedBean
@RequestScoped
public class LoginController {

    public LoginController() {
    }

    public String login() {
        return "books";
    }

    public String exit(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "exit";
    }

}
