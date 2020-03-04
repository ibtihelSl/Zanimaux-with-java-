/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;

import pidev.Zanimaux.entities.assurance;
import java.util.List;

/**
 *
 * @author ci
 */
public interface IAssurance {
             public void ajouterAssurance(assurance a);
              public List<assurance> ListerAssurance();
              public void modifierAssurance(assurance a);
              public void deleteAssurance(int id);
              public assurance findByID(int id);





    
}
