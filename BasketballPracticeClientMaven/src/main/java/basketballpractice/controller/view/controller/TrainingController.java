/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import basketballpractice.communication.Communication;
import basketballpractice.controller.view.component.validator.impl.RequiredStringValidator;
import basketballpractice.controller.view.constant.Constants;
import basketballpractice.controller.view.coordinator.MainCoordinator;
import basketballpractice.controller.view.form.FrmTraining;
import basketballpractice.controller.view.form.component.table.AssigneeTableModel;
import basketballpractice.domain.Training;
import basketballpractice.domain.Coach;
import basketballpractice.view.form.util.FormMode;

/**
 * Kontroler koji upravlja formom FrmTraining
 * @author Aleksandar
 */
public class TrainingController {
    private final FrmTraining frmTraining;
    private FormMode formMode;

    /**
     * Konstruktor
     * @param frmTraining
     */
    public TrainingController(FrmTraining frmTraining) {
        this.frmTraining = frmTraining;
        addActionListeners();
    }

    private void addActionListeners() {
        frmTraining.addSaveBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();         
            }

            private void save() {
                 try {
                    Training training = new Training();
                    training.setName(frmTraining.getInputName().getValue().toString());
                    training.setDescription(frmTraining.getInputDescription().getValue().toString());
                    AssigneeTableModel model = (AssigneeTableModel) frmTraining.getTblAssignees().getModel();
                    if (model.getAssignees().isEmpty()) {
                        JOptionPane.showMessageDialog(frmTraining,"Add at least 1 assignee");
                        return;
                    }
                    training.setAssignees(model.getAssignees());
                    switch(formMode) {
                        case FORM_ADD:
                            Coach coach = (Coach) MainCoordinator.getInstance().getParam(Constants.CURRENT_COACH);
                            training.setOwner(coach);
                            Communication.getInstance().addTraining(training);
                            break;
                        case FORM_VIEW:
                            training.setId(Integer.parseInt(frmTraining.getInputId().getValue().toString()));
                            Communication.getInstance().editTraining(training);
                            break;
                    }
                    JOptionPane.showMessageDialog(frmTraining, "Training successfully saved");
                    frmTraining.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(FrmTraining.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(frmTraining, ex.getMessage());
                    if (ex.getMessage().equals(Constants.SERVER_CLOSED))
                        System.exit(0);
                }
            }
        });
        
        frmTraining.addAddAssigneeBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AssigneeTableModel model = (AssigneeTableModel) frmTraining.getTblAssignees().getModel();
                    Coach assignee = (Coach) frmTraining.getInputAssignee().getValue();
                    model.addAssignee(assignee);
                    model.fireTableRowsInserted(model.getRowCount(), model.getRowCount());
                } catch (Exception ex) {
                    Logger.getLogger(TrainingController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    /**
     * Metoda koja otvara formu
     * @param formMode
     */
    public void openForm(FormMode formMode) {
        frmTraining.setLocationRelativeTo(MainCoordinator.getInstance().getAllTrainingsController().getFrmAllTrainings());
        prepareView(formMode);
        this.formMode = formMode;
        setupComponents(formMode);
        frmTraining.setVisible(true);
    }

    private void prepareView(FormMode formMode) {
        fillCbAssignees();
        fillTblAssignees(formMode);
        frmTraining.getInputId().getLblText().setText("ID:");
        frmTraining.getInputId().getLblErrorValue().setText("");
        frmTraining.getInputId().getTxtValue().setEnabled(false);
        
        frmTraining.getInputName().setValidator(new RequiredStringValidator());
        frmTraining.getInputName().getLblText().setText("Name:");
        frmTraining.getInputName().getLblErrorValue().setText("");
        
        frmTraining.getInputDescription().setValidator(new RequiredStringValidator());
        frmTraining.getInputDescription().getLblText().setText("Description:");
        frmTraining.getInputDescription().getLblErrorValue().setText("");    
        
        frmTraining.getInputOwner().getLblText().setText("Author:");
        frmTraining.getInputOwner().getTxtValue().setEnabled(false);
        frmTraining.getInputOwner().getLblErrorValue().setText("");
        
        frmTraining.getInputAssignee().getLblText().setText("Add assignee:");
        frmTraining.getInputAssignee().getLblErrorValue().setText("");
    }
         
    private void setupComponents(FormMode formMode) {
        Coach currentCoach = (Coach) MainCoordinator.getInstance().getParam(Constants.CURRENT_COACH);
        switch(formMode) {
            case FORM_ADD:
                frmTraining.getInputOwner().getTxtValue().setText(currentCoach.getUsername());
                break;
            case FORM_VIEW:
                Training training = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
                frmTraining.getInputId().getTxtValue().setText(String.valueOf(training.getId()));
                frmTraining.getInputName().getTxtValue().setText(training.getName());
                frmTraining.getInputDescription().getTxtAreaValue().setText(training.getDescription());
                frmTraining.getInputOwner().getTxtValue().setText(training.getOwner().getUsername());
                authorize(currentCoach, training);
                break;
        }
    }

    private void authorize(Coach currentCoach, Training training) {
        if (currentCoach.getId() != training.getOwner().getId()) {
            frmTraining.getInputName().getTxtValue().setEnabled(false);
            frmTraining.getInputDescription().getTxtAreaValue().setEnabled(false);
            frmTraining.getBtnSave().setEnabled(false);
            frmTraining.getInputAssignee().getCb().setEnabled(false);
            frmTraining.getBtnAddAssignee().setEnabled(false);
        }
    }

    private void fillCbAssignees() {
        try {
            frmTraining.getInputAssignee().getCb().setModel(new DefaultComboBoxModel<>(Communication.getInstance().getAllCoaches().toArray()));
            frmTraining.getInputAssignee().getCb().setSelectedIndex(0);
            frmTraining.getInputAssignee().getCb().addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Coach coach = (Coach) e.getItem();
                    }
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillController.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().equals(Constants.SERVER_CLOSED))
                System.exit(0);
        }
    }

    private void fillTblAssignees(FormMode formMode) {
        List<Coach> assignees = new ArrayList<Coach>();
        try {
            if (formMode == FormMode.FORM_VIEW) {
                Training training = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
                assignees = training.getAssignees();
            }
            AssigneeTableModel atm = new AssigneeTableModel(assignees);
            frmTraining.getTblAssignees().setModel(atm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmTraining, "Error: " + ex.getMessage(), "ERROR DETAILS", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AllTrainingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
