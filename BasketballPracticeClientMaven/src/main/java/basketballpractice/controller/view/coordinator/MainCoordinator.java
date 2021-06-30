/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller.view.coordinator;

import java.util.HashMap;
import java.util.Map;
import basketballpractice.controller.view.constant.Constants;
import basketballpractice.controller.view.controller.AllTrainingDrillsController;
import basketballpractice.controller.view.controller.AllTrainingsController;
import basketballpractice.controller.view.controller.LoginController;
import basketballpractice.controller.view.controller.TrainingController;
import basketballpractice.controller.view.controller.TrainingDrillController;
import basketballpractice.controller.view.form.FrmAllTrainingDrills;
import basketballpractice.controller.view.form.FrmAllTrainings;
import basketballpractice.controller.view.form.FrmLogin;
import basketballpractice.controller.view.form.FrmTraining;
import basketballpractice.controller.view.form.FrmTrainingDrill;
import basketballpractice.view.form.util.FormMode;

/**
 *
 * @author Aleksandar
 */
public class MainCoordinator {
     private static MainCoordinator instance;

    private final AllTrainingsController allTrainingsController;
    private final Map<String, Object> params;
    

    private MainCoordinator() {
        allTrainingsController = new AllTrainingsController(new FrmAllTrainings());
        params = new HashMap<>();
    }

    public static MainCoordinator getInstance() {
        if (instance == null) {
            instance = new MainCoordinator();
        }
        return instance;
    }
     public void openLoginForm() {
        LoginController loginContoller = new LoginController(new FrmLogin());
        loginContoller.openForm();
    }

    public void openAllTrainingsForm() {
        allTrainingsController.openForm();
    }

    public void openAddNewTrainingForm() {
        TrainingController trainingController = new TrainingController(new FrmTraining(allTrainingsController.getFrmAllTrainings(), true));
        trainingController.openForm(FormMode.FORM_ADD);
    }
    public void openTrainingDetailsForm() {
        FrmTraining trainingDetails = new FrmTraining(allTrainingsController.getFrmAllTrainings(), true);
        TrainingController trainingController = new TrainingController(trainingDetails);
        trainingController.openForm(FormMode.FORM_VIEW);
        params.put(Constants.PARAM_TRAINING,trainingDetails);
    }
    
    public void openAllDrillsForm() {
        FrmAllTrainingDrills allTrainingDrills = new FrmAllTrainingDrills();
        AllTrainingDrillsController allTrainingDrillsController = new AllTrainingDrillsController(allTrainingDrills);
        allTrainingDrillsController.openForm();
        params.put(Constants.FORM_ALL_TRAINING_DRILLS,allTrainingDrills);
    }
    
    public void openAddNewTrainingDrillForm() {
        TrainingDrillController trainingDrillController = new TrainingDrillController(new FrmTrainingDrill((FrmAllTrainingDrills)params.get(Constants.FORM_ALL_TRAINING_DRILLS), true));
        trainingDrillController.openForm(FormMode.FORM_ADD);
    }

    public void openTrainingDrillDetailsForm() {
        FrmTrainingDrill drillDetails = new FrmTrainingDrill((FrmAllTrainingDrills)params.get(Constants.FORM_ALL_TRAINING_DRILLS), true);
        TrainingDrillController trainingDrillController = new TrainingDrillController(drillDetails);
        trainingDrillController.openForm(FormMode.FORM_VIEW);
        params.put(Constants.PARAM_TRAINING_DRILL,drillDetails);
    }
    
    public AllTrainingsController getAllTrainingsController() {
        return allTrainingsController;
    }


    public void addParam(String name, Object key) {
        params.put(name, key);
    }

    public Object getParam(String name) {
        return params.get(name);
    }
    
}
