/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.dao;

import java.util.List;
import org.hibernate.Session;
import projektaufgabe.bdo.Arbeitsverhaeltnis;

/**
 *
 * @author Sonja Schäfer
 */
public interface ArbeitsverhaeltnisDAO {

    public void saveOrUpdate(Arbeitsverhaeltnis arbeitsverhaeltnis);

    public List<Arbeitsverhaeltnis> getAllArbeitsverhaeltnis();

    public void setSession(Session session);
}
