/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.form.component.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import basketballpractice.domain.Training;
import basketballpractice.domain.Coach;

/**
 *
 * @author Aleksandar
 */
public class TrainingTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID","Name","Author"};
    private final List<Training> trainings;

    public TrainingTableModel(List<Training> trainings) {
        this.trainings = trainings;
    }

    @Override
    public String getColumnName(int column) {
        if (column>columnNames.length) return "n/a";
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        if (trainings == null) return 0;
        return trainings.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Training training = trainings.get(rowIndex);
        switch(columnIndex) {
            case 2:
                training.setOwner((Coach) value);
                break;
        }
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Training training = trainings.get(rowIndex);
        switch(columnIndex) {
            case 0: return training.getId();
            case 1: return training.getName();
            case 2: return training.getOwner();
            default: return "n/a";
        }
    }
    
    public void addTraining(Training training){
        trainings.add(training);
        fireTableRowsInserted(trainings.size()-1, trainings.size()-1);
    }
    
    public Training getTrainingAt(int row) {
        return trainings.get(row);
    }
    
    
}
