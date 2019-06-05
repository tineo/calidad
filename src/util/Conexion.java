package util;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tineo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class Conexion {
    
    private static Connection connection = null;
    private final static String ADRESS   = "jdbc:mysql://localhost";
    private final static String DATABASE = "calidad";
    private final static String USER     = "root";
    private final static String PASSWORD = "megamisama";
    private final static String PORT     = "3306";
    private final static String DRIVER   = "com.mysql.jdbc.Driver";
    
    /**
     * Method that loads the specified driver
     * 
     * @return void
     **/
    
    private static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName(DRIVER);
        }
        catch (Exception e) {
            errorHandler("Failed to load the driver " + DRIVER, e);
        }
    }

    /**
     * Method that loads the connection into the right property
     * 
     * @return void
     **/
    
    private static void loadConnection() {
        try {
            connection = DriverManager.getConnection(getFormatedUrl(), USER, PASSWORD);
            System.out.println("Conectooo!");
        }
        catch (SQLException e) {
            errorHandler("Failed to connect to the database " + getFormatedUrl(), e);         
        }
    }
    
    /**
     * Method that shows the errors thrown by the singleton
     * 
     * @param  {String}    Message
     * @option {Exception} e
     * @return  void
     **/
    
    private static void errorHandler(String message, Exception e) {
        System.out.println(message);  
        if (e != null) System.out.println(e.getMessage());   
    }

    /**
     * Method that returns the formated URL to connect to the database
     * 
     * @return {String}
     **/
    
    private static String getFormatedUrl() {
        return ADRESS + ":" + PORT + "/" + DATABASE;
    }
    
    /**
     * Static method that returns the instance for the singleton
     * 
     * @return {Connection} connection
     **/
    
    public static Connection getConnection() {
        if (connection == null) {
            loadDriver();
            loadConnection();
        }
        return connection;
    }
    
    /**
     * Static method that close the connection to the database
     * 
     * @return void
     **/
    
    public static void closeConnection() {
        if (connection == null) {
            errorHandler("No connection found", null);
        }
        else {
            try {
                connection.close();
                connection = null;
            }
            catch (SQLException e) {
                errorHandler("Failed to close the connection", e);
            }
        }
    }
}