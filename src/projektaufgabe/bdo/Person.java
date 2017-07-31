/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.bdo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

/**
 *
 * @author Sonja Schäfer
 */
@Entity
@TypeDef(
        name = "localDateType",
        defaultForType = LocalDate.class,
        typeClass = LocalDateUserType.class)

@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "vorname")
    private StringProperty vorname = new SimpleStringProperty();
    @Column(name = "nachname")
    private StringProperty nachname = new SimpleStringProperty();
    @Column(name = "persnr")
    private StringProperty persNr = new SimpleStringProperty();
    @Column(columnDefinition = "date", name = "gebdatum")
    @Type(type = "localDateType")
    private LocalDate gebDatum;
    @Column(columnDefinition = "date", name = "promdatum")
    @Type(type = "localDateType")
    private LocalDate promDatum;
    @OneToMany(mappedBy = "person")
    private Set<Verbindlichkeit> verbindlichkeiten;

    @Transient
    private ObjectProperty<LocalDate> gebDatumProperty = null;

    @Transient
    private ObjectProperty<LocalDate> promDatumProperty = null;

    public Person() {

    }

    public Person(String vorname, String nachname, String persNr, LocalDate gebDatum, LocalDate promDatum) {
        this.vorname.set(vorname);
        this.nachname.set(nachname);
        this.persNr.set(persNr);
        this.gebDatum = gebDatum;
        this.promDatum = promDatum;

    }

    public Integer getId() {
        return id;
    }

    public StringProperty getVornameProperty() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname.set(vorname);
    }

    @Access(AccessType.PROPERTY)
    public String getVorname() {
        return vorname.get();
    }

    public StringProperty getNachnameProperty() {
        return nachname;
    }

    @Access(AccessType.PROPERTY)
    public String getNachname() {
        return nachname.get();
    }

    public void setNachname(String nachname) {
        this.nachname.set(nachname);
    }

    public StringProperty getPersNrProperty() {
        return persNr;
    }

    @Access(AccessType.PROPERTY)
    public String getPersNr() {
        return persNr.get();
        
    }

    public void setPersNr(String persNr) {
        this.persNr.set(persNr);
    }

    @Transient
    public ObjectProperty<LocalDate> getGebDatumProperty() {
        if (gebDatumProperty == null) {
            gebDatumProperty = new SimpleObjectProperty<>(gebDatum);
        }
        if (gebDatum != null
                && !gebDatumProperty.get().isEqual(gebDatum)) {
            gebDatumProperty = new SimpleObjectProperty<>(gebDatum);
        }
        gebDatumProperty.addListener((ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) -> gebDatum = newValue);
        return gebDatumProperty;
    }

    @Transient
    public ObjectProperty<LocalDate> getPromDatumProperty() {
        if (promDatumProperty == null) {
            promDatumProperty = new SimpleObjectProperty<>(promDatum);
        }
        if (promDatum != null
                && !promDatumProperty.get().isEqual(promDatum)) {
            promDatumProperty = new SimpleObjectProperty<>(promDatum);
        }
        promDatumProperty.addListener((ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) -> gebDatum = newValue);
        return promDatumProperty;
    }

    public LocalDate getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(LocalDate gebDatum) {
        this.gebDatum = gebDatum;
    }

    public LocalDate getPromDatum() {
        return promDatum;
    }

    public void setPromDatum(LocalDate promDatum) {
        this.promDatum = promDatum;
    }

    public Set<Verbindlichkeit> getVerbindlichkeiten() {
        return verbindlichkeiten;
    }

    public void setVerbindlichkeiten(Set<Verbindlichkeit> verbindlichkeiten) {
        this.verbindlichkeiten = verbindlichkeiten;
    }

    @Override
    public String toString() {
        return  this.getNachname() + ", "
                + this.getVorname() + ", " + this.getPersNr();
    }

}
