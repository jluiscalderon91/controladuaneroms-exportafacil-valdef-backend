/***********************************************************************
 * Module:  Riesgo.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class Riesgo
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.model;

import java.util.List;

public class Riesgo {

    private String idDef;

    private String codCanal;

    private String codMomentoRiesgo;

    private String codMotivoRiesgo;

    private List<InfoSeleccion> infoSeleccion;

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

    public String getCodMomentoRiesgo() {
        return codMomentoRiesgo;
    }

    public void setCodMomentoRiesgo(String codMomentoRiesgo) {
        this.codMomentoRiesgo = codMomentoRiesgo;
    }

    public String getCodMotivoRiesgo() {
        return codMotivoRiesgo;
    }

    public void setCodMotivoRiesgo(String codMotivoRiesgo) {
        this.codMotivoRiesgo = codMotivoRiesgo;
    }

    public List<InfoSeleccion> getInfoSeleccion() {
        return infoSeleccion;
    }

    public void setInfoSeleccion(List<InfoSeleccion> infoSeleccion) {
        this.infoSeleccion = infoSeleccion;
    }
}
