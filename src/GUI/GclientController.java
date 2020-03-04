/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.ClientDAO;
import pidev.Zanimaux.entities.Client;

/**
 * FXML Controller class
 *
 * @author user16
 */

public class GclientController implements Initializable {

    @FXML
    private SplitPane spp;
    @FXML
    private AnchorPane ap1;
    @FXML
    private Label lab2;
    @FXML
    private TextField txtc;
    @FXML
    private TableView<Client> tbvc;
    //String id, String login, String Nom, String prenom, String mail, String mdp, String address
    @FXML
    private TableColumn<Client, String> log;
    @FXML
    private TableColumn<Client, String> nom;
    @FXML
    private TableColumn<Client, String> prenom;
    @FXML
    private TableColumn<Client, String> adr;
    @FXML
    private AnchorPane ap2;
    @FXML
    private GridPane gridC;
    @FXML
    private Label info;
    @FXML
    private Button suppP;
    @FXML
    private Button modifp;

    private ObservableList<Client> Clients = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

    @FXML
    private TextField ida;
    @FXML
    private TextField loga;
    @FXML
    private TextField noma;
    @FXML
    private TextField prenoma;
    @FXML
    private TextField emaila;
    @FXML
    private TextField passworda;
    @FXML
    private TextField adressa;
    @FXML
    private TextField etat;
   
    @FXML
    private TextField see;
    @FXML
    private AnchorPane ancST;
    @FXML
    private Button retour;
  

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        afficher();
        retour.setOnAction(event -> {

            try {
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilAdmin.fxml"));
                Region root = (Region) loader.load();
                AccueilAdminController ac1 = loader.<AccueilAdminController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();

            } catch (IOException ex) {
                Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        tbvc.setOnMouseClicked((MouseEvent event) -> {
            ida.setText(String.valueOf(Clients
                    .get(tbvc.getSelectionModel().getSelectedIndex())
                    .getId()));

            loga.setText(Clients
                    .get(tbvc.getSelectionModel().getSelectedIndex())
                    .getLogin());

            noma.setText(Clients
                    .get(tbvc.getSelectionModel().getSelectedIndex())
                    .getNom());

            prenoma.setText(Clients
                    .get(tbvc.getSelectionModel().getSelectedIndex())
                    .getPrenom());

            emaila.setText(Clients
                    .get(tbvc.getSelectionModel().getSelectedIndex())
                    .getMail());

            passworda.setText(Clients
                    .get(tbvc.getSelectionModel().getSelectedIndex())
                    .getMdp());
            adressa.setText(Clients
                    .get(tbvc.getSelectionModel().getSelectedIndex())
                    .getAddress());
            etat.setText(String.valueOf(Clients
                    .get(tbvc.getSelectionModel().getSelectedIndex())
                    .getEtat()));
            see.setText(Clients
                    .get(tbvc.getSelectionModel().getSelectedIndex())
                    .getSexe());
        });

        suppP.setOnAction(event -> {
            ClientDAO Mdao = new ClientDAO();
            int id = tbvc.getSelectionModel().getSelectedItem().getId();

            try {
                Mdao.deleteC(id);
                afficher();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        });

        FilteredList<Client> listeFiltre = new FilteredList<>(Clients, e -> true);
        txtc.textProperty().addListener((observableValue, oldValue, newValue) -> {
            listeFiltre.setPredicate((Predicate<? super Client>) candidat -> {
                System.out.println(newValue);
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (candidat.getLogin().contains(newValue)) {
                    return true;
                }
                return false;
            });
            SortedList<Client> CandidatTries = new SortedList<>(listeFiltre);
            CandidatTries.comparatorProperty().bind(tbvc.comparatorProperty());
            tbvc.setItems(CandidatTries);
        });

        modifp.setOnAction(event -> {
            Client c = new Client(
                    Integer.parseInt(ida.getText()),
                    loga.getText(),
                    noma.getText(),
                    prenoma.getText(),
                   see.getText(),
                    emaila.getText(),
                    passworda.getText(),
                    adressa.getText(),Integer.parseInt(etat.getText()));
            try {
                ClientDAO cd1 = new ClientDAO();
                cd1.updateC(c);
            } catch (SQLException ex) {
                Logger.getLogger(GclientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            afficher();
        });

        

    }

    private void afficher() {
        Clients.clear();
        ClientDAO Vdao = new ClientDAO();
        Clients = Vdao.getAll();
        tbvc.setItems(Clients);
        log.setCellValueFactory(cell -> cell.getValue().getLoginO());
        nom.setCellValueFactory(cell -> cell.getValue().getNomO());
        prenom.setCellValueFactory(cell -> cell.getValue().getPrenomO());
        adr.setCellValueFactory(cell -> cell.getValue().getAddressO()); //String.valueOf

    }

}
