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
public class veterinaires {
    
     public int id;
        public String nom;
     public String address;
        public String ville;
    public String phone;
        public String email;
        public String nom_image;

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "veterinaires{" + "id=" + id + ", nom=" + nom + ", address=" + address + ", ville=" + ville + ", phone=" + phone + ", email=" + email + ", nom_image=" + nom_image + '}';
    }

   
    public veterinaires() {
    }

    public veterinaires(int id, String nom, String address, String ville, String phone, String email ,String nom_image) {
        this.id = id;
        this.nom = nom;
        this.address = address;
        this.ville = ville;
        this.phone = phone;
        this.email = email;
        this.nom_image=nom_image;
    }

    public veterinaires(String nom, String address, String ville, String phone, String email) {
        this.nom = nom;
        this.address = address;
        this.ville = ville;
        this.phone = phone;
        this.email = email;
    }
      public veterinaires(int id, String nom, String address, String ville, String phone, String email) {
        this.id = id;
        this.nom = nom;
        this.address = address;
        this.ville = ville;
        this.phone = phone;
        this.email = email;
    }
        
    
}
