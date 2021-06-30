/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.operation.training;

import basketballpractice.domain.Training;
import basketballpractice.operation.AbstractGenericOperation;

/**
 *
 * @author Aleksandar
 */
public class EditTraining extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Training)) {
            throw new Exception("Invalid training data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Training) param);
    }
    
}
