/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Touha
 */
public class MapsMagController implements Initializable,MapComponentInitializedListener  {
 @FXML
    private GoogleMapView mapview;
    @FXML
    private Button retour;
        private GoogleMap map;
         private GeocodingService G;
    private boolean ready;
    String x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          mapview.addMapInializedListener(this);
    }    
     public void createMap(){
          map = new GoogleMap();
        G = new GeocodingService();
        MapOptions mapOptions = new  MapOptions();
          mapOptions.center(new LatLong(36.802850, 10.175506))
                .mapType(MapTypeIdEnum.TERRAIN)
                .overviewMapControl(true)
                .panControl(true)
                .rotateControl(true)
                .scaleControl(true)
                .streetViewControl(true)
                .zoomControl(true)
                .zoom(6);

        map = mapview.createMap(mapOptions);
    }
     @Override
    public void mapInitialized() {
     
         createMap();
 
    x=ListeMagasinClientController.Magasinadress+" "+ListeMagasinClientController.Magasinnom +", " + ListeMagasinClientController.MagasinGouv;
     

             G.geocode(x, (GeocodingResult[] results, GeocoderStatus status) -> {

            LatLong latLong = null;
            if (status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if (results.length > 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                MarkerOptions markerOptions12 = new MarkerOptions();
                markerOptions12.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Animlia");

                Marker marker = new Marker(markerOptions12);
                map.addMarker(marker);

            }

            map.setCenter(latLong);
       });}

    @FXML
    private void listmagasin(ActionEvent event) throws IOException {
        Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeMagasinClient.fxml"));
                            Region root = (Region) loader.load();
                           ListeMagasinClientController liste = loader.<ListeMagasinClientController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                            liste.initialize(null,null);
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();
    }
}
