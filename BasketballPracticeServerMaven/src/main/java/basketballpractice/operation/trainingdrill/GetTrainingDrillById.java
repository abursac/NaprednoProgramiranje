/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.operation.trainingdrill;

import basketballpractice.domain.TrainingDrill;
import basketballpractice.operation.AbstractGenericOperation;

/**
 *
 * @author Aleksandar
 */
public class GetTrainingDrillById extends AbstractGenericOperation {
    
    TrainingDrill trainingDrill;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof TrainingDrill)) {
            throw new Exception("Invalid training drill data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         trainingDrill = (TrainingDrill) repository.getById((TrainingDrill) param);
    }

    public TrainingDrill getTrainingDrill() {
        return trainingDrill;
    }
    
    
}
