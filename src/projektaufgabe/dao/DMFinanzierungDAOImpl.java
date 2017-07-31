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
import projektaufgabe.bdo.DMFinanzierung;

/**
 *
 * @author Sonja Schäfer
 */
public class DMFinanzierungDAOImpl implements DMFinanzierungDAO {

    private Session session;

    public DMFinanzierungDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(DMFinanzierung dmfinanzierung) {
        session.saveOrUpdate(dmfinanzierung);
    }

//    @Override
//    public List<DMFinanzierung> getAllDMFinanzierung() {
//        Query query = session.createQuery("SELECT * "
//                + "FROM finanzierung "
//                + "WHERE finanzierungstyp = ?");
//         query.setString(0, "DM");
//        query.addEntity(DMFinanzierung.class);
//        return (List<DMFinanzierung>) query.list();
//    }


    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
