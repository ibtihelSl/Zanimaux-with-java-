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
import pidev.Zanimaux.IService.IAvisServices;
import pidev.Zanimaux.entities.Avis;
import pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author Touha
 */
public class AvisServices implements IAvisServices{
     Connection cn= Myconnexion.getInstance().getConnection();
      public void ajouterAvis(Avis a){
        try {
            String requete= "insert into avis(rating,commentaire,id_magasin,user_id,user_name) values(?,?,?,?,?)";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setInt(1, a.getRating());
            st.setString(2, a.getCommentaire());
            st.setInt(3, a.getId_magasin());
            st.setInt(4, a.getUser_id());
            st.setString(5, a.getUser_name());
            
            st.executeUpdate();
            System.out.println("Avis ajouter");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
     }
      
      
        public void SupprimerAvis(int id){
        try {
            String requete= "delete from avis where id=?;";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Avis Supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }}
    
    public List<Avis> ListerAvis(int idmag){
                        List<Avis>mylist = new ArrayList<Avis>();

            try {
                String requete2="SELECT *FROM avis where id_magasin=" + idmag + "";
                Statement st2=cn.createStatement();
                ResultSet rs= st2.executeQuery(requete2);
                while(rs.next()){
                Avis a= new Avis();
                a.setId(rs.getInt(1));
                a.setRating(rs.getInt(2));
                a.setCommentaire(rs.getString(3));
                a.setId_magasin(rs.getInt(4));
                a.setUser_id(rs.getInt(6));
                a.setUser_name(rs.getString(7));
                
                mylist.add(a);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AvisServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return mylist;
    
    }
    
    
}
