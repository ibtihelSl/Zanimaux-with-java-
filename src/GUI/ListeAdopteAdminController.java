/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import pidev.Zanimaux.Services.AdoptionService;
import pidev.Zanimaux.Services.AnimalServices;
import pidev.Zanimaux.entities.Adoption;
import pidev.Zanimaux.entities.Animal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author souad
 */
public class ListeAdopteAdminController implements Initializable {

    @FXML
    private TableColumn<Adoption , String> espece;
    @FXML
    private TableColumn<Adoption , String> race;
    @FXML
    private TableColumn<Adoption , String> email;
    @FXML
    private Button Retour;
    @FXML
    private TableView<Adoption> tableview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 initcol();
        listadopte();    } 
      private void initcol(){
   espece.setCellValueFactory(new PropertyValueFactory<>("espece"));
   race.setCellValueFactory(new PropertyValueFactory<>("race"));
   email.setCellValueFactory(new PropertyValueFactory<>("adoption"));
   
   } 
    
   
    private void listadopte()  {
    
        AdoptionService ms= new AdoptionService();
                     ObservableList<Adoption> list= ms.getAllAdoptions();
                  tableview.getItems().setAll(list);
    
    }
    

    @FXML
    private void ListeAnimal(ActionEvent event) throws IOException {
        Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAnimalAdmin.fxml"));
      Region root = (Region) loader.load();
                           ListeAnimalAdminController liste = loader.<ListeAnimalAdminController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }
    
}
