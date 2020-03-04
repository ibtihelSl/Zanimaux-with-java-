/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import pidev.Zanimaux.entities.assurance;
import pidev.Zanimaux.Services.CrudAssurance;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ci
 */
public class ListAssuranceClientController implements Initializable {

     @FXML
    private TableView<assurance> tableview;
    @FXML
    private TableColumn<assurance, String> nom;
    @FXML
    private TableColumn<assurance, String> adresse;
    @FXML
    private TableColumn<assurance, String> mail;
    @FXML
    private TableColumn<assurance, String> description;
    @FXML
    private TableColumn<assurance, String> age_de_ce_animal;
     @FXML
    private TableColumn<assurance, String> type_de_ce_animal;
     
      
   
    @FXML
    private TextField nbranim;
    @FXML
    private Button home;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initcol();
       listAssur();
       
     

    } 
    
   private void initcol(){

   nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
   adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
   mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
   description.setCellValueFactory(new PropertyValueFactory<>("Description"));
   age_de_ce_animal.setCellValueFactory(new PropertyValueFactory<>("age_de_ce_animal")); 
   type_de_ce_animal.setCellValueFactory(new PropertyValueFactory<>("type_de_ce_animal"));
   
 
   
   } 
  
   
    private void listAssur()  {
    
        CrudAssurance ms= new CrudAssurance();
                     List<assurance> list= ms.ListerAssurance();
                  tableview.getItems().setAll(list);
    
    }

    @FXML
    private void calcul(MouseEvent event) {
    assurance assur = tableview.getSelectionModel().getSelectedItem();
            int nbr= Integer.parseInt(nbranim.getText());
          Double  totale=assur.getPrixparanimaux()*nbr;
               //  String tot=totale.toString();
           Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("Totale prix");
        al.setHeaderText(null);
        al.setContentText("le prix totale est : "+totale+"Dt");
        al.showAndWait();
            return;
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
       assurance a = new assurance();

         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));    
                           Parent root = loader.load();
                          AccueilController liste = loader.<AccueilController>getController(); 
                            liste.initialize(null,null); {
        
                    tableview.getScene().setRoot(root);

    }}
    
}
