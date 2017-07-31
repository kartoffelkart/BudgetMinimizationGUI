/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.fxml;

import csunibonn.ris.javafx.platform.PlatformActionHandler;
import csunibonn.ris.javafx.platform.components.PlatformWindow;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import projektaufgabe.bdo.Finanzierung;
import projektaufgabe.bdo.Verbindlichkeit;
import projektaufgabe.bdo.Verbindlichkeit;
import projektaufgabe.service.Service;
import splendidtableview.javafx.SplendidTableView;

/**
 * FXML Controller class
 *
 * @author Sonja Schäfer
 */
public class WindowVerbindlichkeitController implements Initializable, PlatformWindow {

    @FXML
    private StackPane pane;

    private SplendidTableView<Verbindlichkeit> table;

    private TableColumn<Verbindlichkeit, StringProperty> nachname;
    private TableColumn<Verbindlichkeit, StringProperty> vorname;
    private TableColumn<Verbindlichkeit, IntegerProperty> vRef;

    private TableColumn<Verbindlichkeit, LocalDate> von;
    private TableColumn<Verbindlichkeit, LocalDate> bis;
    private TableColumn<Verbindlichkeit, DoubleProperty> anteilVZ;
    private TableColumn<Verbindlichkeit, DoubleProperty> arbeitsstunden;
    private TableColumn<Verbindlichkeit, StringProperty> entgeltstufe;
    private TableColumn<Verbindlichkeit, StringProperty> arbeitsverhaeltnis;
    private TableColumn<Verbindlichkeit, BooleanProperty> dauerstelle;
    private TableColumn<Verbindlichkeit, StringProperty> kategorie;
    private TableColumn<Verbindlichkeit, StringProperty> verbTyp;

    private TableColumn<Verbindlichkeit, StringProperty> institut;
    private TableColumn<Verbindlichkeit, StringProperty> abteilung;
    private TableColumn<Verbindlichkeit, StringProperty> arbeitsgruppe;

    
    private final Service service = Service.getInstance();

    private PlatformActionHandler handler = PlatformActionHandler.getInstance();

    private ObservableList<Verbindlichkeit> liste_Verbindlichkeit = service.getAllVerbindlichkeit();

    /**
     * Initializes the controller class.
     */
    private Verbindlichkeit tempVerbindlichkeit = new Verbindlichkeit();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        table = new SplendidTableView<>();

        table.setMaxHeight(800);
        pane.getChildren().add(table);
        Label label1 = new Label("Verbindlichkeitsübersicht");
        label1.setFont(Font.font(16));
        Label label2 = new Label("Doppelklicken für Detailansicht");
        VBox vbox = new VBox(label1, label2);
        vbox.setSpacing(5);
        table.setHeader(vbox);
//Format format = new Format() {
//
//            @Override
//            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public Object parseObject(String source, ParsePosition pos) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        }
        table.createColumn("Nachname", true, f -> f.getPerson().getNachnameProperty());
        table.createColumn("Vorname", true, f -> f.getPerson().getVornameProperty());
        table.createColumn("VRef", true, f -> f.getvRefProperty());
        TableColumn von = table.createColumn("Von", true, f -> f.getVonProperty());
        von.setCellFactory(column -> {
            return new TableCell<Verbindlichkeit, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        // Format date.
                        setText(myDateFormatter.format(item));

                    }
                }
            };
        });

//            DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//            StringProperty property = new SimpleStringProperty();
//
//            property.setValue(myDateFormatter.format(f.getVonProperty()));
//
//            return property;
//        });
        TableColumn bis = table.createColumn("Bis", true, f -> f.getBisProperty());
        bis.setCellFactory(column -> {
            return new TableCell<Verbindlichkeit, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        // Format date.
                        setText(myDateFormatter.format(item));

                    }
                }
            };
        });

        table.createColumn("%VZ", true, f -> {
            DecimalFormat df = new DecimalFormat("#.##");

            StringProperty property = new SimpleStringProperty();
            property.setValue(df.format(f.getAnteilVZ()) + "%");
            return property;
        });

        table.createColumn("h/Wo.", true, f -> f.getArbeitsstundenProperty());
        table.createColumn("Stufe", true, f -> f.getEntgeltstufeProperty());
        table.createColumn("Verhältnis", true, f -> f.getArbeitsverhaeltnisProperty());
        table.createColumn("D", true, f -> f.getUnbefristetProperty());
        table.createColumn("Kategorie", true, f -> f.getBeschaeftigungsKategProperty());
        table.createColumn("VerbTyp", true, f -> f.getVerbindlichkeitstyp().getTypProperty());

        table.createColumn("Inst", true, f -> f.getOrganisationseinheit().getInstitutProperty());
        table.createColumn("Abt", true, f -> f.getOrganisationseinheit().getAbteilungProperty());
        table.createColumn("AGr", true, f -> f.getOrganisationseinheit().getArbeitsgruppeProperty());

        HBox hb123 = new HBox(table.getSaveButton(), table.getLoadButton());
        hb123.setSpacing(5.0);
        table.setFooter(hb123);

        table.setItems(liste_Verbindlichkeit);

//         ContextMenu contextTableVerbindlichkeitRightClick = new ContextMenu();
//                MenuItem verbindlichkeitVonVorlageitem = new MenuItem("neue Verbindlichkeit auf dieser Vorlage");
//                verbindlichkeitVonVorlageitem.setOnAction((ActionEvent event2) -> {
//                    
//                   
//
//                });
//                contextTableVerbindlichkeitRightClick.getItems().addAll(verbindlichkeitVonVorlageitem);
//
//
//        table.setRowContextMenu(contextTableVerbindlichkeitRightClick);
        table.addRowContextMenuItem("neue Verbindlichkeit auf dieser Vorlage", (new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Verbindlichkeit selectedVerbindlichkeit = table.getSelectedItem();
                service.setWithClose(false);

                service.saveOrUpdateVerbindlichkeit(selectedVerbindlichkeit);
                Verbindlichkeit verbindlichkeitClone = selectedVerbindlichkeit.clone();

                service.setWithClose(true);
                ((VerbindlichkeitanlegenController) handler.openWindow(
                        "fxml/Verbindlichkeitanlegen.fxml")).setVerbindlichkeit(verbindlichkeitClone, "detail");

            }
        }));

        table.setRowOnDoubleClick(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {

                    Verbindlichkeit newVerbindlichkeit = table.getSelectedItem();
                    ((VerbindlichkeitanlegenController) handler.openWindow("fxml/Verbindlichkeitanlegen.fxml")).setVerbindlichkeit(newVerbindlichkeit, "detail");
//                    handler.notifyTarget("fxml/Verbindlichkeitanlegen.fxml",new Object[] {newVerbindlichkeit});

                }
            }
        });
    }

    @Override
    public void handleAction(Object[] args) {
        for (Object temp : args) {

            if ((temp instanceof String) && (temp.equals("refreshTable"))) {
                liste_Verbindlichkeit = service.getAllVerbindlichkeit();
                table.setItems(liste_Verbindlichkeit);

            }

        }
    }

    @Override
    public Pane getPane() {
        return pane;
    }

    @Override
    public String getTitle() {
        return "Verbindlichkeiten Übersicht";
    }

}
