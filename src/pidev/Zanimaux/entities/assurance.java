/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev.Zanimaux.entities;

/**
 *
 * @author ci
 */
public class assurance {
    
      public int id;
        public String nom;
    public String adresse;
     public String mail;
        public String description;
    public String age_de_ce_animal;
        public String type_de_ce_animal;
    public Double totalprix;
    public Double prixparanimaux;

    
    
    
    public assurance(int id, String nom, String adresse, String mail, String description, String age_de_ce_animal, String type_de_ce_animal, Double totalprix, Double prixparanimaux) {
 this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.description = description;
        this.age_de_ce_animal = age_de_ce_animal;
        this.type_de_ce_animal = type_de_ce_animal;
        this.totalprix = totalprix;
        this.prixparanimaux = prixparanimaux;
    }
     public assurance(int id, String nom, String adresse, String mail, String description, String age_de_ce_animal, String type_de_ce_animal, Double prixparanimaux) {
 this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.description = description;
        this.age_de_ce_animal = age_de_ce_animal;
        this.type_de_ce_animal = type_de_ce_animal;
        this.prixparanimaux = prixparanimaux;
    }
        
    public assurance(String nom, String adresse, String mail, String description, String age_de_ce_animal, String type_de_ce_animal, Double prixparanimaux) {
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.description = description;
        this.age_de_ce_animal = age_de_ce_animal;
        this.type_de_ce_animal = type_de_ce_animal;
        this.prixparanimaux = prixparanimaux;
    }

    public assurance(String nom, String adresse, String mail, String description, String age_de_ce_animal) {
        
         this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.description = description;
        this.age_de_ce_animal = age_de_ce_animal;
    }

    public assurance(int id, String nom, String adresse, String mail, String description, String age_de_ce_animal) {
        this.id=id;
         this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.description = description;
        this.age_de_ce_animal = age_de_ce_animal;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge_de_ce_animal() {
        return age_de_ce_animal;
    }

    public void setAge_de_ce_animal(String age_de_ce_animal) {
        this.age_de_ce_animal = age_de_ce_animal;
    }

    public String getType_de_ce_animal() {
        return type_de_ce_animal;
    }

    public void setType_de_ce_animal(String type_de_ce_animal) {
        this.type_de_ce_animal = type_de_ce_animal;
    }

    public double getTotalprix() {
        return totalprix;
    }

    public void setTotalprix(double totalprix) {
        this.totalprix = totalprix;
    }

    public Double getPrixparanimaux() {
        return prixparanimaux;
    }

    public void setPrixparanimaux(Double prixparanimaux) {
        this.prixparanimaux = prixparanimaux;
    }

    @Override
    public String toString() {
        return "assurance{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", mail=" + mail + ", description=" + description + ", age_de_ce_animal=" + age_de_ce_animal + ", type_de_ce_animal=" + type_de_ce_animal + ", totalprix=" + totalprix + ", prixparanimaux=" + prixparanimaux + '}';
    }

    public assurance() {
    }

    
    public assurance(String nom, String adresse, String mail, String description, String age_de_ce_animal, String type_de_ce_animal, Double totalprix, Double prixparanimaux) {
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.description = description;
        this.age_de_ce_animal = age_de_ce_animal;
        this.type_de_ce_animal = type_de_ce_animal;
        this.totalprix = totalprix;
        this.prixparanimaux = prixparanimaux;
    }

        
}
