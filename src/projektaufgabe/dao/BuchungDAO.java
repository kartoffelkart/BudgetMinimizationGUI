/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektaufgabe.dao;

import projektaufgabe.bdo.Buchung;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Meike Brülls <s6mebrue@uni-bonn.de>
 */
public interface BuchungDAO {
    
    public void saveOrUpdate(Buchung test);
    
    public void setSession(Session session);
    
    public void deleteBuchung(Buchung test);
    
    public List<Buchung> getBuchungen();
    
    public Buchung getBuchungById(Integer id);
    
}
