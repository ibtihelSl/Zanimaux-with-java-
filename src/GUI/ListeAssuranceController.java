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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
public class ListeAssuranceController implements Initializable {

    @FXML
 private TableView<assurance> tableview ;
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
 private TableColumn<assurance, Double> prixparanimaux;
 
    @FXML
    private MenuItem SuppAssur;
    @FXML
    private MenuItem editAssur;
    @FXML
    private Button AjouterAssur;
    @FXML
    private Button retour;
 /*   @FXML
    private TableColumn<?, ?> ModifAssur;
    @FXML
    private Button AjouterAssur;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initcol();
        listAssur();
    } 
    
   private void initcol(){
   nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
   adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
   mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
   description.setCellValueFactory(new PropertyValueFactory<>("description"));
      age_de_ce_animal.setCellValueFactory(new PropertyValueFactory<>("age_de_ce_animal"));
            type_de_ce_animal.setCellValueFactory(new PropertyValueFactory<>("type_de_ce_animal"));
        prixparanimaux.setCellValueFactory(new PropertyValueFactory<>("prixparanimaux"));



   } 
    
   
    private void listAssur()  {
    
        CrudAssurance ms= new CrudAssurance();
                     List<assurance> list= ms.ListerAssurance();
                  tableview.getItems().setAll(list);
    
    }

    @FXML
    private void SupprimerAssurance(ActionEvent event) {
    assurance assur = tableview.getSelectionModel().getSelectedItem();
    if (assur == null) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("No Magasin selected");
        al.setHeaderText(null);
        al.setContentText("Please select Assurance for deletion.");
        al.showAndWait();
            return;
        }
      Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("DeletingAssurance");
      alert.setContentText("are you sure want to delete the assurance "+assur.getNom()+"?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK)
        {
        CrudAssurance ms= new CrudAssurance();
        ms.deleteAssurance(assur.getId());
       listAssur();
         
       
       
        
         TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les Assurances");
                    tray.setMessage("Vouz avez supprimer cet assurance");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));
        }
     
    }

    @FXML
    private void ajouterAssurance(ActionEvent event) throws IOException {
         Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterAssurance.fxml"));
                            Region root = (Region) loader.load();
                           AjouterAssuranceController liste= loader.<AjouterAssuranceController>getController();
                      liste.initialize(null,null);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }
                      /*     Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterAssurance.fxml"));    
                           Parent root = loader.load();

         AjouterAssuranceController liste = loader.getController();
       
                  tableview.getScene().setRoot(root);*/


    





    
    @FXML
    private void ModifierAssurance(ActionEvent event) throws IOException {
    assurance assur = tableview.getSelectionModel().getSelectedItem(); 
       Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierAssurance.fxml"));    
                           Parent root = (Region) loader.load();

         ModifierAssuranceController editAssur = loader.<ModifierAssuranceController>getController();
         editAssur.setAssurid(assur.getId());
         editAssur.setAssurnom(assur.getNom());
         editAssur.setAssuradresse(assur.getAdresse());
         editAssur.setAssurmail(assur.getMail());
         editAssur.setAssurdescription(assur.getDescription());
  editAssur.setAssurage_de_ce_animal(assur.getAge_de_ce_animal());
    editAssur.setAssurtype_de_ce_animal(assur.getType_de_ce_animal());
  editAssur.setAssurprixparanimaux(assur.getPrixparanimaux());


 
         tableview.getScene().setRoot(root);
         
        }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
       assurance as = new assurance();

         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilAdmin.fxml"));    
                           Parent root = loader.load();
                         AccueilAdminController liste = loader.<AccueilAdminController>getController(); 
                            liste.initialize(null,null);
                                           tableview.getScene().setRoot(root);

                            
    }
    }


