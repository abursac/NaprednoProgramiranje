/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.io.Serializable;


/**
 * Enum koji se odnosi na jacinu treninga
 * @author Aleksandar
 */
public enum Intensity implements Serializable{

    /**
     * Pocetnik
     */
    BEGINNER,

    /**
     * Solidan
     */
    SOLID,

    /**
     * Napredan
     */
    ADVANCED,

    /**
     * Odlican
     */
    EXCELENT;
    
}
