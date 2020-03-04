/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;

import java.util.List;
import pidev.Zanimaux.entities.Accessoires;

/**
 *
 * @author Touha
 */
public interface IAccessoiresServices {
    public void ajouterAccessoires(Accessoires a);
    public void ModifierAccessoires(Accessoires a);
    public void SupprimerAccessoires(int id);
    public List<Accessoires> ListerAccessoires(int idmag);
    public List<Accessoires> ListerAccessoiresEspece(String espece);
    public Accessoires findByID(int id);
}
