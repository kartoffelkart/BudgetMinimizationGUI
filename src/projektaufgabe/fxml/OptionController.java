/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.fxml;

import csunibonn.ris.javafx.platform.PlatformActionHandler;
import csunibonn.ris.javafx.platform.components.PlatformOption;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import projektaufgabe.Projektaufgabe;
//test import projektaufgabe.service.Service;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sonja Schäfer
 */
public class OptionController implements Initializable, PlatformOption {

    @FXML
    private StackPane pane;
    @FXML
    private TextField portMAXKNOTENZAHL;
    @FXML
    private TextField hostMIN;
    @FXML
    private TextField dbMAX;
    @FXML
    private TextField usernameSCHRITTLAENGE;
    @FXML
    private TextField passwortPOOL;
    @FXML
    private Button settingsUEBERNEHMEN;

    public String schrittlaenge;
    public String pool;
    public String urli;
    public String maxKnotenzahl;
    public String min;
    public String max;
    private Projektaufgabe caller;
    private PlatformActionHandler handler = PlatformActionHandler.getInstance();
//    private final Service service = Service.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      hostMIN.setText("1" );
      dbMAX.setText("30");
      portMAXKNOTENZAHL.setText("15");
      passwortPOOL.setText("5");
      usernameSCHRITTLAENGE.setText("2");
        // TODO
    }

    public void setPlatform(Projektaufgabe caller) {
        this.caller = caller;
    }

    @FXML
    private void handleEinstellungen() {

        maxKnotenzahl = portMAXKNOTENZAHL.getText();
        min = hostMIN.getText();
        max = dbMAX.getText();
        
//        urli = "jdbc:postgresql://"+hosti+":"+porti+"/"+dbi;
//        jdbc:postgresql://localhost:5432/projektaufgabe
        schrittlaenge = usernameSCHRITTLAENGE.getText();
        pool = passwortPOOL.getText();
        
        caller.startInstanceFactory(schrittlaenge, pool,maxKnotenzahl,min,max);
        Stage stage = (Stage) settingsUEBERNEHMEN.getScene().getWindow();
        stage.close();

    }

    @Override
    public String getTitle() {
        return "Option Window";
    }

    @Override
    public Pane getPane() {
        return pane;
    }

}
