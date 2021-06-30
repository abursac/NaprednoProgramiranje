/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.threads;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
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

/**
 *
 * @author Aleksandar
 */
public class ProcessRequests extends Thread {
    
    Socket socket;
    Sender sender;
    Receiver receiver;
    ServerSocket serverSocket;
    boolean run;
    
    public ProcessRequests(Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        sender=new Sender(socket);
        receiver=new Receiver(socket);
        this.serverSocket = serverSocket;
        this.run = true;
    }

    @Override
    public void run() {
        while (run) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                Coach coach;
                Training training;
                TrainingDrill trainingDrill;
                Drill drill;
                int id;
                try {
                if (serverSocket.isClosed()) {
                    System.out.println("server socket is closed");
                    run = false;
                    throw new SocketException("Server socket closed");
                }
                    switch (request.getOperation()) {
                        case LOGIN:
                            coach = (Coach) request.getArgument();
                            response.setResult(Controller.getInstance().login(coach.getUsername(), coach.getPassword()));
                            break;
                        case GET_ALL_COACHES:
                            response.setResult(Controller.getInstance().getAllCoaches());
                            break;
                        case GET_ALL_TRAININGS:
                            response.setResult(Controller.getInstance().getAllTrainings());
                            break;
                        case ADD_TRAINING:
                            training = (Training) request.getArgument();
                            Controller.getInstance().addTraining(training);
                            response.setResult(training);
                            break;
                        case EDIT_TRAINING:
                            training = (Training) request.getArgument();
                            Controller.getInstance().editTraining(training);
                            break;
                        case DELETE_TRAINING:
                            training = (Training) request.getArgument();
                            Controller.getInstance().deleteTraining(training);
                            break;
                        case GET_ALL_TRAINING_DRILLS:
                            training = (Training) request.getArgument();
                            response.setResult(Controller.getInstance().getAllTrainingDrills(training));
                            break;
                        case ADD_TRAINING_DRILL:
                            trainingDrill = (TrainingDrill) request.getArgument();
                            Controller.getInstance().addTrainingDrill(trainingDrill);
                            response.setResult(trainingDrill);
                            break;
                        case ADD_TRAINING_DRILL1:
                            trainingDrill = (TrainingDrill) request.getArgument();
                            Controller.getInstance().addTrainingDrill1(trainingDrill);
                            response.setResult(trainingDrill);
                            break;
                        case EDIT_TRAINING_DRILL:
                            trainingDrill = (TrainingDrill) request.getArgument();
                            Controller.getInstance().editTrainingDrill(trainingDrill);
                            response.setResult(trainingDrill);
                            break;
                        case DELETE_TRAINING_DRILL:
                            trainingDrill = (TrainingDrill) request.getArgument();
                            Controller.getInstance().deleteTrainingDrill(trainingDrill);
                            break;
                        case GET_ALL_DRILLS:
                            response.setResult(Controller.getInstance().getAllDrills());
                            break;
                        case GET_TRAINING_DRILL_BY_ID:
                            trainingDrill = (TrainingDrill) request.getArgument();
                            response.setResult(Controller.getInstance().getTrainingDrillById(trainingDrill));
                            break;
                        case LOGOUT:
                            response.setResult("You have logged out");
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);
            } catch (Exception ex) {
                run = false;
                Logger.getLogger(ProcessRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
    
    
    
    
    
    
    
}
