/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.MagasinServices;
import pidev.Zanimaux.entities.Magasin;

/**
 * FXML Controller class
 *
 * @author Touha
 */
public class EditMagasinController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField address;
    @FXML
    private TextField ville;
    @FXML
    private TextField phone;
    int id;
    int Mid;
    String Mnom;
    String Maddress;
    String Mville;
    String Mphone;
    
         public void setMid(Integer Mid) {
        this.Mid = Mid;
         id= Mid;

    }
    
      public void setMnom(String Mnom) {
        this.Mnom = Mnom;
         nom.setText (String.valueOf(this.Mnom));

    }

    
   
    public void setMaddress(String Maddress) {
        this.Maddress = Maddress;
              address.setText(this.Maddress);

    }
   
 public void setMville(String Mville) {
        this.Mville = Mville;
                ville.setText(this.Mville);

    }
 
   public void setMphone(String Mphone) {
        this.Mphone = Mphone;
                phone.setText(this.Mphone);

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
            // TODO
       
    }   
    

    private void cancel(ActionEvent event) throws IOException {
     exit();
          
    
    }

    @FXML
    private void modifiermagasin(ActionEvent event) throws IOException {
          Magasin m=new Magasin(id, nom.getText(), address.getText(), ville.getText(), phone.getText());
            MagasinServices ms= new MagasinServices();
            ms.ModifierMagasin(m);
            

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeMagasin.fxml"));
            Parent root = loader.load();
            
            ListeMagasinController liste = loader.getController();
            liste.initialize(null, null);
            nom.getScene().setRoot(root);
    }

  
}
