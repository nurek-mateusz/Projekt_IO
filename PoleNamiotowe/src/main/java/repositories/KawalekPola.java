/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

/**
 *
 * @author Micha³
 */
public class KawalekPola {

    protected int pozycjaX;
    protected int pozycjaY;
    protected int wielkoscX;
    protected int wielkoscY;
    protected int id;
    protected int koszt;
    
        public KawalekPola(int _pozycjaX, int _pozycjaY, int _wielkoscX, int _wielkoscY, int _koszt, int _id) {
        
        this.pozycjaX = _pozycjaX;
        this.pozycjaY = _pozycjaY;
        this.wielkoscX = _wielkoscX;
        this.wielkoscY = _wielkoscY;
        this.koszt = _koszt;
        this.id = _id;
        
    }
        
    public int getPozycjaX() {
        return pozycjaX;
    }

    public void setPozycjaX(int pozycjaX) {
        this.pozycjaX = pozycjaX;
    }

    public int getPozycjaY() {
        return pozycjaY;
    }

    public void setPozycjaY(int pozycjaY) {
        this.pozycjaY = pozycjaY;
    }

    public int getWielkoscX() {
        return wielkoscX;
    }

    public void setWielkoscX(int wielkoscX) {
        this.wielkoscX = wielkoscX;
    }

    public int getWielkoscY() {
        return wielkoscY;
    }

    public void setWielkoscY(int wielkoscY) {
        this.wielkoscY = wielkoscY;
    }

    public int getKoszt() {
        return koszt;
    }

    public void setKoszt(int koszt) {
        this.koszt = koszt;
    }
   
    public int getId() {
        return koszt;
    }
}
