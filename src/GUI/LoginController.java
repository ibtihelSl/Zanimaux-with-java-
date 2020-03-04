/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import animations.FadeInLeftTransition1;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

import animations.FadeInRightTransition;
import pidev.Zanimaux.Services.ClientDAO;
import pidev.Zanimaux.entities.Client;
/**
 * FXML Controller class
 *
 * @author abdelaziz
 */
public class LoginController implements Initializable {

    @FXML
    private ImageView img1;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Text lblUserLogin;
    @FXML
    private Text lblPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button insrire;
    static int usernid;
    static int patid;
    @FXML
    private Label lblClose;
     Stage stage;
    @FXML
    private ComboBox<String> combobox = new ComboBox<>();
    @FXML
    private Text aslabel;
    @FXML
    private Text lblUsername;
    @FXML
    private Text labC;
     private void msgbox(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // anv.setVisible(false);
        Platform.runLater(() -> {
            txtUsername.setPromptText("entrer le login");
            txtPassword.setPromptText("entrer le mot de passe");
            new FadeInRightTransition(lblUserLogin).play();
             new FadeInLeftTransition1(lblPassword).play();
            new FadeInLeftTransition1(lblUsername).play();
            new FadeInLeftTransition1(txtUsername).play();
            new FadeInLeftTransition1(txtPassword).play();
            new FadeInRightTransition(btnLogin).play();
            new FadeInRightTransition(aslabel).play();
           
              combobox.getItems().addAll("Administrateur", "Client");
                 new FadeInRightTransition(combobox).play();
                 
                  new FadeInRightTransition(lblClose).play();
            new FadeInLeftTransition1(insrire).play();
            new FadeInRightTransition(labC).play();
            lblClose.setOnMouseClicked((MouseEvent event) -> {
                Platform.exit();
                System.exit(0);
            });
        });
        
        
        insrire.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterC.fxml"));
                Region root = (Region) loader.load();
                AjouterCController ac1 = loader.<AjouterCController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        // TODO
    }  
    
     @FXML
    private void aksiLogin(ActionEvent event) throws SQLException, IOException {
        String user = txtUsername.getText();
        String pswd = txtPassword.getText();
         ClientDAO ctDao = new ClientDAO();
       
       String val = combobox.getValue();
           
        switch (val) {
            case"":
                msgbox("choisir utilisateur");
                break;
            
            case "Administrateur":

                if ((user.equals("admin")) && (pswd.equals("0000"))) {
                   // config2 config = new config2();
                    //config.newStage2(stage, btnLogin, "Evenement.fxml", "Sample Apps", true, StageStyle.UNDECORATED, false);
                  Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilAdmin.fxml"));
                            Region root = (Region) loader.load();
                           AccueilAdminController ac1 = loader.<AccueilAdminController>getController();
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            //st.setMaximized(true);
                            //st.initStyle(StageStyle.UNDECORATED);
                            st.setScene(scene);
                            st.show();

                
                } //Control saisi
                else {
                    msgbox("Données invalides , Verifier les champs !");
                    txtUsername.setText("");
                    txtPassword.setText("");
                }

                break;

            case "Client":
                if ((user.length() > 0) && (pswd.length() > 0)) {
                    Client p1;
                    p1 = ctDao.findByLogin(user);
                    System.out.println(p1);
                    if (p1 == null) {
                        msgbox("  Veuillez vous inscrire !");
                    } else{
                    if (user.equals(p1.getLogin()) && pswd.equals(p1.getMdp()) && p1.getEtat() == 1) {
                        try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
                            Region root = (Region) loader.load();
                           AccueilController ac1 = loader.<AccueilController>getController();

                           usernid = p1.getId();
                            ac1.setUC(usernid);

                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            //st.setMaximized(true);
                            //st.initStyle(StageStyle.UNDECORATED);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (user.equals(p1.getLogin()) && pswd.equals(p1.getMdp()) && p1.getEtat() == 0) {
                        msgbox("  Compte blocké !");
                    } else if (!(user.equals(p1.getLogin()) && pswd.equals(p1.getMdp()))) {
                        msgbox("  Login ou mot de passe erroné !");
                    }
                } }
                else {
                    msgbox("Données invalides, Verifier les champs !");
                    txtUsername.setText("");
                    txtPassword.setText("");
                }

                break;
        }
    }

    public void setLabC(String labC) {
        this.labC.setText(labC);
    }
    
    
    
}
