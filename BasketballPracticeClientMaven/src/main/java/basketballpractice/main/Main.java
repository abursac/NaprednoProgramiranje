/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.main;

import basketballpractice.controller.view.coordinator.MainCoordinator;
import basketballpractice.controller.view.form.FrmLogin;

/**
 * Glavna klijentska klasa
 * @author Aleksandar
 */
public class Main {

    /**
     * Main metoda klijentskog projekta
     * @param args
     */
    public static void main(String[] args) {
        MainCoordinator.getInstance().openLoginForm();
       
    }
}
