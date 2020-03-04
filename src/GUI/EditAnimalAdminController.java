/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import pidev.Zanimaux.Services.AnimalServices;
import pidev.Zanimaux.entities.Animal;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author souad
 */
public class EditAnimalAdminController implements Initializable {

     int id;
    int AId;
    String Aespece;
    int Aage;
    String Arace;
    String Asexe;
    String Adescription;
    int idmag;
    @FXML
    private TextField espece;
    @FXML
    private TextField race;
    @FXML
    private TextField sexe;
    @FXML
    private TextField description;
    @FXML
    private TextField age;
    @FXML
    private Button editanim;
    @FXML
    private Button retour;
    @FXML
    private ImageView imgviewadd;

    
    public void setAId(Integer AId) {
        this.AId = AId;
         id= AId;

    }
    
    
     public void setAdescription(String Adescription) {
        this.Adescription = Adescription;
         description.setText (String.valueOf(this.Adescription));

    }
    
      public void setAespece(String Aespece) {
        this.Aespece = Aespece;
         espece.setText (String.valueOf(this.Aespece));

    }

    

    public void setArace(String Arace) {
        this.Arace= Arace;
                 race.setText (String.valueOf(this.race));

       }
   
    public void setAage(int Aage) {
        this.Aage = Aage;
              age.setText(String.valueOf(this.Aage));}

    public void setAsexe(String Asexe) {
        this.Asexe = Asexe;
         sexe.setText (String.valueOf(this.Asexe));

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
        String image_path;


    @FXML
    private void load(ActionEvent event) throws MalformedURLException{
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

    @FXML
    private void EditAnimal(ActionEvent event) throws SQLException, IOException {
           Animal a=new Animal(id, espece.getText(),race.getText(),sexe.getText(),description.getText(),(Integer.parseInt(age.getText())));
         a.setImg(image_path);
            AnimalServices as = new AnimalServices();
            as.updateAn(a);
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
