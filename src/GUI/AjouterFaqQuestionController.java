/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.Zanimaux.entities.FaqQuestions;
import pidev.Zanimaux.Services.CrudFaqQuestion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
public class AjouterFaqQuestionController implements Initializable {

    @FXML
    private Button AjouterFaqQuestion;
    @FXML
    private TextField question;
    @FXML
    private TextArea reponse;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML 
     private void ajouterFaqQuestion(ActionEvent event) throws IOException  {
     
     FaqQuestions fa = new FaqQuestions(question.getText(),reponse.getText());
              CrudFaqQuestion ms= new CrudFaqQuestion();
              ms.ajouterFaqQuestion(fa);
                             Stage st = new Stage();

               FXMLLoader loader = new FXMLLoader(getClass().getResource("ListFaqQuestion.fxml"));    
                           Parent root = loader.load();

         ListFaqQuestionController liste = loader.getController();
         liste.initialize(null,null);
         question.getScene().setRoot(root);
         
         
         TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les FaqQuestions");
                    tray.setMessage("Vouz avez ajouter un nouveaux FaqQuestion");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));

          

          
     

    
}
}
