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
@DiscriminatorValue("DM")
public class DMFinanzierung extends VBSFinanzierung {

    @ManyToOne
    @JoinColumn(name = "dmbewilligung")   //Fremdschlüssel
    private DMBewilligung dmbewilligung;

    @Override
    public DMFinanzierung clone() {

        DMFinanzierung dMFinanzierungClone = new DMFinanzierung();
        //            super.clone().

        dMFinanzierungClone.setAnteil(this.getAnteil());
        dMFinanzierungClone.setBemerkung(this.getBemerkung());
        dMFinanzierungClone.setFinanzierungsTyp(this.getFinanzierungsTyp());

        dMFinanzierungClone.setVerbindlichkeit(this.getVerbindlichkeit());//findet der das?

        dMFinanzierungClone.setVerbuchungsstelle(this.getVerbuchungsstelle());
        dMFinanzierungClone.setDmbewilligung(this.getDmbewilligung());

        return dMFinanzierungClone;

    }

    public DMFinanzierung() {
    }

    public DMFinanzierung(Double anteil, String finanzierungsTyp, String bemerkung) {
        super(anteil, finanzierungsTyp, bemerkung);

    }

    public DMBewilligung getDmbewilligung() {
        return dmbewilligung;
    }

    public void setDmbewilligung(DMBewilligung dmbewilligung) {
        this.dmbewilligung = dmbewilligung;
    }

    public String toString() {

        return super.toString() + "," + this.dmbewilligung.getBewilligungsNr();

    }

    public StringProperty getFinanzierungsText() {
        StringProperty sp = new SimpleStringProperty();
        sp.set(this.toString());
        return sp;

}
}
