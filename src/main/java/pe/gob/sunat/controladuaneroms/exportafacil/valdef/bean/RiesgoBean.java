/***********************************************************************
 * Module:  RiegoBean.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class RiegoBean
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RiesgoBean {
    private String idDef;

    private String codCanal;

    private String codMomentoRiesgo;

    private String codMotivoRiesgo;

    private String seleccionCodModelo;

    private String seleccionCodSerie;

    private String seleccionFraude;

    private String seleccionDetalle;

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

    public String getSeleccionCodModelo() {
        return seleccionCodModelo;
    }

    public void setSeleccionCodModelo(String seleccionCodModelo) {
        this.seleccionCodModelo = seleccionCodModelo;
    }

    public String getSeleccionCodSerie() {
        return seleccionCodSerie;
    }

    public void setSeleccionCodSerie(String seleccionCodSerie) {
        this.seleccionCodSerie = seleccionCodSerie;
    }

    public String getSeleccionFraude() {
        return seleccionFraude;
    }

    public void setSeleccionFraude(String seleccionFraude) {
        this.seleccionFraude = seleccionFraude;
    }

    public String getSeleccionDetalle() {
        return seleccionDetalle;
    }

    public void setSeleccionDetalle(String seleccionDetalle) {
        this.seleccionDetalle = seleccionDetalle;
    }
}
