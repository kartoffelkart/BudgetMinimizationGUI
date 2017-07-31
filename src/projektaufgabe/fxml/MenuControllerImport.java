/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.fxml;

import csunibonn.ris.javafx.platform.PlatformActionHandler;
import csunibonn.ris.javafx.platform.ribbon.PlatformRibbon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Stephan
 */
public class MenuControllerImport implements Initializable, PlatformRibbon {

    private PlatformActionHandler handler = PlatformActionHandler.getInstance();
    @FXML
    private StackPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public String getTitle() {
        return " ";
    }

    @Override
    public Pane getPane() {
        return pane;
    }

    @FXML
    private void handleClick(ActionEvent event) {
        handler.openWindow("fxml/import.fxml");
    }

}
