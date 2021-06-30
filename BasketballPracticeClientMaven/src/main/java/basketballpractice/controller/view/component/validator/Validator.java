/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.component.validator;

import basketballpractice.controller.view.component.exception.ValidationException;

/**
 *
 * @author Aleksandar
 */
public interface Validator {
    void validate(Object object) throws ValidationException;
}
