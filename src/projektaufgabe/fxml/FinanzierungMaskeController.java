
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.fxml;

import csunibonn.ris.javafx.platform.PlatformActionHandler;

import csunibonn.ris.javafx.platform.components.PlatformWindow;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.util.converter.NumberStringConverter;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;
import projektaufgabe.bdo.DMBewilligung;
import projektaufgabe.bdo.DMFinanzierung;
import projektaufgabe.bdo.Finanzierung;
import projektaufgabe.bdo.PBMFinanzierung;
import projektaufgabe.bdo.QMBewilligung;
import projektaufgabe.bdo.QMFinanzierung;
import projektaufgabe.bdo.Stelle;
import projektaufgabe.bdo.VBSFinanzierung;
import projektaufgabe.bdo.Verbuchungsstelle;
import projektaufgabe.service.Service;

/**
 * FXML Controller class
 *
 * @author Sonja
 */
public class FinanzierungMaskeController implements Initializable, PlatformWindow {

    @FXML
    private StackPane pane;

    @FXML
    private Label finanzierungsart;
    @FXML
    private TextField anteilVZ;

    @FXML
    private StackPane paneFinanzierung;
    @FXML
    private TextArea bemerkung;
//-------------------------------paneVBS
    @FXML
    private StackPane panevbs;
    @FXML
    private TextField pn;
    @FXML
    private TextField titel;
    @FXML
    private TextField kapitel;
    @FXML
    private TextField position;
    @FXML
    private TextField zweck;
    @FXML
    private TextField ut;
//-------------------------------paneDM
    @FXML
    private StackPane panedm;
    @FXML
    private TextField dmfnr;
//-------------------------------paneQM
    @FXML
    private StackPane paneqmf;
    @FXML
    private TextField qmfnr;

//-------------------------------panePBM
    @FXML
    private StackPane panepbm;
    @FXML
    private TextField stelle;
    //----------------------
    @FXML
    Separator seperator;
//-------------------------------Buttons
    @FXML
    private Button abbrechen;

    @FXML
    private Button addFinanzierung;
//---------------------------------------
    private Popup popupVerb;

    private final Service service = Service.getInstance();
    private PlatformActionHandler handler = PlatformActionHandler.getInstance();

    private VerbindlichkeitanlegenController caller;

    private Finanzierung finanzierung;
    private String fall;

    Verbuchungsstelle selectedVerbuchungsstelle;

