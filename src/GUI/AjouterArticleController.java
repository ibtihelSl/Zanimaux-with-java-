/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.Zanimaux.entities.Article;
import pidev.Zanimaux.Services.CrudArticle;
import java.io.File;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import javafx.scene.control.TableView;


/**
 * FXML Controller class
 *
 * @author ci
 */
public class AjouterArticleController implements Initializable {
    String image_path;
    @FXML
    private ImageView imgviewadd;

    @FXML
    private TextField Titre;
     @FXML
    private TextArea details;
    ;
    @FXML
    private Button AjouterArticlet;
    @FXML
    private Button retour;
 private TableView<Article> tableview ;
    @FXML
    private Label erreur_titre;
    @FXML
    private Label erreur_description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML 
     private void ajouterarticle(ActionEvent event) throws IOException  {
         Article a = new Article(Titre.getText(),details.getText());
  boolean istitreEmp= validation.TextFieldValidation.isTextFieldNotEmpty(Titre, erreur_titre, "Titre is Required");
      boolean isDetailsEmp= validation.TextFieldValidation.isTextFAreaNotEmpty(details, erreur_description, "Details is Required");

        if (istitreEmp && isDetailsEmp) 
      {
              CrudArticle ms= new CrudArticle();
              ms.ajouterArticle(a);
               FXMLLoader loader = new FXMLLoader(getClass().getResource("ListArticle.fxml"));    
                           Parent root = loader.load();

         ListArticleController liste = loader.getController();
         liste.initialize(null,null);
         Titre.getScene().setRoot(root);
         
         
          TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les Articles");
                    tray.setMessage("Vouz avez ajouter un nouveaux Article");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));
     
    
    
    
      }
     }
    private void load(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            image_path = selectedFile.toURI().toURL().toString();
            Image image = new Image(image_path);
            imgviewadd.setImage(image);
        } else {
            System.out.println("fichier invalide");
        }
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
       Article articles = new Article();

         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ListArticle.fxml"));    
                           Parent root = loader.load();
                          ListArticleController liste = loader.<ListArticleController>getController(); 
                            liste.initialize(null,null);
                                           tableview.getScene().setRoot(root);

    }
    

}
