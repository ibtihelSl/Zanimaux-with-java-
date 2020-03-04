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
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ci
 */
public class ModifierFaqQuestionController implements Initializable {
      @FXML
    private TextField question;
    @FXML
    private TextArea reponse;
 
    int id;
    int FaqQuestionid;
   String FaqQuestionQuestion;
    String FaqQuestionReponse;

  

    public void setFaqQuestionid(int FaqQuestionid) {
        this.FaqQuestionid = FaqQuestionid;
        id=FaqQuestionid;
    }


    public void setFaqQuestionQuestion(String FaqQuestionQuestion) {
        this.FaqQuestionQuestion = FaqQuestionQuestion;
         question.setText (String.valueOf(this.FaqQuestionQuestion));
    }

   

    public void setFaqQuestionReponse(String FaqQuestionReponse) {
        this.FaqQuestionReponse = FaqQuestionReponse;
         reponse.setText (String.valueOf(this.FaqQuestionReponse));
    }
    
    
    
    

        @FXML
    private void cancel(ActionEvent event) throws IOException {
     exit();
          
    
    }

    @FXML
    private void modifierFaqQuestion(ActionEvent event) throws IOException {
        FaqQuestions fa=new FaqQuestions(id, question.getText(),reponse.getText());
            CrudFaqQuestion as = new CrudFaqQuestion();
            as.ModifierFaqQuestion(fa);
              FXMLLoader loader = new FXMLLoader(getClass().getResource("ListFaqQuestion.fxml"));    
                           Parent root = loader.load();

        ListFaqQuestionController liste = loader.getController();
         liste.initialize(null,null);
         question.getScene().setRoot(root);
         
         TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les FaqQuestions");
                    tray.setMessage("Vouz avez modidier un nouveaux FaqQuestion");
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
