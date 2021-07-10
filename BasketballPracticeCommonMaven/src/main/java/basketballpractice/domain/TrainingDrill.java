/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 * Domenska klasa TrainingDrill
 * @author Aleksandar
 */
public class TrainingDrill implements GenericEntity{
    private int id;
    private Training training;
    private Date createdOn;
    private String description;
    private Drill drill;
    private Coach assignee;
    private Intensity intensity;
    private Coach author;

    /**
     * Bezparametarski konstruktor
     */
    public TrainingDrill() {
    }
    
    /**
     * Konstruktor koji kao parametar prima id
     * @param id Id kao ceo broj
     */
    public TrainingDrill(int id) {
        this.id = id;
    }

    /**
     * Konstruktor koji kao parametar prima sva polja klase
     * @param id Id vezbe kao ceo broj
     * @param training Trening kojem vezba pripada kao Training
     * @param createdOn Datum kreiranja vezbe kao Date
     * @param description Opis vezbe kao String
     * @param drill Vezba kao Drill
     * @param assignee Dodeljeni trener kao Coach
     * @param intensity Intenzitet vezbe kao Intensity
     * @param author Autor vezbe kao Coach
     */
    public TrainingDrill(int id, Training training, Date createdOn, String description, Drill drill, Coach assignee, Intensity intensity, Coach author) {
        this.id = id;
        this.training = training;
        this.createdOn = createdOn;
        this.description = description;
        this.drill = drill;
        this.assignee = assignee;
        this.intensity = intensity;
        this.author = author;
    }
    
    /**
     * Konstruktor koji kao parametar prima trening
     * @param training Trening kojem vezba pripada kao Training
     */
    public TrainingDrill(Training training) {
        this.training = training;
    }

    /**
     * Konstruktor koji kao parametre prima id i trening
     * @param id Id vezbe kao ceo broj
     * @param training Trening kojem vezba pripada kao Training
     */
    public TrainingDrill(int id, Training training) {
        this.id = id;
        this.training = training;
    }

    /**
     * Vraca vrednost id-ja vezbe
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Postavlja vrednost id-ja vezbe na onu koju prosledimo kroz parametar
     */
    @Override
    public void setId(int id) throws Exception {
        if(id < 0)
            throw new Exception("TrainingDrill ID can't be a negative number");
        this.id = id;
    }

    /**
     * Vraca vrednost treninga
     * @return
     */
    public Training getTraining() {
        return training;
    }

    /**
     * Postavlja vrednost treninga kojem vezba pripada na onu koju prosledimo kroz parametar
     * @param training Trening kojem vezba pripada kao Training
     * @throws java.lang.Exception Stvara se izuzetak ako Trening nije potpuno inicijalizovan
     */
    public void setTraining(Training training) throws Exception {
        if(training == null || training.getId() == 0 || training.getName().equals("") || training.getDescription().equals("") || training.getOwner() == null || training.getAssignees().isEmpty())
            throw new Exception("Training must be fully initialized");
        this.training = training;
    }

    /**
     * Vraca datum kreiranja vezbe
     * @return
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Postavlja vrednost datuma kreiranja vezbe na onu koju prosledimo kroz parametar
     * @param createdOn Datum kreiranja kao Date
     * @throws java.lang.Exception Stvara se izuzetak ako to nije danasnji datum
     */
    public void setCreatedOn(Date createdOn) throws Exception {
        if(!(createdOn.getYear() == (new Date()).getYear() && createdOn.getMonth() == (new Date()).getMonth() && createdOn.getDate() == (new Date()).getDate()))
            throw new Exception("Date of creation must be today's date");
        this.createdOn = createdOn;
    }

    /**
     * Vraca opis vezbe
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Postavlja opis vezbe na onaj koji prosledimo kroz parametar
     * @param description Opis vezbe kao String
     * @throws java.lang.Exception Stvara se izuzetak ako je opis vezbe kraci od 10 karaktera
     */
    public void setDescription(String description) throws Exception {
        if(description.length() < 10)
            throw new Exception("Description must be at least 10 characters long");
        this.description = description;
    }

    /**
     * Vraca vezbu
     * @return
     */
    public Drill getDrill() {
        return drill;
    }

    /**
     * Postavlja vrednost vezbe na onu koju prosledimo kroz parametar
     * @param drill Vezba kao Drill
     * @throws java.lang.Exception Stvara se izuzetak ako vezba nije potpuno inicijalizovana
     */
    public void setDrill(Drill drill) throws Exception {
        if(drill == null || drill.getId() == 0 || drill.getName().equals("") || drill.getDescription().equals(""))
            throw new Exception("Drill must be fully initialized.");
        this.drill = drill;
    }

