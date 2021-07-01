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

/**
 * Domenska klasa Coach
 * @author Aleksandar
 */
public class Coach implements GenericEntity{
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;

    /**
     * Konstruktor
     */
    public Coach() {
    }
    
    /**
     * Konstruktor
     * @param id
     */
    public Coach(int id) {
        this.id = id;
    }

    /**
     * Konstruktor
     * @param id
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @param email
     */
    public Coach(int id, String firstname, String lastname, String username, String password, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Getter za id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Getter za Firstname
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Getter za Lastname
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Getter za username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter za password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter za email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter za id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter za Firstname
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Setter za Lastname
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Setter za username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter za password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter za email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.firstname);
        hash = 89 * hash + Objects.hashCode(this.lastname);
        hash = 89 * hash + Objects.hashCode(this.username);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.email);
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
        final Coach other = (Coach) obj;
        if (!Objects.equals(this.username, other.username)) {
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
        return "coach";
    }

    /**
     * Vraca imena kolona tabele iz baze
     * @return
     */
    @Override
    public String getColumnNamesForInsert() {
        return "username, password, email, firstname, lastname";
    }

    /**
     * Sluzi za izradu upita za unos u bazu
     * @return
     */
    @Override
    public String getInsertValues() {
        return "'"+username+"','"+password+"','"+email+"','"+firstname+"','"+lastname+"'";
    }

    /**
     * Sluzi za izradu upita za unos u bazu
     * @return
     */
    @Override
    public String setAtrValue() {
        return "username=" + (username == null ? null : "'" + username + "'")
                 +"', " + "password=" + (password == null ? null : "'" + password + "'")
                 +"', " + "email=" + (email == null ? null : "'" + email + "'")
                 +"', " + "firstname=" + (firstname == null ? null : "'" + firstname + "'")
                 +"', " + "lastname=" + (lastname == null ? null : "'" + lastname + "'");
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
        return new Coach(rs.getInt("coach.id"),rs.getString("coach.firstname"),rs.getString("coach.lastname"),rs.getString("coach.username"),rs.getString("coach.password"),rs.getString("coach.email"));
    }
}
