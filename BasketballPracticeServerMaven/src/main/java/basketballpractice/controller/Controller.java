/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.controller;

import java.util.List;
import basketballpractice.domain.Training;
import basketballpractice.domain.TrainingDrill;
import basketballpractice.domain.Drill;
import basketballpractice.domain.Coach;
import basketballpractice.operation.AbstractGenericOperation;
import basketballpractice.operation.training.AddTraining;
import basketballpractice.operation.training.DeleteTraining;
import basketballpractice.operation.training.EditTraining;
import basketballpractice.operation.training.GetAllTrainings;
import basketballpractice.operation.trainingdrill.AddTrainingDrill;
import basketballpractice.operation.trainingdrill.DeleteTrainingDrill;
import basketballpractice.operation.trainingdrill.EditTrainingDrill;
import basketballpractice.operation.trainingdrill.GetAllTrainingDrills;
import basketballpractice.operation.trainingdrill.GetTrainingDrillById;
import basketballpractice.operation.drill.GetAllDrills;
import basketballpractice.operation.coach.GetAllCoaches;

/**
 *
 * @author Aleksandar
 */
public class Controller {
    private static Controller controller;

    public Controller() {
    }
    
    public static Controller getInstance() {
        if (controller == null)
            controller = new Controller();
        return controller;
    }
    
    public Coach login(String username, String password) throws Exception {
        List<Coach> coaches = getAllCoaches();
        System.out.println(coaches);
        for (Coach coach: coaches) {
            if (coach.getUsername().equals(username)&&coach.getPassword().equals(password)) {
                return coach;
            }
        }
        throw new Exception("Unknown coach");
    }
    
    public List<Coach> getAllCoaches() throws Exception{
        AbstractGenericOperation operation = new GetAllCoaches();
        operation.execute(new Coach());
        return ((GetAllCoaches)operation).getCoaches();
    }

    public List<Training> getAllTrainings() throws Exception{
        AbstractGenericOperation operation = new GetAllTrainings();
        operation.execute(new Training());
        return ((GetAllTrainings)operation).getTrainings();
    }
        
    public void addTraining(Training project) throws Exception {
        AbstractGenericOperation operation = new AddTraining();
        operation.execute(project);
    }
        
    public void editTraining(Training project) throws Exception {
        AbstractGenericOperation operation = new EditTraining();
        operation.execute(project);
    }
    
    public void deleteTraining(Training project) throws Exception {
       AbstractGenericOperation operation = new DeleteTraining();
        operation.execute(project);
    }


    public List<TrainingDrill> getAllTrainingDrills(Training training) throws Exception{
        AbstractGenericOperation operation = new GetAllTrainingDrills();
        operation.execute(new TrainingDrill(training));
        return ((GetAllTrainingDrills)operation).getTrainingDrills();
    }


    public void addTrainingDrill(TrainingDrill trainingDrill) throws Exception{
        AbstractGenericOperation operation = new AddTrainingDrill();
        operation.execute(trainingDrill);
    }
    
    public void addTrainingDrill1(TrainingDrill trainingDrill) throws Exception{
        AbstractGenericOperation operation = new AddTrainingDrill();
        //operation.execute(trainingDrill);
    }

    public void editTrainingDrill(TrainingDrill trainingDrill) throws Exception {
        AbstractGenericOperation operation = new EditTrainingDrill();
        operation.execute(trainingDrill);
    }
    
    public void deleteTrainingDrill(TrainingDrill trainingDrill) throws Exception{
        AbstractGenericOperation operation = new DeleteTrainingDrill();
        operation.execute(trainingDrill);
    }

    public List<Drill> getAllDrills() throws Exception{
        AbstractGenericOperation operation = new GetAllDrills();
        operation.execute(new Drill());
        return ((GetAllDrills)operation).getDrills();
    }
    
    public TrainingDrill getTrainingDrillById(TrainingDrill trainingDrill) throws Exception{
        AbstractGenericOperation operation = new GetTrainingDrillById();
        operation.execute(trainingDrill);
        return ((GetTrainingDrillById)operation).getTrainingDrill();
    }
    
}
