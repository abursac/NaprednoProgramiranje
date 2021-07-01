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
 * Serverski kontroler koji upravlja svim procesima
 * @author Aleksandar
 */
public class Controller {
    private static Controller controller;

    /**
     * Konstruktor
     */
    public Controller() {
    }
    
    /** 
     * Singleton metoda
     * @return
     */
    public static Controller getInstance() {
        if (controller == null)
            controller = new Controller();
        return controller;
    }
    
    /**
     * Metoda za prijavljivanje na sistem
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
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
    
    /**
     * Metoda koja vraca sve trenera
     * @return
     * @throws Exception
     */
    public List<Coach> getAllCoaches() throws Exception{
        AbstractGenericOperation operation = new GetAllCoaches();
        operation.execute(new Coach());
        return ((GetAllCoaches)operation).getCoaches();
    }

    /**
     * Metoda koja vraca sve treninge
     * @return
     * @throws Exception
     */
    public List<Training> getAllTrainings() throws Exception{
        AbstractGenericOperation operation = new GetAllTrainings();
        operation.execute(new Training());
        return ((GetAllTrainings)operation).getTrainings();
    }
        
    /**
     * Metodfa koja dodaje trening
     * @param project
     * @throws Exception
     */
    public void addTraining(Training project) throws Exception {
        AbstractGenericOperation operation = new AddTraining();
        operation.execute(project);
    }
        
    /**
     * Metoda za izmenu treninga
     * @param project
     * @throws Exception
     */
    public void editTraining(Training project) throws Exception {
        AbstractGenericOperation operation = new EditTraining();
        operation.execute(project);
    }
    
    /**
     * Metoda za brisanje treninga
     * @param project
     * @throws Exception
     */
    public void deleteTraining(Training project) throws Exception {
       AbstractGenericOperation operation = new DeleteTraining();
        operation.execute(project);
    }

    /**
     * Metoda koja vraca sve stavke treninga
     * @param training
     * @return
     * @throws Exception
     */
    public List<TrainingDrill> getAllTrainingDrills(Training training) throws Exception{
        AbstractGenericOperation operation = new GetAllTrainingDrills();
        operation.execute(new TrainingDrill(training));
        return ((GetAllTrainingDrills)operation).getTrainingDrills();
    }

    /**
     * Metoda koja dodaje stavku treninga
     * @param trainingDrill
     * @throws Exception
     */
    public void addTrainingDrill(TrainingDrill trainingDrill) throws Exception{
        AbstractGenericOperation operation = new AddTrainingDrill();
        operation.execute(trainingDrill);
    }
    
    /**
     *
     * @param trainingDrill
     * @throws Exception
     */
    public void addTrainingDrill1(TrainingDrill trainingDrill) throws Exception{
        AbstractGenericOperation operation = new AddTrainingDrill();
        //operation.execute(trainingDrill);
    }

    /**
     * Metoda koja menja stavku treninga
     * @param trainingDrill
     * @throws Exception
     */
    public void editTrainingDrill(TrainingDrill trainingDrill) throws Exception {
        AbstractGenericOperation operation = new EditTrainingDrill();
        operation.execute(trainingDrill);
    }
    
    /**
     * Metoda koja brise stavku treninga
     * @param trainingDrill
     * @throws Exception
     */
    public void deleteTrainingDrill(TrainingDrill trainingDrill) throws Exception{
        AbstractGenericOperation operation = new DeleteTrainingDrill();
        operation.execute(trainingDrill);
    }

    /**
     * Metoda koja vraca sve stavke
     * @return
     * @throws Exception
     */
    public List<Drill> getAllDrills() throws Exception{
        AbstractGenericOperation operation = new GetAllDrills();
        operation.execute(new Drill());
        return ((GetAllDrills)operation).getDrills();
    }
    
    /**
     * Metoda koja vraca stavku treninga prema id-ju
     * @param trainingDrill
     * @return
     * @throws Exception
     */
    public TrainingDrill getTrainingDrillById(TrainingDrill trainingDrill) throws Exception{
        AbstractGenericOperation operation = new GetTrainingDrillById();
        operation.execute(trainingDrill);
        return ((GetTrainingDrillById)operation).getTrainingDrill();
    }
    
}
