/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.communication;

import java.io.Serializable;

public enum Operation  implements Serializable{
    LOGIN,
    GET_ALL_COACHES,
    GET_ALL_TRAININGS,
    ADD_TRAINING,
    EDIT_TRAINING,
    DELETE_TRAINING,
    GET_ALL_TRAINING_DRILLS,
    ADD_TRAINING_DRILL,
    ADD_TRAINING_DRILL1,
    EDIT_TRAINING_DRILL,
    DELETE_TRAINING_DRILL,
    GET_ALL_DRILLS,
    GET_TRAINING_DRILL_BY_ID,
    LOGOUT
    
}
