/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import projektaufgabe.bdo.DMBewilligung;
import projektaufgabe.bdo.Entgeltstufe;
import projektaufgabe.bdo.QMBewilligung;

/**
 *
 * @author Sonja Schäfer
 */
public interface EntgeltstufeDAO {

    public void saveOrUpdate(Entgeltstufe entgeltstufe);

    public List<Entgeltstufe> getAllEntgeltstufe();

    public void setSession(Session session);
}
