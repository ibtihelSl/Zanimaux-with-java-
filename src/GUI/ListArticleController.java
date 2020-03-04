/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.Zanimaux.entities.Article;
import pidev.Zanimaux.entities.Comment;
import pidev.Zanimaux.Services.CrudArticle;
import pidev.Zanimaux.Services.CrudComment;
import pidev.Zanimaux.utils.Myconnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
public class ListArticleController implements Initializable {
    
     
    @FXML
    private MenuItem editArticle;
 
    
    @FXML
    private MenuItem deleteArticle;
    @FXML
    private TableColumn<Article, String> Titre;
    @FXML
    private TableColumn<Article, String> details;
    @FXML
    private TableView<Article> tableview;
    @FXML
    private Button addArticle;
    @FXML
    private Button home;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initcol();
        listarticle();
    }    
    
     private void initcol(){
   Titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
   details.setCellValueFactory(new PropertyValueFactory<>("details"));

     }

      private void listarticle()  {
    
          CrudArticle as= new CrudArticle();
                     List<Article> list= as.ListerArticle();
                  tableview.getItems().setAll(list);
    
    }
     
    @FXML
    private void EditeArticle(ActionEvent event) throws IOException {
        
         Article article = tableview.getSelectionModel().getSelectedItem();
   
         
         
         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierArticle.fxml"));    
                           Parent root = (Region) loader.load();

         ModifierArticleController art = loader.<ModifierArticleController>getController();
         art.setAId(article.getId());
         art.setATitre(article.getTitre());
         art.setADetails(article.getDetails());
            //      art.setAVeterinaire_id(article.getVeterinaire_id());

        
         tableview.getScene().setRoot(root);

        
        
    }

    @FXML
    private void DeleteArticle(ActionEvent event) {
        Article articles = tableview.getSelectionModel().getSelectedItem();
    if (articles == null) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("No Article selected");
        al.setHeaderText(null);
        al.setContentText("Please select Article for deletion.");
        al.showAndWait();
            return;
        }
      Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("DeletingArticle");
      alert.setContentText("are you sure want to delete the Article "+articles.getTitre()+"?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK)
        {
         CrudArticle as= new CrudArticle();
        as.SupprimerArticle(articles.getId());
       listarticle();
         
       TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les Articles");
                    tray.setMessage("Vouz avez supprimer cet article");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));
        }
     
        
    }

    @FXML
    private void AjouterArticle(ActionEvent event) throws IOException {
               Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterArticle.fxml"));    
                           Parent root = loader.load();

         AjouterArticleController liste = loader.getController();
       
                  tableview.getScene().setRoot(root);

      
                   
    }
    
               

       
       
    
    
/*@FXML
    private void AddToBasketAction(ActionEvent event) throws SQLException {

        CrudArticle pps = new CrudArticle();
        
        Article a = new Article();

        a.setId(MyConnection.art.getId());

        a.setId(selectedArticle.getId());
       a.setTitre(selectedArticle.getTitre());

       
        pps.ajouterArticle(a);
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle("product "+ selectedArticle.getTitre() +" added to basket");
        tray.setMessage("you added"+qteTextField.getText()+" "+selectedArticle.getTitre()+" to basket");
       
        tray.showAndDismiss(Duration.seconds(1));
    }
*/
    private void ListeArticle(ActionEvent event) throws IOException {
         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ListArticle.fxml"));    
                           Parent root = loader.load();

         ListArticleController liste = loader.getController();
       
                  tableview.getScene().setRoot(root);

        
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilAdmin.fxml"));    
                           Parent root = loader.load();

         AccueilAdminController liste = loader.getController();
       
                  tableview.getScene().setRoot(root);
    }
    
    
}
