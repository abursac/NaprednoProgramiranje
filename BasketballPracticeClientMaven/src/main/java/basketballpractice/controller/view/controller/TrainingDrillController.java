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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import basketballpractice.communication.Communication;
import basketballpractice.controller.view.component.validator.impl.RequiredStringValidator;
import basketballpractice.controller.view.constant.Constants;
import basketballpractice.controller.view.coordinator.MainCoordinator;
import basketballpractice.controller.view.form.FrmTrainingDrill;
import basketballpractice.domain.Training;
import basketballpractice.domain.TrainingDrill;
import basketballpractice.domain.Intensity;
import basketballpractice.domain.Drill;
import basketballpractice.domain.Coach;
import basketballpractice.view.form.util.FormMode;

/**
 *
 * @author Aleksandar
 */
public class TrainingDrillController {
    private final FrmTrainingDrill frmTrainingDrill;
    private FormMode formMode;

    public TrainingDrillController(FrmTrainingDrill frmProjectTask) {
        this.frmTrainingDrill = frmProjectTask;
        addActionListener();
    }

    private void addActionListener() {
        frmTrainingDrill.addSaveBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
            private void save() {
                try {
                    TrainingDrill trainingDrill = new TrainingDrill();
                    trainingDrill.setDescription(frmTrainingDrill.getInputProjectTaskDescription().getValue().toString());
                    trainingDrill.setDrill((Drill) frmTrainingDrill.getInputTask().getValue());
                    trainingDrill.setAssignee((Coach) frmTrainingDrill.getInputAssignee().getValue());
                    trainingDrill.setIntensity((Intensity) frmTrainingDrill.getInputStatus().getValue());
                    Training training = null;
                    switch(formMode) {
                        case FORM_ADD:
                            training = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
                            Coach coach = (Coach) MainCoordinator.getInstance().getParam(Constants.CURRENT_COACH);
                            trainingDrill.setTraining(training);
                            trainingDrill.setAuthor(coach);
                            Communication.getInstance().addTrainingDrill(trainingDrill);
                            break;
                        case FORM_VIEW:
                            trainingDrill.setId(Integer.parseInt(frmTrainingDrill.getInputId().getValue().toString()));
                            training = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
                            trainingDrill.setTraining(training);
                            Communication.getInstance().editTrainingDrill(trainingDrill);
                            break;
                    }
                    //JOptionPane.showMessageDialog(frmTrainingDrill, "Training drill successfully saved");
                    frmTrainingDrill.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frmTrainingDrill, e.getMessage());
                    if (e.getMessage().equals(Constants.SERVER_CLOSED))
                        System.exit(0);
                }
            }
        });
    }
    
    public void openForm(FormMode formMode) {
        this.formMode = formMode;
        frmTrainingDrill.setLocationRelativeTo(MainCoordinator.getInstance().getAllTrainingsController().getFrmAllTrainings());
        prepareView();
        setupComponents();
        frmTrainingDrill.setVisible(true);
    }

    private void prepareView() {
        fillCbDrill();
        fillCbAssignee();
        fillCbIntensity();
        frmTrainingDrill.getInputId().getLblText().setText("ID:");
        frmTrainingDrill.getInputId().getLblErrorValue().setText("");
        frmTrainingDrill.getInputId().getTxtValue().setEnabled(false);
        
        frmTrainingDrill.getInputProject().getLblText().setText("Training:");
        frmTrainingDrill.getInputProject().getLblErrorValue().setText("");
        frmTrainingDrill.getInputProject().getTxtValue().setEnabled(false);
        
        frmTrainingDrill.getInputAuthor().getLblText().setText("Author:");
        frmTrainingDrill.getInputAuthor().getLblErrorValue().setText("");
        frmTrainingDrill.getInputAuthor().getTxtValue().setEnabled(false);
        
        frmTrainingDrill.getInputTask().getLblText().setText("Drill:");
        frmTrainingDrill.getInputTask().getLblErrorValue().setText("");
        
        frmTrainingDrill.getInputTaskDescription().getLblText().setText("Drill description:");
        frmTrainingDrill.getInputTaskDescription().getLblErrorValue().setText("");
        frmTrainingDrill.getInputTaskDescription().getTxtAreaValue().setEnabled(false);
        
        frmTrainingDrill.getInputProjectTaskDescription().setValidator(new RequiredStringValidator());
        frmTrainingDrill.getInputProjectTaskDescription().getLblText().setText("Description:");
        frmTrainingDrill.getInputProjectTaskDescription().getLblErrorValue().setText("");
        
        frmTrainingDrill.getInputAssignee().getLblText().setText("Assignee:");
        frmTrainingDrill.getInputAssignee().getLblErrorValue().setText("");
        
        frmTrainingDrill.getInputStatus().getLblText().setText("Intensity:");
        frmTrainingDrill.getInputStatus().getLblErrorValue().setText("");
    }
    
    private void fillCbDrill() {
        try {
            frmTrainingDrill.getInputTask().getCb().setModel(new DefaultComboBoxModel<>(Communication.getInstance().getAllDrills().toArray()));
            frmTrainingDrill.getInputTask().getCb().setSelectedIndex(0);
            frmTrainingDrill.getInputTaskDescription().getTxtAreaValue().setText("Practicing shots from different positions");
            frmTrainingDrill.getInputTask().getCb().addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Drill drill = (Drill) e.getItem();
                        frmTrainingDrill.getInputTaskDescription().getTxtAreaValue().setText(drill.getDescription());
                    }
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillController.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().equals(Constants.SERVER_CLOSED))
                System.exit(0);
        }
    }
    
    private void fillCbAssignee() {
        try {
            Training currentTraining = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
            frmTrainingDrill.getInputAssignee().getCb().setModel(new DefaultComboBoxModel<>(currentTraining.getAssignees().toArray()));
            frmTrainingDrill.getInputAssignee().getCb().setSelectedIndex(0);
            frmTrainingDrill.getInputAssignee().getCb().addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Coach coach = (Coach) e.getItem();
                    }
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillCbIntensity() {
        try {
            frmTrainingDrill.getInputStatus().getCb().setModel(new DefaultComboBoxModel<>(Intensity.class.getEnumConstants()));
            frmTrainingDrill.getInputStatus().getCb().setSelectedIndex(0);
            frmTrainingDrill.getInputStatus().getCb().addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Intensity intensity = (Intensity) e.getItem();
                    }
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setupComponents() {
        Coach currentCoach = (Coach) MainCoordinator.getInstance().getParam(Constants.CURRENT_COACH);
        Training currentTraining = (Training) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING);
        switch(formMode) {
            case FORM_ADD:
                frmTrainingDrill.getInputProject().getTxtValue().setText(currentTraining.getId()+" "+currentTraining.getName());
                frmTrainingDrill.getInputAuthor().getTxtValue().setText(currentCoach.getUsername());
                break;
            case FORM_VIEW:
                TrainingDrill trainingDrill = (TrainingDrill) MainCoordinator.getInstance().getParam(Constants.PARAM_TRAINING_DRILL);
                frmTrainingDrill.getInputId().getTxtValue().setText(String.valueOf(trainingDrill.getId()));
                frmTrainingDrill.getInputProject().getTxtValue().setText(trainingDrill.getTraining().getId()+" "+trainingDrill.getTraining().getName());
                frmTrainingDrill.getInputAuthor().getTxtValue().setText(trainingDrill.getAuthor().getUsername());
                frmTrainingDrill.getInputAssignee().getCb().setSelectedItem(trainingDrill.getAssignee());
                frmTrainingDrill.getInputTask().getCb().setSelectedItem(trainingDrill.getDrill());
                frmTrainingDrill.getInputStatus().getCb().setSelectedItem(trainingDrill.getIntensity());
                frmTrainingDrill.getInputTaskDescription().getTxtAreaValue().setText(trainingDrill.getDrill().getDescription());
                frmTrainingDrill.getInputProjectTaskDescription().getTxtAreaValue().setText(trainingDrill.getDescription());
                authorize(currentCoach, trainingDrill);
                break;
        }
    }

    private void authorize(Coach currentCoach, TrainingDrill trainingDrill) {
        int currentCoachId = currentCoach.getId();
        if (currentCoachId != trainingDrill.getTraining().getOwner().getId() && currentCoachId != trainingDrill.getAssignee().getId() && currentCoachId != trainingDrill.getAuthor().getId()) {
            frmTrainingDrill.getInputAssignee().setEnabled(false);
            frmTrainingDrill.getInputTask().setEnabled(false);
            frmTrainingDrill.getInputStatus().setEnabled(false);
            frmTrainingDrill.getInputTaskDescription().setEnabled(false);
            frmTrainingDrill.getInputProjectTaskDescription().setEnabled(false);
            frmTrainingDrill.getBtnSave().setEnabled(false);
        }
    }

}
