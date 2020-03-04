/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.Event_services;
import pidev.Zanimaux.entities.Event;
import pidev.Zanimaux.utils.Myconnexion;

/**
 * FXML Controller class
 *
 * @author abdelaziz
 */
public class EvenementController implements Initializable {

    @FXML
    private AnchorPane gestionevent;
    @FXML
    private TextField titre;
    @FXML
    private TextField adresse;
    @FXML
    private TextField type;
    @FXML
    private TextField nbrplace;
    @FXML
    private TextField details;
    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker datefin;
    @FXML
    private Button ajoutevent;
    @FXML
    private Button modifevent;
    @FXML
    private Button suppevent;
    @FXML
    private AnchorPane listcherts;
    private TextField rechercheevent;
    @FXML
    private TableColumn<Event, String> titretab;
    @FXML
    private TableColumn<Event, String> adressetab;
    @FXML
    private TableColumn<Event, Date> datedebuttab;
    @FXML
    private TableColumn<Event, Date> datefintab;
    @FXML
    private TableColumn<Event, String> typetab;
    @FXML
    private TableColumn<Event, Integer> nbrplacetab;
    @FXML
    private TableColumn<Event, String> detailstab;
    @FXML
    private TableColumn<Event, Integer> nbrreservationtab;
    @FXML
    private TableColumn<Event, Integer> archivetab;

    private ObservableList<Event> Events = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Event> tabEvent;
    

     @FXML
    private BarChart<String, Integer> barchart;
     Connection con= Myconnexion.getInstance().getConnection();
    private Statement st;
    PreparedStatement pste;
    private ResultSet rs;
    @FXML
    private TextField rechEvent;
    @FXML
    private Button RetourButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherEvent();
        load();
        
              tabEvent.setOnMouseClicked((MouseEvent event) -> {
           titre.setText(Events
                    .get(tabEvent.getSelectionModel().getSelectedIndex())
                    .getTitre());

            adresse.setText(Events
                    .get(tabEvent.getSelectionModel().getSelectedIndex())
                    .getAdresse());

           type.setText(Events
                    .get(tabEvent.getSelectionModel().getSelectedIndex())
                    .getType());

            nbrplace.setText(String.valueOf(Events
                    .get(tabEvent.getSelectionModel().getSelectedIndex())
                    .getNombre_place()));
            
           
         details.setText(Events
                    .get(tabEvent.getSelectionModel().getSelectedIndex())
                    .getDetails());
        });

        
           RetourButton.setOnAction(event -> {

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
        
        FilteredList<Event> listeFiltre = new FilteredList<>(Events, e -> true);
        rechEvent.textProperty().addListener((observableValue, oldValue, newValue) -> {
            listeFiltre.setPredicate((Predicate<? super Event>) candidat -> {
                System.out.println(newValue);

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (candidat.getTitre().contains(newValue)) {
                    return true;
                }
                return false;
            });
            SortedList<Event> CandidatTries = new SortedList<>(listeFiltre);
            CandidatTries.comparatorProperty().bind(tabEvent.comparatorProperty());
            tabEvent.setItems(CandidatTries);
        });
        
    }

    @FXML
    private void AjoutEvenement(ActionEvent event) throws SQLException, ParseException {

        String DATE_PATTERN = "yyyy/MM/dd";

        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
        String date1 = DATE_FORMATTER.format(datedebut.getValue());
        String date2 = DATE_FORMATTER.format(datefin.getValue());

        java.util.Date utilDate = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        utilDate = formatter.parse(date1);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        java.util.Date utilDate2 = new java.util.Date();
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy/MM/dd");
        utilDate = formatter.parse(date2);
        java.sql.Date sqlDate2 = new java.sql.Date(utilDate.getTime());

        Event e = new Event(titre.getText(), adresse.getText(), sqlDate, sqlDate2, type.getText(), Integer.parseInt(nbrplace.getText()), details.getText());
        Event_services es = new Event_services();
        es.insertE(e);
         afficherEvent();

    }

    
    private void afficherEvent() {

        Events.clear();
        Event_services sv_b = new Event_services();

        Events = sv_b.getAll();
        tabEvent.setItems(Events);
        titretab.setCellValueFactory(cell -> cell.getValue().getTitreO());
        adressetab.setCellValueFactory(cell -> cell.getValue().getAdresseO());
        datedebuttab.setCellValueFactory((TableColumn.CellDataFeatures<Event, Date> Event) -> new SimpleObjectProperty(Event.getValue().getDate_debut()));
        datefintab.setCellValueFactory((TableColumn.CellDataFeatures<Event, Date> Event) -> new SimpleObjectProperty(Event.getValue().getDate_fin()));
        typetab.setCellValueFactory((TableColumn.CellDataFeatures<Event, String> Event) -> new SimpleObjectProperty(Event.getValue().getType()));
        nbrplacetab.setCellValueFactory((TableColumn.CellDataFeatures<Event, Integer> Event) -> new SimpleObjectProperty(Event.getValue().getNombre_place()));
        detailstab.setCellValueFactory((TableColumn.CellDataFeatures<Event, String> Event) -> new SimpleObjectProperty(Event.getValue().getDetails()));
        nbrreservationtab.setCellValueFactory((TableColumn.CellDataFeatures<Event, Integer> Event) -> new SimpleObjectProperty(Event.getValue().getNombre_reserve()));
        archivetab.setCellValueFactory((TableColumn.CellDataFeatures<Event, Integer> Event) -> new SimpleObjectProperty(Event.getValue().getArchive()));

    }

    @FXML
    private void updateart(ActionEvent event) throws SQLException, ParseException {
        LocalDate lcd1=datedebut.getValue();
        Date dateb=Date.valueOf(lcd1);
        LocalDate lcd2=datefin.getValue();
        Date datef=Date.valueOf(lcd2);
       int id=tabEvent.getSelectionModel().getSelectedItem().getId();
                    
       
        Event ev=new Event(id, titre.getText(),adresse.getText(), dateb, datef, type.getText(), Integer.parseInt(nbrplace.getText()), details.getText(),0,0);
        Event_services evs = new Event_services();
        evs.updateR(ev);
         afficherEvent();
    }

    @FXML
    private void deleteart(ActionEvent event) throws SQLException {
       
        Event_services crud = new Event_services();

        ObservableList<Event> selectedRows, arti;
        arti = tabEvent.getItems();
        selectedRows = tabEvent.getSelectionModel().getSelectedItems();

        for (Event a : selectedRows) {
            Event aa = new Event();
            System.out.println(a.getId());
            int id = a.getId();

            crud.deleteE(a);

        }
         afficherEvent();
    }
    
     

     private void load() {
        Event_services s1 = new Event_services();
        String req ="select titre,nombre_reserve FROM event ORDER BY nombre_reserve asc";
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
       try {
                  st = con.createStatement();
                       rs = st.executeQuery(req);
                       
                       while(rs.next())
                       {series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));}
                       barchart.getData().add(series);
       } catch (SQLException ex) {
           Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
       }

    }

    // @FXML
    /* private void showOnClick(MouseEvent event) {
        try {
            Event b = (Event) tabEvent.getSelectionModel().getSelectedItem();
            Event_services sv_b = new Event_services();
            sv_b.displayAll(ti);

            latit.setText(String.valueOf(b.getLati()));
            numTF.setText(String.valueOf(b.getNumero()));
            longit.setText(String.valueOf(b.getLongi()));

        } catch (SQLException ex) {
            Logger.getLogger(Controllers.BoutiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
} 
