/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.Services;

import pidev.Zanimaux.IService.IAnimauxServices;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.Zanimaux.entities.Animaux;
import pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author Touha
 */
public class AnimauxServices implements IAnimauxServices{
    
    public Animaux ListerAnimauxuser(int user_id){
        Connection cn= Myconnexion.getInstance().getConnection();
Animaux a= new Animaux();
            try {
                String requete2="SELECT * FROM animaux where user_id=" + user_id + "";
                Statement st2=cn.createStatement();
                ResultSet rs= st2.executeQuery(requete2);
                
                while(rs.next()){
                
                a.setId(rs.getInt(6));
                a.setNom(rs.getString(1));
                a.setEspece(rs.getString(5));
                a.setId_user(rs.getInt(9));
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccessoiresServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return a;
    
    }
    
}
