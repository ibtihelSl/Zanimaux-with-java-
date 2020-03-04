/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.entities;

import java.sql.Timestamp;

/**
 *
 * @author ci
 */
public class Article {
    public int id;
    public String Titre;
    public String Description;
    public Timestamp Date;
    public int veterinaire_id;
    public String details;
    public String nom_image;


        
        public Article(String Titre, String details) {
    this.Titre = Titre;
     
        this.details = details;
     
    }


    public Article(String Titre, String Description, int veterinaire_id, String details, String nom_image) {
    this.Titre = Titre;
        this.Description = Description;
       
        this.veterinaire_id = veterinaire_id;
        this.details = details;
        this.nom_image = nom_image;  
    }

    public Article(String Titre, String Description, String details, String nom_image) {
         this.Titre = Titre;
        this.Description = Description;
       
        this.details = details;
        this.nom_image = nom_image;
    }

    public Article(String Titre, String details, int veterinaire_id) {
         this.Titre = Titre;
               this.details = details;
                this.veterinaire_id = veterinaire_id;

    }

    public Article(int id1, String text, String text0) {
    this.id=id1;
     this.Titre = text;
               this.details = text0;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Timestamp getDate() {
        return Date;
    }

    public void setDate(Timestamp Date) {
        this.Date = Date;
    }

   

    public int getVeterinaire_id() {
        return veterinaire_id;
    }

    public void setVeterinaire_id(int veterinaire_id) {
        this.veterinaire_id = veterinaire_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

   

    public Article() {
    }

    public Article(int id, String Titre, String Description, Timestamp Date, int veterinaire_id, String details, String nom_image) {
        this.id = id;
        this.Titre = Titre;
        this.Description = Description;
        this.Date = Date;
        this.veterinaire_id = veterinaire_id;
        this.details = details;
        this.nom_image = nom_image;
    }
    
    public Article(int id, String Titre, String Description, Timestamp Date, int veterinaire_id, String details) {
        this.id = id;
        this.Titre = Titre;
        this.Description = Description;
        this.Date = Date;
        this.veterinaire_id = veterinaire_id;
        this.details = details;
    }
    
        public Article(int id, String Titre, String Description, int veterinaire_id, String details, String nom_image) {
        this.id = id;
        this.Titre = Titre;
        this.Description = Description;
      
        this.veterinaire_id = veterinaire_id;
        this.details = details;
        this.nom_image = nom_image;
    }
          
            
     public Article(String Titre, String Description, Timestamp Date, int veterinaire_id, String details, String nom_image) {
        this.Titre = Titre;
        this.Description = Description;
        this.Date = Date;
        this.veterinaire_id = veterinaire_id;
        this.details = details;
        this.nom_image = nom_image;
    }
    
      public Article(String Titre, String Description, Timestamp  Date, int veterinaire_id, String details) {
      
        this.Titre = Titre;
        this.Description = Description;
        this.Date = Date;
        this.veterinaire_id = veterinaire_id;
        this.details = details;
     
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", Titre=" + Titre + ", Description=" + Description + ", Date=" + Date + ", veterinaire_id=" + veterinaire_id + ", details=" + details + ", nom_image=" + nom_image + '}';
    }
  
}
