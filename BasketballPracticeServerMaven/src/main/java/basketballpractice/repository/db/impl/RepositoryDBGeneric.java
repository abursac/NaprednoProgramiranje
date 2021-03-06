/*
 * To change this license header, choose License Headers in Training Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.repository.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import basketballpractice.domain.GenericEntity;
import basketballpractice.domain.Training;
import basketballpractice.domain.TrainingDrill;
import basketballpractice.domain.Coach;
import basketballpractice.repository.db.DBConnectionFactory;
import basketballpractice.repository.db.DBRepository;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.json.simple.JSONObject;

/**
 * Implementira konkretne metode za komuniciranje sa bazom podataka
 * @author Aleksandar
 */
public class RepositoryDBGeneric implements DBRepository<GenericEntity> {

    boolean test = false;
    Connection connection;
    public RepositoryDBGeneric(boolean test)
    {
        this.test = test;
    }
    
    @Override
    public void add(GenericEntity entity) throws Exception {
        try {
            if(test)
            {
                connection = DBConnectionFactory.getInstance().getTestConnection();
            }
            else
            {
                connection = DBConnectionFactory.getInstance().getConnection();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                int id = rsKey.getInt(1);
                entity.setId(id);
                if (entity instanceof Training) {
                    Training project = (Training) entity;
                    addAssignees(project);
                }
            }
            statement.close();
            rsKey.close();
            
            
            JSONObject object = new JSONObject();
            String[] columns = entity.getColumnNamesForInsert().split(",");
            String[] values = entity.getInsertValues().split(",");
            for(int i = 0; i < columns.length; i++)
            {
                object.put(columns[i], values[i]);
            }
            PrintStream ostr = new PrintStream(new FileOutputStream("file.txt", true));
            ostr.print(object.toJSONString());
            ostr.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity entity) throws Exception {
        try {
            if(test)
            {
                connection = DBConnectionFactory.getInstance().getTestConnection();
            }
            else
            {
                connection = DBConnectionFactory.getInstance().getConnection();
            }
            List<GenericEntity> entities = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(entity.getTableName())
                    .append(entity.getJoin());
            if (entity instanceof TrainingDrill) {
                TrainingDrill pt = (TrainingDrill) entity;
                sb.append(" WHERE trainingId=").append(pt.getTraining().getId());
            }
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                GenericEntity e = entity.getNewRecord(rs);
                if (entity instanceof Training) {
                    Training training = (Training) e;
                    training.setAssignees(getAllAssignees(training));
                }
                entities.add(e);
            }
            rs.close();
            statement.close();
            return entities;
         } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void edit(GenericEntity entity) throws Exception {
        try {
            if(test)
            {
                connection = DBConnectionFactory.getInstance().getTestConnection();
            }
            else
            {
                connection = DBConnectionFactory.getInstance().getConnection();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(entity.getTableName())
                    .append(" SET ").append(entity.setAtrValue())
                    .append(" WHERE ")
                    .append(entity.getWhereCondition());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            if (entity instanceof Training) {
                Training training = (Training) entity;
                addAssignees(training);
            }
            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity entity) throws Exception {
         try {
             if(test)
            {
                connection = DBConnectionFactory.getInstance().getTestConnection();
            }
            else
            {
                connection = DBConnectionFactory.getInstance().getConnection();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(entity.getTableName())
                    .append(" WHERE ")
                    .append(entity.getWhereCondition());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public GenericEntity getById(GenericEntity entity) throws Exception {
         try {
             if(test)
            {
                connection = DBConnectionFactory.getInstance().getTestConnection();
            }
            else
            {
                connection = DBConnectionFactory.getInstance().getConnection();
            }
            System.out.println(entity.getWhereCondition());
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(entity.getTableName())
                    .append(entity.getJoin())
                    .append(" WHERE ")
                    .append(entity.getWhereCondition());   
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            GenericEntity e = null;
            if (rs.next()) {
                e = entity.getNewRecord(rs);
                if (entity instanceof Training) {
                    Training training = (Training) e;
                    training.setAssignees(getAllAssignees(training));
                }
            }
            rs.close();
            statement.close();
            return e;
         } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     * Dodaje dodeljene trenere za odredjeni trening u bazu
     * @param training
     */
    public void addAssignees(Training training){
        System.out.println(training.getAssignees());
        for (Coach assignee : training.getAssignees()) {
            try{
            if(test)
            {
                connection = DBConnectionFactory.getInstance().getTestConnection();
            }
            else
            {
                connection = DBConnectionFactory.getInstance().getConnection();
            }
            String sql = "INSERT INTO coach_training VALUES (?,?,CURDATE())";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, training.getId());
            statement.setInt(2, assignee.getId());
            statement.executeUpdate();
            statement.close();
            } catch (Exception e) {
            System.out.println(e.getMessage());
            }
        }
    }
    
    private List<Coach> getAllAssignees(Training training) {
        try {
            if(test)
            {
                connection = DBConnectionFactory.getInstance().getTestConnection();
            }
            else
            {
                connection = DBConnectionFactory.getInstance().getConnection();
            }
            String sql = "SELECT * FROM COACH WHERE id IN (SELECT coachId FROM coach_training WHERE trainingId = ?)";
            List<Coach> coaches = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, training.getId());
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Coach coach = new Coach();
                coach.setId(rs.getInt("id"));
                coach.setFirstname(rs.getString("firstname"));
                coach.setLastname(rs.getString("lastname"));
                coach.setUsername(rs.getString("username"));
                coach.setEmail(rs.getString("email"));
                coach.setPassword(rs.getString("password"));
                coaches.add(coach);
            }
            rs.close();
            statement.close();
            return coaches;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
