/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.bdo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.*;

/**
 *
 * @author Sonja
 */
@Entity
@DiscriminatorValue("VBSF")
public class VBSFinanzierung extends Finanzierung {

    @ManyToOne
    @JoinColumn(name = "verbuchungsstelleid")//Fremdschlüssel
    private Verbuchungsstelle verbuchungsstelle;

//  public String getFinanzierungsText(){
//        return  getVerbuchungsstelle().toString();
// }   
    @Override
    public VBSFinanzierung clone() {

        VBSFinanzierung vBSFinanzierungClone = new VBSFinanzierung();
        //            super.clone().

        vBSFinanzierungClone.setAnteil(this.getAnteil());
        vBSFinanzierungClone.setBemerkung(this.getBemerkung());
        vBSFinanzierungClone.setFinanzierungsTyp(this.getFinanzierungsTyp());

        vBSFinanzierungClone.setVerbindlichkeit(super.getVerbindlichkeit());

        vBSFinanzierungClone.setVerbuchungsstelle(verbuchungsstelle);

        return vBSFinanzierungClone;

    }

    public VBSFinanzierung() {
    }

    public VBSFinanzierung(Double anteil, String finanzierungsTyp, String bemerkung) {//Verbindlichkeit verbindlichkeit,Verbuchungsstelle verbuchungsstelle, String neuesAttribut) {
        super(anteil, finanzierungsTyp, bemerkung);//, verbuchungsstelle);

    }

    public Verbuchungsstelle getVerbuchungsstelle() {
        return verbuchungsstelle;
    }

    public void setVerbuchungsstelle(Verbuchungsstelle verbuchungsstelle) {
        this.verbuchungsstelle = verbuchungsstelle;
    }

    @Override
    public String toString() {
        //return "VBSFinanzierung{" + super.toString() + verbuchungsstelle + '}';

        return super.toString() + ", "
                + this.getVerbuchungsstelle().getKapitel() + ", "
                + this.getVerbuchungsstelle().getTitel() + ", "
                + this.getVerbuchungsstelle().getUntertitel() + ", "
                + this.getVerbuchungsstelle().getPosition() + ", "
                + this.getVerbuchungsstelle().getPn() + ", "
                + this.getVerbuchungsstelle().getZweck();

    }

    public StringProperty getFinanzierungsText() {
        StringProperty sp = new SimpleStringProperty();
        sp.set(this.toString());
        return sp;

}
}
