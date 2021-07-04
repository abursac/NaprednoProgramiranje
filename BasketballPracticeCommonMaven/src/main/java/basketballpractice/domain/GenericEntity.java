/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfejs kojeg implementiraju sve domenske klase
 * @author Aleksandar
 */
public interface GenericEntity extends Serializable {

    /**
     * Vraca ime tabele u bazi kojoj odgovara klasa
     * @return
     */
    String getTableName();

    /**
     * Vraca imena kolona tabele iz baze
     * @return
     */
    String getColumnNamesForInsert();

    /**
     * Sluzi za izradu upita za unos u bazu
     * @return
     */
    String getInsertValues();

    /**
     * Setter za id
     * @param id
     * @throws java.lang.Exception
     */
    void setId(int id) throws Exception;
    
    /**
     * Sluzi za izradu upita za unos u bazu
     * @return
     */
    String setAtrValue();
    
    /**
     * Sluzi za izradu uslova za upit za bazu
     * @return
     */
    String getWhereCondition();
    
    /**
     * Sluzi za join-ovanje u bazi
     * @return
     */
    String getJoin();
    
    /**
     * Vadi instancu klase iz baze
     * @param rs
     * @return
     * @throws SQLException
     */
    GenericEntity getNewRecord(ResultSet rs) throws SQLException;
}
