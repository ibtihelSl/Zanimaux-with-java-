/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.Zanimaux.entities.veterinaires;
import pidev.Zanimaux.Services.CrudVeterinaires;
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
public class ModifierVeterinaireController implements Initializable {

    
    @FXML
    private TextField nom;
    @FXML
    private TextField address;
    @FXML
    private TextField ville;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    int id;
    int Vetid;
    String Vetnom;
    String Vetaddress;
    String Vetville;
    String Vetphone;
    String VetEmail;

  

    public void setVetEmail(String VetEmail) {
        this.VetEmail = VetEmail;
        email.setText (String.valueOf(this.VetEmail));
    }
    
   

    public void setVetphone(String Vetphone) {
        this.Vetphone = Vetphone;
        phone.setText (String.valueOf(this.Vetphone));
    }

   
    public void setVetid(int Vetid) {
        this.Vetid = Vetid;
         id= this.Vetid;
    }

 
    public void setVetnom(String Vetnom) {
        this.Vetnom = Vetnom;
        nom.setText (String.valueOf(this.Vetnom));
    }

 

    public void setVetaddress(String Vetaddress) {
        this.Vetaddress = Vetaddress;
        address.setText (String.valueOf(this.Vetaddress));
    }

   
    public void setVetville(String Vetville) {
        this.Vetville = Vetville;
       ville.setText (String.valueOf(this.Vetville));
    }
    
    
    @FXML
    private void cancel(ActionEvent event) throws IOException {
     exit();
          
    
    }
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void modifierVet(ActionEvent event) throws IOException {
         veterinaires v=new veterinaires(id, nom.getText(), address.getText(),ville.getText(),phone.getText(),email.getText());
            CrudVeterinaires as = new CrudVeterinaires();
            as.modifierVeterinaire(v);
              FXMLLoader loader = new FXMLLoader(getClass().getResource("ListVeterinaire.fxml"));    
                           Parent root = loader.load();

        ListVeterinaireController liste = loader.getController();
         liste.initialize(null,null);
         nom.getScene().setRoot(root);
         
         
         TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les Veterinaires");
                    tray.setMessage("Vouz avez modifier cet veterinaire");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));
            
                                   
        
    }

    
   
    
}
