/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import Beans.EntityManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Micha³
 */
public class PoleRespository {

    EntityManager newEntityManager;

    public PoleRespository() {

        newEntityManager = new EntityManager();
    }

    public boolean dodajPole(String adres) throws SQLException {

        Connection con;
        con = newEntityManager.getConnection();
        Statement statement = null;

        try {
            statement = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UzytkownikRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM polenamiotowe");
        } catch (SQLException ex) {
            Logger.getLogger(UzytkownikRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        int count = 0;
        try {
            while (rs.next()) {
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UzytkownikRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        statement = con.createStatement();
        try {

            statement.executeUpdate("INSERT INTO polenamiotowe (adres,dataZalozenia,poleNamiotoweID,uzytkownikID) VALUES ('" + adres + "',CURDATE()," + (count+1) + "," + 1 + ")");

        } catch (SQLException ex) {
            Logger.getLogger(UzytkownikRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;

    }

    public boolean istniejePole(String adres) throws SQLException {

        Connection con;

        con = newEntityManager.getConnection();
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM polenamiotowe");

        boolean isPole = false;
        while (rs.next()) {

            String loginFromData = rs.getString("adres");

            if (loginFromData.toUpperCase().equals(adres.toUpperCase())) {
                isPole = true;
                break;
            }
        }

        return isPole;
    }

}
