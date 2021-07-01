/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.operation.coach;

import java.util.List;
import basketballpractice.domain.Coach;
import basketballpractice.operation.AbstractGenericOperation;

/**
 * Klasa koja se odnosi na selekciju Coach-eva iz baze
 * @author Aleksandar
 */
public class GetAllCoaches extends AbstractGenericOperation {
    
    List<Coach> coaches;

    @Override
    protected void preconditions(Object param) throws Exception {
         if (param == null || !(param instanceof Coach)) {
            throw new Exception("Invalid coach data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        coaches = repository.getAll((Coach) param);
    }

    /**
     * Vraca listu Coach-eva
     * @return
     */
    public List<Coach> getCoaches() {
        return coaches;
    }
    
}
