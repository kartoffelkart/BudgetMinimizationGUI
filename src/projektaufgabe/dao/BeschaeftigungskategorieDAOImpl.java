/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import projektaufgabe.bdo.Beschaeftigungskategorie;
import projektaufgabe.bdo.Entgeltstufe;

/**
 *
 * @author Sonja Schäfer
 */
public class BeschaeftigungskategorieDAOImpl implements BeschaeftigungskategorieDAO {

    private Session session;

    public BeschaeftigungskategorieDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Beschaeftigungskategorie beschaeftigungskategorie) {
        session.saveOrUpdate(beschaeftigungskategorie);
    }


@Override
    public List<Beschaeftigungskategorie> getAllBeschaeftigungskategorie() {
        SQLQuery query = session.createSQLQuery("SELECT * "
                + "FROM beschaeftigungskategorie "
        );

        query.addEntity(Beschaeftigungskategorie.class);
        return (List<Beschaeftigungskategorie>) query.list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
