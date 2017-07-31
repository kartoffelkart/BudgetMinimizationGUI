/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.bdo;

import java.io.Serializable;
import java.util.Objects;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

/**
 *
 * @author Sonja Schäfer
 */
@Entity
@Table(name = "finanzierung")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "classtype",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("F")
public class Finanzierung implements Serializable, Cloneable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "anteil")
    private DoubleProperty anteil = new SimpleDoubleProperty();

    @Column(name = "finanzierungsTyp")
    private StringProperty finanzierungsTyp = new SimpleStringProperty();
    @Column(name = "bemerkung")
    private StringProperty bemerkung = new SimpleStringProperty();
    @ManyToOne
    @JoinColumn(name = "verbindlichkeitid")     //Fremdschlüssel
    private Verbindlichkeit verbindlichkeit;

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Finanzierung other = (Finanzierung) obj;
//        if (!Objects.equals(this.anteil, other.anteil)) {
//            return false;
//        }
//        if (!Objects.equals(this.finanzierungsTyp, other.finanzierungsTyp)) {
//            return false;
//        }
//        if (!Objects.equals(this.bemerkung, other.bemerkung)) {
//            return false;
//        }
//        if (!Objects.equals(this.verbindlichkeit, other.verbindlichkeit)) {
//            return false;
//        }
//        return true;
//    }
    @Override
    public Finanzierung clone() {
        Finanzierung finanzierungClone = new Finanzierung();

        finanzierungClone.setAnteil(this.getAnteil());
        finanzierungClone.setBemerkung(this.getBemerkung());
        finanzierungClone.setFinanzierungsTyp(this.getFinanzierungsTyp());

        finanzierungClone.setVerbindlichkeit(verbindlichkeit);
        return finanzierungClone;
    }

    public Finanzierung() {
    }

    public Finanzierung(Double anteil, String finanzierungsTyp, String bemerkung) {//, Verbindlichkeit verbindlichkeit, Verbuchungsstelle verbuchungsstelle) {
        this.anteil.set(anteil);
        this.finanzierungsTyp.set(finanzierungsTyp);
        this.bemerkung.set(bemerkung);

    }

    public DoubleProperty getAnteilProperty() {
        return anteil;
    }

    public StringProperty getBemerkungProperty() {
        return bemerkung;
    }

    public Verbindlichkeit getVerbindlichkeit() {
        return verbindlichkeit;
    }

    public StringProperty getFinanzierungsTypProperty() {
        return finanzierungsTyp;
    }

    public Integer getId() {
        return id;
    }

    public void setFinanzierungsTyp(String finanzierungsTyp) {
        this.finanzierungsTyp.set(finanzierungsTyp);
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung.set(bemerkung);
    }

    public void setAnteil(Double anteil) {
        this.anteil.set(anteil);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVerbindlichkeit(Verbindlichkeit verbindlichkeit) {
        this.verbindlichkeit = verbindlichkeit;
    }

    @Access(AccessType.PROPERTY)
    public Double getAnteil() {
        return anteil.get();
    }

    @Access(AccessType.PROPERTY)
    public String getFinanzierungsTyp() {
        return finanzierungsTyp.get();
    }

    @Access(AccessType.PROPERTY)
    public String getBemerkung() {
        return bemerkung.get();
    }

//    public Verbuchungsstelle getVerbuchungsstelle() {
//        return verbuchungsstelle;
//    }
//
//    public void setVerbuchungsstelle(Verbuchungsstelle verbuchungsstelle) {
//        this.verbuchungsstelle = verbuchungsstelle;
//    }
//     @Access(AccessType.PROPERTY)
//    public String getKapitel() {
//        return kapitel.get();
//    }
//
//    public StringProperty getKapitelProperty() {
//        return kapitel;
//    }
//
//    public void setKapitel(String kapitel) {
//        this.kapitel.set(kapitel);
//    }
//
//    @Access(AccessType.PROPERTY)
//
//    public String getTitel() {
//        return titel.get();
//    }
//
//    public StringProperty getTitelProperty() {
//        return titel;
//    }
//
//    public void setTitel(String titel) {
//        this.titel.set(titel);
//    }
//
//    @Access(AccessType.PROPERTY)
//    public String getUntertitel() {
//        return untertitel.get();
//    }
//
//    public StringProperty getUntertitelProperty() {
//        return untertitel;
//    }
//
//    public void setUntertitel(String untertitel) {
//        this.untertitel.set(untertitel);
//    }
//
//    @Access(AccessType.PROPERTY)
//    public String getPosition() {
//        return position.get();
//    }
//
//    public StringProperty getPositionProperty() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position.set(position);
//    }
//
//    @Access(AccessType.PROPERTY)
//    public String getPn() {
//        return pn.get();
//    }
//
//    public StringProperty getPnProperty() {
//        return pn;
//    }
//
//    public void setPn(String pn) {
//        this.pn.set(pn);
//    }
//
//    @Access(AccessType.PROPERTY)
//    public String getZweck() {
//        return zweck.get();
//    }
//
//    public StringProperty getZweckProperty() {
//        return zweck;
//    }
//
//    public void setZweck(String zweck) {
//        this.zweck.set(zweck);
//    }
    @Override
    public String toString() {
        return this.getBemerkung();

    }

    public StringProperty getFinanzierungsText() {
        StringProperty sp = new SimpleStringProperty();
        sp.set(this.toString());
        return sp;

}
}
