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

    private int pozycjaX;
    private int pozycjaY;
    private int wielkoscX;
    private int wielkoscY;

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
    private int koszt;

    public KawalekPola(int _pozycjaX, int _pozycjaY, int _wielkoscX, int _wielkoscY, int _koszt) {
        
        this.pozycjaX = _pozycjaX;
        this.pozycjaY = _pozycjaY;
        this.wielkoscX = _wielkoscX;
        this.wielkoscY = _wielkoscY;
        this.koszt = _koszt;
        
    }
}
