/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.LoginController.usernid;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import GUI.LoginController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import pidev.Zanimaux.Services.ClientDAO;
import pidev.Zanimaux.Services.Event_services;
import pidev.Zanimaux.Services.Participants_servics;
import pidev.Zanimaux.entities.Client;
import pidev.Zanimaux.entities.Event;
import pidev.Zanimaux.entities.Participants;
import pidev.Zanimaux.utils.Myconnexion;

        
/**
 * FXML Controller class
 *
 * @author abdelaziz
 */
public class EvenementClientController implements Initializable {

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
    private ImageView img11;
    @FXML
    private TableColumn<Event, String> titre2;
    @FXML
    private TableColumn<Event, String> adresse2;
    @FXML
    private TableColumn<Event, Date> datedebut2;
    @FXML
    private TableColumn<Event, Date> datefin2;
    @FXML
    private TableColumn<Event, String> type2;
    @FXML
    private TableColumn<Event, Integer> nbrplace2;
    @FXML
    private TableColumn<Event, String> details2;
    @FXML
    private Button participerbutton;
    @FXML
    private TableView<Event> tabEventC;
     private ObservableList<Event> Events = FXCollections.observableArrayList();
    

    @FXML
    private TextField Recherche;
    private void msgbox(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(usernid);
        try {
            listEventC();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementClientController.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(EvenementClientController.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(EvenementClientController.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(ListeMagasinClientController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
        
        
        // TODO
        
    }  
      
    
    private void listEventC() throws SQLException {
           ObservableList<Event> data = FXCollections.observableArrayList();
            data.clear();
        Connection cn = Myconnexion.getInstance().getConnection();
        Event_services crud=new Event_services();
     List<Event> la=crud.getAll();
      
      
           //    ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM `boutique`");
    for(Event e:la)
    {   
         if(e.getDate_fin().after(Date.valueOf(LocalDate.now())))
         {
        data.add(e);
        
        titre2.setCellValueFactory(cell -> cell.getValue().getTitreO());
        adresse2.setCellValueFactory(cell -> cell.getValue().getAdresseO());
        datedebut2.setCellValueFactory((TableColumn.CellDataFeatures<Event, Date> Event ) -> new SimpleObjectProperty(Event.getValue().getDate_debut()));
        datefin2.setCellValueFactory((TableColumn.CellDataFeatures<Event, Date> Event ) -> new SimpleObjectProperty(Event.getValue().getDate_fin()));
        type2.setCellValueFactory((TableColumn.CellDataFeatures<Event, String> Event ) -> new SimpleObjectProperty(Event.getValue().getType()));
       nbrplace2.setCellValueFactory((TableColumn.CellDataFeatures<Event, Integer> Event ) -> new SimpleObjectProperty(Event.getValue().getNombre_place()));
       details2.setCellValueFactory((TableColumn.CellDataFeatures<Event, String> Event ) -> new SimpleObjectProperty(Event.getValue().getDetails()));
       
     
      
          tabEventC.setItems(null);  
        tabEventC.setItems(data); 
         } else
         {   
             e.setArchive(1);
      
            
          
            crud.updateR(e);
   
         }
    }        
        
        
        
        
        
 }
    
    
     @FXML
    private void Participer(ActionEvent event) throws SQLException, ParseException {
      // Connection cn= DataSource.getInstance().getConnection();
       Event_services crud=new Event_services();
        
        ObservableList<Event> selectedRows, arti;
        arti= tabEventC.getItems();
        selectedRows = tabEventC.getSelectionModel().getSelectedItems();
           
           
        for(Event a:selectedRows)
        {
        Event aa=new Event();
            Participants par = new Participants();
           System.out.println(a.getId());
            int id=a.getId();
          int nreser = a.getNombre_reserve();
          if (nreser<a.getNombre_place())
          {
              nreser = nreser +1;
            a.setNombre_reserve(nreser);
            crud.updateR(a);
              ClientDAO cd1= new ClientDAO();
              Client a1=cd1.findByID(usernid);
              par.setParticipant(a1.getMail());
              par.setTitre(a.getTitre());
              par.setAdresse(a.getAdresse());
              par.setDateDebut(a.getDate_debut());
              Participants_servics ps= new Participants_servics();
              ps.insertParti(par);
            
            
            
            msgbox("  vous ete inscrit dans cet evenement !");
            
          }
          else {
              msgbox("  y a plus de place dans cette evenement !");
          }
   

    }}
    
    
    
    
    
}
