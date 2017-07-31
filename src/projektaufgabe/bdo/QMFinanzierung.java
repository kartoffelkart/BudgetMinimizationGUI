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
@DiscriminatorValue("QMF")
public class QMFinanzierung extends VBSFinanzierung {

    @ManyToOne
    @JoinColumn(name = "qmbewilligungid")   //Fremdschlüssel
    private QMBewilligung qmbewilligung;

     @Override
    public QMFinanzierung clone() {

        QMFinanzierung qMFinanzierungClone = new QMFinanzierung();
        //            super.clone().

        qMFinanzierungClone.setAnteil(this.getAnteil());
        qMFinanzierungClone.setBemerkung(this.getBemerkung());
        qMFinanzierungClone.setFinanzierungsTyp(this.getFinanzierungsTyp());

        qMFinanzierungClone.setVerbindlichkeit(this.getVerbindlichkeit());//findet der das?

        qMFinanzierungClone.setVerbuchungsstelle(this.getVerbuchungsstelle());
        qMFinanzierungClone.setQmbewilligung(this.getQmbewilligung());

        return qMFinanzierungClone;

    }
    
    public QMFinanzierung() {
    }

    public QMFinanzierung(Double anteil, String finanzierungsTyp, String bemerkung
            ) {
        super(anteil, finanzierungsTyp, bemerkung);
        
    }

    public QMBewilligung getQmbewilligung() {
        return qmbewilligung;
    }

    public void setQmbewilligung(QMBewilligung qmbewilligung) {
        this.qmbewilligung = qmbewilligung;
    }


    public String toString() {

        return super.toString() + "," + this.qmbewilligung.getBewilligungsNr();
    }

    public StringProperty getFinanzierungsText() {
        StringProperty sp = new SimpleStringProperty();
        sp.set(this.toString());
        return sp;

}
}
