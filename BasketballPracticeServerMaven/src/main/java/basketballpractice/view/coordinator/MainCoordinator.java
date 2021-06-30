/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.view.coordinator;

import java.util.HashMap;
import java.util.Map;
import basketballpractice.view.controller.MainController;
import basketballpractice.view.controller.SettingsController;
import basketballpractice.view.form.FrmMain;
import basketballpractice.view.form.FrmSettings;

/**
 *
 * @author Aleksandar
 */
public class MainCoordinator {
    private static MainCoordinator instance;

    private final MainController mainController;
    

    private MainCoordinator() {
        mainController = new MainController(new FrmMain());
    }

    public static MainCoordinator getInstance() {
        if (instance == null) {
            instance = new MainCoordinator();
        }
        return instance;
    }
     public void openMainForm() {
        mainController.openForm();
    }
     
    public void openSettingsForm() {
       SettingsController settingsController = new SettingsController( new FrmSettings(mainController.getFrmMain(), true));
       settingsController.openForm();
    }
}
