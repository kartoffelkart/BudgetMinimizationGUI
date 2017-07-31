/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.Finanzierung;
import projektaufgabe.bdo.VBSFinanzierung;

/**
 *
 * @author Sonja Schäfer
 */
public interface VBSFinanzierungDAO {

    public void saveOrUpdate(VBSFinanzierung finanzierung);

    public List<VBSFinanzierung> getAllVBSFinanzierung();

    public VBSFinanzierung getVBSFinanzierungById(Integer id);

    public void setSession(Session session);

    public void deleteVBSFinanzierungById(Integer id);

    public void deleteVerbindllichkeitenByVBSFinanzierungId(Integer id);


}
