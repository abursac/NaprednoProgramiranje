/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.communication;

import java.net.Socket;
import java.util.List;
import basketballpractice.domain.Training;
import basketballpractice.domain.TrainingDrill;
import basketballpractice.domain.Drill;
import basketballpractice.domain.Coach;

/**
 * Singleton klasa koja obuhvata komunikaciju klijenta sa serverom
 * @author Aleksandar
 */
public class Communication {
    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Communication instance;
    
    /*
    * Konstruktor klase, inicijalizuje Socket, Sender i Receiver
    */
    private Communication() throws Exception{
        socket=new Socket("127.0.0.1", 9000);
        sender=new Sender(socket);
        receiver=new Receiver(socket);
    }
    
    /**
     * Metoda koja poziva konstruktor, osobina Singleton klase
     * @return
     * @throws Exception
     */

    public static Communication getInstance() throws Exception{
        if(instance==null){
            instance=new Communication();
        }
        return instance;
    }
    
    /**
     * Metoda koja prilikom logovanja korisnika prosledjuje zahtev ka serveru i prima odgovor
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public Coach login(String username, String password) throws Exception {
        Coach coach = new Coach();
        coach.setUsername(username);
        coach.setPassword(password);
        Request request = new Request(Operation.LOGIN,coach);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException()==null) {
            return (Coach) response.getResult();
        } else {
            throw response.getException();
        }
    }
    
    /**
     * Metoda koja vraca listu svih Coach-ova iz baze
     * @return
     * @throws Exception
     */
    public List<Coach> getAllCoaches() throws Exception{
        Request request = new Request(Operation.GET_ALL_COACHES,null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Coach>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    /**
     * Metoda koja vraca listu svih Training-a iz baze
     * @return
     * @throws Exception
     */
    public List<Training> getAllTrainings() throws Exception{
        Request request = new Request(Operation.GET_ALL_TRAININGS,null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Training>) response.getResult();
        } else {
            throw response.getException();
        }
    }
        
    /**
     * Metoda kojom se dodaje novi trening
     * @param training
     * @throws Exception
     */
    public void addTraining(Training training) throws Exception {
        Request request = new Request(Operation.ADD_TRAINING,training);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
        
    /**
     * Metoda kojom se menja vec postojeci Training
     * @param training
     * @throws Exception
     */
    public void editTraining(Training training) throws Exception {
        Request request = new Request(Operation.EDIT_TRAINING,training);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    
    /**
     * Metoda kojom se brise trening
     * @param training
     * @throws Exception
     */
    public void deleteTraining(Training training) throws Exception {
       Request request = new Request(Operation.DELETE_TRAINING,training);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    /**
     * Metoda koja vraca sve TrainingDrill-ove za prosledjeni Training
     * @param training
     * @return
     * @throws Exception
     */
    public List<TrainingDrill> getAllTrainingDrills(Training training) throws Exception{
        Request request = new Request(Operation.GET_ALL_TRAINING_DRILLS,training);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<TrainingDrill>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    /**
     * Metoda koja dodaje novi TrainingDrill
     * @param trainingDrill
     * @throws Exception
     */
    public void addTrainingDrill(TrainingDrill trainingDrill) throws Exception{
        Request request = new Request(Operation.ADD_TRAINING_DRILL1,trainingDrill);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    /**
     * Metoda koja menja vec postojeci TrainingDrill
     * @param trainingDrill
     * @throws Exception
     */
    public void editTrainingDrill(TrainingDrill trainingDrill) throws Exception {
        Request request = new Request(Operation.EDIT_TRAINING_DRILL,trainingDrill);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    
    /**
     * Metoda koja brise trainingDrill
     * @param trainingDrill
     * @throws Exception
     */
    public void deleteTrainingDrill(TrainingDrill trainingDrill) throws Exception{
        Request request = new Request(Operation.DELETE_TRAINING_DRILL,trainingDrill);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    /**
     * Metoda koja vraca sve TrainingDrill-ove iz baze
     * @return
     * @throws Exception
     */
    public List<Drill> getAllDrills() throws Exception{
        Request request = new Request(Operation.GET_ALL_DRILLS,null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Drill>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    /**
     * Metoda koja pretrazuje TrainingDrill-ove preko njihovog ID-ja
     * @param trainingDrill
     * @return
     * @throws Exception
     */
    public TrainingDrill getTrainingDrillById(TrainingDrill trainingDrill) throws Exception{
        Request request = new Request(Operation.GET_TRAINING_DRILL_BY_ID, trainingDrill);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (TrainingDrill) response.getResult();
        } else {
            throw response.getException();
        }
    }

    /**
     * Metoda koja odjavljuje ulogovanog korisnika
     * @throws Exception
     */
    public void logout() throws Exception {
        Request request = new Request(Operation.LOGOUT, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    
    
}
