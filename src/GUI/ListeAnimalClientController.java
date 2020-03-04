/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import pidev.Zanimaux.Services.AdoptionService;
import pidev.Zanimaux.Services.AnimalServices;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import pidev.Zanimaux.entities.Adoption;
import pidev.Zanimaux.entities.Animal;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author souad
 */
public class ListeAnimalClientController implements Initializable {

       @FXML
    private Button Adopté;
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
    private Button home;
   
       @FXML
    private TableView<Animal> tableview;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
initcol();
        listanimal();    }   
    
    
    
    
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

        
    private static Animal SelectedItem;

    @FXML
    private void Adopté(ActionEvent event) throws SQLException {
        AnimalServices crud=new AnimalServices();
        
        ObservableList<Animal> selectedRows, arti;
        arti= tableview.getItems();
        selectedRows = tableview.getSelectionModel().getSelectedItems();
           
           
        for(Animal a:selectedRows)
        {
        Animal aa=new Animal();
            Adoption par = new Adoption();
           System.out.println(a.getId());
            int id=a.getId();
          int nreser = a.getNbReservation();
          if (nreser==0)
          {
              nreser = nreser +1;
            a.setNbReservation(nreser);
            crud.updateAn(a);
              //ClientDAO cd1= new ClientDAO();
             // Client a1=cd1.findByID(usernid);
             // par.setAdoption(a1.getMail());
              par.setEspece(a.getEspaceA());
              par.setRace(a.getRaceA());
              AdoptionService ps= new AdoptionService();
          //    ps.insertParti(par);
            
             Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("Confirmation");
        al.setHeaderText(null);
        al.setContentText("  félicitation, vous avez adopté cet animal !");
        al.showAndWait();
            
              
            
          }
          else {
             
       
             
                Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("Confirmation");
        al.setHeaderText(null);
        al.setContentText("  cet animal déja adopté !");
        al.showAndWait();}
            
          

    }}
    
    @FXML
    private void Home(ActionEvent event) throws IOException {

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
                            Logger.getLogger(GUI.AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                        }}
    }
