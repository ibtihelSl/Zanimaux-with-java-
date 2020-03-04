/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.Event_services;

/**
 * FXML Controller class
 *
 * @author Touha
 */
import pidev.Zanimaux.entities.Association;
import pidev.Zanimaux.entities.Event;
import pidev.Zanimaux.utils.Myconnexion;
import pidev.Zanimaux.Services.Association_services;
public class AssociationClientController implements Initializable {

    @FXML
    private Label home;
    @FXML
    private Label evenement;
    @FXML
    private Label association;
    @FXML
    private Label adoption;
    @FXML
    private Label veterinaire;
    @FXML
    private Label magasin;
    @FXML
    private TableView<Association> tabAssocia;
     private ObservableList<Association> Associations = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Association, String> nom;
    @FXML
    private TableColumn<Association, String> adresse;
    @FXML
    private TableColumn<Association, String> phone;
    @FXML
    private TableColumn<Association, String> email;
    @FXML
    private TableColumn<Association, String> description;
    @FXML
    private TextField recherche;
    @FXML
    private ChoiceBox<String> choiseBox;
    ObservableList<String> comboList = FXCollections.observableArrayList("Nom","Adresse");
    @FXML
    private Label petsitter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            listAssociationC();
        } catch (SQLException ex) {
            Logger.getLogger(AssociationClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setOnMouseClicked((MouseEvent event) -> {
              try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
                            Region root = (Region) loader.load();
                           AccueilController ac1 = loader.<AccueilController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(AssociationClientController.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(AssociationClientController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            });
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
                            Logger.getLogger(AssociationClientController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            });
        
         choiseBox.setItems(comboList);
         
         recherche.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    filtrerAssociationList((String) oldValue, (String) newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(AssociationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        
    }    
    
    
     void filtrerAssociationList(String oldValue, String newValue) throws SQLException {
        
     Association_services ms = new Association_services();

      String choix = choiseBox.getValue();
      if (choix.equals("Nom")){
        ObservableList<Association> filteredList = FXCollections.observableArrayList();
        if (recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            tabAssocia.setItems((ObservableList<Association>) ms.getAll());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Association st :  tabAssocia.getItems()) {
               
               String filterAssociationTitre = st.getName();

             
                if (filterAssociationTitre.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
           tabAssocia.setItems(filteredList);
    }
      }
    
      
      else if (choix.equals("Adresse")){
        ObservableList<Association> filteredList = FXCollections.observableArrayList();
        if (recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
             tabAssocia.setItems((ObservableList<Association>) ms.getAll());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Association st :  tabAssocia.getItems()) {
               
               String filterAssociationString = st.getAdress();

             
                if (filterAssociationString.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            tabAssocia.setItems(filteredList);
    }
      }
           
      
      
    }
 
    
    
    private void listAssociationC() throws SQLException {
           
        Associations.clear();
         Association_services sv_b = new Association_services();

        Associations = sv_b.getAll();
        tabAssocia.setItems(Associations);
        
        nom.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getName()));
        adresse.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getAdress())); 
        phone.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getPhone()));
         email.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getEmail()));
         description.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getDescription()));
        
        
        
        
 }
    
    
    
}
