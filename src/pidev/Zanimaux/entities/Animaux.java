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
public class Animaux {
     public int id;
    public String nom;
    public String espece;
    public int id_user;

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

   

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Animaux{" + "id=" + id + ", nom=" + nom + ", espece=" + espece + ", id_user=" + id_user + '}';
    }

    public Animaux() {
    }

    public Animaux(int id, String nom, String espece, int id_user) {
        this.id = id;
        this.nom = nom;
        this.espece = espece;
        this.id_user = id_user;
    }

    public Animaux(String nom, String espece, int id_user) {
        this.nom = nom;
        this.espece = espece;
        this.id_user = id_user;
    }
    
    
    
}
