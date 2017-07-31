/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.QMFinanzierung;

/**
 *
 * @author Sonja Schäfer
 */
public interface QMFinanzierungDAO {

    public void saveOrUpdate(QMFinanzierung qmfinanzierung);

//    public List<QMFinanzierung> getAllQMFinanzierung();
    public void setSession(Session session);

}
