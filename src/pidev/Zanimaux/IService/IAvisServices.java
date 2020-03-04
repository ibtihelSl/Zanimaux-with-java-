/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;

import java.util.List;
import pidev.Zanimaux.entities.Avis;

/**
 *
 * @author Touha
 */
public interface IAvisServices {
    public void ajouterAvis(Avis a);
    public void SupprimerAvis(int id);
    public List<Avis> ListerAvis(int idmag);
}
