/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import projektaufgabe.bdo.Person;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import projektaufgabe.bdo.Organisationseinheit;

/**
 *
 * @author Sonja Schäfer
 */
public class OrganisationseinheitDAOImpl implements OrganisationseinheitDAO {

    private Session session;

    public OrganisationseinheitDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Organisationseinheit organisationseinheit) {
        session.saveOrUpdate(organisationseinheit);
    }

    @Override
    public List<Organisationseinheit> getAllOrganisationseinheit() {
        Query query = session.createQuery("from Organisationseinheit");
        return query.list();
    }

    @Override
    public Organisationseinheit getOrganisationseinheitById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM organisationseinheit "
                + "WHERE id = ?");
        query.setInteger(0, id);
        query.addEntity(Organisationseinheit.class);
        return (Organisationseinheit) query.list().get(0);
    }

    @Override
    public void deleteOrganisationseinheitById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM organisationseinheit "
                + "WHERE id = ?");
        query.setInteger(0, id);
        
        query.executeUpdate();
    }

   @Override
    public void refreshOrganisationseinheit(Organisationseinheit organisationseinheit) {
        session.refresh(organisationseinheit);
    }
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
