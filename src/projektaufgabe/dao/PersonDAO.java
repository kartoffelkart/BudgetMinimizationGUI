/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import projektaufgabe.bdo.Person;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Sonja Schäfer
 */
public interface PersonDAO {

    public void saveOrUpdate(Person person);

    public List<Person> getAllPerson();

    public Person getPersonById(Integer id);

    public List<Person> getPersonByName(String vorname, String nachname);

    public void deletePersonById(Integer id);

    public void deleteVerbindllichkeitenByPersonId(Integer id);

    public void setSession(Session session);

    public void refreshPerson(Person person);

}
