/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import projektaufgabe.bdo.Verbindlichkeit;
import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.Person;

/**
 *
 * @author Sonja Schäfer
 */
public interface VerbindlichkeitDAO {

    public void saveOrUpdate(Verbindlichkeit verbindlichkeit);

    public List<Verbindlichkeit> getAllVerbindlichkeit();

    public Verbindlichkeit getVerbindlichkeitById(Integer id);

    public void setSession(Session session);

    public void refreshVerbindlichkeit(Verbindlichkeit verbindlichkeit);

}
