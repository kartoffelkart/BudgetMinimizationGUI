/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.bdo;

import java.io.Serializable;
import java.util.Set;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author Sonja
 */

@Entity
@Table(name = "arbeitsverhaeltnis")
public class Arbeitsverhaeltnis implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "index")
    private Integer index;
     @Column(name = "arbeitsverhaeltnis")
    private StringProperty arbeitsverhaeltnis = new SimpleStringProperty();
    
    
    public Arbeitsverhaeltnis() {
    }

    public Arbeitsverhaeltnis(String arbeitsverhaeltnis) {
        this.arbeitsverhaeltnis.set(arbeitsverhaeltnis); 
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
  public StringProperty getArbeitsverhaeltnisProperty() {
        return arbeitsverhaeltnis;
    }

    @Access(AccessType.PROPERTY)
    public String getArbeitsverhaeltnis() {
        return arbeitsverhaeltnis.get();
    }

    public void setArbeitsverhaeltnis(String arbeitsverhaeltnis) {
        this.arbeitsverhaeltnis.set(arbeitsverhaeltnis);
    }

    @Override
    public String toString() {
        return "Arbeitsverhaeltnis{" +  this.getArbeitsverhaeltnis();
    }

    
     
}
