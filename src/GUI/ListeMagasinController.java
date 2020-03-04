/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.Zanimaux.Services.MagasinServices;
import pidev.Zanimaux.entities.Magasin;


    
/**
 * FXML Controller class
 *
 * @author Touha
 */
public class ListeMagasinController implements Initializable {

 @FXML
 private TableView<Magasin> tableview ;
 @FXML
 private TableColumn<Magasin, String> nom;
 @FXML
 private TableColumn<Magasin, String> address;
 @FXML
 private TableColumn<Magasin, String> ville;
 @FXML
 private TableColumn<Magasin, String> phone;
    @FXML
    private MenuItem deletmag;
    @FXML
    private MenuItem addmagasin;
    @FXML
    private MenuItem editmag;
    @FXML
    private MenuItem ajouacc;
    @FXML
    private MenuItem Listacc;
    @FXML
    private Button retour;
    @FXML
    private Button pdf;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initcol();
        listmagasin();
    } 
    
   private void initcol(){
   nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
   address.setCellValueFactory(new PropertyValueFactory<>("address"));
   ville.setCellValueFactory(new PropertyValueFactory<>("Ville"));
   phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
   
   } 
    
   
    private void listmagasin()  {
    
    MagasinServices ms= new MagasinServices();
                     List<Magasin> list= ms.ListerMagasin();
                  tableview.getItems().setAll(list);
    
    }

    @FXML
    private void SupprimerMagasin(ActionEvent event) {
    Magasin magasin = tableview.getSelectionModel().getSelectedItem();
    if (magasin == null) {
            Alert al = new Alert(AlertType.INFORMATION);
        al.setTitle("No Magasin selected");
        al.setHeaderText(null);
        al.setContentText("Please select Magasin for deletion.");
        al.showAndWait();
            return;
        }
      Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("DeletingMagasin");
      alert.setContentText("are you sure want to delete the magasin "+magasin.getNom()+"?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK)
        {
        MagasinServices ms= new MagasinServices();
        ms.SupprimerMagasin(magasin.getId());
       listmagasin();
         
        }
     
    }

    @FXML
    private void ajouterMagasin(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterMagasin.fxml"));    
                           Parent root = loader.load();

         AjouterMagasinController mag = loader.getController();
       
          tableview.getScene().setRoot(root);

    }
    
    @FXML
    private void editMagasin(ActionEvent event) throws IOException {
    Magasin magasin = tableview.getSelectionModel().getSelectedItem(); 
      
          FXMLLoader loader = new FXMLLoader(getClass().getResource("EditMagasin.fxml"));    
                           Parent root = loader.load();

         EditMagasinController edmag = loader.<EditMagasinController>getController();
         edmag.setMid(magasin.getId());
         edmag.setMnom(magasin.getNom());
         edmag.setMaddress(magasin.getAddress());
         edmag.setMville(magasin.getVille());
         edmag.setMphone(magasin.getPhone());

         tableview.getScene().setRoot(root);
         
        }

    @FXML
    private void AjouterAccessoires(ActionEvent event) throws IOException {
     Magasin magasin = tableview.getSelectionModel().getSelectedItem(); 
 FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterAccessoires.fxml"));    
                           Parent root = loader.load();
     AjouterAccessoiresController acc = loader.getController();
     acc.setIdmag(magasin.getId());
      tableview.getScene().setRoot(root);
    }

    @FXML
    private void ListeAccessoires(ActionEvent event) throws IOException {
        Magasin magasin = tableview.getSelectionModel().getSelectedItem(); 
 FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeAccessoires.fxml"));    
                           Parent root = loader.load();
        ListeAccessoiresController acc = loader.<ListeAccessoiresController>getController();
     acc.setIdmag(magasin.getId());
     acc.initialize(null, null);
      tableview.getScene().setRoot(root);
      
    }

    @FXML
    private void pdf(ActionEvent event) throws IOException, DocumentException {
                 Node source = (Node) event.getSource();

        FileChooser chooser = new FileChooser();

        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PDF Files(.pdf)", ".pdf");
        chooser.getExtensionFilters().add(filter);

        File file = chooser.showSaveDialog(source.getScene().getWindow());
        if (file != null) {
            exporterPdf(file);

        }
    }
      public void exporterPdf(File file) throws IOException, DocumentException {
         Document doc = new Document();

         try {
            try {
            
                PdfWriter.getInstance(doc, new FileOutputStream(file));
                doc.open();


                doc.add(new Paragraph("   "));
              
                doc.add(new Phrase("Liste Magasins", FontFactory.getFont("Arial", 20, Font.BOLDITALIC)));
             
             
                doc.add(new Paragraph("   "));

                PdfPTable table = new PdfPTable(4);
                table.setWidthPercentage(100);
                PdfPCell cell;

                cell = new PdfPCell(new Phrase("Nom", FontFactory.getFont("Comic Sans MS", 12)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Adresse", FontFactory.getFont("Comic Sans MS", 12)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Ville", FontFactory.getFont("Comic Sans MS", 12)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase("Phone", FontFactory.getFont("Comic Sans MS", 12)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);
                
                                 

                
                 ////////////////////////////////////////////////////////////////////////////
             MagasinServices ms= new MagasinServices();
            List<Magasin> list= ms.ListerMagasin();
             
                for (Magasin mag : list) {

                    cell = new PdfPCell(new Phrase(mag.getNom(), FontFactory.getFont("Comic Sans MS", 12)));

                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.WHITE);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(mag.getAddress(), FontFactory.getFont("Comic Sans MS", 12)));

                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.WHITE);
                    table.addCell(cell);

                     cell = new PdfPCell(new Phrase(mag.getVille(), FontFactory.getFont("Comic Sans MS", 12)));

                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.WHITE);
                    table.addCell(cell);
                    
                    cell = new PdfPCell(new Phrase(mag.getPhone(), FontFactory.getFont("Comic Sans MS", 12)));

                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.WHITE);
                    table.addCell(cell);
                      
                   
              
                
                   
                }    
                doc.add(table);
                doc.close();
                Desktop.getDesktop().open(file);

         } catch (FileNotFoundException ex) {
                Logger.getLogger(ListeMagasinController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DocumentException ex) {
            Logger.getLogger(ListeMagasinController.class.getName()).log(Level.SEVERE, null, ex);
        }
      

    }

    @FXML
    private void Menu(ActionEvent event) throws IOException {
        Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("accueilAdmin.fxml"));
                Region root = (Region) loader.load();
                AccueilAdminController ac1 = loader.<AccueilAdminController>getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                st.setScene(scene);
                st.show();
    }

class URLBuilder {
    private StringBuilder folders, params;
    private String connType, host;

    void setConnectionType(String conn) {
        connType = conn;
    }

    URLBuilder(){
        folders = new StringBuilder();
        params = new StringBuilder();
    }

    URLBuilder(String host) {
        this();
        this.host = host;
    }

    void addSubfolder(String folder) {
        folders.append("/");
        folders.append(folder);
    }

    void addParameter(String parameter, String value) {
        if(params.toString().length() > 0){params.append("&");}
        params.append(parameter);
        params.append("=");
        params.append(value);
    }

    String getURL() throws URISyntaxException, MalformedURLException {
        URI uri = new URI(connType, host, folders.toString(),
                params.toString(), null);
        return uri.toURL().toString();
    }

    String getRelativeURL() throws URISyntaxException, MalformedURLException{
        URI uri = new URI(null, null, folders.toString(), params.toString(), null);
        return uri.toString();
    }
    }

    
    
}
