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

public class RepositoryDBGeneric implements DBRepository<GenericEntity> {

    @Override
    public void add(GenericEntity entity) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
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
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity entity) throws Exception {
        try {
        Connection connection = DBConnectionFactory.getInstance().getConnection();
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
            Connection connection = DBConnectionFactory.getInstance().getConnection();
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
            Connection connection = DBConnectionFactory.getInstance().getConnection();
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
            System.out.println(entity.getWhereCondition());
            Connection connection = DBConnectionFactory.getInstance().getConnection();
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


    
    public void addAssignees(Training training){
        System.out.println(training.getAssignees());
        for (Coach assignee : training.getAssignees()) {
            try{
            String sql = "INSERT INTO coach_training VALUES (?,?,CURDATE())";
            Connection connection = DBConnectionFactory.getInstance().getConnection();
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
            String sql = "SELECT * FROM COACH WHERE id IN (SELECT coachId FROM coach_training WHERE trainingId = ?)";
            List<Coach> coaches = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
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
