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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pidev.Zanimaux.entities.Participants;
import pidev.Zanimaux.utils.Myconnexion;


/**
 *
 * @author abdelaziz
 */
public class Participants_servics {
    private Connection connection;
      
   
   public Participants_servics ()
    {
        connection = Myconnexion.getInstance().getConnection();}
    
   
   
    public void insertParti(Participants c) throws SQLException{
                                             
        String requete = "insert into participants (titre,dateDebut,participant,adresse) values (?,?,?,?)";
        try {
        PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, c.getTitre());
            ps.setDate(2, c.getDateDebut());
            ps.setString(3, c.getParticipant());
            ps.setString(4, c.getAdresse());
       
            ps.executeUpdate();
             System.out.println("Participant ajouté");
                
        } catch (SQLException ex) {
            Logger.getLogger(Event_services.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    
    
    
      public ObservableList<Participants> getAllParticicpant() {
         ObservableList<Participants> list=FXCollections.observableArrayList();       
      String requete = "select * from participants";
          
        try {
            Statement ste=connection.createStatement();
          ResultSet rs=ste.executeQuery(requete);
            while (rs.next()) { 
           Participants p=new Participants(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
                 list.add(p);
            }
        }  catch (SQLException ex) {
             System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        } 
        return  list;
          }
       
        public Participants findByIDParticipant(int id) throws SQLException{
       Participants p=null;
        String requete = "select * from participants where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //id,nom,login,email,password
                 p=new Participants(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));

                return p; 
            }}  catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return p;    }
    
    
}
