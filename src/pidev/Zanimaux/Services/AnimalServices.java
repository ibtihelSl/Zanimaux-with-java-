/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.Services;

import pidev.Zanimaux.entities.Animal;
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
import pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author souad
 */
public class AnimalServices {
      Connection connection= Myconnexion.getInstance().getConnection();


    public void insertAn(Animal c) throws SQLException {

        String requete = "insert into animal (especeA,raceA,sexe,description,age,img,nombre_reserve) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, c.getEspaceA());
            ps.setString(2, c.getRaceA());
            ps.setString(3, c.getSexe());
            ps.setString(4, c.getDescription());
            ps.setInt(5, c.getAge());
            ps.setString(6, c.getImg());
            ps.setInt(7, c.getNbReservation());

            ps.executeUpdate();
            System.out.println("Animal ajouté");

        } catch (SQLException ex) {
            Logger.getLogger(AnimalServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteAn(Animal r) throws SQLException {

        PreparedStatement pst;
        String req = "DELETE FROM animal WHERE  id=?";
        pst = connection.prepareStatement(req);
        pst.setInt(1, r.getId());
        try {
            pst.executeUpdate();
            System.out.println("animale supp");
        } catch (SQLException ex) {
            Logger.getLogger(AnimalServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateAn(Animal R) throws SQLException {

        PreparedStatement pst;
        String req = "update animal set especeA=?,raceA=?,sexe=?,description=?,age=? where id=?";
        pst = connection.prepareStatement(req);
        pst.setString(1, R.getEspaceA());
        pst.setString(2, R.getRaceA());
        pst.setString(3, R.getSexe());
        pst.setString(4, R.getDescription());

        pst.setInt(5, R.getAge());
        pst.setInt(6, R.getId());        
try {
            pst.executeUpdate();
            System.out.println("animal modifié");
        } catch (SQLException ex) {
            Logger.getLogger(AnimalServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Animal> getAll() {
        ObservableList<Animal> list = FXCollections.observableArrayList();
        String requete = "select * from animal";

        try {
            Statement ste = connection.createStatement();
            ResultSet rs = ste.executeQuery(requete);
            while (rs.next()) {
//           Animal p=new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8),rs.getInt(9),rs.getInt(10));
                Animal p = new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }
        return list;
    }

    public Animal findByID(int id) throws SQLException {

        Animal p = null;
        String requete = "select * from animal where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //id,nom,login,email,password
                p = new Animal(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(7));

                return p;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }
        return p;
    }

    public List<Animal> displayAll(String espece) throws SQLException {

        List<Animal> v = new ArrayList<>();
        //Statement ste = con.createStatement();
        Statement ste = connection.createStatement();
        String req = "Select * from animal where especeA=" + espece;

        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            Animal p = new Animal(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(7));

            v.add(p);

        }
        return v;
    }

}
