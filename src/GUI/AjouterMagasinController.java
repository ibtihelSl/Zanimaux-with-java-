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
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.MagasinServices;
import pidev.Zanimaux.entities.Magasin;

/**
 * FXML Controller class
 *
 * @author Touha
 */
public class AjouterMagasinController implements Initializable {
    
     @FXML
    private Button addmagasin;
    @FXML
    private TextField nom;
    @FXML
    private TextField address;
    @FXML
    private TextField ville;
    @FXML
    private TextField phone;
    @FXML
    private Button Retour;
    @FXML
    private Label erreur_nom;
    @FXML
    private Label erreur_adresse;
    @FXML
    private Label erreur_ville;
    @FXML
    private Label erreur_phone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML 
     private void ajoutermagasin(ActionEvent event) throws IOException  {
         boolean isNomEmpty= validation.TextFieldValidation.isTextFieldNotEmpty(nom, erreur_nom, "Nom is Required");
        boolean isAddresseEmpty= validation.TextFieldValidation.isTextFieldNotEmpty(address, erreur_adresse, "Addresse is Required");
        boolean isvilleEmp= validation.TextFieldValidation.isTextFieldNotEmpty(ville, erreur_ville, "ville is Required");
      boolean isphoneEmp= validation.TextFieldValidation.isTextFieldNotEmpty(phone, erreur_phone, "Phone is Required");

        if (isNomEmpty && isAddresseEmpty && isvilleEmp && isphoneEmp) 
      {
        Magasin m = new Magasin(nom.getText(),address.getText(),ville.getText(),phone.getText());
              MagasinServices ms= new MagasinServices();
              ms.ajouterMagasin(m);

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


          
     }}

    void ajoutermagasin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
