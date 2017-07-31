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
import projektaufgabe.bdo.Entgeltstufe;

/**
 *
 * @author Sonja Schäfer
 */
public class EntgeltstufeDAOImpl implements EntgeltstufeDAO {

    private Session session;

    public EntgeltstufeDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Entgeltstufe entgeltstufe) {
        session.saveOrUpdate(entgeltstufe);
    }


@Override
    public List<Entgeltstufe> getAllEntgeltstufe() {
        SQLQuery query = session.createSQLQuery("SELECT * "
                + "FROM entgeltstufe "
        );

        query.addEntity(Entgeltstufe.class);
        return (List<Entgeltstufe>) query.list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
