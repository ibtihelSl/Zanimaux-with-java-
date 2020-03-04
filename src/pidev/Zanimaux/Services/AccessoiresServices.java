/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev.Zanimaux.Services;

import pidev.Zanimaux.IService.IAccessoiresServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.Zanimaux.entities.Accessoires;
import pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author Touha
 */
public class AccessoiresServices implements IAccessoiresServices{
    Connection cn= Myconnexion.getInstance().getConnection();
      public void ajouterAccessoires(Accessoires a){
        try {
            String requete= "insert into accessoires(nom,prix,espece,id_magasin,image_name) values(?,?,?,?,?)";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, a.getNom());
            st.setFloat(2, a.getPrix());
            st.setString(3, a.getEspece());
            st.setInt(4, a.getId_magasin());
            st.setString(5, a.getImage());
            
            st.executeUpdate();
            System.out.println("Accessoire ajouter");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
     }
      public void ModifierAccessoires(Accessoires a){
        try {
            String requete= "update accessoires set nom=?,prix=?,espece=? where id=?;";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, a.getNom());
            st.setFloat(2, a.getPrix());
            st.setString(3, a.getEspece());
           
            st.setInt(4, a.getId());
            st.executeUpdate();
            System.out.println("Accessoire Modifier");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }}
     
      public void SupprimerAccessoires(int id){
        try {
            String requete= "delete from accessoires where id=?;";
             PreparedStatement st=cn.prepareStatement(requete);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Accessoire Supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }}
    
    public List<Accessoires> ListerAccessoires(int idmag){
                        List<Accessoires>mylist = new ArrayList<Accessoires>();

            try {
                String requete2="SELECT * FROM accessoires where id_magasin=" + idmag + "";
                Statement st2=cn.createStatement();
                ResultSet rs= st2.executeQuery(requete2);
                while(rs.next()){
                Accessoires a= new Accessoires();
                a.setId(rs.getInt(1));
                a.setNom(rs.getString(2));
                a.setPrix(rs.getFloat(3));
                a.setImage(rs.getString(4));
                a.setEspece(rs.getString(8));
                a.setId_magasin(rs.getInt(6));
                 mylist.add(a);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccessoiresServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return mylist;
    
    }
    
     public List<Accessoires> ListerAccessoiresEspece(String espece){
                        List<Accessoires>mylist = new ArrayList<Accessoires>();

            try {
                String requete3="SELECT * FROM accessoires where espece='" + espece + "'";
                Statement st3=cn.createStatement();
                ResultSet rs2= st3.executeQuery(requete3);
                while(rs2.next()){
                Accessoires a= new Accessoires();
                a.setId(rs2.getInt(1));
                a.setNom(rs2.getString(2));
                a.setPrix(rs2.getFloat(3));
                a.setImage(rs2.getString(4));
                a.setEspece(rs2.getString(8));
                a.setId_magasin(rs2.getInt(6));
                 mylist.add(a);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccessoiresServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return mylist;
    
    }
    
     public Accessoires findByID(int id) {
       Accessoires a=null;
        String requete = "select * from accessoires where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //id,nom,login,email,password
                 a=new Accessoires(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5),rs.getInt(6));

                return a; 
            }}  catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return a;    }
    
}
