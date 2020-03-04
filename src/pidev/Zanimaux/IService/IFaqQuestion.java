/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;

import pidev.Zanimaux.entities.FaqQuestions;
import java.util.List;

/**
 *
 * @author ci
 */
public interface IFaqQuestion {
    
   public void ajouterFaqQuestion(FaqQuestions fa);
   public void ModifierFaqQuestion(FaqQuestions fa);
   public void SupprimerFaqQuestion(int id);
    public List<FaqQuestions> ListerFaqQuestion();
     public FaqQuestions findByID(int id);



    
}
