/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import projektaufgabe.bdo.Person;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import projektaufgabe.bdo.QMBewilligung;

/**
 *
 * @author Sonja Schäfer
 */
public class QMBewilligungDAOImpl implements QMBewilligungDAO {

    private Session session;

    public QMBewilligungDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(QMBewilligung qMBewilligung) {
        session.saveOrUpdate(qMBewilligung);
    }

    @Override
    public List<QMBewilligung> getAllQMBewilligung() {
        Query query = session.createQuery("from qmbewilligung");
        return query.list();
    }

    @Override
    public QMBewilligung getQMBewilligungById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM qmbewilligung "
                + "WHERE id = ?");
        query.setInteger(0, id);
        query.addEntity(QMBewilligung.class);
        return (QMBewilligung) query.list().get(0);
    }

    @Override
    public List<QMBewilligung> getQMBewilligungByNr(String nr) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM qmbewilligung "
                + "WHERE bewilligungsNr = ?");
        query.setString(0, nr);
        query.addEntity(QMBewilligung.class);
        return (List<QMBewilligung>) query.list();
    }

    @Override
    public void deleteQMBewilligungById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM qmbewilligung "
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
