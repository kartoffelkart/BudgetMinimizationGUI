/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import projektaufgabe.bdo.Stelle;

/**
 *
 * @author Sonja
 */
public class StelleDAOImpl implements StelleDAO{
     private Session session;

    public StelleDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Stelle stelle) {
        session.saveOrUpdate(stelle);
    }
     @Override
    public void setSession(Session session) {
        this.session = session;
    }
  
            @Override
    public List<Stelle> getStellenByNr(String nr) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM stelle "
                + "WHERE stellenNr = ?");
        query.setString(0, nr);
       query.addEntity(Stelle.class);
        return (List<Stelle>) query.list();
    }
}
