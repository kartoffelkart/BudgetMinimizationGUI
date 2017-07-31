/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.Stelle;

/**
 *
 * @author Sonja
 */
public interface StelleDAO {

    public void saveOrUpdate(Stelle stelle);

    public void setSession(Session session);

    public List<Stelle> getStellenByNr(String nr);

}
