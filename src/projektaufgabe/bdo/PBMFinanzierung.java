/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.bdo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sonja
 */
@Entity
@DiscriminatorValue("PBMF")
public class PBMFinanzierung extends Finanzierung {

    @ManyToOne
    @JoinColumn(name = "stelleid")//Fremdschlüssel
    private Stelle stelle;

//  public String getFinanzierungsText(){
//        return  getStelle().toString();
// }    
    @Override
    public PBMFinanzierung clone() {
        PBMFinanzierung pBMfinanzierungClone = new PBMFinanzierung();

        pBMfinanzierungClone.setAnteil(this.getAnteil());
        pBMfinanzierungClone.setBemerkung(this.getBemerkung());
        pBMfinanzierungClone.setFinanzierungsTyp(this.getFinanzierungsTyp());

        pBMfinanzierungClone.setVerbindlichkeit(this.getVerbindlichkeit());
        pBMfinanzierungClone.setStelle(this.getStelle());

        return pBMfinanzierungClone;
    }

    public PBMFinanzierung() {
    }

    public PBMFinanzierung(Double anteil, String finanzierungsTyp, String bemerkung) {//Verbindlichkeit verbindlichkeit,Stelle stelle, String neuesAttribut) {
        super(anteil, finanzierungsTyp, bemerkung);//, stelle);

    }

    public Stelle getStelle() {
        return stelle;
    }

    public void setStelle(Stelle stelle) {
        this.stelle = stelle;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.getStelle().getStellenNr();
    }

    public StringProperty getFinanzierungsText() {
        StringProperty sp = new SimpleStringProperty();
        sp.set(this.toString());
        return sp;

}
}
