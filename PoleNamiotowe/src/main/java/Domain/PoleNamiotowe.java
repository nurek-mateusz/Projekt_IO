/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Mateusz Purga³
 */
public class PoleNamiotowe {

    protected String adres;
    protected String opis;
    protected String data;
    protected int id;
    protected int userId;

    public PoleNamiotowe(String adres, String opis, String data, int id, int userId) {
        this.adres = adres;
        this.opis = opis;
        this.data = data;
        this.id = id;
        this.userId = userId;
    }

    public String getAdres() {
        return this.adres;
    }

    public String getOpis() {
        return this.opis;
    }

    public String getData() {
        return this.data;
    }

    public int getId() {
        return this.id;
    }

    public int getUserId() {
        return this.userId;
    }
}
