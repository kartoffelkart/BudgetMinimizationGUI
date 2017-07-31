/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.bdo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import javax.persistence.Transient;

/**
 *
 * @author Meike Brülls <s6mebrue@uni-bonn.de>
 */
@Entity
@Table(name = "buchungtest")
public class Buchung {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "jahr")
    @Transient
    private IntegerProperty jahr = new SimpleIntegerProperty();
    @Column(name = "kap")
    @Transient
    private StringProperty kap = new SimpleStringProperty();
    @Column(name = "titel")
    @Transient
    private StringProperty titel = new SimpleStringProperty();
    @Column(name = "lieferant")
    @Transient
    private StringProperty lieferant = new SimpleStringProperty();
    @Column(name = "ut")
    @Transient
    private StringProperty ut = new SimpleStringProperty();
    @Column(name = "fb")
    @Transient
    private StringProperty fb = new SimpleStringProperty();
    @Column(name = "ins")
    @Transient
    private StringProperty ins = new SimpleStringProperty();
    @Column(name = "ins2")
    @Transient
    private StringProperty ins2 = new SimpleStringProperty();
    @Column(name = "ins3")
    @Transient
    private StringProperty ins3 = new SimpleStringProperty();
    @Column(name = "huel")
    @Transient
    private StringProperty huel = new SimpleStringProperty();
    @Column(name = "u")
    @Transient
    private StringProperty u = new SimpleStringProperty();
    @Column(name = "kennz1")
    @Transient
    private StringProperty kennz1 = new SimpleStringProperty();
    @Column(name = "betrag")
    @Transient
    private StringProperty betrag = new SimpleStringProperty();
    @Column(name = "bdatum")
    @Transient
    private StringProperty bdatum = new SimpleStringProperty();
    @Column(name = "grund1")
    @Transient
    private StringProperty grund1 = new SimpleStringProperty();
    @Column(name ="personalbuchung")
    @Transient
    private BooleanProperty personalbuchung = new SimpleBooleanProperty();
    @Column(name = "grund2")
    @Transient
    private StringProperty grund2 = new SimpleStringProperty();
    @Column(name = "auftragsnr")
    @Transient
    private StringProperty auftragsnr = new SimpleStringProperty();
    @Column(name = "rechnungsdatum")
    @Transient
    private StringProperty rechnungsdatum = new SimpleStringProperty();
    @Column(name = "fibu")
    @Transient
    private StringProperty fibu = new SimpleStringProperty();
    @Column(name = "rechnungsnr")
    @Transient
    private StringProperty rechnungsnr = new SimpleStringProperty();
    @Column(name = "kostenart")
    @Transient
    private StringProperty kostenart = new SimpleStringProperty();
    @Column(name = "kostenstelle")
    @Transient
    private StringProperty kostenstelle = new SimpleStringProperty();
    @Column(name = "kostentraeger")
    @Transient
    private StringProperty kostentraeger = new SimpleStringProperty();
    @Column(name = "bga")
    @Transient
    private StringProperty bga = new SimpleStringProperty();
    @Column(name = "kassenzeichen")
    @Transient
    private StringProperty kassenzeichen = new SimpleStringProperty();
    @Column(name = "kennz2")
    @Transient
    private StringProperty kennz2 = new SimpleStringProperty();
    @Column(name = "op")
    @Transient
    private StringProperty op = new SimpleStringProperty();
    @Column(name = "aw")
    @Transient
    private StringProperty aw = new SimpleStringProperty();
    @Column(name = "nachname") 
    @Transient
    private StringProperty nachname = new SimpleStringProperty();
    @Column(name = "vorname") 
    @Transient
    private StringProperty vorname = new SimpleStringProperty();

    public Buchung() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Access(AccessType.PROPERTY)
    public Integer getJahr() {
        return jahr.get();
    }

    public void setJahr(Integer jahr) {
        this.jahr.set(jahr);
    }

    public IntegerProperty getJahrProperty() {
        return jahr;
    }
    
    @Access(AccessType.PROPERTY)
    public Boolean getPersonalbuchung(){
        return personalbuchung.get();
    }
    
    public void setPersonalbuchung(Boolean personalbuchung){
        this.personalbuchung.set(personalbuchung);
    }
    
    public BooleanProperty getPersonalbuchungProperty() {
        return personalbuchung;
    }

    @Access(AccessType.PROPERTY)
    public String getKap() {
        return kap.get();
    }

    public void setKap(String kap) {
        this.kap.set(kap);
    }

    public StringProperty getKapProperty() {
        return kap;
    }

    @Access(AccessType.PROPERTY)
    public String getTitel() {
        return titel.get();
    }

    public void setTitel(String titel) {
        this.titel.set(titel);
    }

    public StringProperty getTitelProperty() {
        return titel;
    }

    @Access(AccessType.PROPERTY)
    public String getLieferant() {
        return lieferant.get();
    }

    public void setLieferant(String lieferant) {
        this.lieferant.set(lieferant);
    }

    public StringProperty getLieferantProperty() {
        return lieferant;
    }

    @Access(AccessType.PROPERTY)
    public String getUt() {
        return ut.get();
    }

    public void setUt(String ut) {
        this.ut.set(ut);
    }

    public StringProperty getUtProperty() {
        return ut;
    }

    @Access(AccessType.PROPERTY)
    public String getFb() {
        return fb.get();
    }

    public void setFb(String fb) {
        this.fb.set(fb);
    }

    public StringProperty getFbProperty() {
        return fb;
    }

    @Access(AccessType.PROPERTY)
    public String getIns() {
        return ins.get();
    }

    public void setIns(String ins) {
        this.ins.set(ins);
    }

    public StringProperty getInsProperty() {
        return ins;
    }

    @Access(AccessType.PROPERTY)
    public String getIns2() {
        return ins2.get();
    }

    public void setIns2(String ins2) {
        this.ins2.set(ins2);
    }

    public StringProperty getIns2Property() {
        return ins2;
    }

    @Access(AccessType.PROPERTY)
    public String getIns3() {
        return ins3.get();
    }

    public void setIns3(String ins3) {
        this.ins3.set(ins3);
    }

    public StringProperty getIns3Property() {
        return ins3;
    }

    @Access(AccessType.PROPERTY)
    public String getHuel() {
        return huel.get();
    }

    public void setHuel(String huel) {
        this.huel.set(huel);
    }

    public StringProperty getHuelProperty() {
        return huel;
    }
    @Access(AccessType.PROPERTY)
    public String getU() {
        return u.get();
    }

    public void setU(String u) {
        this.u.set(u);
    }

    public StringProperty getUProperty() {
        return u;
    }
    @Access(AccessType.PROPERTY)
    public String getKennz1() {
        return kennz1.get();
    }

    public void setKennz1(String kennz1) {
        this.kennz1.set(kennz1);
    }

    public StringProperty getKennz1Property() {
        return kennz1;
    }
    @Access(AccessType.PROPERTY)
    public String getBetrag() {
        return betrag.get();
    }

    public void setBetrag(String betrag) {
        this.betrag.set(betrag);
    }

    public StringProperty getBetragProperty() {
        return betrag;
    }
    @Access(AccessType.PROPERTY)
    public String getBDatum() {
        return bdatum.get();
    }

    public void setBDatum(String bdatum) {
        this.bdatum.set(bdatum);
    }

    public StringProperty getBDatumProperty() {
        return bdatum;
    }
    @Access(AccessType.PROPERTY)
    public String getGrund1() {
        return grund1.get();
    }

    public void setGrund1(String grund1) {
        this.grund1.set(grund1);
    }

    public StringProperty getGrund1Property() {
        return grund1;
    }
    @Access(AccessType.PROPERTY)
    public String getGrund2() {
        return grund2.get();
    }

    public void setGrund2(String grund2) {
        this.grund2.set(grund2);
    }

    public StringProperty getGrund2Property() {
        return grund2;
    }
    @Access(AccessType.PROPERTY)
    public String getAuftragsNr() {
        return auftragsnr.get();
    }

    public void setAuftragsNr(String auftragsnr) {
        this.auftragsnr.set(auftragsnr);
    }

    public StringProperty getAuftragsNrProperty() {
        return auftragsnr;
    }
    @Access(AccessType.PROPERTY)
    public String getRechnungsNr() {
        return rechnungsnr.get();
    }

    public void setRechnungsNr(String rechnungsnr) {
        this.rechnungsnr.set(rechnungsnr);
    }

    public StringProperty getRechnungsNrProperty() {
        return rechnungsnr;
    }
    @Access(AccessType.PROPERTY)
    public String getFibu() {
        return fibu.get();
    }

    public void setFibu(String fibu) {
        this.fibu.set(fibu);
    }

    public StringProperty getFibuProperty() {
        return fibu;
    }
    @Access(AccessType.PROPERTY)
    public String getRechnungsDatum() {
        return rechnungsdatum.get();
    }

    public void setRechnungsDatum(String rechnungsdatum) {
        this.rechnungsdatum.set(rechnungsdatum);
    }

    public StringProperty getRechnungsDatumProperty() {
        return rechnungsdatum;
    }
    @Access(AccessType.PROPERTY)
    public String getKostenart() {
        return kostenart.get();
    }

    public void setKostenart(String kostenart) {
        this.kostenart.set(kostenart);
    }

    public StringProperty getKostenartProperty() {
        return kostenart;
    }
    @Access(AccessType.PROPERTY)
    public String getKostenstelle() {
        return kostenstelle.get();
    }

    public void setKostenstelle(String kostenstelle) {
        this.kostenstelle.set(kostenstelle);
    }

    public StringProperty getKostenstelleProperty() {
        return kostenstelle;
    }
    @Access(AccessType.PROPERTY)
    public String getKostentraeger() {
        return kostentraeger.get();
    }

    public void setKostentraeger(String kostentraeger) {
        this.kostentraeger.set(kostentraeger);
    }

    public StringProperty getKostentraegerProperty() {
        return kostentraeger;
    }
    @Access(AccessType.PROPERTY)
    public String getBGA() {
        return bga.get();
    }

    public void setBGA(String bga) {
        this.bga.set(bga);
    }

    public StringProperty getBGAProperty() {
        return bga;
    }
    @Access(AccessType.PROPERTY)
    public String getKassenzeichen() {
        return kassenzeichen.get();
    }

    public void setKassenzeichen(String kassenzeichen) {
        this.kassenzeichen.set(kassenzeichen);
    }

    public StringProperty getKassenzeichenProperty() {
        return kassenzeichen;
    }
    @Access(AccessType.PROPERTY)
    public String getKennz2() {
        return kennz2.get();
    }

    public void setKennz2(String kennz2) {
        this.kennz2.set(kennz2);
    }

    public StringProperty getKennz2Property() {
        return kennz2;
    }
    @Access(AccessType.PROPERTY)
    public String getOP() {
        return op.get();
    }

    public void setOP(String op) {
        this.op.set(op);
    }

    public StringProperty getOPProperty() {
        return op;
    }
    @Access(AccessType.PROPERTY)
    public String getAW() {
        return aw.get();
    }

    public void setAW(String aw) {
        this.aw.set(aw);
    }

    public StringProperty getAWProperty() {
        return aw;
    }
    @Access(AccessType.PROPERTY)
    public String getNachname() {
        return nachname.get();
    }

    public void setNachname(String nachname) {
        this.nachname.set(nachname);
    }

    public StringProperty getNachnameProperty() {
        return nachname;
    }
    @Access(AccessType.PROPERTY)
    public String getVorname() {
        return vorname.get();
    }

    public void setVorname(String vorname) {
        this.vorname.set(vorname);
    }

    public StringProperty getVornameProperty() {
        return vorname;
    }

    
    
    /*
     @Override
     public boolean equals(Object o) {
     if (o instanceof Buchung) {
     Buchung b = (Buchung) o;
     System.out.println(b + " Erst buchung dann objekt  " + this);
     boolean x = this.getFb() == b.getFb() &&
     this.getIns() == b.getIns() &&
     this.getJahr() == b.getJahr() &&
     this.getKap() == b.getKap() &&
     this.getLieferant() == b.getLieferant() &&
     this.getTitel() == b.getTitel() &&
     this.getUt() == b.getUt();
     System.out.println(b.getJahr() + "    ih  " + this.getJahr() + "  x  : " + x); 
     }
     System.out.println("LALALALA");
     return false;
     }
     @Override
     public int hashCode() {
     int hash = 5;
     hash = 97 * hash + Objects.hashCode(this.jahr);
     hash = 97 * hash + Objects.hashCode(this.kap);
     hash = 97 * hash + Objects.hashCode(this.titel);
     hash = 97 * hash + Objects.hashCode(this.lieferant);
     hash = 97 * hash + Objects.hashCode(this.ut);
     hash = 97 * hash + Objects.hashCode(this.fb);
     hash = 97 * hash + Objects.hashCode(this.ins);
     return hash;
     }
     */
    @Override
    public String toString() {

        return this.getKap() + this.getJahr().toString() + this.getTitel() 
                + this.getLieferant() + this.getUt() + this.getFb() 
                + this.getIns()
                + this.getIns2() + this.getIns3() + this.getHuel()
                + this.getU() + this.getKennz1() + this.getBetrag() + this.getBDatum()
                + this.getGrund1() + this.getGrund2() + this.getAuftragsNr()
                + this.getRechnungsDatum() + this.getFibu() + this.getRechnungsNr()
                + this.getKostenart() + this.getKostenstelle() + this.getKostentraeger()
                + this.getBGA() + this.getKassenzeichen() + this.getKennz2()
                + this.getOP() + this.getAW();
    }

}
