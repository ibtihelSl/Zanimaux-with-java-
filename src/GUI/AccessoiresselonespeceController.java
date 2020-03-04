/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.LoginController.usernid;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.AccessoiresServices;
import pidev.Zanimaux.Services.AnimauxServices;
import pidev.Zanimaux.Services.ClientDAO;
import pidev.Zanimaux.Services.MagasinServices;
import pidev.Zanimaux.entities.Accessoires;
import pidev.Zanimaux.entities.Animaux;
import pidev.Zanimaux.entities.Client;
import pidev.Zanimaux.entities.Magasin;
import pidev.Zanimaux.utils.Myconnexion;

/**
 * FXML Controller class
 *
 * @author Touha
 */
public class AccessoiresselonespeceController implements Initializable {

    @FXML
    private JFXListView<Label> lstview;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            remplirListView();
        } catch (SQLException ex) {
            Logger.getLogger(AccessoiresselonespeceController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    
    
    void remplirListView() throws SQLException {
ClientDAO cd1= new ClientDAO();
              Client a1=cd1.findByID(usernid);
        AnimauxServices an= new AnimauxServices();
        Animaux a=an.ListerAnimauxuser(a1.getId());
        
                           
       AccessoiresServices as= new AccessoiresServices();
       List<Accessoires> list= as.ListerAccessoiresEspece(a.getEspece()); 
        
       
        lstview.getItems().clear();
        for( Accessoires ac : list)
        {
            MagasinServices mg=new MagasinServices();
            Magasin m = mg.findByID(ac.getId_magasin());
                 
            Label lbl = new Label("Nom : "+ac.getNom()+"\n Prix :"+ac.getPrix()+"\n Espece : "+ac.getEspece()+ "\n nom magasin :" +m.getNom()+"\n" );
             String img=ac.getImage();
            
              Image image=new Image(img,100,50,true,true);
            
                 lbl.setPrefSize(500, 100);
            
                
                ImageView imageView = new ImageView();
                imageView.imageProperty().unbind();
                imageView.setImage(image);
                imageView.setFitWidth(150);
                imageView.setFitHeight(100);
                lstview.getItems().add(lbl);
                lbl.setGraphic(imageView);
        }}

    @FXML
    private void retour(ActionEvent event) throws IOException {
           
       Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeMagasinClient.fxml"));
                            Region root = (Region) loader.load();
                           ListeMagasinClientController liste = loader.<ListeMagasinClientController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
            
    }
    
}
