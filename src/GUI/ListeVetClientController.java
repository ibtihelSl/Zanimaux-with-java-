/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXListView;
import pidev.Zanimaux.entities.Article;
import pidev.Zanimaux.entities.FaqQuestions;
import pidev.Zanimaux.entities.assurance;
import pidev.Zanimaux.entities.veterinaires;
import pidev.Zanimaux.Services.CrudVeterinaires;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ci
 */
public class ListeVetClientController implements Initializable {
    private TableView<veterinaires> tableview;
    private TableColumn<veterinaires, String> nom;
    private TableColumn<veterinaires, String> address;
    private TableColumn<veterinaires, String> ville;
    private TableColumn<veterinaires, String> phone;
    private TableColumn<veterinaires, String> email;
   @FXML
    private ImageView g6;
   
    ObservableList<String> comboList = FXCollections.observableArrayList("Nom veterinaire", "Ville veterinaire");
    
    @FXML
    private Button art;
    @FXML
    private JFXListView<Label> listview;
    @FXML
    private Button assur;
    @FXML
    private Button FaqQuestion;
    @FXML
    private Button home;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                
        // System.out.println(usernid);
        /* veterinaire.setOnMouseClicked((MouseEvent event) -> {
              try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeVetClient.fxml"));
                            Region root = (Region) loader.load();
                           ListeVetClientController liste = loader.<ListeVetClientController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(ListeVetClientController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            });*/
       //  choiseBox.setItems(comboList);
       /*  initcol();
        listVet();*/
        remplirListView();
        // Recherche.textProperty().addListener(new ChangeListener() {
          /*  @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    filtrerVeterinaireList((String) oldValue, (String) newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(ListeVetClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         });*/
                 }

  
    
     
      /*void filtrerVeterinaireList(String oldValue, String newValue) throws SQLException {
        
     CrudVeterinaires ms = new CrudVeterinaires();

      String choix = choiseBox.getValue();
      if (choix.equals("Nom Veterinaire")){
        ObservableList<veterinaires> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listview.setItems((ObservableList<veterinaires>) ms.ListerVeterinaires());

        }else{ 
            newValue = newValue.toUpperCase();
            for (veterinaires st : tableview.getItems()) {
               
               String filterVetName = st.getNom();

             
                if (filterVetName.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            tableview.setItems(filteredList);
    }
      }
    
      
      else if (choix.equals("Ville Veterinaire")){
        ObservableList<veterinaires> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            tableview.setItems((ObservableList<veterinaires>) ms.ListerVeterinaires());

        }else{ 
            newValue = newValue.toUpperCase();
            for (veterinaires st : tableview.getItems()) {
               
               String filterVetVille = st.getVille();

             
                if (filterVetVille.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            tableview.setItems(filteredList);
    }
      }
      }*/
         
       private void remplirListView() {
        CrudVeterinaires cv= new CrudVeterinaires();
                     List<veterinaires> list= cv.ListerVeterinaires();
        listview.getItems().clear();
        for(veterinaires a : list)
        {
            Label lbl = new Label(" Nom : "+a.getNom()+"\n addresse :"+a.getAddress()+"\n Ville : "+a.getVille()+ "\n Phone :" +a.getPhone()+"\n Email :"+a.getEmail()+"\n" );
              String img=a.getNom_image();
            
              Image image=new Image("http://localhost/integration/symfony3/web/images/"+img,100,50,true,true);
            
                 lbl.setPrefSize(500, 100);
            
                
                ImageView imageView = new ImageView();
                imageView.imageProperty().unbind();
                imageView.setImage(image);
                imageView.setFitWidth(150);
                imageView.setFitHeight(100);
                listview.getItems().add(lbl);
                lbl.setGraphic(imageView);
        }}
      
     /*  private void initcol(){
   nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
   address.setCellValueFactory(new PropertyValueFactory<>("address"));
   ville.setCellValueFactory(new PropertyValueFactory<>("Ville"));
   phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
   email.setCellValueFactory(new PropertyValueFactory<>("Email"));
   } 
    
   
    private void listVet()  {
            veterinaires vet = tableview.getSelectionModel().getSelectedItem(); 

        CrudVeterinaires ms= new CrudVeterinaires();
                     List<veterinaires> list= ms.ListerVeterinaires();
                  tableview.getItems().setAll(list);
                 
    
    }*/
    @FXML
    private void ListeArticle(ActionEvent event) throws IOException {
       
 try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ArticleClient.fxml"));
                            Region root = (Region) loader.load();
                          ArticleClientController ac1 = loader.<ArticleClientController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
        /* Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ArticleClient.fxml"));    
                           Parent root = loader.load();
                          ArticleClientController liste = loader.<ArticleClientController>getController(); 
                            liste.initialize(null,null);
          tableview.getScene().setRoot(root);*/

    }
     @FXML
    private void ListeAssurance(ActionEvent event) throws IOException {
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
         /*Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ListAssuranceClient.fxml"));    
                           Parent root = loader.load();
                          
                          ListAssuranceClientController liste = loader.<ListAssuranceClientController>getController(); 
                            liste.initialize(null,null);
                                         tableview.getScene().setRoot(root);*/

    
    }

   /* @FXML
    private void FaqQuestion(ActionEvent event) throws IOException {
          FaqQuestions fq = new FaqQuestions();

         Stage st = new Stage();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ListFaqQuestionClient.fxml"));    
                           Parent root = loader.load();
                          
                          ListFaqQuestionClientController liste = loader.<ListFaqQuestionClientController>getController(); 
                            liste.initialize(null,null);
                                          tableview.getScene().setRoot(root);

    }*/

    @FXML
    private void Home(ActionEvent event) throws IOException {

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
    
    }
      
    }
      
