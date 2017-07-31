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
import projektaufgabe.bdo.DMBewilligung;

/**
 *
 * @author Sonja Schäfer
 */
public class DMBewilligungDAOImpl implements DMBewilligungDAO {

    private Session session;

    public DMBewilligungDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(DMBewilligung dMBewilligung) {
        session.saveOrUpdate(dMBewilligung);
    }

    @Override
    public List<DMBewilligung> getAllDMBewilligung() {
        Query query = session.createQuery("from dmBewilligung");
        return query.list();
    }

    @Override
    public DMBewilligung getDMBewilligungById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM dmbewilligung "
                + "WHERE id = ?");
        query.setInteger(0, id);
        query.addEntity(DMBewilligung.class);
        return (DMBewilligung) query.list().get(0);
    }

    @Override
    public List<DMBewilligung> getDMBewilligungByNr(String nr) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM dmbewilligung "
                + "WHERE bewilligungsNr = ?");
        query.setString(0, nr);
       query.addEntity(DMBewilligung.class);
        return (List<DMBewilligung>) query.list();
    }

    @Override
    public void deleteDMBewilligungById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM dmbewilligung "
                + "WHERE id = ?");
        query.setInteger(0, id);
        //query.addEntity(Person.class);
        query.executeUpdate();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
