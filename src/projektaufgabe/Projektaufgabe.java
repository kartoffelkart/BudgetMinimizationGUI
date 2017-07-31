/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe;

import csunibonn.ris.javafx.platform.JavaFXPlatform;
import csunibonn.ris.javafx.platform.settings.PlatformSettingsManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.xml.transform.TransformerException;
import org.hibernate.SessionFactory;
import projektaufgabe.fxml.OptionController;
import projektaufgabe.service.HibernateUtil;
import projektaufgabe.service.Service;

/**
 *
 * @author Sonja
 */
public class Projektaufgabe extends Application {

//    @Override
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
    private Stage stage;

    JavaFXPlatform app;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        app = new JavaFXPlatform(getClass(), "configuration.xml");

//        app.setOnPlatformClose(e -> {
//            Service.getInstance().closeSession();
//            javafx.application.Platform.exit();
//        });
//        app.setOnPlatformClose(new EventHandler<WindowEvent>() {
//
//            @Override
//            public void handle(WindowEvent event) {
//                System.out.println("test");
//                HibernateUtil.getInstance().close();
//            }
//        });
        PlatformSettingsManager man = PlatformSettingsManager.getInstance();
      

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/projektaufgabe/fxml/Option.fxml"));
                Parent root = (Parent) loader.load();
                OptionController controller = (OptionController) loader.getController();
                controller.setPlatform(this);

                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();

            } catch (IOException ex) {
                Logger.getLogger(Projektaufgabe.class.getName()).log(Level.SEVERE, null, ex);
            }
   

    }

    public void startInstanceFactory(String schrittlaenge, String pool, String maxKnotenzahl,String min, String max ) {
//        PlatformSettingsManager man = PlatformSettingsManager.getInstance();
//        man.storeCustomElement("hibernate.connection.url", urli);
//        man.storeCustomElement("hibernate.connection.username", user);
//        man.storeCustomElement("hibernate.connection.password", pw);
//
//        man.storeCustomElement("preLoadDone", "true");
//        System.out.println(man.getCustomElement("hibernate.connection.username"));
//        try {
//            app.start(stage);
//            app.setOnPlatformClose(e -> {
//                Service.getInstance().closeSession();
//                javafx.application.Platform.exit();
//            });
//        } catch (Exception ex) {
//            Logger.getLogger(Projektaufgabe.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            man.saveDocument();
//        } catch (IOException | TransformerException ex) {
//            Logger.getLogger(Projektaufgabe.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //TODO: STARTEN

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

//         Service service = Service.getInstance();
//
//        Finanzierung newFinanzierung = new Finanzierung(50.0, "finanzierung", "jaja");
//
//        VBSFinanzierung vbsFinanzierung = new VBSFinanzierung(20.0, "VBSFinanzierung", "Laberlaber", "Blabla");//Verbindlichkeit verbindlichkeit, Verbuchungsstelle verbuchungsstelle) {
//
//        service.saveOrUpdateFinanzierung(newFinanzierung);
//
//        service.saveOrUpdateFinanzierung(vbsFinanzierung);
//
