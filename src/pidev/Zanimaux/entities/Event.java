/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.entities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import java.util.Objects;
/**
 *
 * @author abdelaziz
 */
public class Event {

    private int id;
    private String titre;
    private String adresse;
    private Date date_debut;
    private Date date_fin;
    private String type;
    private int nombre_place;
    private String details;
    private int nombre_reserve;
    private int archive;

    public Event(int id, String titre, String adresse, Date date_debut, Date date_fin, String type, int nombre_place, String details, int nombre_reserve, int archive) {
        this.id = id;
        this.titre = titre;
        this.adresse = adresse;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type = type;
        this.nombre_place = nombre_place;
        this.details = details;
        this.nombre_reserve = nombre_reserve;
        this.archive = archive;
    }

    public Event(String titre, String adresse, Date date_debut, Date date_fin, String type, int nombre_place, String details) {
        this.titre = titre;
        this.adresse = adresse;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type = type;
        this.nombre_place = nombre_place;
        this.details = details;
        nombre_reserve = 0;
        archive = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event() {
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
       
     this.date_debut= date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNombre_place() {
        return nombre_place;
    }

    public void setNombre_place(int nombre_place) {
        this.nombre_place = nombre_place;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getNombre_reserve() {
        return nombre_reserve;
    }

    public void setNombre_reserve(int nombre_reserve) {
        this.nombre_reserve = nombre_reserve;
    }

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }
    public SimpleStringProperty getTitreO() {
        return new SimpleStringProperty(titre);

    }
    public SimpleStringProperty getAdresseO() {
        return new SimpleStringProperty(adresse);

    }
    
    
    
    
    
    
    

}
