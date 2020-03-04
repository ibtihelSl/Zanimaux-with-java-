/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import static GUI.LoginController.usernid;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.ClientDAO;
import pidev.Zanimaux.Services.Participants_servics;
import pidev.Zanimaux.entities.Client;
import pidev.Zanimaux.entities.EmailController;
import pidev.Zanimaux.entities.Participants;
import pidev.Zanimaux.utils.Myconnexion;
/**
 * FXML Controller class
 *
 * @author abdelaziz
 */
public class AccueilController implements Initializable {

    @FXML
    private Label UC;
    @FXML
    private Label home;
    
    @FXML
    private Label evenement;
    @FXML
    private Label association;
    @FXML
    private Label adoption;
    @FXML
    private Label magasin;
    @FXML
    private Label veterinaire;
    @FXML
    private Label associationimg;
    @FXML
    private Label evenementimg;
    @FXML
    private Label petsitterimg;
    @FXML
    private Label adoptionimg;
    @FXML
    private Label magasinimg;
    @FXML
    private Label assuranceimg;
    @FXML
    private Label veterinaireimg;
    @FXML
    private Button logoutButton;
    @FXML
    private Label assurance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       mail();
        
        
        
        logoutButton.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                Region root = (Region) loader.load();
                LoginController ac1 = loader.<LoginController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
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
           magasin.setOnMouseClicked((MouseEvent event) -> {
              try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeMagasinClient.fxml"));
                            Region root = (Region) loader.load();
                           ListeMagasinClientController ac1 = loader.<ListeMagasinClientController>getController();
                           
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
         
          assurance.setOnMouseClicked((MouseEvent event) -> {
              try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListAssuranceClient.fxml"));
                            Region root = (Region) loader.load();
                           ListAssuranceClientController ac1 = loader.<ListAssuranceClientController>getController();
                           
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
    
    
    public Label getUC() {
        return UC;
    }

    
    public void setUC(int u) throws SQLException {
         Client p1;
         ClientDAO ctDao=new ClientDAO();
         p1 = ctDao.findByID(usernid);
        this.UC.setText(p1.getNom());
    }
    
    public int getUsernid() {
        return usernid;
    }
    public void setUsernis(int u)
    {  usernid =u;
    }
   public void mail ()
    {
         ObservableList<Participants> data = FXCollections.observableArrayList();
            data.clear();
        Connection cn = Myconnexion.getInstance().getConnection();
        Participants_servics crud=new Participants_servics();
     List<Participants> la=crud.getAllParticicpant();
      
      
           //    ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM `boutique`");
    for(Participants e:la)
    {   
         if(e.getDateDebut().equals(Date.valueOf(LocalDate.now())))
         { EmailController em=new EmailController(e.getParticipant(), "Votre evenement commence aujord'hui", "Titre"+e.getTitre()+"\n"+"Adresse :"+e.getAdresse());
             em.send();
             
        
    }

    
}
    }}