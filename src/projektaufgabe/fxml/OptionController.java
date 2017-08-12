/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.fxml;

import csunibonn.ris.javafx.platform.PlatformActionHandler;
import csunibonn.ris.javafx.platform.components.PlatformOption;
import java.io.IOException;
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

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;

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
    private TextField dateiname;
    @FXML
    private TextField usernameSCHRITTLAENGE;
    @FXML
    private TextField passwortPOOL;
    @FXML
    private Button settingsUEBERNEHMEN;

    public Integer schrittlaenge;
    public Integer pool;
    public Integer maxKnotenzahl;
    public Integer min;
    public Integer max;
    public String heuristik;
    private Projektaufgabe caller;
    private PlatformActionHandler handler = PlatformActionHandler.getInstance();
//    private final Service service = Service.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hostMIN.setText("1");
        dbMAX.setText("100");
        portMAXKNOTENZAHL.setText("100");
        passwortPOOL.setText("5");
        usernameSCHRITTLAENGE.setText("2");
        dateiname.setText("changeOrder");
        // TODO
    }

    public void setPlatform(Projektaufgabe caller) {
        this.caller = caller;
    }

    @FXML
    private void handleEinstellungen() throws IOException, MatlabConnectionException, MatlabInvocationException {

        maxKnotenzahl = Integer.parseInt(portMAXKNOTENZAHL.getText());
        min = Integer.parseInt(hostMIN.getText());
        max = Integer.parseInt(dbMAX.getText());
        schrittlaenge = Integer.parseInt(usernameSCHRITTLAENGE.getText());
        pool = Integer.parseInt(passwortPOOL.getText());
        heuristik = dateiname.getText();

        caller.startInstanceFactory(schrittlaenge, pool, maxKnotenzahl, min, max, heuristik);


        MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder()
                .setUsePreviouslyControlledSession(true)
                .setHidden(true)
                .setMatlabLocation(null).build();

        MatlabProxyFactory factory = new MatlabProxyFactory(options);
        MatlabProxy proxy = factory.getProxy();

        proxy.eval("addpath('C:\\Users\\Soyo\\Desktop\\Bachelorarbeit')");

        proxy.feval("bachelorarbeit");

//        proxy.disconnect();
//        Stage stage = (Stage) settingsUEBERNEHMEN.getScene().getWindow();
//        stage.close();
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
