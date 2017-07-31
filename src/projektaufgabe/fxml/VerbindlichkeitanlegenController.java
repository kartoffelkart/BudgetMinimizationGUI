/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.fxml;

import csunibonn.ris.javafx.platform.PlatformActionHandler;
import csunibonn.ris.javafx.platform.components.PlatformWindow;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;
import projektaufgabe.bdo.DMBewilligung;
import projektaufgabe.bdo.DMFinanzierung;
import projektaufgabe.bdo.Entgeltstufe;
import projektaufgabe.bdo.Finanzierung;
import projektaufgabe.bdo.Organisationseinheit;
import projektaufgabe.bdo.PBMFinanzierung;
import projektaufgabe.bdo.Person;
import projektaufgabe.bdo.QMBewilligung;
import projektaufgabe.bdo.QMFinanzierung;
import projektaufgabe.bdo.Stelle;
import projektaufgabe.bdo.VBSFinanzierung;
import projektaufgabe.bdo.Verbindlichkeit;
import projektaufgabe.bdo.Verbindlichkeitstyp;
import projektaufgabe.bdo.Verbuchungsstelle;
import projektaufgabe.service.Service;
import splendidtableview.javafx.SplendidTableView;

/**
 * FXML Controller class
 *
 * @author Sonja
 */
public class VerbindlichkeitanlegenController implements Initializable, PlatformWindow {

    @FXML
    private StackPane pane;
    @FXML
    private StackPane paneFinanzierungen;
    @FXML
    private Label fensterart;

    @FXML
    private ComboBox verbindlichkeitartComboBox;
    //----------------------------------------person
    @FXML
    private TextField nachname;
    @FXML
    private TextField vorname;
    @FXML
    private TextField persnr;
    @FXML
    private DatePicker geburtstdatum;
    @FXML
    private DatePicker promotionsdatum;

    @FXML
    private Separator separator1;
    @FXML
    private Separator separator2;
    //------------------------------------------verbindlichkeit
    @FXML
    private DatePicker von;
    @FXML
    private DatePicker bis;
    @FXML
    private CheckBox unbefristet;

    @FXML
    private TextField institut;
    @FXML
    private TextField abteilung;
    @FXML
    private TextField arbeitsgruppe;

    @FXML
    private ComboBox entgeltstufeComboBox;

    @FXML
    private TextField arbeitsstunden;
    @FXML
    private ComboBox arbeitsverhaeltnisComboBox;
    @FXML
    private ComboBox beschaeftigungskategorieComboBox;
    @FXML
    private TextField anteilVollzeit;
    @FXML
    private TextArea bemerkung;

    // ------------------------------------------------buttons
    @FXML
    private Button verbindlichkeitAnlegen;
    @FXML
    private Button abbrechen;

    @FXML
    private Button addFinanzierung;
    @FXML
    private TextField summe;

//    private Double sum;
    private Stage stage;

    private Popup popup;
    private Popup popupPer;
    private Popup popupOrg;

    private final Service service = Service.getInstance();
    private PlatformActionHandler handler = PlatformActionHandler.getInstance();

    //------------------------------- finanzierungen
    private ObservableList<Finanzierung> listFinanzierungen = FXCollections.observableArrayList();
    private ObservableList<Finanzierung> unusedListFinanzierungen = FXCollections.observableArrayList(new Finanzierung());
    private ObservableList<Finanzierung> listFinanzierungenToDelete = FXCollections.observableArrayList();
    private Finanzierung aktuelleFinanzierung;

    private SplendidTableView<Finanzierung> table = new SplendidTableView<>();
    private TableColumn<Finanzierung, Double> anteil;
    private TableColumn<Finanzierung, StringProperty> typ;
    private TableColumn<Finanzierung, String> bemerkungFin;
    private TableColumn<Finanzierung, StringProperty> finanzierungsString;

