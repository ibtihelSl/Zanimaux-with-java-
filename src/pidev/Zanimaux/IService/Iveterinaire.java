/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;

import pidev.Zanimaux.entities.veterinaires;
import java.util.List;

/**
 *
 * @author ci
 */
public interface Iveterinaire {
        public void ajouterVeterinaire(veterinaires v);
            public List<veterinaires> ListerVeterinaires();

       public void modifierVeterinaire(veterinaires v);
         public void deleteVeterinaire(int id);
             public veterinaires findByID(int id);


       

    
}
