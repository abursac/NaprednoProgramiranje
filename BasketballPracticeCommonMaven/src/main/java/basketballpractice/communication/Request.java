/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.communication;

import java.io.Serializable;

/**
 * Klasa koja predstavlja zahtev koji klijent salje serveru
 * @author Aleksandar
 */
public class Request implements Serializable{
    private Operation operation;
    private Object argument;

    /**
     * Konstruktor
     */
    public Request() {
    }

    /**
     * Konstruktor
     * @param operation
     * @param argument
     */
    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    /**
     * Getter za operaciju
     * @return
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Setter za operaciju
     * @param operation
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * Getter za argument
     * @return
     */
    public Object getArgument() {
        return argument;
    }

    /**
     * Setter za argument
     * @param argument
     */
    public void setArgument(Object argument) {
        this.argument = argument;
    }
    
    
}
