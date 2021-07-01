/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.repository.db;

import basketballpractice.repository.Repository;

/**
 * Interfejs koji predstavlja repozitorijum baze podataka
 * @author Aleksandar
 * @param <T>
 */
public interface DBRepository<T> extends Repository<T> {

    /**
     * Uspostavljanje veze sa bazom
     * @throws Exception
     */
    default public void connect() throws Exception{
        DBConnectionFactory.getInstance().getConnection();
    }
    
    /**
     * Raskidanje veze sa bazom
     * @throws Exception
     */
    default public void disconnect() throws Exception{
        DBConnectionFactory.getInstance().getConnection().close();
    }
    
    /**
     * Potvrdjivanje transakcija
     * @throws Exception
     */
    default public void commit() throws Exception{
        DBConnectionFactory.getInstance().getConnection().commit();
    }
    
    /**
     * Ponistavanje transakcija
     * @throws Exception
     */
    default public void rollback() throws Exception{
        DBConnectionFactory.getInstance().getConnection().rollback();
    }
}
