/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.fxml;

import csunibonn.ris.javafx.platform.PlatformActionHandler;
import csunibonn.ris.javafx.platform.ribbon.PlatformRibbon;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import projektaufgabe.bdo.Finanzierung;
import projektaufgabe.bdo.Organisationseinheit;
import projektaufgabe.bdo.Person;
import projektaufgabe.bdo.QMBewilligung;
import projektaufgabe.bdo.QMFinanzierung;
import projektaufgabe.bdo.Stelle;
import projektaufgabe.bdo.VBSFinanzierung;
import projektaufgabe.bdo.Verbindlichkeit;
import projektaufgabe.bdo.Verbindlichkeitstyp;
import projektaufgabe.bdo.Verbuchungsstelle;
import projektaufgabe.service.Service;

/**
 * FXML Controller class
 *
 * @author Sonja Schäfer
 */
public class MenuPersonalverwaltungController implements Initializable, PlatformRibbon {

    private PlatformActionHandler handler = PlatformActionHandler.getInstance();
    @FXML
    private StackPane pane2;

    private final Service service = Service.getInstance();
    @FXML
    private Button verbindlichkeitAnlegen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        Service service = Service.getInstance();
//        Verbindlichkeitstyp  elternzeit = new Verbindlichkeitstyp("Elternzeit");
//        
//        service.saveOrUpdateVerbindlichkeitstyp(elternzeit);
//          Verbindlichkeitstyp  kuendigung = new Verbindlichkeitstyp("Kündigung");
//        service.saveOrUpdateVerbindlichkeitstyp(kuendigung);
//          Verbindlichkeitstyp  hoeherstufung = new Verbindlichkeitstyp("Höherstufung");
//        service.saveOrUpdateVerbindlichkeitstyp(hoeherstufung);
//         Verbindlichkeitstyp  arbeitszeitreduzierung = new Verbindlichkeitstyp("Arbeitszeitreduzierung");
//        service.saveOrUpdateVerbindlichkeitstyp(arbeitszeitreduzierung);
//         Verbindlichkeitstyp  neueinstellung = new Verbindlichkeitstyp("Neueinstellung");
//        service.saveOrUpdateVerbindlichkeitstyp(neueinstellung);
//        
//        
//        
//        LocalDate date1 = LocalDate.now();
//        Person newPerson2 = new Person("Willi", "Weinachtsmann", "1", date1, date1);
//        service.saveOrUpdatePerson(newPerson2);
//        Organisationseinheit newOrganisationseinheit2 = new Organisationseinheit("Coca cola", "PR-Abteilung", "Arbeitsgruppe1", "Wir haben den Weihnachtsmann erfunden.");
//        service.saveOrUpdateOrganisationseinheit(newOrganisationseinheit2);
//        Verbindlichkeit newVerbindlichkeit2 = new Verbindlichkeit(1, date1, date1,
//                70.0, 11.5, "E3", "Willi ist Saisonarbeiter", "Künstler",
//                "Angestellter");
//        newVerbindlichkeit2.setPerson(newPerson2);
//        newVerbindlichkeit2.setOrganisationseinheit(newOrganisationseinheit2);
//        newVerbindlichkeit2.setVerbindlichkeitstyp(neueinstellung);
//        service.saveOrUpdateVerbindlichkeit(newVerbindlichkeit2);
//        Person newPerson = new Person("Hansi", "Osterhase", "2", date1, date1);
//        service.saveOrUpdatePerson(newPerson);
//        Organisationseinheit newOrganisationseinheit = new Organisationseinheit("institut", "abteilung", "arbeitsgruppe", "bemerkung");
//        service.saveOrUpdateOrganisationseinheit(newOrganisationseinheit);
//        Verbindlichkeit newVerbindlichkeit = new Verbindlichkeit(1, date1, date1,
//                70.0, 11.5, "E4", "Hansi ist Saisonarbeiter", "Wissenschaftler",
//                "Angestellter");
//        newVerbindlichkeit.setPerson(newPerson);
//        newVerbindlichkeit.setOrganisationseinheit(newOrganisationseinheit);
//        newVerbindlichkeit.setVerbindlichkeitstyp(elternzeit );
//        service.saveOrUpdateVerbindlichkeit(newVerbindlichkeit);
//        Stelle newStelle = new Stelle("stelle 5");
//        Finanzierung newFinanzierung = new Finanzierung(50.0, "", "Alles wird gut");
//        newFinanzierung.setVerbindlichkeit(newVerbindlichkeit);
//        service.saveOrUpdateFinanzierung(newFinanzierung);
//
//        Finanzierung newFinanzierung2 = new Finanzierung(20.0, "", "Alles wird gut");
//        newFinanzierung2.setVerbindlichkeit(newVerbindlichkeit2);
//        service.saveOrUpdateFinanzierung(newFinanzierung2);
//        Set<Finanzierung> setFin = new HashSet<Finanzierung>();
//        setFin.add(newFinanzierung);
//        Set<Verbindlichkeit> tempVerb = new HashSet<>();
//        tempVerb.add(newVerbindlichkeit);
//        newPerson.setVerbindlichkeiten(tempVerb);
//        newOrganisationseinheit.setVerbindlichkeiten(tempVerb);
//        tempVerb = new HashSet<>();
//        tempVerb.add(newVerbindlichkeit2);
//        newPerson2.setVerbindlichkeiten(tempVerb);
//        newOrganisationseinheit2.setVerbindlichkeiten(tempVerb);
//        Set<Finanzierung> tempFin = new HashSet<>();
//        tempFin.add(newFinanzierung);
//        newVerbindlichkeit.setFinanzierungen(tempFin);
//        tempFin = new HashSet<>();
//        tempFin.add(newFinanzierung2);
//        newVerbindlichkeit2.setFinanzierungen(tempFin);
//        service.saveOrUpdateVerbindlichkeit(newVerbindlichkeit);
//        Verbuchungsstelle newVerbuchungsstelle = new Verbuchungsstelle("061111",
//                "12987", "01", "AL", "603000", "Institut Informatik, Abt.3, Personal");
//        service.saveOrUpdateVerbuchungsstelle(newVerbuchungsstelle);
//
//       
//
//        VBSFinanzierung vbsFinanzierung = new VBSFinanzierung(20.0, "VBS",
//                "Laberlaber");
//        vbsFinanzierung.setVerbuchungsstelle(newVerbuchungsstelle);
//        vbsFinanzierung.setVerbindlichkeit(newVerbindlichkeit);
//        service.saveOrUpdateVBSFinanzierung(vbsFinanzierung);
//
//        QMBewilligung newQMBewilligung = new QMBewilligung("3");
//        service.saveOrUpdateQMBewilligung(newQMBewilligung);
//
//        QMFinanzierung qMFinanzierung = new QMFinanzierung(20.0, "QM", "Alles wird gut");
//        qMFinanzierung.setVerbuchungsstelle(newVerbuchungsstelle);
//        qMFinanzierung.setVerbindlichkeit(newVerbindlichkeit);
//        qMFinanzierung.setQmbewilligung(newQMBewilligung);
//        service.saveOrUpdateQMFinanzierung(qMFinanzierung);
    }

    @Override
    public String getTitle() {
        return "Personalverwaltung";
    }

    @Override
    public Pane getPane() {
        return pane2;
    }

    @FXML
    private void handleOpenFinanzierung(ActionEvent event) {
        handler.openWindow("fxml/WindowFinanzierung.fxml");
    }
@FXML
    private void handleOpenVerbindlichkeit(ActionEvent event) {
        handler.openWindow("fxml/WindowVerbindlichkeit.fxml");
    }
    @FXML
    private void handleVerbindlichkeitAnlegen(ActionEvent event) {
        Verbindlichkeit tempVerb = new Verbindlichkeit();
        Verbindlichkeitstyp verbTyp = new Verbindlichkeitstyp();
        Person newPerson = new Person();
        Organisationseinheit newOrganisationseinheit = new Organisationseinheit();

        tempVerb.setPerson(newPerson);
        tempVerb.setOrganisationseinheit(newOrganisationseinheit);
        tempVerb.setVerbindlichkeitstyp(verbTyp);
        ((VerbindlichkeitanlegenController) handler.openWindow("fxml/Verbindlichkeitanlegen.fxml")).setVerbindlichkeit(tempVerb, "anlegen");

    }

}
