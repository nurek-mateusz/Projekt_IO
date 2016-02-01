/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import Domain.Uzytkownik;
import java.sql.Connection;
import java.sql.Statement;

import Beans.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateusz Purga³
 */
public class UzytkownikRepository {

    EntityManager newEntityManager;

    public UzytkownikRepository() {

        newEntityManager = new EntityManager();

    }

    public String WeryfikujLoginHaslo(String login, String password) throws SQLException {
        Connection con;

        con = newEntityManager.getConnection();
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM uzytkownik WHERE login = '" + login + "' AND haslo = '" + password + "'");
        if (rs.next()) {
            return rs.getString("uzytkownikID");
        }

        return null;
    }

    public boolean UzytkownikIstnieje(String login, String password) throws SQLException {

        Connection con;

        con = newEntityManager.getConnection();
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM uzytkownik");

        boolean isLogin = false;
        while (rs.next()) {

            String loginFromData = rs.getString("login");

            if (loginFromData.toUpperCase().equals(login.toUpperCase())) {
                isLogin = true;
                break;
            }
        }

        return isLogin;
    }

    public boolean RejestrujUzytkownika(String login, String password) throws SQLException {
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
            rs = statement.executeQuery("SELECT * FROM uzytkownik");
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
        String zapytanie;
        try {

            zapytanie = "INSERT INTO uzytkownik (haslo,login,rolaID) VALUES ('" + password + "','" + login + "',1)";
            statement.executeUpdate(zapytanie);
            //statement.executeUpdate("INSERT INTO Uzytkownik VALUES ('" + login + "','" + password + "'," + (count+1) + "," + 1 + ")");

        } catch (SQLException ex) {
            Logger.getLogger(UzytkownikRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public Uzytkownik getByID(int ID) {

        return null;
    }
}
