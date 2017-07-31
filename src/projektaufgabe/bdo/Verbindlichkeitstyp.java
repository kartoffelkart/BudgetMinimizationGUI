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
@Table(name = "verbindlichkeitstyp")
public class Verbindlichkeitstyp implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "typ")
    private StringProperty typ = new SimpleStringProperty();
    
    @OneToMany(mappedBy = "verbindlichkeitstyp")
    private Set<Verbindlichkeit> verbindlichkeiten;

    public Verbindlichkeitstyp() {
    }

    public Verbindlichkeitstyp(String typ) {
        this.typ.set(typ);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Access(AccessType.PROPERTY)
    public String getTyp() {
        return typ.get();
    }

    public StringProperty getTypProperty() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ.set(typ);
    }

    @Override
    public String toString() {
        return  typ.get() ;
    }

}
