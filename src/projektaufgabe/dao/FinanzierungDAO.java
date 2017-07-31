/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.Finanzierung;

/**
 *
 * @author Sonja Schäfer
 */
public interface FinanzierungDAO {

    public void saveOrUpdate(Finanzierung finanzierung);

    public List<Finanzierung> getAllFinanzierung();

    public Finanzierung getFinanzierungById(Integer id);

    public void setSession(Session session);

    public void deleteFinanzierungById(Integer id);

    public void deleteVerbindllichkeitenByFinanzierungId(Integer id);

    public List<Finanzierung> getAllFinanzierungByVerbindlichkeitId(Integer id);

    public void refreshFinanzierung(Finanzierung finanzierung);

}
