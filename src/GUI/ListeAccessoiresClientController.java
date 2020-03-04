/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import static GUI.LoginController.usernid;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class ListeAccessoiresClientController implements Initializable {
    private TableColumn<Accessoires, String> nom;
    private TableColumn<Accessoires, Float> prix;
    @FXML
    private Button listmag;
    private TableView<Accessoires> tableview;
    private TableColumn<Accessoires, String> espece;
    @FXML
    private TableView<Avis> tableview1;
    @FXML
    private TableColumn<Avis, Integer> rat;
    @FXML
    private TableColumn<Avis, String> commentaire;
    @FXML
    private Rating rating;
    @FXML
    private TextField message;
 int idmag;
    @FXML
    private ImageView img6;
    @FXML
    private JFXListView<Label> listview;
    @FXML
    private ImageView imgviw;
    @FXML
    private TableColumn<Avis, String> rat1;
    @FXML
    private MenuItem delav;
   

    public void setIdmag(Integer AId) {
        this.idmag= AId;
       }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         initcola();
        listavis();
     
     
        remplirListView();
       
                
                }
    private void remplirListView() {
        AccessoiresServices as= new AccessoiresServices();
                     List<Accessoires> list= as.ListerAccessoires(idmag);
        listview.getItems().clear();
        for(Accessoires a : list)
        {
            Label lbl = new Label("Nom : "+a.getNom()+"\n Prix :"+a.getPrix()+"\n Espece : "+a.getEspece()+ "\n"  );
         String img=a.getImage();
            
            Image image=new Image("http://localhost/integration/symfony3/web/images/"+img,100,50,true,true);
            
                 lbl.setPrefSize(500, 100);
            
                
                ImageView imageView = new ImageView();
                imageView.imageProperty().unbind();
                imageView.setImage(image);
                imageView.setFitWidth(150);
                imageView.setFitHeight(100);
                listview.getItems().add(lbl);
                lbl.setGraphic(imageView);
        }}
        
      
  
     

    @FXML
    private void AfficheMAgasin(ActionEvent event) throws IOException {
        
       Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeMagasinClient.fxml"));
                            Region root = (Region) loader.load();
                           ListeMagasinClientController liste = loader.<ListeMagasinClientController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
            
    }
        private void initcola(){
            
   rat1.setCellValueFactory(new PropertyValueFactory<>("user_name"));
   rat.setCellValueFactory(new PropertyValueFactory<>("rating"));
   commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
    
     }

      private void listavis()  {
    
          AvisServices av= new AvisServices();
                     List<Avis> list= av.ListerAvis(idmag);
                  tableview1.getItems().setAll(list);
    
    }
       
     

    @FXML
    private void ajouterrating(MouseEvent event) {
ClientDAO cd1= new ClientDAO();
              Client a1=cd1.findByID(usernid);
 Avis a = new Avis(((int)rating.getRating()),message.getText(),idmag,a1.getId(),a1.getNom());
              AvisServices as= new AvisServices();
              as.ajouterAvis(a);
               Alert alert=new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("votre avis");
      alert.setHeaderText(null);
      alert.setContentText("merci pour votre avis ");
      alert.showAndWait();
               listavis();
    }

    @FXML
    private void deleteavis(ActionEvent event) {
      
        Avis avis = tableview1.getSelectionModel().getSelectedItem();
        ClientDAO cd1= new ClientDAO();
              Client a1=cd1.findByID(usernid);
   
    if (avis.getUser_id() == a1.getId()) {
        
      Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("DeletingRating");
      alert.setContentText("are you sure want to delete your Rating ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK)
        {
         AvisServices as= new AvisServices();
        as.SupprimerAvis(avis.getId());
       listavis();
    }
    } else{
       Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("Attention");
        al.setHeaderText(null);
        al.setContentText("c n est pas ton rating");
        al.showAndWait();
    
    }}
    
}
