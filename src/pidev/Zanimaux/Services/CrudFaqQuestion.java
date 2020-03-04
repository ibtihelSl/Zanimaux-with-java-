/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.Services;

import pidev.Zanimaux.IService.IFaqQuestion;
import pidev.Zanimaux.entities.FaqQuestions;
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
/**
 *
 * @author ci
 */
public class CrudFaqQuestion implements IFaqQuestion{
    
  Connection cn= Myconnexion.getInstance().getConnection();
  
      public void ajouterFaqQuestion(FaqQuestions fa){
        try {
            String requete= "insert into choices(question,reponse) values(?,?)";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, fa.getQuestion());
            st.setString(2, fa.getReponse());
            st.executeUpdate();
            System.out.println("FaqQuestion ajouter");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
     }
      public void ModifierFaqQuestion(FaqQuestions fa){
        try {
            String requete= "update choices set question=?,reponse=? where id=?;";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, fa.getQuestion());
            st.setString(2, fa.getReponse());
            st.setInt(3, fa.getId());
            st.executeUpdate();
            System.out.println("FaqQuestion Modifier");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());      
        }}
     
      public void SupprimerFaqQuestion(int id){
        try {
            String requete= "delete from choices where id=?;";
             PreparedStatement st=cn.prepareStatement(requete);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("FaqQuestion Supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());       
        }}
    
    public List<FaqQuestions> ListerFaqQuestion(){
                        List<FaqQuestions>mylist = new ArrayList<FaqQuestions>();

            try {
                String requete2="SELECT *FROM choices";
                Statement st2=cn.createStatement();
                ResultSet rs= st2.executeQuery(requete2);
                while(rs.next()){
                FaqQuestions fa= new FaqQuestions();
                fa.setId(rs.getInt(1));
                fa.setQuestion(rs.getString(2));
                fa.setReponse(rs.getString(3));
                mylist.add(fa);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CrudFaqQuestion.class.getName()).log(Level.SEVERE, null, ex);
            }
            return mylist;
    
    }
    
     public FaqQuestions findByID(int id) {
       FaqQuestions a=null;
        String requete = "select * from choices where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                 a=new FaqQuestions(rs.getInt(1), rs.getString(2), rs.getString(3));

                return a; 
            }}  catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return a;    }
    
}
           

