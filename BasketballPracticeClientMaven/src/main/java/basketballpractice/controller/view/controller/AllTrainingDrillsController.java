/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import basketballpractice.communication.Communication;
import basketballpractice.controller.view.constant.Constants;
import basketballpractice.controller.view.coordinator.MainCoordinator;
import basketballpractice.controller.view.form.FrmAllTrainingDrills;
import basketballpractice.controller.view.form.component.table.TrainingDrillTableModel;
import basketballpractice.domain.Training;
import basketballpractice.domain.TrainingDrill;
import basketballpractice.domain.Coach;

/**
 *
 * @author Aleksandar
 */
public class AllTrainingDrillsController {
    private final FrmAllTrainingDrills frmAllTrainingDrills;

    public AllTrainingDrillsController(FrmAllTrainingDrills frmAllTasks) {
        this.frmAllTrainingDrills = frmAllTasks;
        addActionListener();
    }

    private void addActionListener() {
        frmAllTrainingDrills.btnAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openAddNewTrainingDrillForm();
            }
        });
        frmAllTrainingDrills.btnSaveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row =  frmAllTrainingDrills.getTblTasks().getSelectedRow();
                if (row>=0){
                    Training training = null;
                    TrainingDrill trainingDrill = ((TrainingDrillTableModel) frmAllTrainingDrills.getTblTasks().getModel()).getTrainingDrillAt(row);
                    training = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
                            Coach coach = (Coach) MainCoordinator.getInstance().getParam(Constants.CURRENT_COACH);
                            trainingDrill.setTraining(training);
                            trainingDrill.setAuthor(coach);
                    try {
                        Communication.getInstance().addTrainingDrill(trainingDrill);
                    } catch (Exception ex) {
                        Logger.getLogger(AllTrainingDrillsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(frmAllTrainingDrills, "You must select a drill.", "TRAINING DRILL DETAILS", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(frmAllTrainingDrills, "Training drill successfully saved");
            }
        });
        
        frmAllTrainingDrills.btnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(frmAllTrainingDrills.getTxtSearch().getText());
                    Training training = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
                    TrainingDrill trainingDrill = Communication.getInstance().getTrainingDrillById(new TrainingDrill(id,training));
                    MainCoordinator.getInstance().addParam(Constants.PARAM_TRAINING_DRILL, trainingDrill);
                    MainCoordinator.getInstance().openTrainingDrillDetailsForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frmAllTrainingDrills, "System can't find the drill.", "TRAINING DRILL DETAILS", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frmAllTrainingDrills.btnDetailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row =  frmAllTrainingDrills.getTblTasks().getSelectedRow();
                if (row>=0){
                    TrainingDrill trainingDrill = ((TrainingDrillTableModel) frmAllTrainingDrills.getTblTasks().getModel()).getTrainingDrillAt(row);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_TRAINING_DRILL, trainingDrill);
                    MainCoordinator.getInstance().openTrainingDrillDetailsForm();
                }
                else {
                    JOptionPane.showMessageDialog(frmAllTrainingDrills, "You must select a drill.", "TRAINING DRILL DETAILS", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frmAllTrainingDrills.btnRemoveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = frmAllTrainingDrills.getTblTasks().getSelectedRow();
                if (row>=0) {
                    TrainingDrill trainingDrill = ((TrainingDrillTableModel) frmAllTrainingDrills.getTblTasks().getModel()).getTrainingDrillAt(row);
                    if (!authorize(trainingDrill)) return;
                    try {
                        Communication.getInstance().deleteTrainingDrill(trainingDrill);
                        JOptionPane.showMessageDialog(frmAllTrainingDrills, "Training drill deleted successfully!\n", "Delete training drill", JOptionPane.INFORMATION_MESSAGE);
                    }catch (Exception ex) {
                        JOptionPane.showMessageDialog(frmAllTrainingDrills, "Error deleting drill.", "TRAINING DRILL DETAILS", JOptionPane.ERROR_MESSAGE);
                        if (ex.getMessage().equals(Constants.SERVER_CLOSED))
                            System.exit(0);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(frmAllTrainingDrills, "You must select a drill.", "TRAINING DRILL DETAILS", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        frmAllTrainingDrills.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                fillTblTasks();
            }
        });
    }
    
    public void openForm() {
        frmAllTrainingDrills.setLocationRelativeTo(null);
        prepareView();
        authorize();
        frmAllTrainingDrills.setVisible(true);
    }
    
    private void fillTblTasks() {
        try {
            List<TrainingDrill> trainingDrills;
            Training training = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
            trainingDrills = Communication.getInstance().getAllTrainingDrills(training);
            TrainingDrillTableModel pttm = new TrainingDrillTableModel(trainingDrills);
            frmAllTrainingDrills.getTblTasks().setModel(pttm);
        } catch (Exception ex) {
            Logger.getLogger(AllTrainingDrillsController.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().equals(Constants.SERVER_CLOSED))
                System.exit(0);
        }
    }

    private void prepareView() {
        frmAllTrainingDrills.setTitle("View training drills");
        Training training = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
        frmAllTrainingDrills.getLblProject().setText(training.getId()+" "+training.getName());
    }

    public FrmAllTrainingDrills getFrmAllTasks() {
        return frmAllTrainingDrills;
    }

    private void authorize() {
        Training training = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
        Coach currentCoach = (Coach) MainCoordinator.getInstance().getParam(Constants.CURRENT_COACH);
        if (currentCoach.getId() != training.getOwner().getId() && !training.getAssignees().contains(currentCoach)) {
            frmAllTrainingDrills.getBtnAdd().setEnabled(false);
            frmAllTrainingDrills.getBtnRemove().setEnabled(false);
        }
    }
    
    
    private boolean authorize(TrainingDrill trainingDrill) {
        Coach currentCoach = (Coach) MainCoordinator.getInstance().getParam(Constants.CURRENT_COACH);
        int currentCoachId = currentCoach.getId();
        if (currentCoachId != trainingDrill.getTraining().getOwner().getId() && currentCoachId != trainingDrill.getAssignee().getId() && currentCoachId != trainingDrill.getAuthor().getId()) {
            JOptionPane.showMessageDialog(frmAllTrainingDrills, "You don't have permission to delete this training", "TRAINING DETAILS", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    
}
