/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.Verbuchungsstelle;

/**
 *
 * @author Sonja Schäfer
 */
public interface VerbuchungsstelleDAO {

    public void saveOrUpdate(Verbuchungsstelle verbuchungsstelle);

    public List<Verbuchungsstelle> getAllVerbuchungsstelle();

    public Verbuchungsstelle getVerbuchungsstelleById(Integer id);

    public void deleteVerbuchungsstelleById(Integer id);

    public void setSession(Session session);

    public List<Verbuchungsstelle> getVerbuchungsstelleByName(String kapitel, String titel, String ut, String position, String pn, String zweck);

}
