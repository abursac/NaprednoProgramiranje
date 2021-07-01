/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.operation.training;

import java.util.List;
import basketballpractice.domain.Training;
import basketballpractice.operation.AbstractGenericOperation;

/**
 * Klasa koja se odnosi na vracanje svih Training-a
 * @author Aleksandar
 */
public class GetAllTrainings extends AbstractGenericOperation{

    List<Training> trainings;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Training)) {
            throw new Exception("Invalid training data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        trainings = repository.getAll((Training) param);
    }

    /**
     * Vraca listu Training-a
     * @return
     */
    public List<Training> getTrainings() {
        return trainings;
    }
    
}
