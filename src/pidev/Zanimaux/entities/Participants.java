/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.entities;

import java.sql.Date;

/**
 *
 * @author abdelaziz
 */
public class Participants {

    private int id;
    private String titre;
    private Date dateDebut;
    private String participant;
    private String adresse;

    public Participants(int id, String titre, Date dateDebut, String participant, String adresse) {
        this.id = id;
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.participant = participant;
        this.adresse = adresse;
    }
    public Participants( String titre, Date dateDebut, String participant, String adresse) {
       
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.participant = participant;
        this.adresse = adresse;
    }
     public Participants() {
    
    }
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    

}
