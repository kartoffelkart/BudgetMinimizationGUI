/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.service;

import java.util.List;
import projektaufgabe.dao.PersonDAOImpl;
import projektaufgabe.dao.VerbindlichkeitDAOImpl;

import projektaufgabe.bdo.Person;
import projektaufgabe.bdo.Verbindlichkeit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import projektaufgabe.bdo.Arbeitsverhaeltnis;
import projektaufgabe.bdo.Beschaeftigungskategorie;
import projektaufgabe.bdo.Buchung;
import projektaufgabe.bdo.DMBewilligung;
import projektaufgabe.bdo.Entgeltstufe;
import projektaufgabe.bdo.Finanzierung;
import projektaufgabe.bdo.Organisationseinheit;
import projektaufgabe.bdo.PBMFinanzierung;
import projektaufgabe.bdo.QMBewilligung;
import projektaufgabe.bdo.QMFinanzierung;
import projektaufgabe.bdo.Stelle;
import projektaufgabe.bdo.VBSFinanzierung;
import projektaufgabe.bdo.Verbindlichkeitstyp;
import projektaufgabe.bdo.Verbuchungsstelle;
import projektaufgabe.dao.ArbeitsverhaeltnisDAOImpl;
import projektaufgabe.dao.BeschaeftigungskategorieDAOImpl;
import projektaufgabe.dao.BuchungDAOImpl;
import projektaufgabe.dao.DMBewilligungDAOImpl;
import projektaufgabe.dao.EntgeltstufeDAOImpl;
import projektaufgabe.dao.FinanzierungDAOImpl;
import projektaufgabe.dao.OrganisationseinheitDAOImpl;
import projektaufgabe.dao.QMBewilligungDAOImpl;
import projektaufgabe.dao.QMFinanzierungDAOImpl;
import projektaufgabe.dao.StelleDAOImpl;
import projektaufgabe.dao.VBSFinanzierungDAOImpl;
import projektaufgabe.dao.VerbindlichkeitstypDAOImpl;
import projektaufgabe.dao.VerbuchungsstelleDAOImpl;

/**
 *
 * @author Sonja Schäfer
 */
public class Service {

    private static Service instance = null;
    private HibernateUtil hibernateutil = null;
    private Session session = null;
    private Transaction transaction;
    private Boolean withClose = true;
    private PersonDAOImpl persondao = null;
    private VerbindlichkeitDAOImpl verbindlichkeitdao = null;
    private FinanzierungDAOImpl finanzierungdao = null;
    private VBSFinanzierungDAOImpl vbsfinanzierungdao = null;
    private QMFinanzierungDAOImpl qmfinanzierungdao = null;
    private OrganisationseinheitDAOImpl organisationseinheitdao = null;
    private VerbuchungsstelleDAOImpl verbuchungsstelledao = null;
    private QMBewilligungDAOImpl qmbewilligungdao = null;
    private StelleDAOImpl stelledao = null;
    private BuchungDAOImpl buchungdao = null;
    private DMBewilligungDAOImpl dmbewilligungdao = null;
    private VerbindlichkeitstypDAOImpl verbindlichkeitstypdao = null;
    private EntgeltstufeDAOImpl entgeltstufedao = null;
    private BeschaeftigungskategorieDAOImpl beKategoriedao = null;
    private ArbeitsverhaeltnisDAOImpl arbeitsverhaeltnisdao = null;

