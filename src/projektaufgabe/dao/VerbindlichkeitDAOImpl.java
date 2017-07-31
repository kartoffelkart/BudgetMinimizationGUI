/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import projektaufgabe.bdo.Verbindlichkeit;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import projektaufgabe.bdo.Person;

/**
 *
 * @author Sonja Schäfer
 */
public class VerbindlichkeitDAOImpl implements VerbindlichkeitDAO {

    private Session session;

    public VerbindlichkeitDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Verbindlichkeit verbindlichkeit) {
        session.saveOrUpdate(verbindlichkeit);
    }

    @Override
    public List<Verbindlichkeit> getAllVerbindlichkeit() {
        Query query = session.createQuery("from Verbindlichkeit");
        return query.list();
    }
    /*@Override  ///Ich bräuchte eine Klasse Stelle wo ich die Objekte reinpacken kann
     oder ich mache Konstruktor von Verbindlichkeit, der nur einige Eintrage braucht
     public List<Stelle> getAllStellenInfoByPerson(Integer id) {
     SQLQuery query = session.createSQLQuery(
     "SELECT DISTINCT vertragsbeginn,vertragsende,arbeitszeit,endgeldstufe,arbeitsverhaeltnis,dauerstelle,typ,stellennummer "
     + "FROM verbindlichkeit "
     + "WHERE personid = ?");
     return query.list();
     }*/

    @Override
    public Verbindlichkeit getVerbindlichkeitById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM verbindlichkeit "
                + "WHERE id = ?");
        query.setInteger(0, id);
        query.addEntity(Verbindlichkeit.class);
        return (Verbindlichkeit) query.list().get(0);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void refreshVerbindlichkeit(Verbindlichkeit verbindlichkeit) {
        session.refresh(verbindlichkeit);
    }

}
