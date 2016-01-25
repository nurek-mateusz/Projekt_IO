/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polenamiotowe.controller;
import Beans.EntityManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateusz Purga³
 */
public class NewClass {
    public static void main(String [] args) throws SQLException
    {
        EntityManager em = new EntityManager();
        Connection con = em.getConnection();

        
        // Tworzymy obiekt wyra¿enia
            Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
            // Wysy³amy zapytanie do bazy danych
            ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM Uzytkownik");
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
            // Przegl¹damy otrzymane wyniki
            System.out.printf("|%-3s|%-12s|%-10s|%-5s|\n", "ID", "Nazwisko", "Imiê", "Ocena");
            System.out.println("-----------------------------------");
            while (rs.next()) {
                System.out.printf("|%-3s", rs.getInt("id"));
                System.out.printf("|%-12s", rs.getString("nazwisko"));
                System.out.printf("|%-10s", rs.getString("imie"));
                System.out.printf("| %-4s|\n", rs.getFloat("ocena"));
            }
            System.out.println("-----------------------------------");
            rs.close();
            
    }
    
}
