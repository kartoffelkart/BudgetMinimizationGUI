/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.fxml;

import projektaufgabe.bdo.Buchung;
import projektaufgabe.service.Service;
import csunibonn.ris.javafx.platform.components.PlatformWindow;
import csunibonn.ris.javafx.platform.settings.PlatformSettingsManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Popup;
import javafx.stage.Stage;
import splendidtableview.javafx.SplendidTableView;

/**
 * FXML Controller class
 *
 * @author Meike Brülls <s6mebrue@uni-bonn.de>
 */
public class ImportController implements Initializable, PlatformWindow {

    @FXML
    private StackPane pane;
    private SplendidTableView<Buchung> tableBuchungen;

    private TableColumn<Buchung, Integer> columnIns2;
    private TableColumn<Buchung, Integer> columnIns3;
    private TableColumn<Buchung, Integer> columnHuel;

    private Label labelDaten = new Label();
    private Label labelDatensatz = new Label();
    private Button buttonDelete = new Button("Delete");
    private Button buttonImport = new Button("Import");

    private final Service service = Service.getInstance();

    private Stage stage;

    private ObservableList<Buchung> testListe = FXCollections.observableArrayList();
    private ObservableList<Buchung> dbListe = FXCollections.observableArrayList();
    private ObservableList<Buchung> neueListe = FXCollections.observableArrayList();

    private String pfad;
    int count = 0;

    //Variablen zur Zuteilung der Spalten
    int jahrS = 0;
    int kapS = 0;
    int titelS = 0;
    int lieferantS = 0;
    int utS = 0;
    int fbS = 0;
    int insS = 0;
    int ins2S = 0;
    int ins3S = 0;
    int huelS = 0;
    int uS = 0;
    int kennz1S = 0;
    int betragS = 0;
    int bdatumS = 0;
    int grund1S = 0;
    int grund2S = 0;
    int auftragsnrS = 0;
    int rechnungsdatumS = 0;
    int fibuS = 0;
    int rechnungsnrS = 0;
    int kostenartS = 0;
    int kostenstelleS = 0;
    int kostentraegerS = 0;
    int bgaS = 0;
    int kassenzeichenS = 0;
    int kennz2S = 0;
    int opS = 0;
    int awS = 0;

