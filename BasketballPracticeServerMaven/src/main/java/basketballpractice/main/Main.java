/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.main;

import basketballpractice.server.Server;
import basketballpractice.view.coordinator.MainCoordinator;


/**
 *
 * @author Aleksandar
 */
public class Main {
    public static void main(String[] args) {
        MainCoordinator.getInstance().openMainForm();
        //new Server().startServer();
    }
}