    private ObservableList<Verbuchungsstelle> liste_verbuchungsstellen = service.getAllVerbuchungsstelle();
    // Wrap the ObservableList in a FilteredList (initially display all data).
    FilteredList<Verbuchungsstelle> filteredDataVerbuchungsstelle = new FilteredList<>(liste_verbuchungsstellen, p -> true);
    private ListView<Verbuchungsstelle> listViewVerb = new ListView<>(filteredDataVerbuchungsstelle);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void setFilteredListVerbuchungsstellePredicate() {
//        prozentVZ.setOnMouseClicked((MouseEvent mouseevent) -> {
//
//            if (mouseevent.getButton() == MouseButton.SECONDARY) {
//                ContextMenu contextTextFieldAntVZRightClick = new ContextMenu();
//                MenuItem changevonVZzuTZitem = new MenuItem("Umschalten auf Abdeckung der Teilzeitstelle in %");
//                changevonVZzuTZitem.setOnAction((ActionEvent event2) -> {
//                  
//                    if(anteilVZ.isVisible()){
//                    anteilTZ.setVisible(true);
//                    anteilTZ.setEditable(true);
//                    anteilVZ.setVisible(false);
//                    anteilVZ.setEditable(false);
//                    prozentTZ.setVisible(true);
//                    prozentTZ.setDisable(false);
//                    prozentVZ.setVisible(false);
//                    prozentVZ.setDisable(true);}
//                    else{
//                        anteilTZ.setVisible(false);
//                    anteilTZ.setEditable(false);
//                    anteilVZ.setVisible(true);
//                    anteilVZ.setEditable(true);
//                    prozentTZ.setVisible(false);
//                    prozentTZ.setDisable(true);
//                    prozentVZ.setVisible(true);
//                    prozentVZ.setDisable(false);
//                    }
//
//                });
//                contextTextFieldAntVZRightClick.getItems().addAll(changevonVZzuTZitem);
//
//                contextTextFieldAntVZRightClick.show(prozentVZ, mouseevent.getScreenX(), mouseevent.getScreenY());
//                System.out.println("VZ");
//
//            }
//        });

//        prozentTZ.setOnMouseClicked((MouseEvent mouseevent) -> {
//
//            if (mouseevent.getButton() == MouseButton.SECONDARY) {
//                ContextMenu contextTextFieldAntTZRightClick = new ContextMenu();
//                MenuItem changevonTZzuVZitem = new MenuItem("Abdeckung einer Vollzeitstelle in %");
//                changevonTZzuVZitem.setOnAction((ActionEvent event2) -> {
//                    anteilTZ.setVisible(false);
//                    anteilTZ.setEditable(false);
//                    anteilVZ.setVisible(true);
//                    anteilVZ.setEditable(true);
//                    prozentTZ.setVisible(false);
//                    prozentTZ.setDisable(true);
//                    prozentVZ.setVisible(true);
//                    prozentVZ.setDisable(false);
//
//                });
//                contextTextFieldAntTZRightClick.getItems().addAll(changevonTZzuVZitem);
//
//                contextTextFieldAntTZRightClick.show(prozentTZ, mouseevent.getScreenX(), mouseevent.getScreenY());
//                System.out.println("TZ");
//            }
//        });
        //mache popup mit listview mit filteredList
        listViewVerb.setMaxHeight(150.0);
        popupVerb = new Popup();
        popupVerb.getContent().add(listViewVerb);

        // bei Auswahl durch doppelklick alle Attribute übernehmen und popup ausblenden
        listViewVerb.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    Verbuchungsstelle p = listViewVerb.getSelectionModel().getSelectedItem();
                    if (selectedVerbuchungsstelle != null) {
                        kapitel.setText(selectedVerbuchungsstelle.getKapitel());
                        titel.setText(selectedVerbuchungsstelle.getTitel());
                        ut.setText(selectedVerbuchungsstelle.getUntertitel());
                        position.setText(selectedVerbuchungsstelle.getPosition());
                        pn.setText(selectedVerbuchungsstelle.getPn());
                        zweck.setText(selectedVerbuchungsstelle.getZweck());

                        popupVerb.hide();

                    }
                }
            }
        });
        // bei Auswahl durch Enter alle Attribute übernehmen und popup ausblenden
        listViewVerb.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                selectedVerbuchungsstelle = listViewVerb.getSelectionModel().getSelectedItem();
                if (selectedVerbuchungsstelle != null) {
                    kapitel.setText(selectedVerbuchungsstelle.getKapitel());
                    titel.setText(selectedVerbuchungsstelle.getTitel());
                    ut.setText(selectedVerbuchungsstelle.getUntertitel());
                    position.setText(selectedVerbuchungsstelle.getPosition());
                    pn.setText(selectedVerbuchungsstelle.getPn());
                    zweck.setText(selectedVerbuchungsstelle.getZweck());

                    popupVerb.hide();

                }
            }
        });

        kapitel.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyVerbuchungsstelle();
            showPopup();

        });

        kapitel.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupVerb.hide();
            }
        });
        titel.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyVerbuchungsstelle();
            showPopup();

        });

        titel.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupVerb.hide();
            }
        });
        ut.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyVerbuchungsstelle();
            showPopup();

        });

        ut.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupVerb.hide();
            }
        });
        position.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyVerbuchungsstelle();
            showPopup();

        });

        position.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupVerb.hide();
            }
        });
        pn.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyVerbuchungsstelle();
            showPopup();

        });

        pn.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupVerb.hide();
            }
        });
        zweck.textProperty().addListener((observable, oldValue, newValue) -> {

            handleFilterApplyVerbuchungsstelle();
            showPopup();
        });

        zweck.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                popupVerb.hide();
            }
        });
    }

    private void showPopup() {
        //wenn die lilteredList leer ist popup ausblenden 
        if (listViewVerb.getItems().isEmpty()) {
            if (popupVerb.isShowing()) {
                popupVerb.hide();
            }
        } else {
            //wenn die filteresList nicht leer ist, und es sich gerade noch nicht zeigt, dann zeige es 
            if (!popupVerb.isShowing()) {

                Point2D point = seperator.localToScreen(0.0, 0.0);
                try {
                    popupVerb.show(seperator, point.getX(), point.getY());
                } catch (Exception e) {
                    System.out.println("PredicateException");

                }

            }
            if (listViewVerb.getSelectionModel().getSelectedItem() == null) {
                listViewVerb.getSelectionModel().select(0);
            }

        }

    }

    private void handleFilterApplyVerbuchungsstelle() {
        Predicate<Verbuchungsstelle> pr = p -> {
            return true;
        };
//kapitel
        String filter_kapitel = kapitel.getText();

        if (filter_kapitel != null && !filter_kapitel.isEmpty()) {
            pr = p -> {
                return p.getKapitel().startsWith(filter_kapitel);
            };
        }
        //titel
        String filter_titel = titel.getText();
        if (filter_titel != null && !filter_titel.isEmpty()) {
            pr = pr.and(p -> {
                return p.getTitel().startsWith(filter_titel);
            });
        }
        //ut
        String filter_ut = ut.getText();
        if (filter_ut != null && !filter_ut.isEmpty()) {
            pr = pr.and(p -> {
                return p.getUntertitel().startsWith(filter_ut);
            });
        }
        //position
        String filter_position = position.getText();
        if (filter_position != null && !filter_position.isEmpty()) {
            pr = pr.and(p -> {
                return p.getPosition().startsWith(filter_position);
            });
        }
        //pn
        String filter_pn = pn.getText();
        if (filter_pn != null && !filter_pn.isEmpty()) {
            pr = pr.and(p -> {
                return p.getPn().startsWith(filter_pn);
            });
        }

        filteredDataVerbuchungsstelle.setPredicate(pr);
    }

    public void setFinanzierung(Finanzierung finanzierung, String fensterart) {
        this.finanzierung = finanzierung;
        finanzierungsart.textProperty().bind(finanzierung.getFinanzierungsTypProperty());
        bemerkung.textProperty().bindBidirectional(finanzierung.getBemerkungProperty());
        anteilVZ.textProperty().bindBidirectional(finanzierung.getAnteilProperty(), new NumberStringConverter());
        anteilVZ.setTooltip(new Tooltip(finanzierung.getAnteil() + " % einer VZ-Stelle werden durch diese Finanzierung abgedeckt"));
        ContextMenu contextSwitchPercentageMode = new ContextMenu();
        MenuItem tzItem = new MenuItem("open Eingabe in % von Verbindlichkeit");
        tzItem.setOnAction((ActionEvent event) -> {
            System.out.println("So weiter gehts");
        });
        contextSwitchPercentageMode.getItems().addAll(tzItem);
        anteilVZ.setContextMenu(contextSwitchPercentageMode);

        setFilteredListVerbuchungsstellePredicate();

        if (finanzierung instanceof QMFinanzierung) {
            showQMPane(fensterart);
        } else {
            if (finanzierung instanceof DMFinanzierung) {
                showDMPane(fensterart);
            } else {
                if (finanzierung instanceof VBSFinanzierung) {
                    showVBSPane(fensterart);
                } else {
                    if (finanzierung instanceof PBMFinanzierung) {
                        showPBMPane(fensterart);
                    }
                }
            }
        }

    }

    private void showVBSPane(String fensterart) {

        panevbs.setVisible(true);
        panevbs.setDisable(false);

        panepbm.setVisible(false);
        panepbm.setDisable(true);

        paneqmf.setVisible(false);
        paneqmf.setDisable(true);

        panedm.setVisible(false);
        panedm.setDisable(true);

        kapitel.textProperty().bindBidirectional(((VBSFinanzierung) finanzierung).getVerbuchungsstelle().getKapitelProperty());
        ut.textProperty().bindBidirectional(((VBSFinanzierung) finanzierung).getVerbuchungsstelle().getUntertitelProperty());
        position.textProperty().bindBidirectional(((VBSFinanzierung) finanzierung).getVerbuchungsstelle().getPositionProperty());
        titel.textProperty().bindBidirectional(((VBSFinanzierung) finanzierung).getVerbuchungsstelle().getTitelProperty());
        pn.textProperty().bindBidirectional(((VBSFinanzierung) finanzierung).getVerbuchungsstelle().getPnProperty());
        zweck.textProperty().bindBidirectional(((VBSFinanzierung) finanzierung).getVerbuchungsstelle().getZweckProperty());

    }

    private void showQMPane(String fensterart) {

        panevbs.setVisible(true);
        panevbs.setDisable(false);

        paneqmf.setVisible(true);
        paneqmf.setDisable(false);

        panepbm.setVisible(false);
        panepbm.setDisable(true);

        panedm.setVisible(false);
        panedm.setDisable(true);

        kapitel.textProperty().bindBidirectional(((QMFinanzierung) finanzierung).getVerbuchungsstelle().getKapitelProperty());
        ut.textProperty().bindBidirectional(((QMFinanzierung) finanzierung).getVerbuchungsstelle().getUntertitelProperty());
        position.textProperty().bindBidirectional(((QMFinanzierung) finanzierung).getVerbuchungsstelle().getPositionProperty());
        titel.textProperty().bindBidirectional(((QMFinanzierung) finanzierung).getVerbuchungsstelle().getTitelProperty());
        pn.textProperty().bindBidirectional(((QMFinanzierung) finanzierung).getVerbuchungsstelle().getPnProperty());
        zweck.textProperty().bindBidirectional(((QMFinanzierung) finanzierung).getVerbuchungsstelle().getZweckProperty());
        qmfnr.textProperty().bindBidirectional(((QMFinanzierung) finanzierung).getQmbewilligung().getBewilligungsNrProperty());
    }

    private void showDMPane(String fensterart) {

        panevbs.setVisible(true);
        panevbs.setDisable(false);

        panedm.setVisible(true);
        panedm.setDisable(false);

        panepbm.setVisible(false);
        panepbm.setDisable(true);

        paneqmf.setVisible(false);
        paneqmf.setDisable(true);

        kapitel.textProperty().bindBidirectional(((DMFinanzierung) finanzierung).getVerbuchungsstelle().getKapitelProperty());
        ut.textProperty().bindBidirectional(((DMFinanzierung) finanzierung).getVerbuchungsstelle().getUntertitelProperty());
        position.textProperty().bindBidirectional(((DMFinanzierung) finanzierung).getVerbuchungsstelle().getPositionProperty());
        titel.textProperty().bindBidirectional(((DMFinanzierung) finanzierung).getVerbuchungsstelle().getTitelProperty());
        pn.textProperty().bindBidirectional(((DMFinanzierung) finanzierung).getVerbuchungsstelle().getPnProperty());
        zweck.textProperty().bindBidirectional(((DMFinanzierung) finanzierung).getVerbuchungsstelle().getZweckProperty());
        dmfnr.textProperty().bindBidirectional(((DMFinanzierung) finanzierung).getDmbewilligung().getBewilligungsNrProperty());
    }

    private void showPBMPane(String fensterart) {

        panevbs.setVisible(false);
        panevbs.setDisable(true);

        panepbm.setVisible(true);
        panepbm.setDisable(false);

        paneqmf.setVisible(false);
        paneqmf.setDisable(true);

        panedm.setVisible(false);
        panedm.setDisable(true);

        stelle.textProperty().bindBidirectional(((PBMFinanzierung) finanzierung).getStelle().getStellenNrProperty());
    }

    private void abbrechen() {
//finanzierung ist bidirectional gebunden daher refresh notwendig
        if (finanzierung.getId() != null) {
            service.refreshFinanzierung(finanzierung);

        } else {
            handler.notifyTarget("fxml/Verbindlichkeitanlegen.fxml", new Object[]{finanzierung});

        }
        pane.getScene().getWindow().hide();

    }

    @FXML
    private void handleFinanzierungUebernehmen(ActionEvent event) {

        if (finanzierung instanceof QMFinanzierung) {
            qMFinanzierungUebernehmen();
        } else {
            if (finanzierung instanceof DMFinanzierung) {
                dMFinanzierungUebernehmen();
            } else {
                if (finanzierung instanceof VBSFinanzierung) {
                    vBSFinanzierungUebernehmen();
                } else {
                    if (finanzierung instanceof PBMFinanzierung) {
                        pBMFinanzierungUebernehmen();
                    }
                }
            }
        }

    }

    private Verbuchungsstelle findeVerbuchungsstelle() {

        List<Verbuchungsstelle> verList = service.getVerbuchungsstelleByName(kapitel.getText(), titel.getText(), ut.getText(), position.getText(), pn.getText(), zweck.getText());
        if (verList.isEmpty()) {

            Action action = Dialogs.create()
                    .title("Verbuchungsstelle nicht gefunden")
                    .message("Die Verbuchungsstelle ist nicht in der Datenbank vorhanden.")
                    .actions(new Action[]{Dialog.ACTION_CLOSE})//Actions.YES, Dialog.Actions.NO})
                    .showConfirm();
            if (action == Dialog.ACTION_CLOSE) {
//                abbrechen();
            }
            return null;
        } else {
            return verList.get(0);
        }
    }

    private QMBewilligung findeQMBewilligung() {
        List<QMBewilligung> qmBewilligungsListe = service.getQMBewilligungByNr(this.qmfnr.getText());
        if (qmBewilligungsListe.isEmpty()) {

            Action action = Dialogs.create()
                    .title("QM-Bewilligung nicht gefunden")
                    .message("Die QM-Bewilligung  ist nicht in der Datenbank vorhanden.")
                    .actions(new Action[]{Dialog.ACTION_CLOSE})//Actions.YES, Dialog.Actions.NO})
                    .showConfirm();
            if (action == Dialog.ACTION_CLOSE) {
//                abbrechen();
            }
            return null;

        } else {
            return qmBewilligungsListe.get(0);

        }
    }

    private DMBewilligung findeDMBewilligung() {
        List<DMBewilligung> dmBewilligungsListe = service.getDMBewilligungByNr(this.dmfnr.getText());
        if (dmBewilligungsListe.isEmpty()) {

            Action action = Dialogs.create()
                    .title("DM-Bewilligung nicht gefunden")
                    .message("Die DM-Bewilligung  ist nicht in der Datenbank vorhanden.")
                    .actions(new Action[]{Dialog.ACTION_CLOSE})//Actions.YES, Dialog.Actions.NO})
                    .showConfirm();
            if (action == Dialog.ACTION_CLOSE) {
//                abbrechen();
            }
            return null;
        }
        return dmBewilligungsListe.get(0);
    }

    private Stelle findeStelle() {
        List<Stelle> stelle = service.getStellenByNr(this.stelle.getText());
        if (stelle.isEmpty()) {

            Action action = Dialogs.create()
                    .title("Stelle nicht gefunden")
                    .message("Die Stelle ist nicht in der Datenbank vorhanden.")
                    .actions(new Action[]{Dialog.ACTION_CLOSE})//Actions.YES, Dialog.Actions.NO})
                    .showConfirm();
            if (action == Dialog.ACTION_CLOSE) {
//                abbrechen();
            }
            return null;
        }
        return stelle.get(0);

    }

    private void vBSFinanzierungUebernehmen() {
        if (findeVerbuchungsstelle() != null) {
            ((VBSFinanzierung) finanzierung).setVerbuchungsstelle(findeVerbuchungsstelle());

            handler.notifyTarget("fxml/Verbindlichkeitanlegen.fxml", new Object[]{"refreshListView"});

            pane.getScene().getWindow().hide();
        }
    }

    private void qMFinanzierungUebernehmen() {

        if (findeVerbuchungsstelle() != null) {

            ((QMFinanzierung) finanzierung).setVerbuchungsstelle(findeVerbuchungsstelle());

            if (findeQMBewilligung() != null) {

                ((QMFinanzierung) finanzierung).setQmbewilligung(findeQMBewilligung());

                handler.notifyTarget("fxml/Verbindlichkeitanlegen.fxml", new Object[]{"refreshListView"});

                pane.getScene().getWindow().hide();
            }
        }
    }

    private void pBMFinanzierungUebernehmen() {
        if (findeStelle() != null) {

            ((PBMFinanzierung) finanzierung).setStelle(findeStelle());//invocation target exception

            handler.notifyTarget("fxml/Verbindlichkeitanlegen.fxml", new Object[]{"refreshListView"});

            pane.getScene().getWindow().hide();
        }
    }

    private void dMFinanzierungUebernehmen() {
        if (findeVerbuchungsstelle() != null) {

            ((DMFinanzierung) finanzierung).setVerbuchungsstelle(findeVerbuchungsstelle());

            if (findeDMBewilligung() != null) {

                ((DMFinanzierung) finanzierung).setDmbewilligung(findeDMBewilligung());

                handler.notifyTarget("fxml/Verbindlichkeitanlegen.fxml", new Object[]{"refreshListView"});

                pane.getScene().getWindow().hide();
            }
        }
    }

    @FXML
    private void handleAbbrechen(ActionEvent event) {
        abbrechen();

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
        return "Finanzierungsmaske";
    }

    public void setApp(VerbindlichkeitanlegenController controller) {
        caller = controller;
    }
}
