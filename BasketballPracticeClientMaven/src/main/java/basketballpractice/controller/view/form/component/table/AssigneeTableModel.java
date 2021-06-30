/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.form.component.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import basketballpractice.domain.Training;
import basketballpractice.domain.Coach;

/**
 *
 * @author Aleksandar
 */
public class AssigneeTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID","Username"};
    private final List<Coach> assignees;

    public AssigneeTableModel(List<Coach> assignees) {
        this.assignees = assignees;
    }

    @Override
    public String getColumnName(int column) {
        if (column>columnNames.length) return "n/a";
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        if (assignees == null) return 0;
        return assignees.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Coach assignee = assignees.get(rowIndex);
//        switch(columnIndex) {
//            case 2:
//                project.setOwner((Coach) value);
//                break;
//        }
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Coach assignee = assignees.get(rowIndex);
        switch(columnIndex) {
            case 0: return assignee.getId();
            case 1: return assignee.getUsername();
            default: return "n/a";
        }
    }
    
    public void addAssignee(Coach assignee){
        if (!assignees.contains(assignee)) {
            assignees.add(assignee);
            fireTableRowsInserted(assignees.size()-1, assignees.size()-1);
        }
    }
    
    public Coach getAssigneeAt(int row) {
        return assignees.get(row);
    }

    public List<Coach> getAssignees() {
        return assignees;
    }
    
    
}
