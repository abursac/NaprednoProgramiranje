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
import basketballpractice.controller.view.form.FrmAllTrainings;
import basketballpractice.controller.view.form.component.table.TrainingTableModel;
import basketballpractice.domain.Training;
import basketballpractice.domain.Coach;

/**
 * Kontroler koji upravlja formom FrmAllTrainings
 * @author Aleksandar
 */
public class AllTrainingsController {
    private final FrmAllTrainings frmAllTrainings;

    /**
     * Konstruktor
     * @param frmAllProjects
     */
    public AllTrainingsController(FrmAllTrainings frmAllProjects) {
        this.frmAllTrainings = frmAllProjects;
        addActionListener();
    }
    
    private void addActionListener() {
        frmAllTrainings.btnLogoutActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Communication.getInstance().logout();
                    MainCoordinator.getInstance().openLoginForm();
                    frmAllTrainings.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frmAllTrainings, ex.getMessage(), "Coach details", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frmAllTrainings.jmiNewProjectActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openAddNewTrainingForm();
            }
        });
       frmAllTrainings.btnAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openAddNewTrainingForm();
            }
        });
        frmAllTrainings.btnDetailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = frmAllTrainings.getTblProjects().getSelectedRow();
                if (row >= 0) {
                    Training training = ((TrainingTableModel) frmAllTrainings.getTblProjects().getModel()).getTrainingAt(row);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_TRAINING, training);
                    MainCoordinator.getInstance().openTrainingDetailsForm();
                } else {
                    JOptionPane.showMessageDialog(frmAllTrainings, "You must select a training", "TRAINING DETAILS", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frmAllTrainings.btnRemoveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = frmAllTrainings.getTblProjects().getSelectedRow();
                if (row >= 0) {
                    Training training = ((TrainingTableModel) frmAllTrainings.getTblProjects().getModel()).getTrainingAt(row);
                    Coach currentCoach = (Coach) MainCoordinator.getInstance().getParam(Constants.CURRENT_COACH);
                    if (currentCoach.getId() != training.getOwner().getId()) {
                        JOptionPane.showMessageDialog(frmAllTrainings, "You don't have permission to delete this training", "TRAINING DETAILS", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        Communication.getInstance().deleteTraining(training);
                        JOptionPane.showMessageDialog(frmAllTrainings, "Training deleted successfully!\n", "Delete training", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                         JOptionPane.showMessageDialog(frmAllTrainings, "Error deleting training!\n" + ex.getMessage(), "Delete training", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(AllTrainingsController.class.getName()).log(Level.SEVERE, null, ex);
                        if (ex.getMessage().equals(Constants.SERVER_CLOSED))
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(frmAllTrainings, "You must select a training", "TRAINING DETAILS", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        frmAllTrainings.btnDrillsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = frmAllTrainings.getTblProjects().getSelectedRow();
                if (row >= 0) {
                    Training training = ((TrainingTableModel) frmAllTrainings.getTblProjects().getModel()).getTrainingAt(row);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_TRAINING, training);
                    MainCoordinator.getInstance().openAllDrillsForm();
                } else {
                    JOptionPane.showMessageDialog(frmAllTrainings, "You must select a training", "TRAINING DETAILS", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        frmAllTrainings.addWindowListener(new WindowAdapter(){
            @Override
            public void windowActivated(WindowEvent e) {
                fillTblProjects();
            }
        });

    }
    
    /**
     * Metoda koja otvara formu
     */
    public void openForm() {
        frmAllTrainings.setLocationRelativeTo(null);
        prepareView();
        frmAllTrainings.setVisible(true);
    }

    private void prepareView() {
        frmAllTrainings.setTitle("View trainings");
    }

    private void fillTblProjects() {
        List<Training> trainings;
        try {
            trainings = Communication.getInstance().getAllTrainings();
            TrainingTableModel ptm = new TrainingTableModel(trainings);
            frmAllTrainings.getTblProjects().setModel(ptm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmAllTrainings, "Error: " + ex.getMessage(), "ERROR DETAILS", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AllTrainingsController.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().equals(Constants.SERVER_CLOSED))
                System.exit(0);
        }
    }

    /**
     * Metoda koja vraca formu FrmAllTrainings
     * @return
     */
    public FrmAllTrainings getFrmAllTrainings() {
        return frmAllTrainings;
    }
    
}
