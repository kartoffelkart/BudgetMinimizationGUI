/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.Verbindlichkeitstyp;

/**
 *
 * @author Sonja Schäfer
 */
public interface VerbindlichkeitstypDAO {

    public void saveOrUpdate(Verbindlichkeitstyp verbindlichkeitstyp);

    public List<Verbindlichkeitstyp> getAllVerbindlichkeitstyp();

   
    public void setSession(Session session);

   
}
