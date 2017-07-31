/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.bdo;

import java.io.Serializable;
import static java.sql.Date.valueOf;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

/**
 *
 * @author Sonja
 */
@Entity
@TypeDef(
        name = "localDateType",
        defaultForType = LocalDate.class,
        typeClass = LocalDateUserType.class)
@Table(name = "verbindlichkeit")
public class Verbindlichkeit implements Serializable, Cloneable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "vRef")
    private IntegerProperty vRef = new SimpleIntegerProperty();
    @Column(columnDefinition = "date", name = "von")
    @Type(type = "localDateType")
    private LocalDate von;
    @Column(columnDefinition = "date", name = "bis")
    @Type(type = "localDateType")
    private LocalDate bis;
    @Column(name = "anteilVZ")
    private DoubleProperty anteilVZ = new SimpleDoubleProperty();
    @Column(name = "arbeitsstunden")
    private DoubleProperty arbeitsstunden = new SimpleDoubleProperty();
    @Column(name = "entgeltstufe")
    private StringProperty entgeltstufe = new SimpleStringProperty();
    @Column(name = "bemerkung")
    private StringProperty bemerkung = new SimpleStringProperty();
    @Column(name = "arbeitsverhaeltnis")
    private StringProperty arbeitsverhaeltnis = new SimpleStringProperty();
    @Column(name = "unbefristet")
    private BooleanProperty unbefristet = new SimpleBooleanProperty();
    @Column(name = "BeschaeftigungsKateg")
    private StringProperty beschaeftigungsKateg = new SimpleStringProperty();
    @ManyToOne
    @JoinColumn(name = "personid")//Fremdschlüssel
    private Person person;
    @ManyToOne
    @JoinColumn(name = "verbindlichkeitstypid")//Fremdschlüssel
    private Verbindlichkeitstyp verbindlichkeitstyp;
    @ManyToOne
    @JoinColumn(name = "organisationsid")//Fremdschlüssel
    private Organisationseinheit organisationseinheit;
    @OneToMany(mappedBy = "verbindlichkeit")
    private Set<Finanzierung> finanzierungen = new HashSet<>();
    @Transient
    private ObjectProperty<LocalDate> vonproperty = null;
    @Transient
    private ObjectProperty<LocalDate> bisproperty = null;

