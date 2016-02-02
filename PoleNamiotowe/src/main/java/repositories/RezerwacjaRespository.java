/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import Beans.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Micha³
 */
public class RezerwacjaRespository {

    EntityManager newEntityManager;

    public RezerwacjaRespository() {
        newEntityManager = new EntityManager();
    }

    public void dodajRezerwacje(String dataRozpoczecia, String dataZakonczenia, int uzytkownikID, int kawalekPolaID) throws ParseException, SQLException {

        Connection con;

        con = newEntityManager.getConnection();
        Statement statement = con.createStatement();
        String zapytanie = "INSERT INTO rezerwacja (dataZaczecia,dataZakonczenia,dataZgloszeniaRezerwacji,uzytkownikID,kawalekPolaID) VALUES";
        String zapytanie2 = "('" + dataRozpoczecia + "','" + dataZakonczenia + "',CURDATE()," + uzytkownikID + "," + kawalekPolaID + ")";
        statement.executeUpdate((zapytanie + zapytanie2));

    }

    public boolean mozliwaRejestracja(String dataRozpoczecia, String dataZakonczenia, int kawalekPolaID) throws ParseException, SQLException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date dataR = format.parse(dataRozpoczecia);
        Date dataZ = format.parse(dataZakonczenia);

        Connection con;

        con = newEntityManager.getConnection();
        Statement statement = con.createStatement();
        if (dataR.compareTo(dataZ) > 0) {
            return false;
        }
        ResultSet rs = statement.executeQuery("SELECT * from rezerwacja WHERE kawalekPolaID=" + kawalekPolaID);
        boolean czyRezerwowac = true;
        while (rs.next()) {
            Date bdDataR = format.parse(rs.getString("dataZaczecia"));
            Date bdDataZ = format.parse(rs.getString("dataZakonczenia"));

            if (dataR.compareTo(bdDataZ) < 1) {
                if (dataZ.compareTo(bdDataR) >= 0) {
                    czyRezerwowac = false;
                    break;
                }
            }
        }
        return czyRezerwowac;
    }
}
