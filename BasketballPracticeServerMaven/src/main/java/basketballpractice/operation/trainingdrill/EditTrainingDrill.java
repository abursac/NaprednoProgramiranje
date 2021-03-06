/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.operation.trainingdrill;

import basketballpractice.domain.TrainingDrill;
import basketballpractice.operation.AbstractGenericOperation;

/**
 * Klasa koja se odnosi na menjanje TrainingDrill-a
 * @author Aleksandar
 */
public class EditTrainingDrill extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof TrainingDrill)) {
            throw new Exception("Invalid training drill data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((TrainingDrill) param);
    }
    
}
