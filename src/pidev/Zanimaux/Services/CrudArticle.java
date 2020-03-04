/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.Services;

import pidev.Zanimaux.IService.IArticle;
import pidev.Zanimaux.entities.Article;
import pidev.Zanimaux.utils.Myconnexion;
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

/**
 *
 * @author ci
 */
public class CrudArticle implements IArticle{
    
     Connection cn=Myconnexion.getInstance().getConnection();
     
      public void ajouterArticle(Article a){
        try {
            String requete= "insert into article(Titre,Description,Date,details) values(?,?,?,?)";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, a.getTitre());
            st.setString(2, a.getDescription());
            st.setTimestamp(3, a.getDate());

            st.setString(4, a.getDetails());
        
           
            st.executeUpdate();
            System.out.println("Article ajouter");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
     }
      public void ModifierArticle(Article a){
        try {
            String requete= "update article set Titre=?,details=? where id=?;";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, a.getTitre());
         
            st.setString(2, a.getDetails());
          
            st.setInt(3, a.getId());
            st.executeUpdate();
            System.out.println("Article Modifier");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());      
        }}
     
      public void SupprimerArticle(int id){
        try {
            String requete= "delete from article where id=?;";
             PreparedStatement st=cn.prepareStatement(requete);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Article Supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());     
        }}
    
    public ObservableList<Article> ListerArticle(){
                        ObservableList<Article>mylist = FXCollections.observableArrayList();

            try {
                String requete2="SELECT *FROM article";
                Statement st2=cn.createStatement();
                ResultSet rs= st2.executeQuery(requete2);
                while(rs.next()){
                Article a= new Article();
                a.setId(rs.getInt(1));
                a.setTitre(rs.getString(2));
                a.setDescription(rs.getString(3));
                a.setVeterinaire_id(rs.getInt(5));
                a.setDetails(rs.getString(6));
                a.setNom_image(rs.getString(7));
                mylist.add(a);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CrudArticle.class.getName()).log(Level.SEVERE, null, ex);
            }
            return mylist;
    
    }
    
     public Article findByID(int id) {
       Article a=null;
        String requete = "select * from article where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                 a=new Article(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getTimestamp(4),rs.getInt(5),rs.getString(6),rs.getString(7));

                return a; 
            }}  catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return a;    }
    
    
}
