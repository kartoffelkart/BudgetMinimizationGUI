/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.DMFinanzierung;
import projektaufgabe.bdo.QMFinanzierung;

/**
 *
 * @author Sonja Schäfer
 */
public interface DMFinanzierungDAO {

    public void saveOrUpdate(DMFinanzierung dmfinanzierung);

    public void setSession(Session session);

}