////equals neu implementieren
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Verbindlichkeit other = (Verbindlichkeit) obj;
//        if (!Objects.equals(this.vRef, other.vRef)) {
//            return false;
//        }
//        if (!Objects.equals(this.von, other.von)) {
//            return false;
//        }
//        if (!Objects.equals(this.bis, other.bis)) {
//            return false;
//        }
//        if (!Objects.equals(this.anteilVZ, other.anteilVZ)) {
//            return false;
//        }
//        if (!Objects.equals(this.arbeitsstunden, other.arbeitsstunden)) {
//            return false;
//        }
//        if (!Objects.equals(this.entgeltstufe, other.entgeltstufe)) {
//            return false;
//        }
//        if (!Objects.equals(this.bemerkung, other.bemerkung)) {
//            return false;
//        }
//        if (!Objects.equals(this.arbeitsverhaeltnis, other.arbeitsverhaeltnis)) {
//            return false;
//        }
//        if (!Objects.equals(this.unbefristet, other.unbefristet)) {
//            return false;
//        }
//        if (!Objects.equals(this.beschaeftigungsKateg, other.beschaeftigungsKateg)) {
//            return false;
//        }
//        if (!Objects.equals(this.person, other.person)) {
//            return false;
//        }
//        if (!Objects.equals(this.verbindlichkeitstyp, other.verbindlichkeitstyp)) {
//            return false;
//        }
//        if (!Objects.equals(this.organisationseinheit, other.organisationseinheit)) {
//            return false;
//        }
//        if (!Objects.equals(this.finanzierungen, other.finanzierungen)) {
//            return false;
//        }
//        if (!Objects.equals(this.vonproperty, other.vonproperty)) {
//            return false;
//        }
//        if (!Objects.equals(this.bisproperty, other.bisproperty)) {
//            return false;
//        }
//        return true;
//    }
    @Override
    public Verbindlichkeit clone() {
        Verbindlichkeit verbindlichkeitClone = new Verbindlichkeit();
//            LocalDate date = LocalDate.from(this.getVon());
//            this.getVon().adjustInto(date);
//            return false;);.
        verbindlichkeitClone.setVon(LocalDate.from(this.getVon()));
        verbindlichkeitClone.setBis(LocalDate.from(this.getBis()));

        verbindlichkeitClone.setvRef(this.getvRef()); //ist Integer such nur eine Objektreferenz?
        verbindlichkeitClone.setAnteilVZ(this.getAnteilVZ());
        verbindlichkeitClone.setArbeitsstunden(this.getArbeitsstunden());
        verbindlichkeitClone.setEntgeltstufe(this.getEntgeltstufe());
        verbindlichkeitClone.setBemerkung(this.getBemerkung());
        verbindlichkeitClone.setArbeitsverhaeltnis(this.getArbeitsverhaeltnis());
        verbindlichkeitClone.setUnbefristet(this.getUnbefristet());
        verbindlichkeitClone.setBeschaeftigungsKateg(this.getBeschaeftigungsKateg());

        verbindlichkeitClone.setPerson(person);
        verbindlichkeitClone.setVerbindlichkeitstyp(verbindlichkeitstyp);
        verbindlichkeitClone.setOrganisationseinheit(organisationseinheit);

        for (Finanzierung temp : finanzierungen) {
            Finanzierung tempClone = temp.clone();
            tempClone.setVerbindlichkeit(verbindlichkeitClone);
            System.out.println(verbindlichkeitClone.getFinanzierungen());
            System.out.println(tempClone);
            System.out.println(tempClone.getBemerkung());
            System.out.println(temp.getClass());
            verbindlichkeitClone.addFinanzierung(tempClone);
        }

        return verbindlichkeitClone;
    }

    public Verbindlichkeit() {

    }

    public Verbindlichkeit(Integer vRef, LocalDate von, LocalDate bis, Double anteilVZ, Double arbeitsstunden, String entgeltstufe, String bemerkung, String arbeitsverhaeltnis, String BeschaeftigungsKateg) {
        this.vRef.set(vRef);
        this.von = von;
        this.bis = bis;
        this.anteilVZ.set(anteilVZ);
        this.arbeitsstunden.set(arbeitsstunden);
        this.entgeltstufe.set(entgeltstufe);
        this.bemerkung.set(bemerkung);
        this.arbeitsverhaeltnis.set(arbeitsverhaeltnis);
        this.beschaeftigungsKateg.set(BeschaeftigungsKateg);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Access(AccessType.PROPERTY)
    public Integer getvRef() {
        return vRef.get();
    }

    public IntegerProperty getvRefProperty() {
        return vRef;
    }

    public void setvRef(Integer vRef) {
        this.vRef.set(vRef);
    }

    public LocalDate getVon() {
        return von;
    }

    @Transient
    public ObjectProperty<LocalDate> getVonProperty() {
        if (vonproperty == null) {
            vonproperty = new SimpleObjectProperty<>(von);
        }
        if (von != null
                && !vonproperty.get().isEqual(von)) {
            vonproperty = new SimpleObjectProperty<>(von);
        }
        vonproperty.addListener((ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) -> von = newValue);
        return vonproperty;
    }

    public void setVon(LocalDate von) {
        this.von = von;
    }

    public LocalDate getBis() {
        return bis;
    }

    @Transient
    public ObjectProperty<LocalDate> getBisProperty() {
        if (bisproperty == null) {
            bisproperty = new SimpleObjectProperty<>(bis);
        }
        if (bis != null
                && !bisproperty.get().isEqual(bis)) {
            bisproperty = new SimpleObjectProperty<>(bis);
        }
        bisproperty.addListener((ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) -> bis = newValue);
        return bisproperty;
    }

    public void setBis(LocalDate bis) {
        this.bis = bis;
    }

    @Access(AccessType.PROPERTY)
    public Double getAnteilVZ() {
        return anteilVZ.get();
    }

    public DoubleProperty getAnteilVZProperty() {
        return anteilVZ;
    }

    public void setAnteilVZ(Double anteilVZ) {
        this.anteilVZ.set(anteilVZ);
    }

    @Access(AccessType.PROPERTY)
    public Double getArbeitsstunden() {
        return arbeitsstunden.get();
    }

    public DoubleProperty getArbeitsstundenProperty() {
        return arbeitsstunden;
    }

    public void setArbeitsstunden(Double arbeitsstunden) {
        this.arbeitsstunden.set(arbeitsstunden);
    }

    @Access(AccessType.PROPERTY)
    public String getEntgeltstufe() {
        return entgeltstufe.get();
    }

    public StringProperty getEntgeltstufeProperty() {
        return entgeltstufe;
    }

    public void setEntgeltstufe(String entgeltstufe) {
        this.entgeltstufe.set(entgeltstufe);
    }

    @Access(AccessType.PROPERTY)
    public String getBemerkung() {
        return bemerkung.get();
    }

    public StringProperty getBemerkungProperty() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung.set(bemerkung);
    }

    @Access(AccessType.PROPERTY)
    public String getArbeitsverhaeltnis() {
        return arbeitsverhaeltnis.get();
    }

    public StringProperty getArbeitsverhaeltnisProperty() {
        return arbeitsverhaeltnis;
    }

    public void setArbeitsverhaeltnis(String arbeitsverhaeltnis) {
        this.arbeitsverhaeltnis.set(arbeitsverhaeltnis);

    }

    @Access(AccessType.PROPERTY)
    public Boolean getUnbefristet() {
        return unbefristet.get();
    }

    public BooleanProperty getUnbefristetProperty() {
        return unbefristet;
    }

    public void setUnbefristet(Boolean unbefristet) {
        this.unbefristet.set(unbefristet);
    }

    @Access(AccessType.PROPERTY)
    public String getBeschaeftigungsKateg() {
        return beschaeftigungsKateg.get();
    }

    public StringProperty getBeschaeftigungsKategProperty() {
        return beschaeftigungsKateg;
    }

    public void setBeschaeftigungsKateg(String BeschaeftigungsKateg) {
        this.beschaeftigungsKateg.set(BeschaeftigungsKateg);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Organisationseinheit getOrganisationseinheit() {
        return organisationseinheit;
    }

    public void setOrganisationseinheit(Organisationseinheit organisationseinheit) {
        this.organisationseinheit = organisationseinheit;
    }

    public Set<Finanzierung> getFinanzierungen() {
        return finanzierungen;
    }

    public void addFinanzierung(Finanzierung finanzierung) {
        finanzierungen.add(finanzierung);
    }

    public void setFinanzierungen(Set<Finanzierung> finanzierungen) {
        this.finanzierungen = finanzierungen;
    }
//     public void setFinanzierungen(ObservableList<Finanzierung> list) {
//         Set<Finanzierung> finanzierungen = new HashSet<>();
//        for (Finanzierung temp : list) {
//            finanzierungen.add(temp);
//            this.finanzierungen = finanzierungen;
//        }
//    }
//
//    public void addFinanzierung(Finanzierung finanzierungen) {
//        this.finanzierungen.add(finanzierungen);
//    }

    public Verbindlichkeitstyp getVerbindlichkeitstyp() {
        return verbindlichkeitstyp;
    }

    public void setVerbindlichkeitstyp(Verbindlichkeitstyp verbindlichkeitstyp) {
        this.verbindlichkeitstyp = verbindlichkeitstyp;
    }

    @Override
    public String toString() {
        return "Verbindlichkeit{" + "id=" + id + ", vRef=" + vRef + ", von="
                + von + ", bis=" + bis + ", anteilVZ=" + anteilVZ + ", arbeitsstunden="
                + arbeitsstunden + ", entgeltstufe=" + entgeltstufe + ", bemerkung="
                + bemerkung + ", arbeitsverhaeltnis=" + arbeitsverhaeltnis + ", unbefristet="
                + unbefristet + ", BeschaeftigungsKateg=" + beschaeftigungsKateg + '}';
    }

}
