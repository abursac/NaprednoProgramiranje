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
 *
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

    public TrainingDrill() {
    }
    
    public TrainingDrill(int id) {
        this.id = id;
    }

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
    
    public TrainingDrill(Training training) {
        this.training = training;
    }

    public TrainingDrill(int id, Training training) {
        this.id = id;
        this.training = training;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drill getDrill() {
        return drill;
    }

    public void setDrill(Drill drill) {
        this.drill = drill;
    }

    public Coach getAssignee() {
        return assignee;
    }

    public void setAssignee(Coach assignee) {
        this.assignee = assignee;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    public Coach getAuthor() {
        return author;
    }

    public void setAuthor(Coach author) {
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