    //--------------------------------personen
    private ObservableList<Person> listPersonen = service.getAllPerson();
    // Wrap the ObservableList in a FilteredList (initially display all data).
    FilteredList<Person> filteredDataPersonen = new FilteredList<>(listPersonen, p -> true);
    SortedList<Person> sortedData = new SortedList<>(filteredDataPersonen);
    private ListView<Person> listViewPer = new ListView<>(filteredDataPersonen);

    //-------------------------------organisationseinheiten
    private ObservableList<Organisationseinheit> listOrganisationseinheiten = service.getAllOrganisationseinheit();
    // Wrap the ObservableList in a FilteredList (initially display all data).
    FilteredList<Organisationseinheit> filteredDataOrganisationseinheit = new FilteredList<>(listOrganisationseinheiten, p -> true);
    private ListView<Organisationseinheit> listViewOrga = new ListView<>(filteredDataOrganisationseinheit);
    private Organisationseinheit selectedOrganisationseinheit = new Organisationseinheit();

//----------------------------------------------
    private Verbindlichkeit verbindlichkeit = new Verbindlichkeit();

    private String fall;
    private ObjectProperty<Entgeltstufe> tempEntgeltstufeProperty = new SimpleObjectProperty<>();

    /**
     * Initializes the controller class.
     */
    private Verbindlichkeit tempVerbindlichkeit = new Verbindlichkeit();

    //-----------------------------------
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //---------------------------------------------------Splendid Table

        table.setMaxHeight(150);

        paneFinanzierungen.getChildren().add(table);

        typ = table.createColumn("Typ", true, f -> f.getFinanzierungsTypProperty());
        anteil = table.createColumn("Anteil", true, f -> f.getAnteil());
        anteil.setCellFactory(TextFieldTableCell.<Finanzierung, Double>forTableColumn(new DoubleStringConverter()));
        anteil.setOnEditCommit((TableColumn.CellEditEvent<Finanzierung, Double> event) -> {
            ((Finanzierung) event.getTableView().getItems().get(event.getTablePosition().getRow())).setAnteil(event.getNewValue());
        });
        finanzierungsString = table.createColumn("Bemerkung", true, f -> f.getFinanzierungsText());
        bemerkungFin = table.createColumn("Bemerkung", true, f -> f.getBemerkung());
        bemerkungFin.setCellFactory(TextFieldTableCell.forTableColumn());
        bemerkungFin.setOnEditCommit((TableColumn.CellEditEvent<Finanzierung, String> event) -> {
            ((Finanzierung) event.getTableView().getItems().get(event.getTablePosition().getRow())).setBemerkung(event.getNewValue());

        });

       
        //---------------------------------------------------
//        verbindlichkeitartComboBox.setOnAction(event3 -> {
//            if (((Verbindlichkeitstyp) verbindlichkeitartComboBox.getValue()).getTyp().equalsIgnoreCase("Elternzeit")) {
//                System.out.println("Elternzeit");
//
//            }
//        });

        table.addRowContextMenuItem("delete", (EventHandler<ActionEvent>) (ActionEvent event) -> {
            Finanzierung finDelete = table.getSelectedItem();
            System.out.println("item" + table.getSelectedItem());
            listFinanzierungenToDelete.add(finDelete);
            listFinanzierungen.remove(finDelete);
            table.setItems(listFinanzierungen);
        });
        table.addRowContextMenuItem("edit", (EventHandler<ActionEvent>) (ActionEvent event) -> {
            aktuelleFinanzierung = table.getSelectedItem();//wieso ist das null beim zweien anklicken
            openFinanzWindow(aktuelleFinanzierung, "Detailansicht");
        });