    private Service() {
        hibernateutil = HibernateUtil.getInstance();
        session = hibernateutil.openSession();
        persondao = new PersonDAOImpl(session);
        verbindlichkeitdao = new VerbindlichkeitDAOImpl(session);
        finanzierungdao = new FinanzierungDAOImpl(session);
        vbsfinanzierungdao = new VBSFinanzierungDAOImpl(session);
        qmfinanzierungdao = new QMFinanzierungDAOImpl(session);
        organisationseinheitdao = new OrganisationseinheitDAOImpl(session);
        verbuchungsstelledao = new VerbuchungsstelleDAOImpl(session);
        qmbewilligungdao = new QMBewilligungDAOImpl(session);
        stelledao = new StelleDAOImpl(session);
        buchungdao = new BuchungDAOImpl(session);
        dmbewilligungdao = new DMBewilligungDAOImpl(session);
        verbindlichkeitstypdao = new VerbindlichkeitstypDAOImpl(session);
        entgeltstufedao = new EntgeltstufeDAOImpl(session);
        beKategoriedao = new BeschaeftigungskategorieDAOImpl(session);
        arbeitsverhaeltnisdao = new ArbeitsverhaeltnisDAOImpl(session);

    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private void beginTransaction() {
        if (withClose) {
            Session currentSession = hibernateutil.getCurrentSession();
            persondao.setSession(currentSession);
            verbindlichkeitdao.setSession(currentSession);
            finanzierungdao.setSession(currentSession);
            vbsfinanzierungdao.setSession(currentSession);
            qmfinanzierungdao.setSession(currentSession);
            organisationseinheitdao.setSession(currentSession);
            verbuchungsstelledao.setSession(currentSession);
            qmbewilligungdao.setSession(currentSession);
            stelledao.setSession(currentSession);
            buchungdao.setSession(currentSession);
            dmbewilligungdao.setSession(currentSession);
            verbindlichkeitstypdao.setSession(currentSession);
            entgeltstufedao.setSession(currentSession);

            transaction = currentSession.beginTransaction();
        } else {
            transaction = session.beginTransaction();
        }
    }

    private void endTransaction() {
        transaction.commit();
    }

    public void saveOrUpdatePerson(Person person) {
        beginTransaction();
        persondao.saveOrUpdate(person);
        endTransaction();
    }

    public void saveOrUpdateVerbindlichkeit(Verbindlichkeit verbindlichkeit) {
        beginTransaction();
        verbindlichkeitdao.saveOrUpdate(verbindlichkeit);
        endTransaction();
    }

    public void saveOrUpdateVerbindlichkeitstyp(Verbindlichkeitstyp verbindlichkeitstyp) {
        beginTransaction();
        verbindlichkeitstypdao.saveOrUpdate(verbindlichkeitstyp);
        endTransaction();
    }

    public void saveOrUpdateFinanzierung(Finanzierung finanzierung) {
        beginTransaction();
        finanzierungdao.saveOrUpdate(finanzierung);
        endTransaction();
    }

    public void saveOrUpdatePBMFinanzierung(PBMFinanzierung pbmfinanzierung) {
        beginTransaction();
        finanzierungdao.saveOrUpdate(pbmfinanzierung);
        endTransaction();
    }

    public void saveOrUpdateVBSFinanzierung(VBSFinanzierung vbsfinanzierung) {
        beginTransaction();
        vbsfinanzierungdao.saveOrUpdate(vbsfinanzierung);
        endTransaction();
    }

    public void saveOrUpdateQMFinanzierung(QMFinanzierung qmfinanzierung) {
        beginTransaction();
        qmfinanzierungdao.saveOrUpdate(qmfinanzierung);
        endTransaction();
    }

    public void saveOrUpdateVerbuchungsstelle(Verbuchungsstelle verbuchungsstelle) {
        beginTransaction();
        verbuchungsstelledao.saveOrUpdate(verbuchungsstelle);
        endTransaction();
    }

    public void saveOrUpdateOrganisationseinheit(Organisationseinheit organisationseinheit) {
        beginTransaction();
        organisationseinheitdao.saveOrUpdate(organisationseinheit);
        endTransaction();
    }

    public void saveOrUpdateQMBewilligung(QMBewilligung qMBewilligung) {
        beginTransaction();
        qmbewilligungdao.saveOrUpdate(qMBewilligung);
        endTransaction();
    }

    public ObservableList<Person> getAllPerson() {
        beginTransaction();
        ObservableList<Person> list = FXCollections.observableArrayList(persondao.getAllPerson());
        endTransaction();
        return list;
    }

    public ObservableList<Verbindlichkeit> getAllVerbindlichkeit() {
        beginTransaction();
        ObservableList<Verbindlichkeit> list = FXCollections.observableArrayList(verbindlichkeitdao.getAllVerbindlichkeit());
        endTransaction();
        return list;
    }

    public ObservableList<Finanzierung> getAllFinanzierung() {
        beginTransaction();
        ObservableList<Finanzierung> list = FXCollections.observableArrayList(finanzierungdao.getAllFinanzierung());
        endTransaction();
        return list;
    }

    public ObservableList<Entgeltstufe> getAllEntgeltstufe() {
        beginTransaction();
        ObservableList<Entgeltstufe> list = FXCollections.observableArrayList(entgeltstufedao.getAllEntgeltstufe());
        endTransaction();
        return list;
    }

    public ObservableList<String> getAllEntgeltstufeStrings() {
        beginTransaction();
        ObservableList<Entgeltstufe> list = FXCollections.observableArrayList(entgeltstufedao.getAllEntgeltstufe());

        ObservableList<String> list2 = FXCollections.observableArrayList();

        for (Entgeltstufe tmp : list) {

            list2.add(((Entgeltstufe) tmp).getEntgeltstufe());
        }
        endTransaction();
        return list2;
    }

    public ObservableList<String> getAllBeKategorieStrings() {
        beginTransaction();
        ObservableList<Beschaeftigungskategorie> list = FXCollections.observableArrayList(beKategoriedao.getAllBeschaeftigungskategorie());

        ObservableList<String> list2 = FXCollections.observableArrayList();

        for (Beschaeftigungskategorie tmp : list) {

            list2.add(((Beschaeftigungskategorie) tmp).getBeschaeftigungskategorie());
        }
        endTransaction();
        return list2;
    }

    public ObservableList<String> getAllArbeitsverhaeltnisStrings() {
        beginTransaction();
        ObservableList<Arbeitsverhaeltnis> list = FXCollections.observableArrayList(arbeitsverhaeltnisdao.getAllArbeitsverhaeltnis());

        ObservableList<String> list2 = FXCollections.observableArrayList();

        for (Arbeitsverhaeltnis tmp : list) {

            list2.add(((Arbeitsverhaeltnis) tmp).getArbeitsverhaeltnis());
        }
        endTransaction();
        return list2;
    }

    public ObservableList<Verbuchungsstelle> getAllVerbuchungsstelle() {
        beginTransaction();
        ObservableList<Verbuchungsstelle> list = FXCollections.observableArrayList(verbuchungsstelledao.getAllVerbuchungsstelle());
        endTransaction();
        return list;
    }

    public ObservableList<Verbindlichkeitstyp> getAllVerbindlichkeitstyp() {
        beginTransaction();
        ObservableList<Verbindlichkeitstyp> list = FXCollections.observableArrayList(verbindlichkeitstypdao.getAllVerbindlichkeitstyp());
        endTransaction();
        return list;
    }

    public ObservableList<Finanzierung> getAllFinanzierungByVerbindlichkeit(Verbindlichkeit verbindlichkeit) {
        beginTransaction();
//        ObservableList<Finanzierung> list = FXCollections.observableArrayList(finanzierungdao.getAllFinanzierungByVerbindlichkeitId(verbindlichkeit.getId()));
        verbindlichkeitdao.saveOrUpdate(verbindlichkeit);
        ObservableList<Finanzierung> list = FXCollections.observableArrayList(verbindlichkeit.getFinanzierungen());

        endTransaction();
        return list;
    }

    public ObservableList<Organisationseinheit> getAllOrganisationseinheit() {
        beginTransaction();
        ObservableList<Organisationseinheit> list = FXCollections.observableArrayList(organisationseinheitdao.getAllOrganisationseinheit());
        endTransaction();
        return list;
    }

    public Person getPersonById(Integer id) {
        beginTransaction();
        Person person = persondao.getPersonById(id);
        endTransaction();
        return person;
    }

    public List<Person> getPersonByName(String vorname, String nachname) {

        beginTransaction();
        List<Person> personlist = persondao.getPersonByName(vorname, nachname);
        endTransaction();
        return personlist;
    }

    public List<Verbuchungsstelle> getVerbuchungsstelleByName(String kapitel, String titel, String ut, String position, String pn, String zweck) {
        beginTransaction();
        List<Verbuchungsstelle> verbuchungsstellelist = verbuchungsstelledao.getVerbuchungsstelleByName(kapitel, titel, ut, position, pn, zweck);
        endTransaction();
        return verbuchungsstellelist;
    }

    public List<Stelle> getStellenByNr(String nr) {
        beginTransaction();
        List<Stelle> stelle = stelledao.getStellenByNr(nr);
        endTransaction();
        return stelle;
    }

    public List<QMBewilligung> getQMBewilligungByNr(String nr) {
        beginTransaction();
        List<QMBewilligung> qMBewilligung = qmbewilligungdao.getQMBewilligungByNr(nr);
        endTransaction();
        return qMBewilligung;
    }

    public List<DMBewilligung> getDMBewilligungByNr(String nr) {
        beginTransaction();
        List<DMBewilligung> dMBewilligung = dmbewilligungdao.getDMBewilligungByNr(nr);
        endTransaction();
        return dMBewilligung;
    }

    public void deletePersonById(Integer id) {
        beginTransaction();
        persondao.deletePersonById(id);
        endTransaction();

    }

    public void deleteFinanzierungById(Integer id) {
        beginTransaction();
        finanzierungdao.deleteFinanzierungById(id);
        endTransaction();

    }

    public void deleteVerbindllichkeitenByPersonId(Integer id) {
        beginTransaction();
        persondao.deleteVerbindllichkeitenByPersonId(id);
        endTransaction();

    }

    public void deleteVerbindllichkeitenByFinanzierungId(Integer id) {
        beginTransaction();
        finanzierungdao.deleteVerbindllichkeitenByFinanzierungId(id);
        endTransaction();

    }

    public Verbindlichkeit getVerbindlichkeitenById(Integer id) {
        beginTransaction();
        Verbindlichkeit verbindlichkeit = verbindlichkeitdao.getVerbindlichkeitById(id);
        endTransaction();
        return verbindlichkeit;
    }

    public Finanzierung getFinanzierungById(Integer id) {
        beginTransaction();
        Finanzierung finanzierung = finanzierungdao.getFinanzierungById(id);
        endTransaction();
        return finanzierung;
    }

    public void saveOrUpdateBuchung(Buchung buchung) {
        beginTransaction();
        buchungdao.saveOrUpdate(buchung);
        endTransaction();
    }

    public void deleteBuchung(Buchung buchung) {

        beginTransaction();
        buchungdao.deleteBuchung(buchung);
        endTransaction();

    }

    public ObservableList<Buchung> getAllBuchung() {
        beginTransaction();
        ObservableList<Buchung> list = FXCollections.observableArrayList(buchungdao.getBuchungen());
        endTransaction();
        return list;
    }

    public Buchung getBuchungById(Integer id) {
        beginTransaction();
        Buchung buchung = buchungdao.getBuchungById(id);
        endTransaction();
        return buchung;
    }

    public void refreshVerbindlichkeit(Verbindlichkeit verbindlichkeit) {
        beginTransaction();
        verbindlichkeitdao.refreshVerbindlichkeit(verbindlichkeit);
        endTransaction();
    }

    public void refreshPerson(Person person) {
        beginTransaction();
        persondao.refreshPerson(person);
        endTransaction();
    }

    public void refreshFinanzierung(Finanzierung finanzierung) {
        beginTransaction();
        finanzierungdao.refreshFinanzierung(finanzierung);
        endTransaction();
    }

    public void refreshOrganisationseinheit(Organisationseinheit organisationseinheit) {
        beginTransaction();
        organisationseinheitdao.refreshOrganisationseinheit(organisationseinheit);
        endTransaction();
    }

    public void setWithClose(Boolean close) {
        withClose = close;
        if (!withClose) {

            session = hibernateutil.openSession();
            persondao.setSession(session);
            verbindlichkeitdao.setSession(session);
            finanzierungdao.setSession(session);
            vbsfinanzierungdao.setSession(session);
            qmfinanzierungdao.setSession(session);
            organisationseinheitdao.setSession(session);
            verbuchungsstelledao.setSession(session);
            qmbewilligungdao.setSession(session);
            stelledao.setSession(session);
            buchungdao.setSession(session);
            dmbewilligungdao.setSession(session);
            verbindlichkeitstypdao.setSession(session);
            entgeltstufedao.setSession(session);

        } else {
            closeSession();
        }
    }

    public void closeSession() {
        if (session.isOpen()) {
            session.close();
        }
    }
}
