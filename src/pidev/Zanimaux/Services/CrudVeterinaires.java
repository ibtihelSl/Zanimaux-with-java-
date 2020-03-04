/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev.Zanimaux.Services;

import pidev.Zanimaux.IService.Iveterinaire;
import pidev.Zanimaux.entities.veterinaires;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ci
 */
public class CrudVeterinaires implements Iveterinaire{
     
         Connection cn=Myconnexion.getInstance().getConnection();
        
    private String requete;
        
    
    public void ajouterVeterinaire(veterinaires v){
       
           try {
        String requete=
                "INSERT INTO veterinaires (nom,address,ville,phone,email,nom_image) VALUES(?,?,?,?,?,?)";
               PreparedStatement st= cn.prepareStatement(requete);
               st.setString(1, v.getNom());
               
               st.setString(2, v.getAddress());
               st.setString(3, v.getVille());
               st.setString(4, v.getPhone());
               st.setString(5, v.getEmail());
               st.setString(6, v.getNom_image());

        st.executeUpdate();
        
               System.out.println("Veterinaire ajouter");
               
           } 
           catch (SQLException ex) {
               
               System.err.println(ex.getMessage());     
        }
           
         }
    
    
    public List<veterinaires> ListerVeterinaires(){
        
           List<veterinaires>mylist = new ArrayList<veterinaires>();

            try {
                String requete2="SELECT *FROM veterinaires";
                Statement st2=cn.createStatement();
                ResultSet rs= st2.executeQuery(requete2);
                while(rs.next()){
                veterinaires v= new veterinaires();
                v.setId(rs.getInt(1));
                v.setNom(rs.getString(2));
                v.setAddress(rs.getString(3));
                v.setVille(rs.getString(4));
                v.setPhone(rs.getString(5));
                 v.setEmail(rs.getString(6));
                   v.setNom_image(rs.getString(7));
                mylist.add(v);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CrudVeterinaires.class.getName()).log(Level.SEVERE, null, ex);
            }
            return mylist;
    

            
        }
   
    
       public void modifierVeterinaire(veterinaires v){
        try {
            String requete= "update veterinaires set nom=?, address=?,ville=?,phone=?,email=? where id=?;";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setString(1, v.getNom());
            st.setString(2, v.getAddress());
            st.setString(3, v.getVille());
            st.setString(4, v.getPhone());

            st.setString(5, v.getEmail());
            st.setInt(6, v.getId());
            st.executeUpdate();
            System.out.println("veterinaire Modifier");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }}
     
    
    
  public void deleteVeterinaire(int id){
       
       
        try {
            String requete= "delete from veterinaires where id=?;";
            PreparedStatement st=cn.prepareStatement(requete);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Veterinaire Supprimer");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());      
        }}
  
         
    
    public veterinaires findByID(int id) {
       veterinaires v=null;
        String requete = "select * from veterinaire where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //id,nom,login,email,password
                 v=new veterinaires(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));

                return v; 
            }}  catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }  
           return v;   
    }


   
    
       
}
