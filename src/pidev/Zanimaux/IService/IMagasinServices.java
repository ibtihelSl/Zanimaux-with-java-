/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;

import javafx.collections.ObservableList;
import pidev.Zanimaux.entities.Magasin;

/**
 *
 * @author Touha
 */
public interface IMagasinServices {
    public void ajouterMagasin(Magasin m);
    public void ModifierMagasin(Magasin m);
    public void SupprimerMagasin(int id);
    public ObservableList<Magasin> ListerMagasin();
    public Magasin findByID(int id);
    
}
