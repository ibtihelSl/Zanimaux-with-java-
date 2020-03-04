/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev.Zanimaux.Services;

import pidev.Zanimaux.IService.IAssurance;
import pidev.Zanimaux.entities.assurance;
import pidev.Zanimaux.utils.Myconnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ci
 */
public class CrudAssurance implements IAssurance{
    
     Connection cn=Myconnexion.getInstance().getConnection();
        
    private String requete;

        
         public void ajouterAssurance(assurance a){
        
           try {
        String requete=
                "INSERT INTO assurance (nom,adresse,mail,description,age_de_ce_animal,type_de_ce_animal,prixparanimaux) VALUES(?,?,?,?,?,?,?)";
               PreparedStatement st= cn.prepareStatement(requete);
               st.setString(1, a.getNom());
               st.setString(2, a.getAdresse());
               st.setString(3, a.getMail());
               st.setString(4, a.getDescription());
               st.setString(5, a.getAge_de_ce_animal());
               st.setString(6, a.getType_de_ce_animal());
               st.setDouble(7, a.getPrixparanimaux());
                 

        st.executeUpdate();
        
               System.out.println("Assurance ajouter");
               
           } 
           catch (SQLException ex) {
               
               System.err.println(ex.getMessage());     
        }
           
         } 
    
         
         
 public List<assurance> ListerAssurance(){
          
          
                    List<assurance> myList=new ArrayList<assurance>();

          try {
          
          String requete2="SELECT * FROM assurance";
        
            Statement st2=cn.createStatement();
            ResultSet rs=  st2.executeQuery(requete2);
                      
while(rs.next()){
    
    assurance a=new assurance();
    
    a.setId(rs.getInt(1));
    a.setNom(rs.getString(2));
    a.setAdresse(rs.getString(3));
    a.setMail(rs.getString(4));
   
    a.setDescription(rs.getString(5));
    a.setAge_de_ce_animal(rs.getString(6));
    a.setType_de_ce_animal(rs.getString(7));
    a.setTotalprix(rs.getDouble(8));
    a.setPrixparanimaux(rs.getDouble(9));

    myList.add(a);
    
    
}
            
        }
          catch (SQLException ex) {
            
        }
        
          return myList; 
          
      }  
         
      
            public void modifierAssurance(assurance a){
       try {
            String requete= "update assurance set nom=?,adresse=?,mail=?,description=?,Age_de_ce_animal=?,type_de_ce_animal=?,prixparanimaux=? where id=?;";
            
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, a.getNom());
            st.setString(2, a.getAdresse());
            st.setString(3, a.getMail());
            st.setString(4, a.getDescription());

            st.setString(5, a.getAge_de_ce_animal());
            st.setString(6, a.getType_de_ce_animal());
            st.setDouble(7, a.getPrixparanimaux());


            st.setInt(8, a.getId());
            st.executeUpdate();
            System.out.println("assurance Modifier");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }}
     
    
     
            
            public void deleteAssurance(int id){
       
        try{
            
        String requete4="DELETE FROM assurance WHERE id =?;";

         PreparedStatement st=cn.prepareStatement(requete4);
         
         st.setInt(1, id);

            
            st.executeUpdate();
                           System.out.println(" assurance supprimer");


        }
         catch (SQLException ex) {
                            System.err.println(ex.getMessage());     

               
        }
            
            
}
            
             public assurance findByID(int id) {
       assurance a=null;
        String requete = "select * from assurance where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //id,nom,login,email,password
                 a=new assurance(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getDouble(8),rs.getDouble(9));

                return a; 
            }}  catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return a;   
    }
    
}
