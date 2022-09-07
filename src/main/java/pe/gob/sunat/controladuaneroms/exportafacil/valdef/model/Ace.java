/***********************************************************************
 * Module:  Ace.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class Ace
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.model;

import java.util.List;

public class Ace {
    private String idDef;

    private String codCanal;

    private List<InfoACE> infoACES;

    public String getIdDef() {
        return idDef;
    }

    public void setIdDef(String idDef) {
        this.idDef = idDef;
    }

    public String getCodCanal() {
        return codCanal;
    }

    public void setCodCanal(String codCanal) {
        this.codCanal = codCanal;
    }

    public List<InfoACE> getInfoACES() {
        return infoACES;
    }

    public void setInfoACES(List<InfoACE> infoACES) {
        this.infoACES = infoACES;
    }
}
