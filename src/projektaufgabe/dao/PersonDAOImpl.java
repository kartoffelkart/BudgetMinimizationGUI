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

/**
 *
 * @author Sonja Schäfer
 */
public class PersonDAOImpl implements PersonDAO {

    private Session session;

    public PersonDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdate(Person person) {
        session.saveOrUpdate(person);
    }

    @Override
    public List<Person> getAllPerson() {
        Query query = session.createQuery("from Person");
        return query.list();
    }

    @Override
    public Person getPersonById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM person "
                + "WHERE id = ?");
        query.setInteger(0, id);
        query.addEntity(Person.class);
        return (Person) query.list().get(0);
    }

    @Override
    public List<Person> getPersonByName(String vorname, String nachname) {
        SQLQuery query = session.createSQLQuery(
                "SELECT * "
                + "FROM person "
                + "WHERE vorname = ?"
                + "AND nachname = ?");
        query.setString(0, vorname);
        query.setString(1, nachname);
        query.addEntity(Person.class);
        
            return (List<Person>) query.list();
        
    }

    @Override
    public void deletePersonById(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM person "
                + "WHERE id = ?");
        query.setInteger(0, id);
        //query.addEntity(Person.class);
        query.executeUpdate();
    }

    @Override
    public void deleteVerbindllichkeitenByPersonId(Integer id) {
        SQLQuery query = session.createSQLQuery(
                "DELETE FROM verbindlichkeit "
                + "WHERE personid = ?");
        query.setInteger(0, id);
        // query.addEntity(Person.class);
        query.executeUpdate();
    }
   @Override
    public void refreshPerson(Person person) {
        session.refresh(person);
    }
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
