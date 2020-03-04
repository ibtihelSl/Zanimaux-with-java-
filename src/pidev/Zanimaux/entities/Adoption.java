/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.entities;

/**
 *
 * @author souad
 */
public class Adoption {
      private int id;
    private String espece;
    private String race;
    private String adoption;

    public Adoption() {
    }

    public Adoption(int id, String espece, String race, String adoption) {
        this.id = id;
        this.espece = espece;
        this.race = race;
        this.adoption = adoption;
    }

    public Adoption(String espece, String race, String adoption) {
        this.espece = espece;
        this.race = race;
        this.adoption = adoption;
    }
     public Adoption(String espece, String race) {
        this.espece = espece;
        this.race = race;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAdoption() {
        return adoption;
    }

    public void setAdoption(String adoption) {
        this.adoption = adoption;
    }

    @Override
    public String toString() {
        return "Adoption{" + "id=" + id + ", espece=" + espece + ", race=" + race + ", adoption=" + adoption + '}';
    }

    
    
}
