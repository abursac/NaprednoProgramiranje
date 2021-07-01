/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.component.validator;

import basketballpractice.controller.view.component.exception.ValidationException;

/**
 * Interfejs koji sadrzi jednu metodu, sluzi za validaciju unetog teksta
 * @author Aleksandar
 */
public interface Validator {

    /**
     * Metoda koja vrsi validaciju primljenog objekta, baca ValidationException
     * @param object
     * @throws ValidationException
     */
    void validate(Object object) throws ValidationException;
}
