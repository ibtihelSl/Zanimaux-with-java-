/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.Services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pidev.Zanimaux.entities.Event;
import pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author abdelaziz
 */
public class Event_services {
    
     private Connection connection;
      
   
   public Event_services ()
    {
        connection = Myconnexion.getInstance().getConnection();}
    
   
   
    public void insertE(Event c) throws SQLException{
                                             
        String requete = "insert into event (titre,adresse,date_debut,date_fin,type,nombre_place,details,nombre_reserve,archive) values (?,?,?,?,?,?,?,?,?)";
        try {
        PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, c.getTitre());
            ps.setString(2, c.getAdresse());
            ps.setDate(3, c.getDate_debut());
            ps.setDate(4, c.getDate_fin());
            ps.setString(5, c.getType());
            ps.setInt(6, c.getNombre_place());
            ps.setString(7, c.getDetails());
            ps.setInt(8, 0);
            ps.setInt(9, 0);

            ps.executeUpdate();
             System.out.println("Event ajouté");
                
        } catch (SQLException ex) {
            Logger.getLogger(Event_services.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
      public void  deleteE(Event r) throws SQLException
            {
                        PreparedStatement pst;      
            String req="DELETE FROM event WHERE  id=?" ;
            pst=connection.prepareStatement(req);
               pst.setInt(1,r.getId());
        try {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Event_services.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
      
       public void updateR(Event R) throws SQLException {
         
            PreparedStatement pst;      
        String req="update event set 	titre=?,adresse=?,date_debut=?,date_fin=?,type=?,nombre_place=?,details=?,nombre_reserve=?,archive=? where id=?";
        pst=connection.prepareStatement(req);
        pst.setString(1,R.getTitre());
        pst.setString(2,R.getAdresse());
        pst.setDate(3,R.getDate_debut());
         pst.setDate(4,R.getDate_fin());
         pst.setString(5,R.getType());
         pst.setInt(6,R.getNombre_place());
         pst.setString(7,R.getDetails());
         pst.setInt(8,R.getNombre_reserve());
         pst.setInt(9,R.getArchive());
         
        
        pst.setInt(10,R.getId());
       try {
             pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Event_services.class.getName()).log(Level.SEVERE, null, ex);
        } }
       
       
       
       public ObservableList<Event> getAll() {
         ObservableList<Event> list=FXCollections.observableArrayList();       
      String requete = "select * from event";
          
        try {
            Statement ste=connection.createStatement();
          ResultSet rs=ste.executeQuery(requete);
            while (rs.next()) { 
           Event p=new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8),rs.getInt(9),rs.getInt(10));
                 list.add(p);
            }
        }  catch (SQLException ex) {
             System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        } 
        return  list;
          }
       
        public Event findByID(int id) throws SQLException{
       Event p=null;
        String requete = "select * from event where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //id,nom,login,email,password
                 p=new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8),rs.getInt(9),rs.getInt(10));

                return p; 
            }}  catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return p;    }
        
        public List<Event> displayAll(String titre) throws SQLException {
         
        List<Event> v = new ArrayList<>();
        //Statement ste = con.createStatement();
         Statement ste=connection.createStatement();
        String req = "Select * from Event where titre=" + titre;

        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            Event p = new Event(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getString(7));
            v.add(p);
        }
        return v;
    }
    
    
}

