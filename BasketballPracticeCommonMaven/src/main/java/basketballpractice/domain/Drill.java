/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Domenska klasa Drill
 * @author Aleksandar
 */
public class Drill implements GenericEntity{
    private int id;
    private String name;
    private String description;

    /**
     * Konstruktor
     */
    public Drill() {
    }
    
    /**
     * Konstruktor
     * @param id
     */
    public Drill(int id) {
        this.id = id;
    }

    /**
     * Konstruktor
     * @param id
     * @param name
     * @param description
     */
    public Drill(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
        if( id < 0)
            throw new Exception("ID must be a positive number");
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
            throw new Exception("Drill name must have at least 5 characters");
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
            throw new Exception("Drill description must have at least 10 characters");
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.description);
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
        final Drill other = (Drill) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    /**
     * Vraca ime tabele u bazi kojoj odgovara klasa
     * @return
     */
    @Override
    public String getTableName() {
        return "drill";
    }

    /**
     * Vraca imena kolona tabele iz baze
     * @return
     */
    @Override
    public String getColumnNamesForInsert() {
        return "name,description";
    }

    /**
     * Sluzi za izradu upita za unos u bazu
     * @return
     */
    @Override
    public String getInsertValues() {
        return "'"+name+"','"+description+"'";
    }

    /**
     * Sluzi za izradu upita za unos u bazu
     * @return
     */
    @Override
    public String setAtrValue() {
        return "name='" + name + "', " + "description=" + (description == null ? null : "'" + description + "'");
    }

    /**
     * Sluzi za izradu uslova za upit za bazu
     * @return
     */
    @Override
    public String getWhereCondition() {
        return "id="+id;
    }

    /**
     * Sluzi za join-ovanje u bazi
     * @return
     */
    @Override
    public String getJoin() {
        return "";
    }

    /**
     * Vadi instancu klase iz baze
     * @param rs
     * @return
     * @throws SQLException
     */
    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Drill(rs.getInt("drill.id"),rs.getString("drill.name"),rs.getString("drill.description"));
    }
    
    
}
