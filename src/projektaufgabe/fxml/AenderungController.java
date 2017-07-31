/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektaufgabe.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Meike Brülls <s6mebrue@uni-bonn.de>
 */
public class AenderungController implements Initializable {

    
    @FXML
    private Label labelAenderung;
    
    private ImportController caller;
    
    private AnchorPane pane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }  
    
    public void setLabelText(String text){

        labelAenderung.setText(text);
        
    }
    
    public void setApp(ImportController controller) {
        caller = controller;
    }
    
}
