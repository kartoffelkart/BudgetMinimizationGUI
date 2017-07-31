/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import projektaufgabe.bdo.Person;
import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.Organisationseinheit;

/**
 *
 * @author Sonja Schäfer
 */
public interface OrganisationseinheitDAO {

    public void saveOrUpdate(Organisationseinheit organisationseinheit);

    public List<Organisationseinheit> getAllOrganisationseinheit();

    public Organisationseinheit getOrganisationseinheitById(Integer id);

    public void deleteOrganisationseinheitById(Integer id);

    public void refreshOrganisationseinheit(Organisationseinheit organisationseinheit);

    public void setSession(Session session);

}
