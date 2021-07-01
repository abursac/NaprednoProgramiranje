/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.communication;

import java.io.Serializable;

/**
 * Klasa koja sluzi za odgovor servera ka klijentu
 * @author Aleksandar
 */
public class Response  implements Serializable{
    private Object result;
    private Exception exception;

    /**
     * Konstruktor
     */
    public Response() {
    }

    /**
     * Konstruktor
     * @param result
     * @param exception
     */
    public Response(Object result, Exception exception) {
        this.result = result;
        this.exception = exception;
    }

    /**
     * Getter za result
     * @return
     */
    public Object getResult() {
        return result;
    }

    /**
     * Setter za Result
     * @param result
     */
    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * Getter za gresku
     * @return
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Setter za gresku
     * @param exception
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }
    
    
}
