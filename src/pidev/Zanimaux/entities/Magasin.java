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
public class Magasin {
    public int id;
    public String nom;
    public String address;
    public String ville;
    public String phone;

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

    @Override
    public String toString() {
        return "Magasin{" + "id=" + id + ", nom=" + nom + ", address=" + address + ", ville=" + ville + ", phone=" + phone + '}';
    }

    public Magasin() {
    }

    public Magasin(String nom, String address, String ville, String phone) {
        this.nom = nom;
        this.address = address;
        this.ville = ville;
        this.phone = phone;
    }

    
    public Magasin(int id, String nom, String address, String ville, String phone) {
        this.id = id;
        this.nom = nom;
        this.address = address;
        this.ville = ville;
        this.phone = phone;
    }
    
    
    
    
    
    
}
