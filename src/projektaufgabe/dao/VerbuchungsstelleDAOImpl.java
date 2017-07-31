/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import projektaufgabe.bdo.Verbuchungsstelle;

/**
 *
 * @author Sonja
 */
public class VerbuchungsstelleDAOImpl implements VerbuchungsstelleDAO {

    private Session session;

    public VerbuchungsstelleDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Verbuchungsstelle verbuchungsstelle) {
        session.saveOrUpdate(verbuchungsstelle);
    }

    @Override
    public List<Verbuchungsstelle> getAllVerbuchungsstelle() {
        Query query = session.createQuery("from Verbuchungsstelle");
        return query.list();
    }

    @Override
    public Verbuchungsstelle getVerbuchungsstelleById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM verbuchungsstelle "
                + "WHERE id = ?");
        query.setInteger(0, id);
        query.addEntity(Verbuchungsstelle.class);
        return (Verbuchungsstelle) query.list().get(0);
    }

    @Override
    public List<Verbuchungsstelle> getVerbuchungsstelleByName(String kapitel, String titel, String ut, String position, String pn, String zweck) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM verbuchungsstelle "
                + "WHERE kapitel = ?"
                + "AND titel = ?"
                + "AND untertitel = ?"
                + "AND position = ?"
                + "AND pn = ?"
                + "AND zweck = ?");
        query.setString(0, kapitel);
        query.setString(1, titel);
        query.setString(2, ut);
        query.setString(3, position);
        query.setString(4, pn);
        query.setString(5, zweck);

        query.addEntity(Verbuchungsstelle.class);
        return (List<Verbuchungsstelle>) query.list();
    }

    @Override
    public void deleteVerbuchungsstelleById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM verbuchungsstelle "
                + "WHERE id = ?");
        query.setInteger(0, id);
        //query.addEntity(Verbuchungsstelle.class);
        query.executeUpdate();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
