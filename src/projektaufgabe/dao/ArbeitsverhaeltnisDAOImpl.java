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
import projektaufgabe.bdo.Arbeitsverhaeltnis;
import projektaufgabe.bdo.Entgeltstufe;

/**
 *
 * @author Sonja Schäfer
 */
public class ArbeitsverhaeltnisDAOImpl implements ArbeitsverhaeltnisDAO {

    private Session session;

    public ArbeitsverhaeltnisDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Arbeitsverhaeltnis arbeitsverhaeltnis) {
        session.saveOrUpdate(arbeitsverhaeltnis);
    }


@Override
    public List<Arbeitsverhaeltnis> getAllArbeitsverhaeltnis() {
        SQLQuery query = session.createSQLQuery("SELECT * "
                + "FROM arbeitsverhaeltnis "
        );

        query.addEntity(Arbeitsverhaeltnis.class);
        return (List<Arbeitsverhaeltnis>) query.list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
