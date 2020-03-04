/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  pidev.Zanimaux.Services;

import pidev.Zanimaux.entities.Association;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import  pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author abdelaziz
 */
public class Association_services {
    
    
    
     private Connection connection;
   
   public Association_services ()
    {
          

        connection = Myconnexion.getInstance().getConnection();
    }
    public void insertA(Association c) throws SQLException{
                                             
        String requete = "insert into association (name,adress,	phone,email,description) values (?,?,?,?,?)";
        try {
        PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, c.getName());
            ps.setString(2, c.getAdress());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getDescription());
           ;

            ps.executeUpdate();
                
        } catch (SQLException ex) {
            Logger.getLogger(Association_services.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    public void  deleteA(Association r) throws SQLException
            {
                        PreparedStatement pst;      
            String req="DELETE FROM association WHERE  id=?" ;
            pst=connection.prepareStatement(req);
               pst.setInt(1,r.getId());
        try {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Association_services.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    public void updateA(Association R) throws SQLException {
         
            PreparedStatement pst;      
        String req="update association set adress=?,phone=? where id=?";
        pst=connection.prepareStatement(req);
        pst.setString(1,R.getAdress());
           pst.setString(2,R.getPhone());
        pst.setInt(3,R.getId());
       try {
             pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Association_services.class.getName()).log(Level.SEVERE, null, ex);
        } }
    
     public ObservableList<Association> getAll() {
         ObservableList<Association> list=FXCollections.observableArrayList();       
      String requete = "select * from association";
          
        try {
            Statement ste=connection.createStatement();
          ResultSet rs=ste.executeQuery(requete);
            while (rs.next()) { 
           Association p=new Association(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                 list.add(p);
            }
        }  catch (SQLException ex) {
             System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        } 
        return  list;
          }
     
      public Association findByID(int id) throws SQLException{
       Association p=null;
        String requete = "select * from association where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //id,nom,login,email,password
                 p=new Association(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

                return p; 
            }}  catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return p;    }
    
    
    
    
    
    
    
    
    
}
