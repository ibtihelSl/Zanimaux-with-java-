/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import static GUI.LoginController.usernid;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import pidev.Zanimaux.Services.AccessoiresServices;
import pidev.Zanimaux.Services.AvisServices;
import pidev.Zanimaux.Services.ClientDAO;
import pidev.Zanimaux.entities.Accessoires;
import pidev.Zanimaux.entities.Avis;
import pidev.Zanimaux.entities.Client;

/**
 * FXML Controller class
 *
 * @author Touha
 */
public class ListeAccessoiresController implements Initializable {
    @FXML
    private MenuItem editacc;
    @FXML
    private MenuItem delacc;
    @FXML
    private TableColumn<Accessoires, String> nom;
    @FXML
    private TableColumn<Accessoires, Float> prix;
    @FXML
    private TableView<Accessoires> tableview;
    @FXML
    private Button listMag;
    @FXML
    private TableColumn<Accessoires, String> Espece;
    @FXML
    private TableView<Avis> tableview1;
    @FXML
    private TableColumn<Avis, String> commentaire;
    @FXML
    private TableColumn<Avis, Integer> rat;
 int idmag;
    

    public void setIdmag(Integer AId) {
        this.idmag= AId;
       }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initcol();
        listaccessoires();
        initcola();
        listavis();
    }    
    
     private void initcol(){
   nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
   prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
    Espece.setCellValueFactory(new PropertyValueFactory<>("espece"));
     }

      private void listaccessoires()  {
    
          AccessoiresServices as= new AccessoiresServices();
                     List<Accessoires> list= as.ListerAccessoires(idmag);
                  tableview.getItems().setAll(list);
    
    }
       private void initcola(){
   rat.setCellValueFactory(new PropertyValueFactory<>("rating"));
   commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
    
     }

      private void listavis()  {
    
          AvisServices av= new AvisServices();
                     List<Avis> list= av.ListerAvis(idmag);
                  tableview1.getItems().setAll(list);
    
    }
     
    @FXML
    private void EditeAccessoires(ActionEvent event) throws IOException {
        
         Accessoires accessoires = tableview.getSelectionModel().getSelectedItem();
   
         
         
         
          FXMLLoader loader = new FXMLLoader(getClass().getResource("EditAccessoires.fxml"));    
                           Parent root = loader.load();

         EditAccessoiresController edacc = loader.<EditAccessoiresController>getController();
         edacc.setAId(accessoires.getId());
         edacc.setANom(accessoires.getNom());
         edacc.setAPrix(accessoires.getPrix());
         edacc.setAespece(accessoires.getEspece());
         edacc.setIdmag(accessoires.getId_magasin());
        
         tableview.getScene().setRoot(root);
        
        
    }

    @FXML
    private void DeleteAccessoites(ActionEvent event) {
        Accessoires accessoires = tableview.getSelectionModel().getSelectedItem();
    if (accessoires == null) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("No Accessoire selected");
        al.setHeaderText(null);
        al.setContentText("Please select Accessoire for deletion.");
        al.showAndWait();
            return;
        }
      Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("DeletingAccessoire");
      alert.setContentText("are you sure want to delete the Accessoire "+accessoires.getNom()+"?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK)
        {
         AccessoiresServices as= new AccessoiresServices();
        as.SupprimerAccessoires(accessoires.getId());
       listaccessoires();
         
        }
     
        
    }


    @FXML
    private void ListeMagasin(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeMagasin.fxml"));    
                           Parent root = loader.load();

         ListeMagasinController liste = loader.getController();
         liste.initialize(null, null);
         tableview.getScene().setRoot(root);

        
    }

   
    
}
