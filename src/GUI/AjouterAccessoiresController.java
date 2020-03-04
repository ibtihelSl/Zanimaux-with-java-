/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.AccessoiresServices;
import pidev.Zanimaux.entities.Accessoires;

/**
 * FXML Controller class
 *
 * @author Touha
 */
public class AjouterAccessoiresController implements Initializable {
    
     @FXML
    private Button addaccess;
    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
    @FXML
    private TextField espece;
    private String path="";

    int idmag;
    @FXML
    private ImageView imgviewadd;
    @FXML
    private Button retour;
    @FXML
    private Label erreur_nom;
    @FXML
    private Label erreur_prix;
    @FXML
    private Label erreur_espece;

    public void setIdmag(Integer AId) {
        this.idmag= AId;
       }

 
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML 
     private void ajouteraccessoire(ActionEvent event) throws IOException  {
           
       boolean isNomEmpty= validation.TextFieldValidation.isTextFieldNotEmpty(nom, erreur_nom, "Nom is Required");
        boolean isEspeceEmpty= validation.TextFieldValidation.isTextFieldNotEmpty(espece, erreur_espece, "Espece is Required");
        boolean isprixEmp= validation.TextFieldValidation.isTextFieldNotEmpty(prix, erreur_prix, "prix is Required");
        if (isNomEmpty && isEspeceEmpty && isprixEmp) 
      {
       
         Accessoires a = new Accessoires(nom.getText(),(Float.parseFloat(prix.getText())),espece.getText(),idmag);
         a.setImage(image_path);
              AccessoiresServices as= new AccessoiresServices();
              as.ajouterAccessoires(a);
           Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAccessoires.fxml"));
                            Region root = (Region) loader.load();
                           ListeAccessoiresController liste = loader.<ListeAccessoiresController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            liste.setIdmag(idmag);
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
          
          
     }
}
    String image_path;

    @FXML
    private void load(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            image_path = selectedFile.getName().toString();
            Image image = new Image(image_path);
            imgviewadd.setImage(image);
        } else {
            System.out.println("fichier invalide");
        }
    }

    @FXML
    private void ListeMagasin(ActionEvent event) throws IOException {
         Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeMagasin.fxml"));
                            Region root = (Region) loader.load();
                           ListeMagasinController liste = loader.<ListeMagasinController>getController();
                      liste.initialize(null,null);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }
}