    AenderungController aController = new AenderungController();
    PlatformSettingsManager psm = PlatformSettingsManager.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initSettings();
        Locale.setDefault(Locale.GERMAN);
        initializeSplendidTable();
        handleDateiChooser();

    }

    /**
     * Setzt die Settingsmanagerdatei falls es sie noch nicht gibt und fügt ihr
     * in dem Fall alle Attribute hinzu.
     */
    private void initSettings() {

        if (psm.getCustomElement("checkExist") == null) {

            psm.storeCustomElement("import.Jahr", "Jahr");
            psm.storeCustomElement("import.Kapitel", "Kap");
            psm.storeCustomElement("import.Titel", "Titel");
            psm.storeCustomElement("import.Lieferant", "Lieferant");
            psm.storeCustomElement("import.Ut", "Ut");
            psm.storeCustomElement("import.Ins", "Ins");
            psm.storeCustomElement("import.Ins2", "Ins2");
            psm.storeCustomElement("import.Ins3", "Ins3");
            psm.storeCustomElement("import.Fb", "Fb");
            psm.storeCustomElement("import.Huel", "HUEL");
            psm.storeCustomElement("checkExist", "true");
            psm.storeCustomElement("import.U", "U");
            psm.storeCustomElement("import.Kennz1", "Kennz1");
            psm.storeCustomElement("import.Betrag", "Betrag");
            psm.storeCustomElement("import.BDatum", "BDatum");
            psm.storeCustomElement("import.Grund1", "Grund1");
            psm.storeCustomElement("import.Grund2", "Grund2");
            psm.storeCustomElement("import.AuftragsNr", "AuftragsNr");
            psm.storeCustomElement("import.RechnungsDatum", "RechnungsDatum");
            psm.storeCustomElement("import.Fibu", "Fibu");
            psm.storeCustomElement("import.RechungsNr", "RechungsNr");
            psm.storeCustomElement("import.Kostenart", "Kostenart");
            psm.storeCustomElement("import.Kostenstelle", "Kostenstelle");
            psm.storeCustomElement("import.Kostentraeger", "Kostentraeger");
            psm.storeCustomElement("import.BGA", "BGA");
            psm.storeCustomElement("import.Kassenzeichen", "Kassenzeichen");
            psm.storeCustomElement("import.Kennz2", "Kennz2");
            psm.storeCustomElement("import.OP", "OP");
            psm.storeCustomElement("import.AW", "AW");

        }
    }

    /**
     * Hier werden das Hauptfenster mit der Tabelle etc und der Footer
     * initialisiert.
     */
    private void initializeSplendidTable() {

        //create Table
        tableBuchungen = new SplendidTableView<>();
        tableBuchungen.setPrefHeight(5000);
        tableBuchungen.setMaxHeight(5000);
        tableBuchungen.setPadding(new Insets(5, 5, 5, 5));
        pane.getChildren().add(tableBuchungen);

        //create columns
        tableBuchungen.createColumn("Jahr", true, b -> b.getJahrProperty()).setMinWidth(15);
        tableBuchungen.createColumn("Kapitel", true, b -> b.getKapProperty());
        tableBuchungen.createColumn("Titel", true, b -> b.getTitelProperty());
        tableBuchungen.createColumn("Lieferant", true, b -> b.getLieferantProperty());
        tableBuchungen.createColumn("Ut", true, b -> b.getUtProperty());
        tableBuchungen.createColumn("Fb", true, b -> b.getFbProperty());
        tableBuchungen.createColumn("Ins", true, b -> b.getInsProperty());
        tableBuchungen.createColumn("Ins2", true, b -> b.getIns2Property());
        tableBuchungen.createColumn("Ins3", true, b -> b.getIns3Property());
        tableBuchungen.createColumn("Huel", true, b -> b.getHuelProperty());
        tableBuchungen.createColumn("U", true, b -> b.getUProperty());
        tableBuchungen.createColumn("Kennz1", true, b -> b.getKennz1Property());
        tableBuchungen.createColumn("Betrag", true, b -> b.getBetragProperty());
        tableBuchungen.createColumn("BDatum", true, b -> b.getBDatumProperty());
        tableBuchungen.createColumn("Personalbuchung", true, b -> b.getPersonalbuchungProperty());
        tableBuchungen.createColumn("Grund1", true, b -> b.getGrund1Property());
        tableBuchungen.createColumn("Nachname", true, b -> b.getNachnameProperty());
        tableBuchungen.createColumn("Vorname", true, b -> b.getVornameProperty());
        tableBuchungen.createColumn("Grund2", true, b -> b.getGrund2Property());
        tableBuchungen.createColumn("AuftragsNr", true, b -> b.getAuftragsNrProperty());
        tableBuchungen.createColumn("RechnungsDatum", true, b -> b.getRechnungsDatumProperty());
        tableBuchungen.createColumn("FIBU-B-Dat", true, b -> b.getFibuProperty());
        tableBuchungen.createColumn("RechnungsNr", true, b -> b.getRechnungsNrProperty());
        tableBuchungen.createColumn("Kostenart", true, b -> b.getKostenartProperty());
        tableBuchungen.createColumn("Kostenstelle", true, b -> b.getKostenstelleProperty());
        tableBuchungen.createColumn("Kostentraeger", true, b -> b.getKostentraegerProperty());
        tableBuchungen.createColumn("BGA", true, b -> b.getBGAProperty());
        tableBuchungen.createColumn("Kassen-Zeichen", true, b -> b.getKassenzeichenProperty());
        tableBuchungen.createColumn("Kennz2", true, b -> b.getKennz2Property());
        tableBuchungen.createColumn("OP", true, b -> b.getOPProperty());
        tableBuchungen.createColumn("AW", true, b -> b.getAWProperty());

        //footer
        Separator separator = new Separator();
        separator.setVisible(false);
        separator.setPrefWidth(50);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(labelDaten, labelDatensatz, separator, buttonDelete, buttonImport);
        hBox.setPadding(new Insets(10, 0, 10, 10));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_LEFT);

        buttonDelete.setOnAction(e -> {
            handleDeleteRow();
        });
        buttonImport.setOnAction(e -> {
            handleImport();
        });

        tableBuchungen.setFooter(hBox);
    }

    /**
     * Öffnet das Fenster zum Datei-Auswählen
     */
    private void handleDateiChooser() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Datei wählen");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Textdateien", "*.txt"));
        File selectedFile
                = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {

            try {
                pfad = selectedFile.getCanonicalPath();
                pfad = pfad.replace('\\', '/');

                textAuslesen();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Liest den Test aus der TextDatei Zeile für Zeile aus und splittet jeweils
     * den Text einer Zeile jeweils nach einem Tab
     *
     * Aus jeder Zeile wird ein String-Array erstellt, in seinen Arrays werden
     * die jeweiligen Tab-Abschnitte gespeichert
     */
    private void textAuslesen() {

        if (pfad.isEmpty()) {

        } else {

            try {

                FileReader fr = new FileReader(pfad);

                BufferedReader br = new BufferedReader(fr);

                String zeile = "";

                while ((zeile = br.readLine()) != null) {

                    //    "\\t" steht für Tabulator
                    String[] teilText = zeile.split("\\t");
                    count = count + 1;

                    objekteErstellen(teilText, count);
                }

                br.close();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println(testListe.size() + " Anzahl der Datensätze");

        setWindow();

    }

    /**
     * Liest aus dem String-Array die einzelnen Felder aus und prüft, ob sie in
     * Zeile 1 des Textdokuments standen (dann werden die verschiedenen Spalten
     * zugeordnet) oder einer Zeile >1 standen (dann wird aus jedem String[]
     * Array ein "Test"-Objekt erstellt). Alle diese Objekte werden außerdem
     * einer ObservableList hinzugefügt.
     *
     * @param teilText ein String[], in dem die einzelnen Abschnitte der Zeilen
     * stehen, die aus dem Text.txt ausgelesen wurden
     */
    private void objekteErstellen(String[] teilText, int count) {

        /* Count spiegelt die Zeilenanzahl im Textdokument wieder (in Zeile 1
         stehen die Überschriften). Das bedeutet hier wird geschaut, welche
         Spalte an welcher Stelle in der Textdatei steht.
         */
        if (count == 1) {

            for (int i = 0; i < teilText.length; i++) {

                if (teilText[i].contains((String) psm.getCustomElement("import.Jahr"))) {
                    jahrS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Kapitel"))) {
                    kapS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Titel"))) {
                    titelS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Lieferant"))) {
                    lieferantS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Ut"))) {
                    utS = i;
                }
                if (teilText[i].equals((String) psm.getCustomElement("import.Ins"))) {
                    insS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Ins2"))) {
                    ins2S = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Ins3"))) {
                    ins3S = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Fb"))) {
                    fbS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Huel"))) {
                    huelS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.U"))) {
                    uS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Kennz1"))) {
                    kennz1S = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Betrag"))) {
                    betragS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.BDatum"))) {
                    bdatumS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Grund1"))) {
                    grund1S = i;
                }
                if (teilText[i].equals((String) psm.getCustomElement("import.Grund2"))) {
                    grund2S = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.AuftragsNr"))) {
                    auftragsnrS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.RechnungsDatum"))) {
                    rechnungsdatumS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Fibu"))) {
                    fibuS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.RechungsNr"))) {
                    rechnungsnrS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Kostenart"))) {
                    kostenartS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Kostenstelle"))) {
                    kostenstelleS = i;
                }
                if (teilText[i].equals((String) psm.getCustomElement("import.Kostentraeger"))) {
                    kostentraegerS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.BGA"))) {
                    bgaS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Kassenzeichen"))) {
                    kassenzeichenS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.Kennz2"))) {
                    kennz2S = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.OP"))) {
                    opS = i;
                }
                if (teilText[i].contains((String) psm.getCustomElement("import.AW"))) {
                    awS = i;
                }
            }
        }

        // Aus allen Zeilen des Textdokuments (außer der ersten) werden
        // Buchungsobjekte erstellt
        if (count > 1) {
            try {

                Buchung buchung = new Buchung();
                buchung.setPersonalbuchung(false);

                if (teilText.length > jahrS && !teilText[jahrS].isEmpty()) {
                    buchung.setJahr(Integer.parseInt(teilText[jahrS]));
                }
                if (teilText.length > kapS && !teilText[kapS].isEmpty()) {
                    buchung.setKap(teilText[kapS]);
                }
                if (teilText.length > titelS && !teilText[titelS].isEmpty()) {
                    buchung.setTitel(teilText[titelS]);
                }
                if (teilText.length > lieferantS && !teilText[lieferantS].isEmpty()) {
                    buchung.setLieferant(teilText[lieferantS]);
                }
                if (teilText.length > utS && !teilText[utS].isEmpty()) {
                    buchung.setUt(teilText[utS]);
                }
                if (teilText.length > fbS && !teilText[fbS].isEmpty()) {
                    buchung.setFb(teilText[fbS]);
                }
                if (teilText.length > insS && !teilText[insS].isEmpty()) {
                    buchung.setIns(teilText[insS]);
                }
                if (teilText.length > ins2S && !teilText[ins2S].isEmpty()) {
                    buchung.setIns2(teilText[ins2S]);
                }
                if (teilText.length > ins3S && !teilText[ins3S].isEmpty()) {
                    buchung.setIns3(teilText[ins3S]);
                }
                if (teilText.length > huelS && !teilText[huelS].isEmpty()) {
                    buchung.setHuel(teilText[huelS]);
                }
                if (teilText.length > uS && !teilText[uS].isEmpty()) {
                    buchung.setU(teilText[uS]);
                }
                if (teilText.length > kennz1S && !teilText[kennz1S].isEmpty()) {
                    buchung.setKennz1(teilText[kennz1S]);
                }
                if (teilText.length > betragS && !teilText[betragS].isEmpty()) {
                    buchung.setBetrag(teilText[betragS]);
                }
                if (teilText.length > bdatumS && !teilText[bdatumS].isEmpty()) {
                    buchung.setBDatum(teilText[bdatumS]);
                }
                if (teilText.length > grund1S && !teilText[grund1S].isEmpty()) {
                    buchung.setGrund1(teilText[grund1S]);
                }
                if (teilText.length > grund2S && !teilText[grund2S].isEmpty()) {
                    buchung.setGrund2(teilText[grund2S]);
                }
                if (teilText.length > auftragsnrS && !teilText[auftragsnrS].isEmpty()) {
                    buchung.setAuftragsNr(teilText[auftragsnrS]);
                }
                if (teilText.length > rechnungsdatumS && !teilText[rechnungsdatumS].isEmpty()) {
                    buchung.setRechnungsDatum(teilText[rechnungsdatumS]);
                }
                if (teilText.length > fibuS && !teilText[fibuS].isEmpty()) {
                    buchung.setFibu(teilText[fibuS]);
                }
                if (teilText.length > rechnungsnrS && !teilText[rechnungsnrS].isEmpty()) {
                    buchung.setRechnungsNr(teilText[rechnungsnrS]);
                }
                if (teilText.length > kostenartS && !teilText[kostenartS].isEmpty()) {
                    buchung.setKostenart(teilText[kostenartS]);
                }
                if (teilText.length > kostenstelleS && !teilText[kostenstelleS].isEmpty()) {
                    buchung.setKostenstelle(teilText[kostenstelleS]);
                }
                if (teilText.length > kostentraegerS && !teilText[kostentraegerS].isEmpty()) {
                    buchung.setKostentraeger(teilText[kostentraegerS]);
                }
                if (teilText.length > bgaS && !teilText[bgaS].isEmpty()) {
                    buchung.setBGA(teilText[bgaS]);
                }
                if (teilText.length > kassenzeichenS && !teilText[kassenzeichenS].isEmpty()) {
                    buchung.setKassenzeichen(teilText[kassenzeichenS]);
                }
                if (teilText.length > kennz2S && !teilText[kennz2S].isEmpty()) {
                    buchung.setKennz2(teilText[kennz2S]);
                }
                if (teilText.length > opS && !teilText[opS].isEmpty()) {
                    buchung.setOP(teilText[opS]);
                }
                if (teilText.length > awS && !teilText[awS].isEmpty()) {
                    buchung.setAW(teilText[awS]);
                }

                if (teilText[titelS].startsWith("4")) {

                    buchung.setPersonalbuchung(true);
                    setNames(buchung);
                }

                testListe.add(buchung);

            } catch (NumberFormatException e) {

            }

        }
    }

    /**
     * Erstellt die Daten für die Attribute "Nachname" und "Vorname" aus dem
     * Attribut "Grund1"
     *
     * @param buchung
     */
    private void setNames(Buchung buchung) {

        System.out.println(buchung.getGrund1().toString());

        String[] allNames = buchung.getGrund1().split("\\s*,\\s*");

        String vorname = allNames[1];
        String nachname = allNames[0];

        buchung.setVorname(vorname);
        buchung.setNachname(nachname);
    }

    /**
     * Füllt die Tabelle mit den Daten aus den eben erstellten Objekten
     */
    private void setWindow() {

        compareData();

        Integer countDs = neueListe.size();

        labelDaten.setText(countDs.toString());

        if (countDs == 1) {
            labelDatensatz.setText(" Datensatz");
        } else {
            labelDatensatz.setText(" Datensätze importierbar.");
        }

        tableBuchungen.setItems(neueListe);

    }

    /**
     * Hier sollen die einzelnen TestObjekte aus jeweils aus Textdatei und aus
     * der Datenbank abgerufen werden um später verglichen zu werden (über
     * String- Vergleich, da die jeweiligen PrimaryKeys NICHT mit verglichen
     * werden sollen).
     */
    private void compareData() {

        dbListe = service.getAllBuchung();

        System.out.println("Aus der Datenbank kommen " + dbListe.size() + " Daten.");

        for (int i = 0; i < testListe.size(); i++) {

            boolean gleich = false;

            Buchung b1 = testListe.get(i);

            String t1Text = b1.toString();

            for (int j = 0; j < dbListe.size(); j++) {

                Buchung b2 = dbListe.get(j);

                String t2Text = b2.toString();

                if (t1Text.equals(t2Text)) {
                    gleich = true;
                }
            }

            if (gleich == false) {

                neueListe.add(b1);
            }
        }

    }

    /**
     * Löscht eine Zeile aus der Tabelle im Programm und aus der Liste, so dass
     * sie nicht mit importiert werden kann.
     */
    private void handleDeleteRow() {

        Buchung t = tableBuchungen.getSelectedItem();

        tableBuchungen.deleteItem(t);

        Integer countDs = tableBuchungen.getItemCountAll();

        labelDaten.setText(countDs.toString());

    }

    /**
     * Importiert die Daten aus der Tabelle im Programm in die Datenbank
     */
    private void handleImport() {

        tableBuchungen.getItemsAll().stream().forEach((b) -> {
            service.saveOrUpdateBuchung(b);
        });

        handleAenderungGespeichert();
    }

    /**
     * Öffnet ein PopUp, dass nach dem Import geöffnet wird um dem User die
     * (nicht-)erfolgreiche Importierung zu verkünden.
     */
    private void handleAenderungGespeichert() {

        Integer countDs = neueListe.size();
        String text;

        if (countDs > 0) {
            text = "Die Daten wurden importiert! ";
        } else {
            text = "Es sind keine Daten zum importieren vorhanden! ";
        }
        try {
            Popup popup = new Popup();
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("aenderung.fxml"));
            Parent root = (Parent) myLoader.load();
            popup.getContent().add(root);
            popup.show(pane, 300, 200);
            aController = ((AenderungController) myLoader.getController());
            aController.setApp(this);
            aController.setLabelText(text);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleAction(Object[] os) {

    }

    @Override
    public Pane getPane() {
        return pane;
    }

    @Override
    public String getTitle() {
        return "Buchungsimport";
    }

}
