/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja sluzi za prijaem podataka
 * @author Aleksandar
 */
public class Receiver {
    private Socket socket;

    /**
     * Konstruktor
     * @param socket
     */
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Metoda koja prima podatke, koriste je i klijent i server
     * @return
     * @throws Exception
     */
    public Object receive() throws Exception{
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error receiving object!\n"+ex.getMessage());
        }
    }
}
