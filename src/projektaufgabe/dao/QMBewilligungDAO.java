/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.QMBewilligung;

/**
 *
 * @author Sonja Schäfer
 */
public interface QMBewilligungDAO {

    public void saveOrUpdate(QMBewilligung qMBewilligung);

    public List<QMBewilligung> getAllQMBewilligung();

    public QMBewilligung getQMBewilligungById(Integer id);

    public void deleteQMBewilligungById(Integer id);

    public void setSession(Session session);

    public List<QMBewilligung> getQMBewilligungByNr(String nr);

}
