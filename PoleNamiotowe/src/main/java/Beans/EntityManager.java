/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import java.sql.*;

/**
 *
 * @author Mateusz Purga³
 */
public class EntityManager {
    
    Connection con;
    
    public EntityManager()
    {

        con = null;
        try {
            // £adujemy plik z klas¹ sterownika bazy danych
            Class.forName("com.mysql.jdbc.Driver");
            // Tworzymy po³¹czenie do bazy danych
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/namiotdb", "root", "admin");

        } catch (SQLException sqle) {
            System.err.println("SQL exception: " + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("ClassNotFound exception: " + cnfe.getMessage());
        }  
    
    }
    public Connection getConnection()
    {
        return con;
    }
}
