/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.DMBewilligung;
import projektaufgabe.bdo.QMBewilligung;

/**
 *
 * @author Sonja Schäfer
 */
public interface DMBewilligungDAO {

    public void saveOrUpdate(DMBewilligung dMBewilligung);

    public List<DMBewilligung> getAllDMBewilligung();

    public DMBewilligung getDMBewilligungById(Integer id);

    public void deleteDMBewilligungById(Integer id);

    public void setSession(Session session);

    public List<DMBewilligung> getDMBewilligungByNr(String nr);

}
