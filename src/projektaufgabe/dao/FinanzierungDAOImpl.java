/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import projektaufgabe.bdo.Finanzierung;
import projektaufgabe.bdo.Verbindlichkeit;

/**
 *
 * @author Sonja Schäfer
 */
public class FinanzierungDAOImpl implements FinanzierungDAO {

    private Session session;

    public FinanzierungDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Finanzierung finanzierung) {
        session.saveOrUpdate(finanzierung);
    }

    @Override
    public List<Finanzierung> getAllFinanzierung() {
        Query query = session.createQuery("from Finanzierung");
        return query.list();
    }

    @Override
    public Finanzierung getFinanzierungById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM finanzierung "
                + "WHERE id = ?");
        query.setInteger(0, id);
        query.addEntity(Finanzierung.class);
        return (Finanzierung) query.list().get(0);
    }

         @Override
    public List<Finanzierung> getAllFinanzierungByVerbindlichkeitId(Integer id) {
        SQLQuery query = session.createSQLQuery(
                  "SELECT * "
                + "FROM finanzierung "
                + "WHERE verbindlichkeitid = ?");
        query.setInteger(0, id);
        query.addEntity(Finanzierung.class);
        return (List<Finanzierung>) query.list();
    }
    
//    public Set<Finanzierung> getAllFinanzierungByVerbindlichkeit(Verbindlichkeit verbindlichkeit) {
//       Set<Finanzierung> list = verbindlichkeit.getFinanzierungen();
//        return list;
//    }
    @Override
    public void deleteFinanzierungById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM finanzierung "
                + "WHERE id = ?");
        query.setInteger(0, id);
        //query.addEntity(Person.class);
        query.executeUpdate();
    }

    @Override
    public void deleteVerbindllichkeitenByFinanzierungId(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM verbindlichkeit "
                + "WHERE finanzierungid = ?");
        query.setInteger(0, id);
        // query.addEntity(Person.class);
        query.executeUpdate();
    }
 @Override
    public void refreshFinanzierung(Finanzierung finanzierung) {
        session.refresh(finanzierung);
    }
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
