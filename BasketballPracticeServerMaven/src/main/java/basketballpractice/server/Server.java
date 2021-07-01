/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import basketballpractice.communication.Receiver;
import basketballpractice.communication.Request;
import basketballpractice.communication.Response;
import basketballpractice.communication.Sender;
import basketballpractice.controller.Controller;
import basketballpractice.domain.Training;
import basketballpractice.domain.TrainingDrill;
import basketballpractice.domain.Drill;
import basketballpractice.domain.Coach;
import basketballpractice.threads.ProcessRequests;

/**
 * Serverska nit
 * @author Aleksandar
 */
public class Server extends Thread{
    
    private ServerSocket serverSocket;

    @Override
    public void run() {
       try {
           if (serverSocket == null || serverSocket.isClosed()) {
               serverSocket = new ServerSocket(9000);
                System.out.println("Waiting for connection...");
           }
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected!");
                handleClient(socket);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
    /**
     * Zaustavljanje serverske niti
     */
    public void stopServer() {
        try {
            serverSocket.close();
            System.out.println("closed");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void handleClient(Socket socket) throws Exception {
        ProcessRequests processRequests = new ProcessRequests(socket, serverSocket);
        processRequests.start();
    }

    /**
     * Getter za serverski soket
     * @return
     */
    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
}
