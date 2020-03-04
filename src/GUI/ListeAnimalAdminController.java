/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import pidev.Zanimaux.Services.AnimalServices;
import pidev.Zanimaux.entities.Animal;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author souad
 */
public class ListeAnimalAdminController implements Initializable {

    @FXML
    private TableColumn<Animal, String> espece;
    @FXML
    private TableColumn<Animal, String> race;
    @FXML
    private TableColumn<Animal, String> sexe;
    @FXML
    private TableColumn<Animal, String> description;
    @FXML
    private TableColumn<Animal, Integer> age;
    @FXML
    private TableColumn<Animal, String> img;
    @FXML
    private TableColumn<Animal, Integer> adopte;
    @FXML
    private Button deleteanim;
    @FXML
    private Button editanim;
    @FXML
    private Button addanim;
    @FXML
    private Button listeadop;
    @FXML
    private TableView<Animal> tableview;
    @FXML
    private TextField Recherche;
    @FXML
    private Button retour;
    @FXML
    private ChoiceBox<String> choiseBox;
        ObservableList<String> comboList = FXCollections.observableArrayList("Espece", "Race");


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initcol();
        listanimal();
           choiseBox.setItems(comboList);
        
         Recherche.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    filtrerAnimalList((String) oldValue, (String) newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(ListeAnimalAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }   
     
    void filtrerAnimalList(String oldValue, String newValue) throws SQLException {
        
      AnimalServices ms = new AnimalServices();

      String choix = choiseBox.getValue();
      if (choix.equals("Espece")){
        ObservableList<Animal> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            tableview.setItems((ObservableList<Animal>) ms.getAll());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Animal st : tableview.getItems()) {
               
               String filterAnimalespace = st.getEspaceA();

             
                if (filterAnimalespace.toUpperCase().matches(newValue)){
                    filteredList.add(st);
                }
            }
      
            tableview.setItems(filteredList);
    }
      }
    
      
      else if (choix.equals("Race")){
        ObservableList<Animal> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            tableview.setItems((ObservableList<Animal>) ms.getAll());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Animal st : tableview.getItems()) {
               
               String filterAnimalRace = st.getRaceA();

             
                if (filterAnimalRace.toUpperCase().matches(newValue)){
                    filteredList.add(st);
                }
            }
      
            tableview.setItems(filteredList);
    }
      }
           
      
      
    }
    
      private void initcol(){
   espece.setCellValueFactory(new PropertyValueFactory<>("especeA"));
   race.setCellValueFactory(new PropertyValueFactory<>("raceA"));
   sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
   description.setCellValueFactory(new PropertyValueFactory<>("description"));
   age.setCellValueFactory(new PropertyValueFactory<>("age"));
   img.setCellValueFactory(new PropertyValueFactory<>("img"));
   adopte.setCellValueFactory(new PropertyValueFactory<>("nbReservation"));
   } 
    
   
    private void listanimal()  {
    
        AnimalServices ms= new AnimalServices();
                     ObservableList<Animal> list= ms.getAll();
                  tableview.getItems().setAll(list);
    
    }

    @FXML
    private void deleteanimal(ActionEvent event) throws SQLException {
         Animal animal = tableview.getSelectionModel().getSelectedItem();
    if (animal == null) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("No Animal selected");
        al.setHeaderText(null);
        al.setContentText("Please select Animal for deletion.");
        al.showAndWait();
            return;
        }
      Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("DeletingAnimal");
      alert.setContentText("are you sure want to delete the animal "+animal.getEspaceA()+"?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK)
        {
         AnimalServices as= new AnimalServices();
        as.deleteAn(animal);
       listanimal();
        
    }}

    @FXML
    private void editanimal(ActionEvent event) throws IOException {
         Animal animal = tableview.getSelectionModel().getSelectedItem();
   
         
         
         
          FXMLLoader loader = new FXMLLoader(getClass().getResource("EditAnimalAdmin.fxml"));    
                           Parent root = loader.load();

         EditAnimalAdminController eda= loader.<EditAnimalAdminController>getController();
         eda.setAId(animal.getId());
         eda.setAespece(animal.getEspaceA());
         eda.setArace(animal.getRaceA());
         eda.setAsexe(animal.getSexe());
         eda.setAdescription(animal.getDescription());
         eda.setAage(animal.getAge());

        
         tableview.getScene().setRoot(root);
    }

    @FXML
    private void addanimal(ActionEvent event) throws IOException {
        Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterAnimalAdmin.fxml"));
                            Region root = (Region) loader.load();
                           AjouterAnimalAdminController liste = loader.<AjouterAnimalAdminController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }

    @FXML
    private void listanimaladopte(ActionEvent event) throws IOException {
         Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAdopteAdmin.fxml"));
                            Region root = (Region) loader.load();
                           ListeAdopteAdminController liste = loader.<ListeAdopteAdminController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }
    
    @FXML
    private void Menu(ActionEvent event) throws IOException {
        Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilAdmin.fxml"));
                Region root = (Region) loader.load();
                GUI.AccueilAdminController ac1 = loader.<GUI.AccueilAdminController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();
    }
    
}
