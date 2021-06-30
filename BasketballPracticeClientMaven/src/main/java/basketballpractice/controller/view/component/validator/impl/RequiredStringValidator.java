/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.component.validator.impl;

import basketballpractice.controller.view.component.exception.ValidationException;
import basketballpractice.controller.view.component.validator.Validator;

/**
 *
 * @author Aleksandar
 */
public class RequiredStringValidator implements Validator{
    @Override
    public void validate(Object object) throws ValidationException {
        if (!(object instanceof String)) throw new ValidationException("Object is not String!");
        if (object.toString().isEmpty()) throw new ValidationException("Field is empty!");
    }
}
