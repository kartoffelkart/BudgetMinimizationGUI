/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import projektaufgabe.bdo.Verbindlichkeitstyp;

/**
 *
 * @author Sonja
 */
public class VerbindlichkeitstypDAOImpl implements VerbindlichkeitstypDAO {

    private Session session;

    public VerbindlichkeitstypDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Verbindlichkeitstyp verbindlichkeitstyp) {
        session.saveOrUpdate(verbindlichkeitstyp);
    }

    @Override
    public List<Verbindlichkeitstyp> getAllVerbindlichkeitstyp() {
        SQLQuery query = session.createSQLQuery("SELECT * "
                + "FROM verbindlichkeitstyp");
        query.addEntity(Verbindlichkeitstyp.class);
        return (List<Verbindlichkeitstyp>) query.list();
    }
 
   
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
