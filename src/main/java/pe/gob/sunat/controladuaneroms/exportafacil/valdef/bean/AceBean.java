/***********************************************************************
 * Module:  AceBean.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class AceBean
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AceBean {
    private String idDef;

    private String codCanal;

    private String nroAce;

    private String fecAce;

    private String codEstadoAce;

    private String nroActaInsp;

    private String fecActaInsp;

    private String nroActaIncInmHal;

    private String fecActaIncInmHal;

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

    public String getNroAce() {
        return nroAce;
    }

    public void setNroAce(String nroAce) {
        this.nroAce = nroAce;
    }

    public String getFecAce() {
        return fecAce;
    }

    public void setFecAce(String fecAce) {
        this.fecAce = fecAce;
    }

    public String getCodEstadoAce() {
        return codEstadoAce;
    }

    public void setCodEstadoAce(String codEstadoAce) {
        this.codEstadoAce = codEstadoAce;
    }

    public String getNroActaInsp() {
        return nroActaInsp;
    }

    public void setNroActaInsp(String nroActaInsp) {
        this.nroActaInsp = nroActaInsp;
    }

    public String getFecActaInsp() {
        return fecActaInsp;
    }

    public void setFecActaInsp(String fecActaInsp) {
        this.fecActaInsp = fecActaInsp;
    }

    public String getNroActaIncInmHal() {
        return nroActaIncInmHal;
    }

    public void setNroActaIncInmHal(String nroActaIncInmHal) {
        this.nroActaIncInmHal = nroActaIncInmHal;
    }

    public String getFecActaIncInmHal() {
        return fecActaIncInmHal;
    }

    public void setFecActaIncInmHal(String fecActaIncInmHal) {
        this.fecActaIncInmHal = fecActaIncInmHal;
    }
}
