/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import pidev.Zanimaux.Services.Event_services;
import pidev.Zanimaux.utils.Myconnexion;


/**
 * FXML Controller class
 *
 * @author abdelaziz
 */
public class StatController implements Initializable {

    @FXML
    private BarChart<String, Integer> barchart;
     Connection con= Myconnexion.getInstance().getConnection();
    private Statement st;
    PreparedStatement pste;
    private ResultSet rs;
           


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
    }    
    
    private void load() {
        Event_services s1 = new Event_services();
        String req ="select titre,nombre_reserve FROM event ORDER BY nombre_reserve asc";
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
       try {
                  st = con.createStatement();
                       rs = st.executeQuery(req);
                       
                       while(rs.next())
                       {series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));}
                       barchart.getData().add(series);
       } catch (SQLException ex) {
           Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
    
}
