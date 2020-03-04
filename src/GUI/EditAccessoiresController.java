/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.AccessoiresServices;
import pidev.Zanimaux.entities.Accessoires;

/**
 * FXML Controller class
 *
 * @author Touha
 */
public class EditAccessoiresController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
    @FXML
    private Button editAcc;
    int id;
    int AId;
    String ANom;
    float APrix;
    String Aespece;
    @FXML
    private TextField espece;
    @FXML
    private ImageView imgviewadd;

    
    public void setAId(Integer AId) {
        this.AId = AId;
         id= AId;

    }
    
      public void setANom(String ANom) {
        this.ANom = ANom;
         nom.setText (String.valueOf(this.ANom));

    }

    int idmag;
    

    public void setIdmag(Integer AId) {
        this.idmag= AId;
       }
   
    public void setAPrix(Float APrix) {
        this.APrix = APrix;
              prix.setText(String.valueOf(this.APrix));}

    public void setAespece(String Aespece) {
        this.Aespece = Aespece;
         espece.setText (String.valueOf(this.Aespece));

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EditeAccessoire(ActionEvent event) throws IOException {
         Accessoires a=new Accessoires(id, nom.getText(), (Float.parseFloat(prix.getText())),espece.getText());
         a.setImage(image_path);
            AccessoiresServices as = new AccessoiresServices();
            as.ModifierAccessoires(a);
              FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAccessoires.fxml"));    
                           Parent root = loader.load();

        ListeAccessoiresController liste = loader.getController();
        liste.setIdmag(idmag);
         liste.initialize(null,null);
         nom.getScene().setRoot(root);
            
                                   
        
    }
     String image_path;

    @FXML
    private void load(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            image_path = selectedFile.getName().toString();
             Image image = new Image(image_path);
            imgviewadd.setImage(image);
            
        } else {
            System.out.println("fichier invalide");
        }
    }

    
}
