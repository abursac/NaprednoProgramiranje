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
 * Domenska klasa koja predstavlja trenera
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
     * Bezparametarski konstruktor
     */
    public Coach() {
    }
    
    /**
     * Konstruktor koji ima samo parametar id
     * @param id Id trenera kao ceo broj
     */
    public Coach(int id) {
        this.id = id;
    }

    /**
     * Konstruktor koji kao parametre prima sva polja klase
     * @param id Id trenera kao ceo broj
     * @param firstname Ime trenera kao String
     * @param lastname Prezime trenera kao String
     * @param username Korisnicko ime trenera kao String
     * @param password Sifra trenera kao String
     * @param email E-mail adresa trenera kao String
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
     * Vraca id trenera
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Vraca ime trenera
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Vraca prezime trenera
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Vraca korisnicko ime trenera
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Vraca sifru trenera
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Vraca e-mail adresu trenera
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja vrednost id-ja na onu vrednost koju prosledimo kao parametar
     * @param id Id trenera kao ceo broj
     */
    @Override
    public void setId(int id) throws Exception {
        if(id < 0)
            throw new Exception("ID must be 0 or larger number");
        this.id = id; 
    }

    /**
     * Postavlja vrednost imena trenera na onu vrednost koju prosledimo kao parametar
     * @param firstname Ime trenera kao String
     * @throws java.lang.Exception Stvara se izuzetak ukoliko je prosledjeno ime krace od 2 karaktera
     */
    public void setFirstname(String firstname) throws Exception {
        if(firstname.length() < 2)
            throw new Exception("First name must have at least 2 characters");     
        this.firstname = firstname;
    }

    /**
     * Postavlja vrednost prezimena trenera na onu vrednost koju prosledimo kao parametar
     * @param lastname Prezime trenera kao String
     * @throws java.lang.Exception Stvara se izuzetak ukoliko je prosledjeno prezime krace od 2 karaktera
     */
    public void setLastname(String lastname) throws Exception {
        if(lastname.length() < 2)
            throw new Exception("Last name must have at least 2 characters");
        this.lastname = lastname;
    }

    /**
     * Postavlja vrednost korisnickog imena trenera na onu vrednost koju prosledimo kao parametar
     * @param username Korisnicko ime trenera kao String
     * @throws java.lang.Exception Stvara se izuzetak ukoliko je prosledjeno korisnicko ime krace od 4 karaktera
     */
    public void setUsername(String username) throws Exception {
        if(username.length() < 4)
            throw new Exception("Username must have at least 4 characters");
        this.username = username;
    }

    /**
     * Postavlja vrednost sifre trenera na onu vrednost koju prosledimo kao parametar
     * @param password Sifra trenera kao String
     * @throws java.lang.Exception Stvara se izuzetak ukoliko je prosledjena sifra kraca od 8 karaktera
     */
    public void setPassword(String password) throws Exception {
        if(password.length() < 8)
            throw new Exception("Password must have at least 8 characters");
        this.password = password;
    }

    /**
     * Postavlja vrednost e-maila trenera na onu vrednost koju prosledimo kao parametar
     * @param email E-mail adresa trenera kao String
     * @throws java.lang.Exception Stvara se izuzetak ukoliko se prosledjena e-mail adresa ne zavrsava sa '.com'
     */
    public void setEmail(String email) throws Exception {
        if(!".com".equals(email.substring(email.length()-4)))
            throw new Exception("E-mail must finish with '.com'");
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
        return "username,password,email,firstname,lastname";
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
     * @param rs Instanca klase iz baze kao ResultSet
     * @return
     * @throws SQLException
     */
    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Coach(rs.getInt("coach.id"),rs.getString("coach.firstname"),rs.getString("coach.lastname"),rs.getString("coach.username"),rs.getString("coach.password"),rs.getString("coach.email"));
    }
}
