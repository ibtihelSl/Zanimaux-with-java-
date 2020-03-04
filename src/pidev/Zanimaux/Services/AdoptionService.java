/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.Services;

import pidev.Zanimaux.entities.Adoption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author souad
 */
public class AdoptionService {
    Connection cn= Myconnexion.getInstance().getConnection();

    
       
    
   
   
    public void insertParti(Adoption c) throws SQLException{
                                             
       PreparedStatement ps;
        String req ="insert into adoption (espece,race) values (?,?)";
        
        ps = cn.prepareStatement(req);
            ps.setString(1, c.getEspece());
            ps.setString(2, c.getRace());
            //ps.setString(3, c.getAdoption());
       
            ps.executeUpdate();
             System.out.println("Adoption ajoutée");
                
       
      }
    
    
    
    
      public ObservableList<Adoption> getAllAdoptions() {
         ObservableList<Adoption> list=FXCollections.observableArrayList();       
      String requete = "select * from adoption";
          
        try {
            Statement ste=cn.createStatement();
          ResultSet rs=ste.executeQuery(requete);
            while (rs.next()) { 
          // Adoption_1 p=new Adoption_1(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
          Adoption p= new Adoption(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
          list.add(p);
            }
        }  catch (SQLException ex) {
             System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        } 
        return  list;
          }
       
        public Adoption findByIDAdoption_1(int id) throws SQLException{
       Adoption p=null;
        String requete = "select * from adoption where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //id,nom,login,email,password
                 p=new Adoption(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

                return p; 
            }}  catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return p;    }
    
    
      
    
}
