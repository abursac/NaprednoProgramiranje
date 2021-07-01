/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.component.validator.impl;
import javax.swing.JPasswordField;
import basketballpractice.controller.view.component.exception.ValidationException;
import basketballpractice.controller.view.component.validator.Validator;

/**
 * Implementacija interfejsa Validator, odnosi se na validaciju sifre
 * @author Aleksandar
 */
public class PasswordValidator implements Validator{

    @Override
    public void validate(Object object) throws ValidationException {
        JPasswordField passwordField = (JPasswordField)object;
        if (passwordField.getPassword().length == 0) throw new ValidationException("Field is empty!");
    }
    
}
