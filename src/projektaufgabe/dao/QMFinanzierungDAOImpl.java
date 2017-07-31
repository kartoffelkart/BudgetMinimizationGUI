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
import projektaufgabe.bdo.QMFinanzierung;

/**
 *
 * @author Sonja Schäfer
 */
public class QMFinanzierungDAOImpl implements QMFinanzierungDAO {

    private Session session;

    public QMFinanzierungDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(QMFinanzierung qmfinanzierung) {
        session.saveOrUpdate(qmfinanzierung);
    }

//    @Override
//    public List<QMFinanzierung> getAllQMFinanzierung() {
//        Query query = session.createQuery("from Finanzierung");
//        return query.list();
//    }

   

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
