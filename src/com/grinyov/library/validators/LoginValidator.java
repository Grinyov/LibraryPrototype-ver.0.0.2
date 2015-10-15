package com.grinyov.library.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;

/**
 * Created by Grinyov Vitaliy on 15.10.15.
 *
 * Класс-валидатор, проверяющий корректность ввода
 */
@FacesValidator("com.grinyov.library.validators.LoginValidator")
public class LoginValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value.toString().length() < 5) {
            ResourceBundle bundle = ResourceBundle.getBundle("com.grinyov.library.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesMessage message = new FacesMessage(bundle.getString("login_length_error"));
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

}