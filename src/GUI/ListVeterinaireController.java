/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.Zanimaux.entities.veterinaires;
import pidev.Zanimaux.Services.CrudVeterinaires;
import pidev.Zanimaux.utils.Myconnexion;
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
import javafx.scene.control.TextField;
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
public class ListVeterinaireController implements Initializable {
@FXML
 private TableView<veterinaires> tableview ;
 @FXML
 private TableColumn<veterinaires, String> nom;
 @FXML
 private TableColumn<veterinaires, String> address;
 @FXML
 private TableColumn<veterinaires, String> ville;
 @FXML
 private TableColumn<veterinaires, String> phone;
 @FXML
 private TableColumn<veterinaires, String> email;
    @FXML
    private MenuItem supVet;
    @FXML
    private Button ajouterVet;
    
     veterinaires selectedArticle;
     @FXML
    private MenuItem editVet;
    @FXML
    private Button retour;
    @FXML
    private Button art;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initcol();
        listVet();
    } 
    
   private void initcol(){
   nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
   address.setCellValueFactory(new PropertyValueFactory<>("address"));
   ville.setCellValueFactory(new PropertyValueFactory<>("Ville"));
   phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
   email.setCellValueFactory(new PropertyValueFactory<>("Email"));
   } 
    
   
    private void listVet()  {
    
        CrudVeterinaires ms= new CrudVeterinaires();
                     List<veterinaires> list= ms.ListerVeterinaires();
                  tableview.getItems().setAll(list);
    
    }

    @FXML
    private void SupprimerVeterinaire(ActionEvent event) {
    veterinaires vet = tableview.getSelectionModel().getSelectedItem();
    if (vet == null) {
            Alert al = new Alert(AlertType.INFORMATION);
        al.setTitle("No veterinaire selected");
        al.setHeaderText(null);
        al.setContentText("Please select Veterinaire for deletion.");
        al.showAndWait();
            return;
        }
      Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("DeletingVeterinaire");
      alert.setContentText("are you sure want to delete this veterinaire "+vet.getNom()+"?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK)
        {
        CrudVeterinaires ms= new CrudVeterinaires();
        ms.deleteVeterinaire(vet.getId());
       listVet();
         
       
       TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les Veterinaires");
                    tray.setMessage("Vouz avez supprimer cet veterinaire");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));
        }
     
    }

    @FXML
    private void ajouterVet(ActionEvent event) throws IOException {
                        Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterVeterinaire.fxml"));    
                           Parent root = loader.load();

         AjouterVeterinaireController liste = loader.getController();
       
                 tableview.getScene().setRoot(root);

      
                
                
    }
    
    @FXML
    private void ModifierVet(ActionEvent event) throws IOException {
    veterinaires vet = tableview.getSelectionModel().getSelectedItem(); 
       Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierVeterinaire.fxml"));    
                           Parent root = (Region) loader.load();

         ModifierVeterinaireController editVet = loader.<ModifierVeterinaireController>getController();
         editVet.setVetid(vet.getId());
         editVet.setVetnom(vet.getNom());
         editVet.setVetaddress(vet.getAddress());
         editVet.setVetville(vet.getVille());
         editVet.setVetphone(vet.getPhone());
  editVet.setVetEmail(vet.getEmail());
                 tableview.getScene().setRoot(root);

        }
      int idvet;

       public void setIdvet(Integer Vetid) {
        this.idvet= Vetid;
     }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
      veterinaires v= new veterinaires();

         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilAdmin.fxml"));    
                           Parent root = loader.load();
                          AccueilAdminController liste = loader.<AccueilAdminController>getController(); 
                            liste.initialize(null,null);
                                            tableview.getScene().setRoot(root);

    
    }

    @FXML
    private void lesArticles(ActionEvent event) throws IOException {
        veterinaires v= new veterinaires();

         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ListArticle.fxml"));    
                           Parent root = loader.load();
                          ListArticleController liste = loader.<ListArticleController>getController(); 
                            liste.initialize(null,null);
                                            tableview.getScene().setRoot(root);
    }

      
    
}
