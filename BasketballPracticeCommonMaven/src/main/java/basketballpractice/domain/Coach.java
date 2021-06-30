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
 *
 * @author Aleksandar
 */
public class Coach implements GenericEntity{
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;

    public Coach() {
    }
    
    public Coach(int id) {
        this.id = id;
    }

    public Coach(int id, String firstname, String lastname, String username, String password, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public String getTableName() {
        return "coach";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "username, password, email, firstname, lastname";
    }

    @Override
    public String getInsertValues() {
        return "'"+username+"','"+password+"','"+email+"','"+firstname+"','"+lastname+"'";
    }

    @Override
    public String setAtrValue() {
        return "username=" + (username == null ? null : "'" + username + "'")
                 +"', " + "password=" + (password == null ? null : "'" + password + "'")
                 +"', " + "email=" + (email == null ? null : "'" + email + "'")
                 +"', " + "firstname=" + (firstname == null ? null : "'" + firstname + "'")
                 +"', " + "lastname=" + (lastname == null ? null : "'" + lastname + "'");
    }

    @Override
    public String getWhereCondition() {
        return "id="+id;
    }

    @Override
    public String getJoin() {
        return "";
    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Coach(rs.getInt("coach.id"),rs.getString("coach.firstname"),rs.getString("coach.lastname"),rs.getString("coach.username"),rs.getString("coach.password"),rs.getString("coach.email"));
    }
}
