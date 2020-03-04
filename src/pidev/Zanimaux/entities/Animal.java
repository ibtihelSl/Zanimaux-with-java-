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
public class Animal {
     private int id;
    private String especeA;
    private String raceA;
    private String sexe;
    private String description;
    private int age;
    private String img;
    private int nbReservation;

    public Animal() {
    }

    public Animal(String especeA, String raceA, String sexe, String description, int age, String img) {
        this.especeA = especeA;
        this.raceA = raceA;
        this.sexe = sexe;
        this.description = description;
        this.age = age;
        this.img = img;
    }
    
    

    public Animal(String especeA, String raceA, String sexe, String description, int age, String img, int nb) {

this.especeA=especeA;
this.raceA=raceA;
this.age=age;
this.sexe=sexe;
this.description=description;
this.img=img;
this.nbReservation=nb;

    }

    public Animal(int id, String especeA, String raceA, String sexe, String description, int age, String img, int nbReservation) {
        this.id = id;
        this.especeA = especeA;
        this.raceA = raceA;
        this.sexe = sexe;
        this.description = description;
        this.age = age;
        this.img = img;
        this.nbReservation = nbReservation;
    }

   
    public Animal(String especeA, String race, String sexe, String description, int age, int nb) {

        this.especeA=especeA;
        this.raceA=race;
        this.sexe=sexe;
        this.description=description;
        this.age=age;
        this.nbReservation=nb;
    }

     public Animal(String especeA, String race, String sexe, String description, int age) {

        this.especeA=especeA;
        this.raceA=race;
        this.sexe=sexe;
        this.description=description;
        this.age=age;
    }
    public Animal(int id, String especeA, String race, String sexe, String description, int age) {

        this.id= id;
        this.especeA= especeA;
        this.raceA=race;
        this.sexe=sexe;
        this.description=description;
        this.age=age;
                
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspaceA() {
        return especeA;
    }

    public void setEspaceA(String espaceA) {
        this.especeA = espaceA;
    }

    public String getRaceA() {
        return raceA;
    }

    public void setRaceA(String raceA) {
        this.raceA = raceA;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNbReservation() {
        return nbReservation;
    }

    public void setNbReservation(int nbReservation) {
        this.nbReservation = nbReservation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", espaceA=" + especeA + ", raceA=" + raceA + ", sexe=" + sexe + ", description=" + description + ", age=" + age + ", img=" + img + ", nbReservation=" + nbReservation + '}';
    }
    
    
    
}
