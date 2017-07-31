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
@Table(name = "organisationseinheit")
public class Organisationseinheit implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "institut")
    private StringProperty institut = new SimpleStringProperty();
    @Column(name = "abteilung")
    private StringProperty abteilung = new SimpleStringProperty();
    @Column(name = "arbeitsgruppe")
    private StringProperty arbeitsgruppe = new SimpleStringProperty();
    @Column(name = "bemerkung")
    private StringProperty bemerkung = new SimpleStringProperty();
    @OneToMany(mappedBy = "organisationseinheit")
    private Set<Verbindlichkeit> verbindlichkeiten;

    public Organisationseinheit() {
    }

    public Organisationseinheit(String institut, String abteilung, String arbeitsgruppe, String bemerkung) {
        this.institut.set(institut);
        this.abteilung.set(abteilung);
        this.arbeitsgruppe.set(arbeitsgruppe);
        this.bemerkung.set(bemerkung);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Access(AccessType.PROPERTY)
    public String getInstitut() {
        return institut.get();
    }

    public void setInstitut(String institut) {
        this.institut.set(institut);
    }

    public StringProperty getInstitutProperty() {
        return institut;
    }

    @Access(AccessType.PROPERTY)
    public String getAbteilung() {
        return abteilung.get();
    }

    public void setAbteilung(String abteilung) {
        this.abteilung.set(abteilung);
    }

    public StringProperty getAbteilungProperty() {
        return abteilung;
    }

    @Access(AccessType.PROPERTY)
    public String getArbeitsgruppe() {
        return arbeitsgruppe.get();
    }

    public void setArbeitsgruppe(String arbeitsgruppe) {
        this.arbeitsgruppe.set(arbeitsgruppe);
    }

    public StringProperty getArbeitsgruppeProperty() {
        return arbeitsgruppe;
    }

    @Access(AccessType.PROPERTY)
    public String getBemerkung() {
        return bemerkung.get();
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung.set(bemerkung);
    }

    public StringProperty getBemerkungProperty() {
        return bemerkung;
    }

    public Set<Verbindlichkeit> getVerbindlichkeiten() {
        return verbindlichkeiten;
    }

    public void setVerbindlichkeiten(Set<Verbindlichkeit> verbindlichkeiten) {
        this.verbindlichkeiten = verbindlichkeiten;
    }

    @Override
    public String toString() {
        return institut.get()
                + "," + abteilung.get() + "," + arbeitsgruppe.get()
                 
//                ", bemerkung=" + bemerkung + ", verbindlichkeiten=" + verbindlichkeiten + 
                ;
    }
}
