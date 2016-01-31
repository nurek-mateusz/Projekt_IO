/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import Domain.Uzytkownik;

/**
 *
 * @author Mateusz Purga³
 */
public class UzytkownikRepository {
    
    Boolean czyUzytkownikIstnieje(String login, String haslo)
    {
        return false;
        
    }
    Boolean DodajUzytkownika(String login, String haslo)
    {
        return true;
    }
    
    Uzytkownik getByID(int ID)
    {
        
        return null;
    }
}
