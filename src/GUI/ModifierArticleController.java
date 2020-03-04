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
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ci
 */
public class ModifierArticleController implements Initializable {
 @FXML
    private TextField Titre;
    @FXML
    private TextField details;
     @FXML
    private TextField veterinaire_id;
    @FXML
    private Button editArticle;
    int id;
    int AId;
    String ATitre;
    String ADetails;
    int AVeterinaire_id;

 

  
    public void setAId(int AId) {
        this.AId = AId;
                 id= this.AId;

    }

    

    public void setATitre(String ATitre) {
        this.ATitre = ATitre;
                Titre.setText (String.valueOf(this.ATitre));

    }

   

    public void setADetails(String ADetails) {
        this.ADetails = ADetails;
        details.setText (String.valueOf(this.ADetails));

    }

   

   /* public void setAVeterinaire_id(int AVeterinaire_id) {
        this.AVeterinaire_id = AVeterinaire_id;
        veterinaire_id.setText (String.valueOf(this.AVeterinaire_id));

    }
    */
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void EditeArticle(ActionEvent event) throws IOException {
         Article a = new Article(id,Titre.getText(),details.getText());
          CrudArticle as = new CrudArticle();
            as.ModifierArticle(a);
              FXMLLoader loader = new FXMLLoader(getClass().getResource("ListArticle.fxml"));    
                           Parent root = loader.load();

        ListArticleController liste = loader.getController();
         liste.initialize(null,null);
         Titre.getScene().setRoot(root);
         
            
         
         TrayNotification tray = new TrayNotification();
                    tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("les Articles");
                    tray.setMessage("Vouz avez modifier cet article");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(2500));

                    tray.setRectangleFill(Color.valueOf("#f78c37"));
    }
    
 @FXML
    private void cancel(ActionEvent event) throws IOException {
     exit();
          
}
}
