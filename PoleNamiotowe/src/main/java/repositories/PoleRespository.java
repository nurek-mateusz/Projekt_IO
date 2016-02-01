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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Domain.PoleNamiotowe;

/**
 *
 * @author Micha³
 */
public class PoleRespository {

    EntityManager newEntityManager;

    public PoleRespository() {

        newEntityManager = new EntityManager();
    }

    public boolean dodajPole(String adres, String Opis, int UzytkownikID) throws SQLException {

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

            statement.executeUpdate("INSERT INTO polenamiotowe (adres,opis,dataZalozenia,uzytkownikID) VALUES ('" + adres + "','" + Opis + "',CURDATE()," + UzytkownikID + ")");

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

    public boolean aktualizujPole(int IDPola, String dane)  {

        List<KawalekPola> listaKawalkow = new ArrayList<KawalekPola>();
        listaKawalkow = tworzPola(dane, IDPola);

        Connection con;

        con = newEntityManager.getConnection();
        try
        {
                    Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * from poleNamiotowe WHERE poleNamiotoweID=" + IDPola);
        if (rs.first()) {
            statement.executeUpdate("DELETE FROM kawalekpola WHERE poleNamiotoweID =" + IDPola);
            for (int i = 0; i < listaKawalkow.size(); i++) {
                statement.executeUpdate("INSERT INTO kawalekpola (poleNamiotoweID,pozycjaX,pozycjaY,wielkoscX,wielkoscY,cenaZaWynajem) VALUES "
                        + "(" + IDPola + "," + listaKawalkow.get(i).getPozycjaX() + "," + listaKawalkow.get(i).getPozycjaY() + "," + listaKawalkow.get(i).getWielkoscX()
                        + "," + listaKawalkow.get(i).getWielkoscY() + "," + listaKawalkow.get(i).getKoszt() + ")");
            }
            return true;
        } else {
            return false;
        }
        }catch(SQLException ex) {
            Logger.getLogger(PoleRespository.class.getName()).log(Level.SEVERE, null, ex);
        }


        return false;
    }

    public static List<KawalekPola> tworzPola(String dane, int IDPola) {

        dane =  dane.substring(0,0) + dane.substring(0 + 1);
        dane =  dane.substring(0,dane.length()-1) + dane.substring(dane.length());
        
        List<KawalekPola> listaPol = new ArrayList<KawalekPola>();

        if (dane.length() > 0) {
            int numberOfSeparator = 0;

            for (int i = 0; i < dane.length(); i++) {
                if (dane.charAt(i) == ',') {
                    numberOfSeparator++;
                }
            }

            if (numberOfSeparator == 0) {
                return listaPol;
            } else {
                for (int i = 0; i < numberOfSeparator; i = i + 5) {
                    int pozycjaX;
                    int pozycjaY;
                    int wielkoscX;
                    int wielkoscY;
                    int koszt;

                    /**
                     * ****************Pozycja X *****************************
                     */
                    int placeOfSeparator = dane.indexOf(',');
                    String s_pozycjaX = "";

                    for (int j = 0; j < placeOfSeparator; j++) {
                        s_pozycjaX = s_pozycjaX + dane.charAt(j);
                    }
                    pozycjaX = Integer.parseInt(s_pozycjaX);
                    String newDane = "";
                    for (int k = 0; k < dane.length(); k++) {
                        if (k > placeOfSeparator) {
                            newDane = newDane + dane.charAt(k);
                        }
                    }
                    dane = newDane;
                    /**
                     * *************Pozycja Y ********************************
                     */
                    placeOfSeparator = dane.indexOf(',');
                    String s_pozycjaY = "";

                    for (int j = 0; j < placeOfSeparator; j++) {
                        s_pozycjaY = s_pozycjaY + dane.charAt(j);
                    }
                    pozycjaY = Integer.parseInt(s_pozycjaY);
                    newDane = "";
                    for (int k = 0; k < dane.length(); k++) {
                        if (k > placeOfSeparator) {
                            newDane = newDane + dane.charAt(k);
                        }
                    }
                    dane = newDane;

                    /**
                     * *******************Wielkosc X************************
                     */
                    placeOfSeparator = dane.indexOf(',');
                    String s_wielkoscX = "";

                    for (int j = 0; j < placeOfSeparator; j++) {
                        s_wielkoscX = s_wielkoscX + dane.charAt(j);
                    }
                    wielkoscX = Integer.parseInt(s_wielkoscX);
                    newDane = "";
                    for (int k = 0; k < dane.length(); k++) {
                        if (k > placeOfSeparator) {
                            newDane = newDane + dane.charAt(k);
                        }
                    }
                    dane = newDane;
                    /**
                     * ****************Wielkosc Y **************************
                     */
                    placeOfSeparator = dane.indexOf(',');
                    String s_wielkoscY = "";

                    for (int j = 0; j < placeOfSeparator; j++) {
                        s_wielkoscY = s_wielkoscY + dane.charAt(j);
                    }
                    wielkoscY = Integer.parseInt(s_wielkoscY);
                    newDane = "";
                    for (int k = 0; k < dane.length(); k++) {
                        if (k > placeOfSeparator) {
                            newDane = newDane + dane.charAt(k);
                        }
                    }
                    dane = newDane;

                    /**
                     * ***************Kwota**********************
                     */
                    if (numberOfSeparator - i != 4) {
                        placeOfSeparator = dane.indexOf(',');
                        String s_koszt = "";

                        for (int j = 0; j < placeOfSeparator; j++) {
                            s_koszt = s_koszt + dane.charAt(j);
                        }
                        koszt = Integer.parseInt(s_koszt);
                        newDane = "";
                        for (int k = 0; k < dane.length(); k++) {
                            if (k > placeOfSeparator) {
                                newDane = newDane + dane.charAt(k);
                            }
                        }
                        dane = newDane;
                    } else {
                        koszt = Integer.parseInt(dane);
                    }

                    listaPol.add(new KawalekPola(pozycjaX, pozycjaY, wielkoscX, wielkoscY, koszt, IDPola));

                }
            }

        }

        return listaPol;
    }

    
    public ArrayList<PoleNamiotowe> getWszystkiePola()
    {
        ArrayList<PoleNamiotowe> wszystkiePola = new ArrayList<PoleNamiotowe>();
        try {
            Connection con;
            
            con = newEntityManager.getConnection();
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM polenamiotowe");
            while(rs.next()) {
                String adres = rs.getString("adres");
                String opis = rs.getString("opis");
                String data = rs.getString("dataZalozenia");
                int poleId = rs.getInt("poleNamiotoweID");
                int userId = rs.getInt("uzytkownikID");
                PoleNamiotowe pole = new PoleNamiotowe(adres,opis, data, poleId, userId);
                wszystkiePola.add(pole);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PoleRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return wszystkiePola;
    }
    
    public List<KawalekPola> pobierzKawalkiPola(int IDPola) throws SQLException {

        List<KawalekPola> listaKawalkow = new ArrayList<KawalekPola>();

        Connection con;

        con = newEntityManager.getConnection();
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * from kawalekpola WHERE poleNamiotoweID=" + IDPola);
        while(rs.next()){
        int pozycjaX = rs.getInt("pozycjaX");
        int pozycjaY = rs.getInt("poxycjaY");
        int wielkoscX = rs.getInt("wielkoscX");
        int wielkoscY = rs.getInt("wielkoscY");
        int koszt = rs.getInt("cenaZaWynajem");
        int id = rs.getInt("kawalekPolaID");
        
        listaKawalkow.add(new KawalekPola(pozycjaX,pozycjaY,wielkoscX,wielkoscY,koszt,id));
        
        }

        return listaKawalkow;

    }
}
