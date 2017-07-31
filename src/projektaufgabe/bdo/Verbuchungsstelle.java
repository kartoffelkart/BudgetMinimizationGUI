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

import javax.persistence.*;

/**
 *
 * @author Sonja Schäfer
 */
@Entity
@Table(name = "verbuchungsstelle")
public class Verbuchungsstelle implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "kapitel")
    private StringProperty kapitel = new SimpleStringProperty();
    @Column(name = "titel")
    private StringProperty titel = new SimpleStringProperty();
    @Column(name = "untertitel")
    private StringProperty untertitel = new SimpleStringProperty();
    @Column(name = "position")
    private StringProperty position = new SimpleStringProperty();
    @Column(name = "pn")
    private StringProperty pn = new SimpleStringProperty();
    @Column(name = "zweck")
    private StringProperty zweck = new SimpleStringProperty();
    @OneToMany(mappedBy = "verbuchungsstelle")
    private Set<VBSFinanzierung> vbsfinanzierungen;

    public Verbuchungsstelle() {
    }

    public Verbuchungsstelle(String kapitel, String titel, String untertitel, String position, String pn, String zweck) {
        this.kapitel.set(kapitel);
        this.titel.set(titel);
        this.untertitel.set(untertitel);
        this.position.set(position);
        this.pn.set(pn);
        this.zweck.set(zweck);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Access(AccessType.PROPERTY)
    public String getKapitel() {
        return kapitel.get();
    }

    public StringProperty getKapitelProperty() {
        return kapitel;
    }

    public void setKapitel(String kapitel) {
        this.kapitel.set(kapitel);
    }

    @Access(AccessType.PROPERTY)

    public String getTitel() {
        return titel.get();
    }

    public StringProperty getTitelProperty() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel.set(titel);
    }

    @Access(AccessType.PROPERTY)
    public String getUntertitel() {
        return untertitel.get();
    }

    public StringProperty getUntertitelProperty() {
        return untertitel;
    }

    public void setUntertitel(String untertitel) {
        this.untertitel.set(untertitel);
    }

    @Access(AccessType.PROPERTY)
    public String getPosition() {
        return position.get();
    }

    public StringProperty getPositionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    @Access(AccessType.PROPERTY)
    public String getPn() {
        return pn.get();
    }

    public StringProperty getPnProperty() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn.set(pn);
    }

    @Access(AccessType.PROPERTY)
    public String getZweck() {
        return zweck.get();
    }

    public StringProperty getZweckProperty() {
        return zweck;
    }

    public void setZweck(String zweck) {
        this.zweck.set(zweck);
    }

    public Set<VBSFinanzierung> getVBSFinanzierungen() {
        return vbsfinanzierungen;
    }

    public void addVBSFinanzierung(VBSFinanzierung vbsfinanzierung) {
        vbsfinanzierungen.add(vbsfinanzierung);
    }

    public void setVBSFinanzierungen(Set<VBSFinanzierung> vbsfinanzierungen) {
        this.vbsfinanzierungen = vbsfinanzierungen;
    }

    @Override
    public String toString() {
        return this.getPn()
                + ", " + this.getPosition()
                + ", " + this.getKapitel()
                + ", " + this.getTitel()
                + ", " + this.getUntertitel()
                + ", " + this.getZweck();
    }

}
