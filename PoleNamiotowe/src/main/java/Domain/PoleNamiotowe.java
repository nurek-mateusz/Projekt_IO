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
}
