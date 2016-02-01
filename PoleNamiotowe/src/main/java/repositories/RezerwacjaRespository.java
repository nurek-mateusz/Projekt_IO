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
        String zapytanie = "INSERT INTO uzytkownik (dataRozpoczecia,dataZakonczenia,dataZgloszeniaRezerwacji,uzytkownikID,kawalekPolaID) VALUES";
        String zapytanie2 = "(" + dataRozpoczecia + "," + dataZakonczenia + ",CURDATE()," + uzytkownikID + "," + kawalekPolaID + ")";
        statement.executeUpdate((zapytanie + zapytanie2));

    }

    public boolean mozliwaRejestracja(String dataRozpoczecia, String dataZakonczenia, int kawalekPolaID) throws ParseException, SQLException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date dataR = format.parse(dataRozpoczecia);
        Date dataZ = format.parse(dataZakonczenia);

        Connection con;

        con = newEntityManager.getConnection();
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT from rezerwacja WHERE rezerwacjaID=" + kawalekPolaID);
        boolean czyRezerwowac = true;
        while (rs.next()) {
            Date bdDataR = format.parse(rs.getNString("dataZaczecia"));
            Date bdDataZ = format.parse(rs.getNString("dataZakonczenia"));

            if (dataR.compareTo(bdDataZ) >= 1) {

            } else if (dataZ.compareTo(bdDataZ) >= 1) {

            } else {
                czyRezerwowac = false;
                break;
            }

        }
        return czyRezerwowac;
    }

}
