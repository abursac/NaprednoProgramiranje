/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.operation.trainingdrill;

import java.util.List;
import basketballpractice.domain.TrainingDrill;
import basketballpractice.operation.AbstractGenericOperation;

/**
 *
 * @author Aleksandar
 */
public class GetAllTrainingDrills extends AbstractGenericOperation{
    
    List<TrainingDrill> trainingDrills;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof TrainingDrill)) {
            throw new Exception("Invalid training drill data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
       trainingDrills = repository.getAll((TrainingDrill) param);
    }

    public List<TrainingDrill> getTrainingDrills() {
        return trainingDrills;
    }
    
}
