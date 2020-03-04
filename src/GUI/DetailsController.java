/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ArticleClientController.D;
import static GUI.ArticleClientController.T;
import GUI.ListeVetClientController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import static com.jfoenix.controls.JFXRippler.RipplerPos.BACK;
import java.io.IOException;
import pidev.Zanimaux.entities.Article;
import pidev.Zanimaux.entities.Comment;
import pidev.Zanimaux.Services.CrudArticle;
import pidev.Zanimaux.Services.CrudComment;
import pidev.Zanimaux.utils.Myconnexion;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ci
 */
public class DetailsController implements Initializable {

    ObservableList<String> comboList = FXCollections.observableArrayList("Titre de l'article");
    private TableView<Article> tableview;
    private JFXListView<Label> listview;
    private TextField Recherche;
    private ChoiceBox<String> choiseBox;

    List<Comment> commentaireliset;
    @FXML
    private TableView<Comment> tableCommentaire;
    Article selectedArticle;
    @FXML
    private TableColumn<Comment, String> showCommentaire;

    @FXML
    private TextArea addCommentaire;

    int Aid;
    int id;
    Article a;
    @FXML
    private Label TitreLabel;
    @FXML
    private Label detailLabel;
    @FXML
    private Button retour;

    public void setAid(int AId) {
        this.Aid = AId;
        id = this.Aid;

    }

    @FXML
    private void EnvoyerCommenatire(ActionEvent event) {

        if (!addCommentaire.getText().isEmpty()) {
            CrudComment cs = new CrudComment();
            Comment c = new Comment();

//         c.setEmailUser(MyConnection.connectedUser.getEmail());
//     c.setArticle_id(selectedArticle.getId());
            c.setMessage(addCommentaire.getText());
            c.setArticle_id(id);
            cs.ajouterComment(c);

            FillCommentaire();
            addCommentaire.clear();

            TrayNotification tray = new TrayNotification();
            tray.setNotificationType(NotificationType.CUSTOM);
            tray.setTitle("les Articles");
            tray.setMessage("Vous avez commenter a cette article");
            tray.setAnimationType(AnimationType.FADE);
            tray.showAndDismiss(Duration.millis(2500));

            tray.setRectangleFill(Color.valueOf("#f78c37"));
        }
        

    }

    public void FillCommentaire() {

        CrudComment as = new CrudComment();
        List<Comment> list = as.afficherArtticleCommentairelist(id);
        tableCommentaire.getItems().setAll(list);

    }

    private void initcol() {
        showCommentaire.setCellValueFactory(new PropertyValueFactory<>("message"));

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     //   choiseBox.setItems(comboList);
        /*  initcol();
        listVet();*/
        initcol();
        FillCommentaire();
        //  remplirListView();
//        Recherche.textProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                try {
//                    filtrerArticleList((String) oldValue, (String) newValue);
//                } catch (SQLException ex) {
//                    Logger.getLogger(ListeVetClientController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
detailLabel.setText(D);
TitreLabel.setText(T);
    }

    void filtrerArticleList(String oldValue, String newValue) throws SQLException {

        CrudArticle ms = new CrudArticle();

        String choix = choiseBox.getValue();
        if (choix.equals("Titre Article")) {
            ObservableList<Article> filteredList = FXCollections.observableArrayList();
            if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
                tableview.setItems((ObservableList<Article>) ms.ListerArticle());

            } else {
                newValue = newValue.toUpperCase();
                for (Article st : tableview.getItems()) {

                    String filterArtTitre = st.getTitre();

                    if (filterArtTitre.toUpperCase().contains(newValue)) {
                        filteredList.add(st);
                    }
                }

                tableview.setItems(filteredList);
            }
        }
    }

    private void remplirListView() {
        CrudArticle cv = new CrudArticle();
        a = cv.findByID(id);
        // listview.getItems().clear();

        Label lbl = new Label(" Titre : " + a.getTitre() + "\n Details :" + a.getDetails() + "\n");
        //  String img=a.getNom_image();

        // Image image=new Image(img,100,50,true,true);
        lbl.setPrefSize(500, 100);

        ImageView imageView = new ImageView();
        imageView.imageProperty().unbind();
        ///imageView.setImage(image);
        imageView.setFitWidth(150);
        imageView.setFitHeight(100);
        listview.getItems().add(lbl);
        lbl.setGraphic(imageView);
        
        
        
    }

    @FXML
    private void ListeArticle(ActionEvent event) {
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
     
    }

}
