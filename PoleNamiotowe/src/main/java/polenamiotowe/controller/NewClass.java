/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polenamiotowe.controller;
import Beans.EntityManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mateusz Purga³
 */
public class NewClass {
    public static void main(String [] args) throws SQLException
    {
        EntityManager em = new EntityManager();
        Connection con = em.getConnection();
            
    }
    
}
