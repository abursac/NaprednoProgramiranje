/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.operation.training;

import basketballpractice.domain.Training;
import basketballpractice.domain.Coach;
import basketballpractice.operation.AbstractGenericOperation;

/**
 * Klasa koja se odnosi na dodavanje Training-a
 * @author Aleksandar
 */
public class AddTraining extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Training)) {
            throw new Exception("Invalid training data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Training) param);
    }
    
}
