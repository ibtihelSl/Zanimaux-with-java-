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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class ListFaqQuestionController implements Initializable {

   @FXML
 private TableView<FaqQuestions> tableview ;
 @FXML
 private TableColumn<FaqQuestions, String> question;
 @FXML
 private TableColumn<FaqQuestions, String> reponse;

    @FXML
    private MenuItem supFaqQuestion;
    @FXML
    private TableColumn<?, ?> ModifFaqQuestion;
    @FXML
    private Button ajouterFaqQuestion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initcol();
        listFaqQuestion();
    } 
    
   private void initcol(){
   question.setCellValueFactory(new PropertyValueFactory<>("Question"));
   reponse.setCellValueFactory(new PropertyValueFactory<>("Reponse"));
   
   } 
    
   
    private void listFaqQuestion()  {
    
        CrudFaqQuestion ms= new CrudFaqQuestion();
                     List<FaqQuestions> list= ms.ListerFaqQuestion();
                  tableview.getItems().setAll(list);
    
    }

    @FXML
    private void SupprimerFaqQuestion(ActionEvent event) {
    FaqQuestions fa = tableview.getSelectionModel().getSelectedItem();
    if (fa == null) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("No FaqQuestion selected");
        al.setHeaderText(null);
        al.setContentText("Please select FaqQuestion for deletion.");
        al.showAndWait();
            return;
        }
      Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("DeletingAssurance");
      alert.setContentText("are you sure want to delete the FaqQuestion "+fa.getQuestion()+"?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK)
        {
        CrudFaqQuestion ms= new CrudFaqQuestion();
        ms.SupprimerFaqQuestion(fa.getId());
       listFaqQuestion();
         
          TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les FaqQuestions");
                    tray.setMessage("Vouz avez supprimer cet FaqQuestion");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));

          

        }
     
    }

    @FXML
    private void ajouterFaqQuestion(ActionEvent event) throws IOException {
                        Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterFaqQuestion.fxml"));    
                           Parent root = loader.load();

         AjouterFaqQuestionController liste = loader.getController();
       
                tableview.getScene().setRoot(root);


    }
    
    @FXML
    private void ModifierFaqQuestion(ActionEvent event) throws IOException {
    FaqQuestions fa = tableview.getSelectionModel().getSelectedItem(); 
       Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierFaqQuestion.fxml"));    
                           Parent root = (Region) loader.load();

         ModifierFaqQuestionController editFa = loader.<ModifierFaqQuestionController>getController();
         editFa.setFaqQuestionid(fa.getId());
         editFa.setFaqQuestionQuestion(fa.getQuestion());
         editFa.setFaqQuestionReponse(fa.getQuestion());
  
 
              tableview.getScene().setRoot(root);

         
        }

}
