/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.repository.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Klasa koja sluzi za uspostavljanje veze sa bazom podataka
 * @author Aleksandar
 */
public class DBConnectionFactory {
    private Connection connection;
    private static DBConnectionFactory instance;
    
    private DBConnectionFactory() {
    }
    
    /**
     * Singleton metoda
     * @return
     */
    public static DBConnectionFactory getInstance() {
        if (instance == null)
            instance = new DBConnectionFactory();
        return instance;
    }
    
    /**
     * Uspostavljanje konekcije
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/dbconfig.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }

    public Connection getTestConnection() throws Exception
    {
        if (connection == null || connection.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/dbconfig_1.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }
}
