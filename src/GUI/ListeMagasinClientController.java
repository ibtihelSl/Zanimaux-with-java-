/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import static GUI.LoginController.usernid;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.MagasinServices;
import pidev.Zanimaux.entities.Magasin;

/**
 * FXML Controller class
 *
 * @author Touha
 */
public class ListeMagasinClientController implements Initializable {
    @FXML
    private TableView<Magasin> tableview;
    @FXML
    private TableColumn<Magasin, String> nom;
    @FXML
    private TableColumn<Magasin, String> address;
    @FXML
    private TableColumn<Magasin, String> ville;
    @FXML
    private TableColumn<Magasin, String> phone;
    @FXML
    private TextField Recherche;
    @FXML
    private ChoiceBox<String> choiseBox;
    ObservableList<String> comboList = FXCollections.observableArrayList("Nom Magasin", "Adress magasin");
    @FXML
    private Button btnmap;

    static String Magasinadress;
    static String MagasinGouv;
    static String Magasinnom;
    @FXML
    private Label home;
    @FXML
    private Label evenement;
    @FXML
    private Label association;
    @FXML
    private Label adoption;
    @FXML
    private Label petsitter;
    @FXML
    private Label magasin;
    @FXML
    private Label veterinaire;
    @FXML
    private ImageView img6;
    @FXML
    private Button maps;
    @FXML
    private Button listacc;
    @FXML
    private Button acc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(usernid);
         magasin.setOnMouseClicked((MouseEvent event) -> {
              try {
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

                        } catch (IOException ex) {
                            Logger.getLogger(ListeMagasinClientController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            });
          home.setOnMouseClicked((MouseEvent event) -> {
              try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
                            Region root = (Region) loader.load();
                          
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            });
         evenement.setOnMouseClicked((MouseEvent event) -> {
              try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("EvenementClient.fxml"));
                            Region root = (Region) loader.load();
                           EvenementClientController ac1 = loader.<EvenementClientController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            });
         
           
         
         veterinaire.setOnMouseClicked((MouseEvent event) -> {
              try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeVetClient.fxml"));
                            Region root = (Region) loader.load();
                           ListeVetClientController ac1 = loader.<ListeVetClientController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            });
         
         
         
         
          association.setOnMouseClicked((MouseEvent event) -> {
              try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("AssociationClient.fxml"));
                            Region root = (Region) loader.load();
                           AssociationClientController liste = loader.<AssociationClientController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(ListeMagasinClientController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            });
         adoption.setOnMouseClicked((MouseEvent event) -> {
              try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAnimalClient.fxml"));
                            Region root = (Region) loader.load();
                    Gui.ListeAnimalClientController ac1 = loader.<Gui.ListeAnimalClientController>getController();

                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            });
        
        
        choiseBox.setItems(comboList);
         initcol();
        listmagasin();
         Recherche.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    filtrerMagasinList((String) oldValue, (String) newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(ListeMagasinClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    } 
    
    
    void filtrerMagasinList(String oldValue, String newValue) throws SQLException {
        
      MagasinServices ms = new MagasinServices();

      String choix = choiseBox.getValue();
      if (choix.equals("Nom Magasin")){
        ObservableList<Magasin> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            tableview.setItems((ObservableList<Magasin>) ms.ListerMagasin());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Magasin st : tableview.getItems()) {
               
               String filterMAgasinName = st.getNom();

             
                if (filterMAgasinName.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            tableview.setItems(filteredList);
    }
      }
    
      
      else if (choix.equals("Adress magasin")){
        ObservableList<Magasin> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            tableview.setItems((ObservableList<Magasin>) ms.ListerMagasin());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Magasin st : tableview.getItems()) {
               
               String filterMAgasinAdress = st.getAddress();

             
                if (filterMAgasinAdress.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            tableview.setItems(filteredList);
    }
      }
           
      
      
    }
    
    
   private void initcol(){
   nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
   address.setCellValueFactory(new PropertyValueFactory<>("address"));
   ville.setCellValueFactory(new PropertyValueFactory<>("Ville"));
   phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
   
   } 
    
   
    private void listmagasin()  {
    
    MagasinServices ms= new MagasinServices();
                     List<Magasin> list= ms.ListerMagasin();
                  tableview.getItems().setAll(list);
    
    }

    @FXML
    private void GotoMap(ActionEvent event) {
         Magasinadress = tableview.getSelectionModel().getSelectedItem().getAddress();
         MagasinGouv = tableview.getSelectionModel().getSelectedItem().getVille();

         Magasinnom = tableview.getSelectionModel().getSelectedItem().getNom();

         
         
        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("mapsMag.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeMagasinClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

    
   

    @FXML
    private void maps(ActionEvent event) throws IOException {
        Stage st = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Maps.fxml"));    
                            Region root = (Region) loader.load();
       MapsController map = loader.getController();
   
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                              Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }

    @FXML
    private void Listeacceessoires(ActionEvent event) throws IOException {
         Magasin magasin = tableview.getSelectionModel().getSelectedItem(); 
         if (magasin==null){
          Alert alert=new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("liste accessoire");
      alert.setHeaderText(null);
      alert.setContentText("choisir un magasin ");
      alert.showAndWait();
         }else{

        Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAccessoiresClient.fxml"));
                            Region root = (Region) loader.load();
                           ListeAccessoiresClientController liste = loader.<ListeAccessoiresClientController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            liste.setIdmag(magasin.getId());
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }}

    @FXML
    void listaccessselonespece(ActionEvent event) throws IOException, SQLException {
        Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("accessoiresselonespece.fxml"));
                            Region root = (Region) loader.load();
                           AccessoiresselonespeceController access = loader.<AccessoiresselonespeceController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            access.remplirListView();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
        
    }
    
}
