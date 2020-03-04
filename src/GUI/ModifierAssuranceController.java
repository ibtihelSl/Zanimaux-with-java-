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
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
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
public class ModifierAssuranceController implements Initializable {

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
    private TextField totalprix;
       @FXML
    private TextField prixparanimaux;
    int id;
    int Assurid;
    String Assurnom;
    String Assuradresse;
    String Assurmail;
    String Assurdescription;
    String Assurage_de_ce_animal;
    String Assurtype_de_ce_animal;
    double Assurtotalprix;
    double Assurprixparanimaux;

  

  

    public void setAssurid(int Assurid) {
        this.Assurid = Assurid;
           id= Assurid;
    }


    public void setAssurnom(String Assurnom) {
        this.Assurnom = Assurnom;
        nom.setText (String.valueOf(this.Assurnom));
    }

  

    public void setAssuradresse(String Assuradresse) {
        this.Assuradresse = Assuradresse;
        adresse.setText (String.valueOf(this.Assuradresse));
    }

  

    public void setAssurmail(String Assurmail) {
        this.Assurmail = Assurmail;
        mail.setText (String.valueOf(this.Assurmail));
    }

  

    public void setAssurdescription(String Assurdescription) {
        this.Assurdescription = Assurdescription;
        description.setText (String.valueOf(this.Assurdescription));
    }

   

    public void setAssurage_de_ce_animal(String Assurage_de_ce_animal) {
        this.Assurage_de_ce_animal = Assurage_de_ce_animal;
        age_de_ce_animal.setText (String.valueOf(this.Assurage_de_ce_animal));
    }

  

    public void setAssurtype_de_ce_animal(String Assurtype_de_ce_animal) {
        this.Assurtype_de_ce_animal = Assurtype_de_ce_animal;
                type_de_ce_animal.setText (String.valueOf(this.Assurtype_de_ce_animal));

    }

    /*public void setAssurtotalprix(double Assurtotalprix) {
        this.Assurtotalprix = Assurtotalprix;
         totalprix.setText (String.valueOf(this.Assurtotalprix));

    }*/


    public void setAssurprixparanimaux(double Assurprixparanimaux) {
        this.Assurprixparanimaux = Assurprixparanimaux;
        prixparanimaux.setText (String.valueOf(this.Assurprixparanimaux));

    }
    

  
      
    
    @FXML
    private void cancel(ActionEvent event) throws IOException {
     exit();
          
    
    }

    @FXML
    private void modifierAssurance(ActionEvent event) throws IOException {
      Double paranimaux=Double.parseDouble(prixparanimaux.getText());
       
         assurance a = new assurance(id,nom.getText(),adresse.getText(),mail.getText(),description.getText(),age_de_ce_animal.getText(),type_de_ce_animal.getText(),paranimaux);
            CrudAssurance as = new CrudAssurance();
            as.modifierAssurance(a);
              FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAssurance.fxml"));    
                           Parent root = loader.load();

        ListeAssuranceController liste = loader.getController();
         liste.initialize(null,null);
         nom.getScene().setRoot(root);
         
         
         TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les Assurances");
                    tray.setMessage("Vouz avez modifier cet assurance");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
