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

@Table(name = "stelle")
public class Stelle implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "stellenNr")
    private StringProperty stellenNr = new SimpleStringProperty();
    ;
    @OneToMany(mappedBy = "stelle")
    private Set<PBMFinanzierung> pbmfinanzierungen;

    public Stelle() {
    }

    public Stelle( String stellenNr) {
      
        this.stellenNr.set(stellenNr);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StringProperty getStellenNrProperty() {
        return stellenNr;
    }

    @Access(AccessType.PROPERTY)
    public String getStellenNr() {
        return stellenNr.get();
    }

    public void setStellenNr(String stellenNr) {
        this.stellenNr.set(stellenNr);
    }

    @Override
    public String toString() {
        return this.getStellenNr();
    }

}
