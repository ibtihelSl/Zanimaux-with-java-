/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.Zanimaux.entities.assurance;
import pidev.Zanimaux.Services.CrudAssurance;
import java.io.IOException;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ci
 */
public class AjouterAssuranceController implements Initializable {

    private TableView<assurance> tableview;
      @FXML
    private Button AjouterAssur;
    @FXML
    private TextField nom;
    @FXML
    private TextField adresse;
     @FXML
    private TextField mail;
      @FXML
    private TextField description;
     @FXML
    private TextField age_de_ce_animal;
    @FXML
    private TextField type_de_ce_animal;
    @FXML
    private TextField prixparanimaux;
   @FXML
   private Button retou;
    @FXML
    private AnchorPane retour;
    @FXML
    private Label erreur_nom;
    @FXML
    private Label erreur_address;
    @FXML
    private Label erreur_email;
    @FXML
    private Label erreur_descri;
    @FXML
    private Label erreur_age;
    @FXML
    private Label erreur_type;
    @FXML
    private Label erreur_prix;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML 
     private void ajouterAssurance(ActionEvent event) throws IOException  {

         boolean isNomEmpty= validation.TextFieldValidation.isTextFieldNotEmpty(nom, erreur_nom, "Nom is Required");
        boolean isAddresseEmpty= validation.TextFieldValidation.isTextFieldNotEmpty(adresse, erreur_address, "Addresse is Required");
        boolean isdescriptionEmp= validation.TextFieldValidation.isTextFieldNotEmpty(description, erreur_descri, "description is Required");
      boolean isageEmp= validation.TextFieldValidation.isTextFieldNotEmpty(age_de_ce_animal, erreur_age, "age is Required");
      boolean isEmailEmp= validation.TextFieldValidation.isEmail(mail, erreur_email, "Email is Required");
      boolean istypeEmp= validation.TextFieldValidation.isTextFieldNotEmpty(type_de_ce_animal, erreur_type, "type is Required");
      boolean isprixEmp= validation.TextFieldValidation.isTextFieldNotEmpty(prixparanimaux, erreur_prix, "prix is Required");

        if (isNomEmpty && isAddresseEmpty && isEmailEmp&& isageEmp && isdescriptionEmp && isprixEmp &&istypeEmp) 
      {
                          Double paranimaux=Double.parseDouble(prixparanimaux.getText());

         assurance a = new assurance(nom.getText(),adresse.getText(),mail.getText(),description.getText(),age_de_ce_animal.getText(),type_de_ce_animal.getText(),paranimaux);
            CrudAssurance as = new CrudAssurance();
              as.ajouterAssurance(a);
               FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAssurance.fxml"));    
                           Parent root = loader.load();

         ListeAssuranceController liste = loader.getController();
         liste.initialize(null,null);
         nom.getScene().setRoot(root);

 
         TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les Assurances");
                    tray.setMessage("Vouz avez ajouter une nouvelle assurance");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));
          
          
     }}
     @FXML
    private void Retour(ActionEvent event) throws IOException {
       assurance as= new assurance();
  Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAssurance.fxml"));
                            Region root = (Region) loader.load();
                           ListeAssuranceController liste= loader.<ListeAssuranceController>getController();
                      liste.initialize(null,null);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }
        
}
