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
import projektaufgabe.bdo.VBSFinanzierung;

/**
 *
 * @author Sonja Schäfer
 */
public class VBSFinanzierungDAOImpl implements VBSFinanzierungDAO {

    private Session session;

    public VBSFinanzierungDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(VBSFinanzierung vbsfinanzierung) {
        session.saveOrUpdate(vbsfinanzierung);
    }

    @Override
    public List<VBSFinanzierung> getAllVBSFinanzierung() {
        Query query = session.createQuery("from VBSFinanzierung");
        return query.list();
    }

    @Override
    public VBSFinanzierung getVBSFinanzierungById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM finanzierung "
                + "WHERE id = ?");
        query.setInteger(0, id);
        query.addEntity(VBSFinanzierung.class);
        return (VBSFinanzierung) query.list().get(0);
    }

    @Override
    public void deleteVBSFinanzierungById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM finanzierung "
                + "WHERE id = ?");
        query.setInteger(0, id);
        //query.addEntity(Person.class);
        query.executeUpdate();
    }

    @Override
    public void deleteVerbindllichkeitenByVBSFinanzierungId(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM verbindlichkeit "
                + "WHERE finanzierungid = ?");
        query.setInteger(0, id);
        // query.addEntity(Person.class);
        query.executeUpdate();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
