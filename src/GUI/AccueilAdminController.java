/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdelaziz
 */
public class AccueilAdminController implements Initializable {

    @FXML
    private Button buttonUser;
    @FXML
    private Button buttonAssociation;
    @FXML
    private Button buttonEvent;
    @FXML
    private ImageView image;
    @FXML
    private Button logoutButton;
    @FXML
    private Button Magasin;
    @FXML
    private Button veterinaire;
    @FXML
    private Button asurance;
     @FXML
    private Button animal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        buttonEvent.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Evenement.fxml"));
                Region root = (Region) loader.load();
                EvenementController ac1 = loader.<EvenementController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        buttonAssociation.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Association.fxml"));
                Region root = (Region) loader.load();
                AssociationController ac1 = loader.<AssociationController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        logoutButton.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                Region root = (Region) loader.load();
                LoginController ac1 = loader.<LoginController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
         buttonUser.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Gclient.fxml"));
                Region root = (Region) loader.load();
                GclientController ac1 = loader.<GclientController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
          Magasin.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeMagasin.fxml"));
                Region root = (Region) loader.load();
                ListeMagasinController ac1 = loader.<ListeMagasinController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
         veterinaire.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListVeterinaire.fxml"));
                Region root = (Region) loader.load();
                ListVeterinaireController ac1 = loader.<ListVeterinaireController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
         asurance.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAssurance.fxml"));
                Region root = (Region) loader.load();
                ListeAssuranceController ac1 = loader.<ListeAssuranceController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
          animal.setOnAction(event -> {

            try {
                
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAnimalAdmin.fxml"));
                Region root = (Region) loader.load();
                Gui.ListeAnimalAdminController liste = loader.<Gui.ListeAnimalAdminController>getController();
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                liste.initialize(null,null);
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();
            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
    

        });
    }
}
