
package projektaufgabe.dao;

import projektaufgabe.bdo.Buchung;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Meike Brülls <s6mebrue@uni-bonn.de>
 */
public class BuchungDAOImpl implements BuchungDAO {

    private Session session;

    public BuchungDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Buchung buchung) {
        session.saveOrUpdate(buchung);
    }

    @Override
    public void deleteBuchung(Buchung buchung) {
        session.delete(buchung);
    }

    @Override
    public List<Buchung> getBuchungen() {
        
        Query query = session.createQuery("from Buchung");
        
        return query.list();

    }

    
    @Override
    public Buchung getBuchungById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM test "
                + "WHERE id = ?");
        query.setInteger(0, id);
        query.addEntity(Buchung.class);
        return (Buchung) query.list().get(0);

    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
