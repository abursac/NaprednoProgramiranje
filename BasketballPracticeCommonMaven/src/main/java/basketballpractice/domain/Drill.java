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
public class Drill implements GenericEntity{
    private int id;
    private String name;
    private String description;

    public Drill() {
    }
    
    public Drill(int id) {
        this.id = id;
    }

    public Drill(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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

    @Override
    public String getTableName() {
        return "drill";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name,description";
    }

    @Override
    public String getInsertValues() {
        return "'"+name+"','"+description+"'";
    }

    @Override
    public String setAtrValue() {
        return "name='" + name + "', " + "description=" + (description == null ? null : "'" + description + "'");
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
        return new Drill(rs.getInt("drill.id"),rs.getString("drill.name"),rs.getString("drill.description"));
    }
    
    
}
