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
import pidev.Zanimaux.IService.IMagasinServices;
import pidev.Zanimaux.entities.Magasin;
import pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author Touha
 */
public class MagasinServices implements IMagasinServices{
        Connection cn= Myconnexion.getInstance().getConnection();
    public void ajouterMagasin(Magasin m){
        try {
            String requete= "insert into magasin(nom,address,ville,phone) values(?,?,?,?)";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, m.getNom());
            st.setString(2, m.getAddress());
            st.setString(3, m.getVille());
            st.setString(4, m.getPhone());
            st.executeUpdate();
            System.out.println("Magasin ajouter");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }}
    
     public void ModifierMagasin(Magasin m){
        try {
            String requete= "update magasin set nom=?,address=?,ville=?,phone=? where id=? ;";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, m.getNom());
            st.setString(2, m.getAddress());
            st.setString(3, m.getVille());
            st.setString(4, m.getPhone());
            st.setInt(5, m.getId());
            st.executeUpdate();
            System.out.println("Magasin Modifier");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }}
     
      public void SupprimerMagasin(int id){
        try {
            String requete= "delete from magasin where id=?;";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Magasin Supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }}
    
    
    
     public ObservableList<Magasin> ListerMagasin(){
                                    ObservableList<Magasin> mylist = FXCollections.observableArrayList();


            try {
                String requete2="SELECT *FROM magasin";
                Statement st2=cn.createStatement();
                ResultSet rs= st2.executeQuery(requete2);
                while(rs.next()){
                Magasin m= new Magasin();
                m.setId(rs.getInt(1));
                m.setNom(rs.getString(2));
                m.setAddress(rs.getString(3));
                m.setVille(rs.getString(4));
                m.setPhone(rs.getString(5));
                mylist.add(m);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MagasinServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return mylist;
    
    }
      public Magasin findByID(int id) {
       Magasin m=null;
        String requete = "select * from magasin where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //id,nom,login,email,password
                 m=new Magasin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

                return m; 
            }}  catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return m;    }
    
}
