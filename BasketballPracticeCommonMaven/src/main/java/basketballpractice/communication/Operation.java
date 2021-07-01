/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.communication;

import java.io.Serializable;

/**
 * Enum koji se odnosi na razlicite operacije koje se vrse
 * @author Aleksandar
 */
public enum Operation  implements Serializable{

    /**
     * Prijava na sistem
     */
    LOGIN,

    /**
     * Vraca sve trenere
     */
    GET_ALL_COACHES,

    /**
     * Vraca sve treninge
     */
    GET_ALL_TRAININGS,

    /**
     * Dodaje trening
     */
    ADD_TRAINING,

    /**
     * Menja trening
     */
    EDIT_TRAINING,

    /**
     * Brise trening
     */
    DELETE_TRAINING,

    /**
     * Vraca sve stavke treninga
     */
    GET_ALL_TRAINING_DRILLS,

    /**
     * Dodaje stavku treninga
     */
    ADD_TRAINING_DRILL,

    /**
     * Dodaje stavku treninga
     */
    ADD_TRAINING_DRILL1,

    /**
     * Menja stavku treninga
     */
    EDIT_TRAINING_DRILL,

    /**
     * Brise stavku treninga
     */
    DELETE_TRAINING_DRILL,

    /**
     * Vraca sve stavke treninga
     */
    GET_ALL_DRILLS,

    /**
     * Vraca stavku treninga prema id-ju
     */
    GET_TRAINING_DRILL_BY_ID,

    /**
     * Odjava sa sistema
     */
    LOGOUT
    
}
