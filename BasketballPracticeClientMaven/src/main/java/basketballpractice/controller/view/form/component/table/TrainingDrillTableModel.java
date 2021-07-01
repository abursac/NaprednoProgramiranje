/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.form.component.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import basketballpractice.domain.TrainingDrill;

/**
 * Model za tabelu TrainingDrill
 * @author Aleksandar
 */
public class TrainingDrillTableModel extends AbstractTableModel{
    
    private final String[] columnNames = {"ID","Created On","Drill","Assignee","Intensity","Author"};
    private final List<TrainingDrill> trainingDrills;

    /**
     * Konstruktor
     * @param trainingDrills
     */
    public TrainingDrillTableModel(List<TrainingDrill> trainingDrills) {
        this.trainingDrills = trainingDrills;
    }

    @Override
    public String getColumnName(int column) {
        if (column>columnNames.length) return "n/a";
        return columnNames[column];
    }
    
    @Override
    public int getRowCount() {
        if (trainingDrills == null) return 0;
        return trainingDrills.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TrainingDrill trainingDrill = trainingDrills.get(rowIndex);
        switch(columnIndex){
            case 0: return trainingDrill.getId();
            case 1: return trainingDrill.getCreatedOn();
            case 2: return trainingDrill.getDrill();
            case 3: return trainingDrill.getAssignee();
            case 4: return trainingDrill.getIntensity();
            case 5: return trainingDrill.getAuthor();
            default: return "n/a";
        }
    }
    
    /**
     * Dodaje TrainingDrill u listu, samim tim u tabelu
     * @param trainingDrill
     */
    public void addTrainingDrill(TrainingDrill trainingDrill) {
        trainingDrills.add(trainingDrill);
        fireTableRowsInserted(trainingDrills.size()-1, trainingDrills.size()-1);
    }
    
    /**
     * Vraca TrainingDrill iz odabranog reda tabele
     * @param row
     * @return
     */
    public TrainingDrill getTrainingDrillAt(int row) {
        return trainingDrills.get(row);
    }
    
}
