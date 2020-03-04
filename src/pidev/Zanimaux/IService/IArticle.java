/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;

import pidev.Zanimaux.entities.Article;
import java.util.List;

/**
 *
 * @author ci
 */
public interface IArticle {
          public void ajouterArticle(Article a);
          public void ModifierArticle(Article a);
          public void SupprimerArticle(int id);
          public List<Article> ListerArticle();
          public Article findByID(int id);





    
}