        table.setRowOnDoubleClick((EventHandler<MouseEvent>) (MouseEvent event) -> {
            aktuelleFinanzierung = table.getSelectedItem();//wieso ist das null beim zweien anklicken
            openFinanzWindow(aktuelleFinanzierung, "Detailansicht");
        });
    }

    public void setVerbindlichkeit(Verbindlichkeit verbindlichkeit, String fall) {

        verbindlichkeitartComboBox.setValue(verbindlichkeit.getVerbindlichkeitstyp());
        verbindlichkeitartComboBox.setItems(FXCollections.observableArrayList(service.getAllVerbindlichkeitstyp()));
        switch (fall) {
            case "detail":
//                fensterart.setText("Detailansicht:");
//                verbindlichkeitartComboBox.setVisible(true);
             

                break;

            case "anlegen":
//                TextFields.bindAutoCompletion(verbindlichkeitartTextField, FXCollections.observableArrayList(service.getAllVerbindlichkeitstyp()));
//                fensterart.setText("Verbindlichkeitstyp:");
//                verbindlichkeitartComboBox.setVisible(true);
  

                break;

        }
        this.fall = fall;
        this.verbindlichkeit = verbindlichkeit;
        vorname.textProperty().bindBidirectional(verbindlichkeit.getPerson().getVornameProperty());
        nachname.textProperty().bindBidirectional(verbindlichkeit.getPerson().getNachnameProperty());

        persnr.textProperty().bindBidirectional(verbindlichkeit.getPerson().getPersNrProperty());
        von.valueProperty().bindBidirectional(verbindlichkeit.getVonProperty());
        bis.valueProperty().bindBidirectional(verbindlichkeit.getBisProperty());
        geburtstdatum.valueProperty().bindBidirectional(verbindlichkeit.getPerson().getGebDatumProperty());
        promotionsdatum.valueProperty().bindBidirectional(verbindlichkeit.getPerson().getPromDatumProperty());
        anteilVollzeit.textProperty().bindBidirectional(verbindlichkeit.getAnteilVZProperty(), new NumberStringConverter());
        TextFields.bindAutoCompletion(anteilVollzeit, "30", "50", "70", "100");

        arbeitsstunden.textProperty().bindBidirectional(verbindlichkeit.getArbeitsstundenProperty(), new NumberStringConverter());
        TextFields.bindAutoCompletion(arbeitsstunden, "7,5", "9,5", "11");

        entgeltstufeComboBox.valueProperty().bindBidirectional(verbindlichkeit.getEntgeltstufeProperty());
//        entgeltstufeComboBox.valueProperty().bindBidirectional(tempEntgeltstufeProperty);
//        tempEntgeltstufeProperty.get().getEntgeltstufeProperty().bindBidirectional(verbindlichkeit.getEntgeltstufeProperty());
        entgeltstufeComboBox.setItems(FXCollections.observableArrayList(service.getAllEntgeltstufeStrings()));
        entgeltstufeComboBox.setOnKeyPressed(new AutoCompleteComboBoxListener<>(entgeltstufeComboBox));
        bemerkung.textProperty().bindBidirectional(verbindlichkeit.getBemerkungProperty());
        arbeitsverhaeltnisComboBox.valueProperty().bindBidirectional(verbindlichkeit.getArbeitsverhaeltnisProperty());
        arbeitsverhaeltnisComboBox.setItems(FXCollections.observableArrayList(service.getAllArbeitsverhaeltnisStrings()));
        arbeitsverhaeltnisComboBox.setOnKeyPressed(new AutoCompleteComboBoxListener<>(arbeitsverhaeltnisComboBox));
        unbefristet.selectedProperty().bindBidirectional(verbindlichkeit.getUnbefristetProperty());
        beschaeftigungskategorieComboBox.valueProperty().bindBidirectional(verbindlichkeit.getBeschaeftigungsKategProperty());
        beschaeftigungskategorieComboBox.setItems(FXCollections.observableArrayList(service.getAllBeKategorieStrings()));
        beschaeftigungskategorieComboBox.setOnKeyPressed(new AutoCompleteComboBoxListener<>(beschaeftigungskategorieComboBox));
        institut.textProperty().bindBidirectional(verbindlichkeit.getOrganisationseinheit().getInstitutProperty());
        abteilung.textProperty().bindBidirectional(verbindlichkeit.getOrganisationseinheit().getAbteilungProperty());
        arbeitsgruppe.textProperty().bindBidirectional(verbindlichkeit.getOrganisationseinheit().getArbeitsgruppeProperty());

        setFilteredListPredicateOrgaEinheit();
        setFilteredListPredicatePerson();
        
         Label l2 = new Label();
        Label l3 = new Label("% einer VZ-Stelle sind abgedeckt. Benötigt werden "+verbindlichkeit.getAnteilVZ()+"%");
                
        System.out.println(anteil);
        l2.textProperty().bind(table.getSumPropertyString(anteil));
        HBox hb = new HBox(l2,l3);
        hb.setSpacing(5.0);
        table.setFooter(hb);
// DecimalFormat df = new DecimalFormat("#.##");
//        if (verbindlichkeit.getOrganisationseinheit() != null) {
//
//            organisationseinheit.setValue(verbindlichkeit.getOrganisationseinheit());
//
//        }
//        organisationseinheit.valueProperty().addListener((ObservableValue<? extends Organisationseinheit> observable, Organisationseinheit oldValue, Organisationseinheit newValue)
//                -> verbindlichkeit.setOrganisationseinheit(newValue)
//        );
        System.out.println("null?" + verbindlichkeit.getId());
        if (verbindlichkeit.getId() != null) {
//            service.setWithClose(false);
//            service.saveOrUpdateVerbindlichkeit(verbindlichkeit);
//            ObservableList<Finanzierung> listFinanzierungen = FXCollections.observableArrayList(verbindlichkeit.getFinanzierungen());

            listFinanzierungen = service.getAllFinanzierungByVerbindlichkeit(verbindlichkeit);//kann man auch als Set aus verbindlichkeit abfragen
//            service.setWithClose(true);
// ------------------------------------------------TABLE VARIANTE

            table.setItems(listFinanzierungen);
            // ----------------------------------------------LIST VIEW VARIANTE          
//            listViewFin.setItems(listFinanzierungen);
//            sum = 0.0;
//            for (Finanzierung tmp : listFinanzierungen) {
//                sum = sum + tmp.getAnteil();
//            }
//
//            summe.setText(sum.toString());

        } else {
            // ------------------------------------------------TABLE VARIANTE

            listFinanzierungen = FXCollections.observableArrayList(verbindlichkeit.getFinanzierungen());

            table.setItems(listFinanzierungen);

            // ----------------------------------------------LIST VIEW VARIANTE    
//            listViewFin.setItems(listFinanzierungen);
//            sum = 0.0;
//            for (Finanzierung tmp : listFinanzierungen) {
//                sum = sum + tmp.getAnteil();
//            }
//
//            summe.setText(sum.toString());
        }

    }

    private void showPopupPerson() {
        //wenn die lilteredList leer ist popup ausblenden 
        if (listViewPer.getItems().isEmpty()) {
            if (popupPer.isShowing()) {
                popupPer.hide();
            }
        } else {
            //wenn die filteresList nicht leer ist, und es sich gerade noch nicht zeigt, dann zeige es 

            if (!popupPer.isShowing()) {

                Point2D point = separator1.localToScene(0.0, 0.0);
                popupPer.show(pane,
                        pane.getScene().getWindow().getX() + point.getX(),//+ 205.0,
                        pane.getScene().getWindow().getY() + point.getY() + 25.0);
            }
            if (listViewPer.getSelectionModel().getSelectedItem() == null) {
                listViewPer.getSelectionModel().select(0);
            }

        }

    }

    private void showPopupOrganisationseinheit() {
        //wenn die lilteredList leer ist popup ausblenden 
        if (listViewOrga.getItems().isEmpty()) {
            if (popupOrg.isShowing()) {
                popupOrg.hide();
            }
        } else {
            //wenn die filteresList nicht leer ist, und es sich gerade noch nicht zeigt, dann zeige es 

            if (!popupOrg.isShowing()) {

                Point2D point = separator2.localToScene(0.0, 0.0);
                popupOrg.show(pane,
                        pane.getScene().getWindow().getX() + point.getX(),//+ 205.0,
                        pane.getScene().getWindow().getY() + point.getY() + 25.0);
            }
            if (listViewOrga.getSelectionModel().getSelectedItem() == null) {
                listViewOrga.getSelectionModel().select(0);
            }

        }

    }

    private void setFilteredListPredicatePerson() {

        //mache popup mit listview mit filteredList
        listViewPer.setMaxHeight(150.0);
        popupPer = new Popup();
        popupPer.getContent().add(listViewPer);

        // bei Auswahl durch doppelklick alle Attribute übernehmen und popup ausblenden
        listViewPer.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    Person p = listViewPer.getSelectionModel().getSelectedItem();
                    if (p != null) {
                        nachname.setText(p.getNachname());
                        vorname.setText(p.getVorname());
                        persnr.setText(p.getPersNr());
                        geburtstdatum.setValue(p.getGebDatum());
                        promotionsdatum.setValue(p.getPromDatum());
                        popupPer.hide();

                    }
                }
            }
        });
        // bei Auswahl durch Enter alle Attribute übernehmen und popup ausblenden
        listViewPer.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                Person p = listViewPer.getSelectionModel().getSelectedItem();
                if (p != null) {
                    nachname.setText(p.getNachname());
                    vorname.setText(p.getVorname());
                    persnr.setText(p.getPersNr());
                    geburtstdatum.setValue(p.getGebDatum());
                    promotionsdatum.setValue(p.getPromDatum());
                    popupPer.hide();

                }
            }
        });

        nachname.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyPerson();
            showPopupPerson();

        });

        nachname.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupPer.hide();
            }
        });
        vorname.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyPerson();
            showPopupPerson();

        });

        vorname.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupPer.hide();
            }
        });
        persnr.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyPerson();
            showPopupPerson();
        });

        persnr.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupPer.hide();
            }
        });

    }

    private void setFilteredListPredicateOrgaEinheit() {

        //mache popup mit listview mit filteredList
        listViewOrga.setMaxHeight(150.0);
        popupOrg = new Popup();
        popupOrg.getContent().add(listViewOrga);

        // bei Auswahl durch doppelklick alle Attribute übernehmen und popup ausblenden
        listViewOrga.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    selectedOrganisationseinheit = listViewOrga.getSelectionModel().getSelectedItem();
                    if (selectedOrganisationseinheit != null) {
                        institut.setText(selectedOrganisationseinheit.getInstitut());
                        abteilung.setText(selectedOrganisationseinheit.getAbteilung());
                        arbeitsgruppe.setText(selectedOrganisationseinheit.getArbeitsgruppe());
                        verbindlichkeit.setOrganisationseinheit(selectedOrganisationseinheit);
                        popupOrg.hide();

                    }
                }
            }
        });
        // bei Auswahl durch Enter alle Attribute übernehmen und popup ausblenden
        listViewOrga.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                selectedOrganisationseinheit = listViewOrga.getSelectionModel().getSelectedItem();
                if (selectedOrganisationseinheit != null) {
                    institut.setText(selectedOrganisationseinheit.getInstitut());
                    abteilung.setText(selectedOrganisationseinheit.getAbteilung());
                    arbeitsgruppe.setText(selectedOrganisationseinheit.getArbeitsgruppe());
                    verbindlichkeit.setOrganisationseinheit(selectedOrganisationseinheit);
                    popupOrg.hide();

                }
            }
        });
        institut.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyOrga();
            showPopupOrganisationseinheit();

        });

        institut.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupOrg.hide();
            }
        });
        abteilung.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyOrga();
            showPopupOrganisationseinheit();

        });

        abteilung.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupOrg.hide();
            }
        });
        arbeitsgruppe.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyOrga();
            showPopupOrganisationseinheit();
        });

        arbeitsgruppe.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupOrg.hide();
            }
        });
    }

    private void handleFilterApplyPerson() {
        Predicate<Person> pr = p -> {
            return true;
        };

        String filter_nachname = nachname.getText();// kann null sein

        if (filter_nachname != null && !filter_nachname.isEmpty()) {
            pr = p -> {
                return p.getNachname().toLowerCase().startsWith(filter_nachname.toLowerCase());
            };
        }

        if (vorname.getText() != null && !vorname.getText().isEmpty()) {//hier alternativ,aber macht das gleiche
            String filter_vorname = vorname.getText().toLowerCase();
            pr = pr.and(p -> {
                return p.getVorname().toLowerCase().startsWith(filter_vorname);
            });
        }

        if (persnr.getText() != null && !persnr.getText().isEmpty()) {
            String filter_persnr = persnr.getText().toLowerCase();

            pr = pr.and(p -> {
                return p.getPersNr().toLowerCase().startsWith(filter_persnr);
            });
        }

        filteredDataPersonen.setPredicate(pr);
    }

    private void handleFilterApplyOrga() {
        Predicate<Organisationseinheit> pr = p -> {
            return true;
        };

        String filter_institut = institut.getText();// kann null sein

        if (filter_institut != null && !filter_institut.isEmpty()) {
            pr = p -> {
                return p.getInstitut().toLowerCase().startsWith(filter_institut.toLowerCase());
            };
        }

        if (abteilung.getText() != null && !abteilung.getText().isEmpty()) {//hier alternativ,aber macht das gleiche
            String filter_abteilung = abteilung.getText().toLowerCase();
            pr = pr.and(p -> {
                return p.getAbteilung().toLowerCase().startsWith(filter_abteilung);
            });
        }

        if (arbeitsgruppe.getText() != null && !arbeitsgruppe.getText().isEmpty()) {
            String filter_arbeitsgruppe = arbeitsgruppe.getText().toLowerCase();

            pr = pr.and(p -> {
                return p.getArbeitsgruppe().toLowerCase().startsWith(filter_arbeitsgruppe);
            });
        }

        filteredDataOrganisationseinheit.setPredicate(pr);
    }

    @Override
    public void handleAction(Object[] args
    ) {
        for (Object temp : args) {
//            if ((temp instanceof String) && (temp.equals("refreshTable"))) {
//                liste_Finanzierung = service.getAllFinanzierung();
//                table.setItems(liste_Finanzierung);
//
//            }
            if (temp instanceof Finanzierung) {
                listFinanzierungen.remove(temp);
                table.setItems(listFinanzierungen);
            }
            if (temp instanceof Verbindlichkeit) {
                verbindlichkeit = (Verbindlichkeit) temp;
            }

            //eventuell muss man vorhe nochmal anders zuweisen
            table.setItems(listFinanzierungen);
        }

    }

    @FXML
    private void handleVerbindlichkeitAnlegen(ActionEvent event
    ) {

        System.out.println(verbindlichkeit);
        System.out.println(verbindlichkeit.getVerbindlichkeitstyp());

        System.out.println(verbindlichkeitartComboBox.getValue());

        verbindlichkeit.setVerbindlichkeitstyp((Verbindlichkeitstyp) verbindlichkeitartComboBox.getValue());//????????

//        if (!Objects.equals(table.getSum(anteil), verbindlichkeit.getAnteilVZ())) {
        if ((table.getSum(anteil).compareTo(new BigDecimal(verbindlichkeit.getAnteilVZ()))) != 0) {

            Action action1 = Dialogs.create()
                    .title("Keine ausreichende Finanzierung")
                    .message("Die Finanzierungen decken eine " + table.getSum(anteil) + " % Stelle ab. Benötigt werden " + verbindlichkeit.getAnteilVZ() + " %.")
                    .actions(new Action[]{Dialog.ACTION_CLOSE})//Actions.YES, Dialog.Actions.NO})
                    .showConfirm();
            if (action1 == Dialog.ACTION_CLOSE) {
//                abbrechen();
            }
        } else {
            List<Person> perList = service.getPersonByName(vorname.getText(), nachname.getText());
            if (perList.isEmpty()) {

                Action action = Dialogs.create()
                        .title("Person nicht gefunden")
                        .message("Die Person '" + nachname.getText() + ", " + vorname.getText() + "' ist nicht in der Datenbank vorhanden. Möchten Sie die Person angelegen?")
                        .actions(new Action[]{Dialog.ACTION_YES, Dialog.ACTION_NO})//Actions.YES, Dialog.Actions.NO})
                        .showConfirm();
                if (action == Dialog.ACTION_YES) {

                    Person neuPer = new Person();
                    neuPer.setGebDatum(verbindlichkeit.getPerson().getGebDatum());
                    neuPer.setNachname(verbindlichkeit.getPerson().getNachname());
                    neuPer.setPersNr(verbindlichkeit.getPerson().getPersNr());
                    neuPer.setPromDatum(verbindlichkeit.getPerson().getPromDatum());
                    neuPer.setVorname(verbindlichkeit.getPerson().getVorname());

                    verbindlichkeit.setPerson(neuPer);
                    service.saveOrUpdatePerson(verbindlichkeit.getPerson());
                } else {
                    abbrechen();
                }
            } else {
                verbindlichkeit.setPerson(perList.get(0));
            }
            service.saveOrUpdateVerbindlichkeit(verbindlichkeit);

            for (Finanzierung fin : listFinanzierungen) { //listViewFin.getItems() != newFinList
                service.saveOrUpdateFinanzierung(fin);
            }
            for (Finanzierung fin : listFinanzierungenToDelete) { //listViewFin.getItems() != newFinList
                if (fin.getId() != null) {
                    service.deleteFinanzierungById(fin.getId());
                }
            }
            handler.closeWindow(this);
            try {
                handler.notifyTarget("fxml/WindowVerbindlichkeit.fxml", new Object[]{"refreshTable"});

            } catch (Exception e) {
                System.out.println("Keine Aktualisierung der Tabelle nötig.");
            }
        }
    }

    private void abbrechen() {
        Action action = Dialogs.create()
                .title("Abbrechen")
                .message("Wollen Sie den ganzen Vorgang abbrechen ?")
                .actions(new Action[]{Dialog.ACTION_YES, Dialog.ACTION_NO})//Actions.YES, Dialog.Actions.NO})
                .showConfirm();
        if (action == Dialog.ACTION_YES) {

            if (verbindlichkeit.getId() != null) {

                for (Finanzierung temp : verbindlichkeit.getFinanzierungen()) {//newFinList ?????????? egal

                    if (temp.getId() != null) {

                        service.refreshFinanzierung(temp);

                    }
                }

                service.refreshOrganisationseinheit(verbindlichkeit.getOrganisationseinheit());
                service.refreshVerbindlichkeit(verbindlichkeit);
                if (verbindlichkeit.getPerson().getId() != null) {

                    service.refreshPerson(verbindlichkeit.getPerson());
                }

            } else {
            }
            handler.closeWindow(this);
        } else {

        }
    }

    @FXML
    private void handleAbbrechen(ActionEvent event
    ) {

        abbrechen();
    }

    @Override
    public Pane getPane() {
        return pane;
    }

    @Override
    public String getTitle() {

//        switch (fall) {
//            case "detail":
//                return verbindlichkeit.getPerson().getVorname() + verbindlichkeit.getPerson().getNachname();
//
//            case "anlegen":
//                return "Verbindlichkeit anlegen";
//
//        }
//        return null;
        return "Verbindlichkeit anlegen";
//               return verbindlichkeit.getPerson().getVorname() + verbindlichkeit.getPerson().getNachname();

    }

    @FXML
    private void handleAddFinanzierung(MouseEvent mouseevent
    ) {
        ContextMenu contextAddFinanz = new ContextMenu();
        MenuItem vbsitem = new MenuItem("VBS Finanzierung");
        vbsitem.setOnAction((ActionEvent event) -> {
            Verbuchungsstelle vbs = new Verbuchungsstelle();
            VBSFinanzierung vbsfin = new VBSFinanzierung();
            vbsfin.setFinanzierungsTyp("VBS");
            vbsfin.setVerbuchungsstelle(vbs);
            listFinanzierungen.add(vbsfin);
            openFinanzWindow(vbsfin, "Anlegen");
        });
        MenuItem qmitem = new MenuItem("QM Finanzierung");
        qmitem.setOnAction((ActionEvent event) -> {
            Verbuchungsstelle vbs = new Verbuchungsstelle();
            QMBewilligung qm = new QMBewilligung();
            QMFinanzierung qmfin = new QMFinanzierung();
            qmfin.setFinanzierungsTyp("QM");
            qmfin.setQmbewilligung(qm);
            qmfin.setVerbuchungsstelle(vbs);
            listFinanzierungen.add(qmfin);

            openFinanzWindow(qmfin, "Anlegen");
        });
        MenuItem pbmitem = new MenuItem("PBM Finanzierung");
        pbmitem.setOnAction((ActionEvent event) -> {
            Stelle stl = new Stelle();
            PBMFinanzierung pbmfin = new PBMFinanzierung();
            pbmfin.setFinanzierungsTyp("PBM");
            pbmfin.setStelle(stl);
            listFinanzierungen.add(pbmfin);

            openFinanzWindow(pbmfin, "Anlegen");
        });
        MenuItem dmitem = new MenuItem("DM Finanzierung");
        dmitem.setOnAction((ActionEvent event) -> {
            Verbuchungsstelle vbs = new Verbuchungsstelle();
            DMBewilligung dm = new DMBewilligung();
            DMFinanzierung dmfin = new DMFinanzierung();
            dmfin.setFinanzierungsTyp("DM");
            dmfin.setVerbuchungsstelle(vbs);
            dmfin.setDmbewilligung(dm);
            listFinanzierungen.add(dmfin);

            openFinanzWindow(dmfin, "Anlegen");
        });

        contextAddFinanz.getItems().addAll(vbsitem, pbmitem, dmitem, qmitem);

        contextAddFinanz.show(addFinanzierung, mouseevent.getScreenX(), mouseevent.getScreenY());

    }

    private void openFinanzWindow(Finanzierung finanzierung, String fensterart) {
        finanzierung.setVerbindlichkeit(verbindlichkeit);
        finanzierung.setAnteil(finanzierung.getAnteil());
        PopOver popup = new PopOver();
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/projektaufgabe/fxml/FinanzierungMaske.fxml"));
            Parent root = (Parent) myLoader.load();
            FinanzierungMaskeController tmp = ((FinanzierungMaskeController) myLoader.getController());
            //tmp.setApp(this);
            tmp.setFinanzierung(finanzierung, fensterart);
            popup.setContentNode(root);
            Point2D point = addFinanzierung.localToScreen(0.0, 0.0);

            popup.setArrowLocation(PopOver.ArrowLocation.LEFT_BOTTOM);
            popup.show(addFinanzierung, point.getX() + addFinanzierung.getWidth(), point.getY() + (addFinanzierung.getHeight() / 2));

        } catch (IOException ex) {
            Logger.getLogger(VerbindlichkeitanlegenController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void handleClosePopup() {
        popup.hide();
    }

}
