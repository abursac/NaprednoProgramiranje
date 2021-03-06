/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.communication;

import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Klasa koja sluzi za slanje podataka
 * @author Aleksandar
 */
public class Sender {
    private Socket socket;

    /**
     * Konstruktor
     * @param socket
     */
    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Metoda koja salje neki objekat
     * @param object
     * @throws Exception
     */
    public void send(Object object) throws Exception{
        try {
            ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error sending object!\n"+ex.getMessage());
        }
    }
}
