/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Domenska klasa Training
 * @author Aleksandar
 */
public class Training implements GenericEntity{
    private int id;
    private String name;
    private String description;
    private Coach owner;
    private List<Coach> assignees;

    /**
     * Konstruktor
     */
    public Training() {
    }
    
    /**
     * Konstruktor
     * @param id
     */
    public Training(int id) {
        this.id = id;
    }

    /**
     * Konstruktor
     * @param id
     * @param name
     * @param description
     * @param owner
     * @param assignee
     */
    public Training(int id, String name, String description, Coach owner, Coach assignee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.assignees = new ArrayList<>();
        this.assignees.add(assignee);
    }
    
    /**
     * Getter za id 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Setter za id
     * @param id
     */
    @Override
    public void setId(int id) throws Exception {
        if(id < 0)
            throw new Exception("Training ID can't be a negative number");
        this.id = id;
    }

    /**
     * Getter za name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter za name
     * @param name
     * @throws java.lang.Exception
     */
    public void setName(String name) throws Exception {
        if(name.length() < 5)
            throw new Exception("Training name must have at least 5 characters");
        this.name = name;
    }

    /**
     * Getter za description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter za description
     * @param description
     * @throws java.lang.Exception
     */
    public void setDescription(String description) throws Exception {
        if(description.length() < 10)
            throw new Exception("Training description must have at least 10 characters");
        this.description = description;
    }

    /**
     * Getter za owner-a
     * @return
     */
    public Coach getOwner() {
        return owner;
    }

    /**
     * Setter za owner-a
     * @param owner
     * @throws java.lang.Exception
     */
    public void setOwner(Coach owner) throws Exception {
        if(owner == null || owner.getId() == 0 || owner.getFirstname().equals("") || owner.getLastname().equals("") || owner.getUsername().equals("") || owner.getPassword().equals("") || owner.getEmail().equals(""))
            throw new Exception("Training owner must be fully initialized.");
        this.owner = owner;
    }

    /**
     * Getter za listu dodeljenih coach-eva
     * @return
     */
    public List<Coach> getAssignees() {
        return assignees;
    }

    /**
     * Setter za listu dodeljenih coach-eva
     * @param assignees
     * @throws java.lang.Exception
     */
    public void setAssignees(List<Coach> assignees) throws Exception {
        if(assignees.isEmpty())
            throw new Exception("You must add at least one assignee.");
        this.assignees = assignees;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.owner);
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
        final Training other = (Training) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", description=" + description + ", owner=" + owner + '}';
    }

    @Override
    public String getTableName() {
        return "training";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, description, coachId";
    }

    @Override
    public String getInsertValues() {
        return "'"+name+"','"+description+"',"+owner.getId();
    }
    
    @Override
    public String setAtrValue() {
       return "name=" + (name == null ? null : "'" + name + "'") + ", " + "description=" + (description == null ? null : "'" + description + "'");
    }

    @Override
    public String getWhereCondition() {
        return "id="+id;
    }

    @Override
    public String getJoin() {
        return " INNER JOIN COACH ON (training.coachId = coach.id)";
    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        Coach coach = new Coach(rs.getInt("coach.id"),rs.getString("coach.firstname"),rs.getString("coach.lastname"),rs.getString("coach.username"),rs.getString("coach.password"),rs.getString("coach.email"));
        return new Training(rs.getInt("training.id"),rs.getString("training.name"),rs.getString("training.description"),coach, null);
    }
    
}
