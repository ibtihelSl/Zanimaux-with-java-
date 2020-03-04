/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.Zanimaux.entities.Article;
import pidev.Zanimaux.Services.CrudArticle;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ci
 */
public class ArticleClientController implements Initializable {
    
        @FXML
    private TableColumn<Article, String> Titre;
    @FXML
    private TableColumn<Article, String> details;

    
       @FXML
    private TableView<Article> tableview;
    @FXML
    private TextField Recherche;
    @FXML
    private ChoiceBox<String> choiseBox;
        ObservableList<String> comboList = FXCollections.observableArrayList("Titre","Details");
    
        public static String T;
        public static String D;
    @FXML
    private Button retour;
        
       
        
       void filtrerVeterinaireList(String oldValue, String newValue) throws SQLException {
        
     CrudArticle ms = new CrudArticle();

      String choix = choiseBox.getValue();
      if (choix.equals("Titre")){
        ObservableList<Article> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            tableview.setItems((ObservableList<Article>) ms.ListerArticle());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Article st : tableview.getItems()) {
               
               String filterVetName = st.getTitre();

             
                if (filterVetName.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            tableview.setItems(filteredList);
    }
      }else if (choix.equals("Details")){
        ObservableList<Article> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            tableview.setItems((ObservableList<Article>) ms.ListerArticle());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Article st : tableview.getItems()) {
               
               String filterVetVille = st.getDetails();

             
                if (filterVetVille.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            tableview.setItems(filteredList);
    }
     
      }}
       
        private void initcol(){
   Titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
   details.setCellValueFactory(new PropertyValueFactory<>("details"));

     }

      private void listarticle()  {
    
          CrudArticle as= new CrudArticle();
                     List<Article> list= as.ListerArticle();
                  tableview.getItems().setAll(list);
                  
                  tableview.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->selectedArticle(newValue));
      }
      
      public void selectedArticle(Article a){
                          Article articles = tableview.getSelectionModel().getSelectedItem();

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.fxml"));
                Parent root = loader.load();
                DetailsController liste = loader.<DetailsController>getController();
                liste.setAid(a.getId());
                T=a.getTitre();
                D=a.getDetails();
                liste.initialize(null,null);
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();
            } catch (IOException ex) {
                Logger.getLogger(ArticleClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      }
      
    
    
  /*           
    private void Details(ActionEvent event) throws IOException {
                Article articles = tableview.getSelectionModel().getSelectedItem();

         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.fxml"));    
                           Parent root = loader.load();
                           DetailsController liste = loader.<DetailsController>getController(); 
                           liste.setAid(articles.getId());
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }*/
   
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initcol();
        listarticle();
choiseBox.setItems(comboList);

    Recherche.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    filtrerVeterinaireList((String) oldValue, (String) newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(ArticleClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         });
    }    

    @FXML
    private void ListVeterinaire(ActionEvent event) {
        try
        {
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
    }
    
}
