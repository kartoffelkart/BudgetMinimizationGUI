/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.bdo;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author Sonja
 */
@Entity
@Table(name = "entgeltstufe")
public class Entgeltstufe implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "index")
    private Integer index;
    @Column(name = "entgeltstufe")
    private StringProperty entgeltstufe = new SimpleStringProperty();

    public Entgeltstufe() {
    }

    public Entgeltstufe(String entgeltstufe) {
        this.entgeltstufe.set(entgeltstufe);
    }

    public Entgeltstufe(StringProperty entgeltstufe) {
        this.entgeltstufe = entgeltstufe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StringProperty getEntgeltstufeProperty() {
        return entgeltstufe;
    }

    @Access(AccessType.PROPERTY)
    public String getEntgeltstufe() {
        return entgeltstufe.get();
    }

    public void setEntgeltstufe(String entgeltstufe) {
        this.entgeltstufe.set(entgeltstufe);
    }

    @Override
    public String toString() {
        return this.getEntgeltstufe();
    }

    public StringProperty toStringProperty() {
        StringProperty sp = new SimpleStringProperty();
        sp.set(this.getEntgeltstufe());
        return sp;
    }

}
