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
public class Accessoires {
    
    public int id;
    public String nom;
    public Float prix;
    public String espece;
    private String image;
    public int id_magasin;
    
     public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }

    @Override
    public String toString() {
        return "Accessoires{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", espece=" + espece + ", image=" + image + ", id_magasin=" + id_magasin + '}';
    }

    
    public Accessoires(int id, String nom, Float prix, String espece, String image, int id_magasin) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.espece = espece;
        this.image = image;
        this.id_magasin = id_magasin;
    }

    

    public Accessoires() {
    }

    public Accessoires(String nom, Float prix, String espece, String image, int id_magasin) {
        this.nom = nom;
        this.prix = prix;
        this.espece = espece;
        this.image = image;
        this.id_magasin = id_magasin;
    }

   
    public Accessoires(String nom, Float prix, String espece, int id_magasin) {
        this.nom = nom;
        this.prix = prix;
        this.espece = espece;
        this.id_magasin = id_magasin;
    }

    public Accessoires(int id, String nom, Float prix, String espece) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.espece = espece;
        
    }

    
    
    public Accessoires(int id, String nom, Float prix, String espece, int id_magasin) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.espece = espece;
        this.id_magasin = id_magasin;
    }


    public Accessoires(int id, String nom, Float prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        
    }
    
    public Accessoires(String nom, Float prix) {
        this.nom = nom;
        this.prix = prix;
    }
    

    

    
    
    
    

    
}