    /**
     * Vraca dodeljenog trenera
     * @return
     */
    public Coach getAssignee() {
        return assignee;
    }

    /**
     * Postavlja dodeljenog trenera na onog kojeg prosledimo kroz konstruktor
     * @param assignee Dodeljeni trener kao Coach
     * @throws java.lang.Exception Stvara se izuzetak ako dodeljeni trener nije potpuno inicijalizovan
     */
    public void setAssignee(Coach assignee) throws Exception {
        if(assignee == null || assignee.getId() == 0 || assignee.getFirstname().equals("") || assignee.getLastname().equals("") || assignee.getUsername().equals("") || assignee.getPassword().equals("") || assignee.getEmail().equals(""))
            throw new Exception("Assignee must be fully initialized.");
        this.assignee = assignee;
    }

    /**
     * Vraca vrednost intenziteta treninga
     * @return
     */
    public Intensity getIntensity() {
        return intensity;
    }

    /**
     * Postavlja vrednost intenziteta treninga na onu koju mu prosledimo kroz parametar
     * @param intensity
     */
    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    /**
     * Vraca vrednost autora treninga
     * @return
     */
    public Coach getAuthor() {
        return author;
    }

    /**
     * Postavlja vrednost autora treninga na onu koju mu prosledimo kroz parametar
     * @param author Autor treninga kao Coach
     * @throws java.lang.Exception Stvara se izuzetak ako autor nije potpuno inicijalizovan
     */
    public void setAuthor(Coach author) throws Exception {
        if(author == null || author.getId() == 0 || author.getFirstname().equals("") || author.getLastname().equals("") || author.getUsername().equals("") || author.getPassword().equals("") || author.getEmail().equals(""))
            throw new Exception("Author must be fully initialized.");
        this.author = author;
    }

    @Override
    public String toString() {
        return "TrainingDrill{" + "id=" + id + ", training=" + training + ", createdOn=" + createdOn + ", description=" + description + ", drill=" + drill + ", assignee=" + assignee + ", intensity=" + intensity + ", author=" + author + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.training);
        hash = 79 * hash + Objects.hashCode(this.createdOn);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.drill);
        hash = 79 * hash + Objects.hashCode(this.assignee);
        hash = 79 * hash + Objects.hashCode(this.intensity);
        hash = 79 * hash + Objects.hashCode(this.author);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TrainingDrill other = (TrainingDrill) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.training, other.training)) {
            return false;
        }
        if (!Objects.equals(this.createdOn, other.createdOn)) {
            return false;
        }
        if (!Objects.equals(this.drill, other.drill)) {
            return false;
        }
        if (!Objects.equals(this.assignee, other.assignee)) {
            return false;
        }
        if (!Objects.equals(this.intensity, other.intensity)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "training_drill";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "trainingId, createdOn, description, drillId, assigneeTrainingId, assigneeId, intensityId, authorId";
    }

    @Override
    public String getInsertValues() {
        return training.getId()+",'"+new java.sql.Date(new Date().getTime())+"','"+description+"',"+drill.getId()+","+training.getId()+","+assignee.getId()+","+intensity.ordinal()+","+author.getId();
    }

    @Override
    public String setAtrValue() {
        return "description=" + (description == null ? null : "'" + description + "'")
                +", drillId="+drill.getId()+", assigneeId="+assignee.getId()+", intensityId="+intensity.ordinal();
    }

    @Override
    public String getWhereCondition() {
        return "training_drill.id="+id+" AND training_drill.trainingId="+training.getId();
    }
    

    @Override
    public String getJoin() {
        return " INNER JOIN COACH o ON (training_drill.authorId = o.id) INNER JOIN COACH a ON(training_drill.assigneeId = a.id)" +
                " INNER JOIN drill d ON (training_drill.drillId = d.id) INNER JOIN training t ON (training_drill.trainingId = t.id)";
    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        Coach owner = new Coach(rs.getInt("o.id"),rs.getString("o.firstname"),rs.getString("o.lastname"),rs.getString("o.username"),rs.getString("o.password"),rs.getString("o.email"));
        Training training = new Training(rs.getInt("t.id"),rs.getString("t.name"),rs.getString("t.description"),owner, null);
        Coach assignee = new Coach(rs.getInt("a.id"),rs.getString("a.firstname"),rs.getString("a.lastname"),rs.getString("a.username"),rs.getString("a.password"),rs.getString("a.email"));
        Drill drill = new Drill(rs.getInt("d.id"),rs.getString("d.name"),rs.getString("d.description"));
        return new TrainingDrill(rs.getInt("training_drill.id"),training,rs.getDate("training_drill.createdOn"),rs.getString("training_drill.description"),drill,assignee,Intensity.values()[rs.getInt("intensityId")],owner);
    }
    
    
}
