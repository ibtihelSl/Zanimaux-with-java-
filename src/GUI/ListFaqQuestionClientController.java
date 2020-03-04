/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXListView;
import pidev.Zanimaux.entities.FaqQuestions;
import pidev.Zanimaux.Services.CrudFaqQuestion;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ci
 */
public class ListFaqQuestionClientController implements Initializable {
      @FXML
 private TableView<FaqQuestions> tableview ;
 @FXML
 private TableColumn<FaqQuestions, String> question;
 @FXML
 private TableColumn<FaqQuestions, String> reponse;
   



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


    
   
     
    
}
