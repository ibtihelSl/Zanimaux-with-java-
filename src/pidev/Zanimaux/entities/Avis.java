/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.entities;

/**
 *
 * @author Touha
 */
public class Avis {
    public int id;
    public int rating;
    public String commentaire;
    public int id_magasin;
    public int user_id;
    public String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
     public int getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }

    @Override
    public String toString() {
        return "Avis{" + "id=" + id + ", rating=" + rating + ", commentaire=" + commentaire + ", id_magasin=" + id_magasin + ", user_id=" + user_id + ", user_name=" + user_name + '}';
    }

   

  


   

    public Avis() {
    }

    public Avis(int rating, String commentaire, int id_magasin, int user_id, String user_name) {
        this.rating = rating;
        this.commentaire = commentaire;
        this.id_magasin = id_magasin;
        this.user_id = user_id;
        this.user_name = user_name;
    }

   

    

    public Avis(int id, int rating, String commentaire) {
        this.id = id;
        this.rating = rating;
        this.commentaire = commentaire;
        
    }

    public Avis(int id, int rating, String commentaire, int id_magasin, int user_id, String user_name) {
        this.id = id;
        this.rating = rating;
        this.commentaire = commentaire;
        this.id_magasin = id_magasin;
        this.user_id = user_id;
        this.user_name = user_name;
    }

    
  
    
    
    
    
    
}
