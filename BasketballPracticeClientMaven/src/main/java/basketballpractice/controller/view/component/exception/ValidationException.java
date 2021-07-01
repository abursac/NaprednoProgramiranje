/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.component.exception;

/**
 * Vrsta Exception-a, nasledjuje klasu Exception
 * @author Aleksandar
 */
public class ValidationException extends Exception {

    /**
     * Konstruktor koji poziva konstruktor nadklase
     * @param message
     */
    public ValidationException(String message) {
        super(message);
    }
}
