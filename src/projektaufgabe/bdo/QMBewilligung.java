/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.bdo;

import java.io.Serializable;
import java.util.Set;
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
@Table(name = "qmbewilligung")
public class QMBewilligung implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
     @Column(name = "bewilligungsNr")
    private StringProperty bewilligungsNr = new SimpleStringProperty();
     
    @OneToMany(mappedBy = "qmbewilligung")
    private Set<QMFinanzierung> qmfinanzierungen;

    public QMBewilligung() {
    }

    public QMBewilligung(String bewilligungsNr) {
        this.bewilligungsNr.set(bewilligungsNr); 
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
  public StringProperty getBewilligungsNrProperty() {
        return bewilligungsNr;
    }

    @Access(AccessType.PROPERTY)
    public String getBewilligungsNr() {
        return bewilligungsNr.get();
    }

    public void setBewilligungsNr(String bewilligungsNr) {
        this.bewilligungsNr.set(bewilligungsNr);
    }

    @Override
    public String toString() {
        return "QMBewilligung{" +  this.getBewilligungsNr();
    }

    
     
}
