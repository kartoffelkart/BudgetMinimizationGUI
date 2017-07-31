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
    private TextField port;
    @FXML
    private TextField host;
    @FXML
    private TextField db;
    @FXML
    private TextField username;
    @FXML
    private TextField passwort;
    @FXML
    private Button settings;

    public String user;
    public String pw;
    public String urli;
    public String porti;
    public String hosti;
    public String dbi;
    private Projektaufgabe caller;
    private PlatformActionHandler handler = PlatformActionHandler.getInstance();
//    private final Service service = Service.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      host.setText("localhost dbvm09.iai.uni-bonn.de" );
      port.setText("5432");
      db.setText("projektaufgabe personalmittel");
      username.setText("postgres schaefer");
        // TODO
    }

    public void setPlatform(Projektaufgabe caller) {
        this.caller = caller;
    }

    @FXML
    private void handleEinstellungen() {

        porti = port.getText();
        hosti = host.getText();
        dbi = db.getText();
        
        urli = "jdbc:postgresql://"+hosti+":"+porti+"/"+dbi;
//        jdbc:postgresql://localhost:5432/projektaufgabe
        user = username.getText();
        pw = passwort.getText();
        caller.configDone(user, pw,urli);
        Stage stage = (Stage) settings.getScene().getWindow();
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
