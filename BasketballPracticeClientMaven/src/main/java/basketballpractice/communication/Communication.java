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
 *
 * @author Aleksandar
 */
public class Communication {
    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Communication instance;
    private Communication() throws Exception{
        socket=new Socket("127.0.0.1", 9000);
        sender=new Sender(socket);
        receiver=new Receiver(socket);
    }
    public static Communication getInstance() throws Exception{
        if(instance==null){
            instance=new Communication();
        }
        return instance;
    }
    
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
        
    public void addTraining(Training training) throws Exception {
        Request request = new Request(Operation.ADD_TRAINING,training);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
        
    public void editTraining(Training training) throws Exception {
        Request request = new Request(Operation.EDIT_TRAINING,training);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    
    public void deleteTraining(Training training) throws Exception {
       Request request = new Request(Operation.DELETE_TRAINING,training);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }


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


    public void addTrainingDrill(TrainingDrill trainingDrill) throws Exception{
        Request request = new Request(Operation.ADD_TRAINING_DRILL1,trainingDrill);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void editTrainingDrill(TrainingDrill trainingDrill) throws Exception {
        Request request = new Request(Operation.EDIT_TRAINING_DRILL,trainingDrill);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    
    public void deleteTrainingDrill(TrainingDrill trainingDrill) throws Exception{
        Request request = new Request(Operation.DELETE_TRAINING_DRILL,trainingDrill);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

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

    public void logout() throws Exception {
        Request request = new Request(Operation.LOGOUT, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    
    
}
