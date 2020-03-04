/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.Association_services;
import pidev.Zanimaux.entities.Association;

/**
 * FXML Controller class
 *
 * @author abdelaziz
 */
public class AssociationController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField adress;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextArea desciption;
    @FXML
    private Button buttonAjouter;
    @FXML
    private Button buttonModifier;
    @FXML
    private Button buttonSupp;
    @FXML
    private AnchorPane TabAssocia;
    @FXML
    private TextField rechercheAssocia;
    @FXML
    private TableColumn<Association, String> nametab;
    @FXML
    private TableColumn<Association, String> adresstab;
    @FXML
    private TableColumn<Association, String> phonetab;
    @FXML
    private TableColumn<Association, String> emailtab;
    @FXML
    private TableColumn<Association, String> dscriptiontab;
     private ObservableList<Association> Associations = FXCollections.observableArrayList();
    @FXML
    private TableView<Association> tabAssociation;
    @FXML
    private Button buttonRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      afficherAssociation();
      
        tabAssociation.setOnMouseClicked((MouseEvent event) -> {
           name.setText(Associations
                    .get(tabAssociation.getSelectionModel().getSelectedIndex())
                    .getName());
            adress.setText(Associations
                    .get(tabAssociation.getSelectionModel().getSelectedIndex())
                    .getAdress());
            phone.setText(Associations
                    .get(tabAssociation.getSelectionModel().getSelectedIndex())
                    .getPhone());
            email.setText(Associations
                    .get(tabAssociation.getSelectionModel().getSelectedIndex())
                    .getEmail());
            desciption.setText(Associations
                    .get(tabAssociation.getSelectionModel().getSelectedIndex())
                    .getDescription());
        });
        
           buttonRetour.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilAdmin.fxml"));
                Region root = (Region) loader.load();
                AccueilAdminController ac1 = loader.<AccueilAdminController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
           
           
           FilteredList<Association> listeFiltre = new FilteredList<>(Associations, e -> true);
        rechercheAssocia.textProperty().addListener((observableValue, oldValue, newValue) -> {
            listeFiltre.setPredicate((Predicate<? super Association>) candidat -> {
                System.out.println(newValue);

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (candidat.getName().contains(newValue)) {
                    return true;
                }
                return false;
            });
            SortedList<Association> CandidatTries = new SortedList<>(listeFiltre);
            CandidatTries.comparatorProperty().bind(tabAssociation.comparatorProperty());
            tabAssociation.setItems(CandidatTries);
        });

        
        
        
        
    }    
     private void afficherAssociation() {

        Associations.clear();
         Association_services sv_b = new Association_services();

        Associations = sv_b.getAll();
        tabAssociation.setItems(Associations);
        
        nametab.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getName()));
        adresstab.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getAdress())); 
        phonetab.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getPhone()));
         emailtab.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getEmail()));
         dscriptiontab.setCellValueFactory((TableColumn.CellDataFeatures<Association, String> Association) -> new SimpleObjectProperty(Association.getValue().getDescription()));
        
    }
     
      @FXML
    private void AjoutAssociation(ActionEvent event) throws SQLException, ParseException {

        Association e = new Association(name.getText(), adress.getText(), phone.getText(), email.getText(),desciption.getText());
        Association_services es = new Association_services();
        es.insertA(e);
         afficherAssociation();

    }
    
    
    @FXML
    private void updateart(ActionEvent event) throws SQLException, ParseException {
    
       int id=tabAssociation.getSelectionModel().getSelectedItem().getId();
      Association ev=new Association(id, name.getText(),adress.getText(), phone.getText(), email.getText(),desciption.getText());
         Association_services es = new Association_services();
            es.updateA(ev);
           afficherAssociation();
    }

    @FXML
    private void deleteart(ActionEvent event) throws SQLException {
        
        Association_services crud = new Association_services();

        ObservableList<Association> selectedRows, arti;
        arti = tabAssociation.getItems();
        selectedRows = tabAssociation.getSelectionModel().getSelectedItems();

        for (Association a : selectedRows) {
           
            System.out.println(a.getId());
            int id = a.getId();

            crud.deleteA(a);

        }
           afficherAssociation();
    }
    
     


     
     
}
