/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.Services;

import pidev.Zanimaux.entities.Article;
import pidev.Zanimaux.entities.Comment;
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
public class CrudComment {
    Connection cn=Myconnexion.getInstance().getConnection();
     PreparedStatement pst;
    ResultSet rs;

      public void ajouterComment(Comment c){
        try {
            String requete= "insert into comment(message,last_time,article_id) values(?,?,?)";
            PreparedStatement st=cn.prepareStatement(requete);
             st.setString(1, c.getMessage());
            st.setTimestamp(2, c.getLast_time()); 
            st.setInt(3, c.getArticle_id());
          
          
           
            st.executeUpdate();
            System.out.println("Comment ajouter");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
     }
     
    
     public List<Comment> afficherArtticleCommentairelist(int id) {

        List<Comment> ls = new ArrayList<Comment>();
        try {
            String select = "Select * from comment where article_id="+id+"";
           // pst = cn.prepareStatement(select);
           Statement st2=cn.createStatement();
        
            //rs = pst.executeQuery();
                        ResultSet rs=  st2.executeQuery(select);

            
            
           /*  List<assurance> myList=new ArrayList<assurance>();

          try {
          
          String requete2="SELECT * FROM assurance";
        
            Statement st2=cn.createStatement();
            ResultSet rs=  st2.executeQuery(requete2);*/
            
            
            while (rs.next()) {
                
                Comment c = new Comment();
                
                c.setMessage(rs.getString(4));
                c.setArticle_id(rs.getInt(2));
                ls.add(c);

            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLSTATE: " + e.getSQLState());
            System.err.println("VnedorError: " + e.getErrorCode());
        }
        return ls;

        
    }
    
}
