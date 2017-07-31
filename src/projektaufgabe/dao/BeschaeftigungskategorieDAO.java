/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.Beschaeftigungskategorie;
import projektaufgabe.bdo.Entgeltstufe;

/**
 *
 * @author Sonja Schäfer
 */
public interface BeschaeftigungskategorieDAO {

    public void saveOrUpdate(Beschaeftigungskategorie beschaeftigungskategorie);

    public List<Beschaeftigungskategorie> getAllBeschaeftigungskategorie();

    public void setSession(Session session);
}
