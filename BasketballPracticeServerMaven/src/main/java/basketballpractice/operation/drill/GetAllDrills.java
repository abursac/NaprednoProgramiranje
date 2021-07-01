/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.operation.drill;

import java.util.List;
import basketballpractice.domain.Drill;
import basketballpractice.operation.AbstractGenericOperation;

/**
 * Klasa koja se odnosi na selekciju Drill-ova iz baze
 * @author Aleksandar
 */
public class GetAllDrills extends AbstractGenericOperation{
    
    List<Drill> drills;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Drill)) {
            throw new Exception("Invalid drill data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
       drills = repository.getAll((Drill) param);
    }

    /**
     * Vraca listu Drill-ova
     * @return
     */
    public List<Drill> getDrills() {
        return drills;
    }
    
}
