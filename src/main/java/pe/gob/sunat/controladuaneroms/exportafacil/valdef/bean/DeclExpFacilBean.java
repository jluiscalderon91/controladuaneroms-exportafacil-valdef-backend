/***********************************************************************
 * Module:  DeclExpFacilBean.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class DeclExpFacilBean
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeclExpFacilBean {


    private String idDef;

    private Date fecDeclaracion;

    private String codEstdua;

    private Date fecAutlevante;

    private String idExportador;

    private String nomRazonsocial;

    private int cntTotbultos;

    private int cntPesobrutoTotal;

    private String codCanal;

    private String codPuerDesti;

    private int mtoValoradu;

    private String idRectificacion;

    private String codEstarecti;

    private String idManifiesto;

    private String numDoctransporte;

    private Date fecRegulariza;

    private String indFueraplazo;

    private String codFuncionario;

    public String getIdDef() {
        return idDef;
    }

    public void setIdDef(String idDef) {
        this.idDef = idDef;
    }

    public Date getFecDeclaracion() {
        return fecDeclaracion;
    }

    public void setFecDeclaracion(Date fecDeclaracion) {
        this.fecDeclaracion = fecDeclaracion;
    }

    public String getCodEstdua() {
        return codEstdua;
    }

    public void setCodEstdua(String codEstdua) {
        this.codEstdua = codEstdua;
    }

    public Date getFecAutlevante() {
        return fecAutlevante;
    }

    public void setFecAutlevante(Date fecAutlevante) {
        this.fecAutlevante = fecAutlevante;
    }

    public String getIdExportador() {
        return idExportador;
    }

    public void setIdExportador(String idExportador) {
        this.idExportador = idExportador;
    }

    public String getNomRazonsocial() {
        return nomRazonsocial;
    }

    public void setNomRazonsocial(String nomRazonsocial) {
        this.nomRazonsocial = nomRazonsocial;
    }

    public int getCntTotbultos() {
        return cntTotbultos;
    }

    public void setCntTotbultos(int cntTotbultos) {
        this.cntTotbultos = cntTotbultos;
    }

    public int getCntPesobrutoTotal() {
        return cntPesobrutoTotal;
    }

    public void setCntPesobrutoTotal(int cntPesobrutoTotal) {
        this.cntPesobrutoTotal = cntPesobrutoTotal;
    }

    public String getCodCanal() {
        return codCanal;
    }

    public void setCodCanal(String codCanal) {
        this.codCanal = codCanal;
    }

    public String getCodPuerDesti() {
        return codPuerDesti;
    }

    public void setCodPuerDesti(String codPuerDesti) {
        this.codPuerDesti = codPuerDesti;
    }

    public int getMtoValoradu() {
        return mtoValoradu;
    }

    public void setMtoValoradu(int mtoValoradu) {
        this.mtoValoradu = mtoValoradu;
    }

    public String getIdRectificacion() {
        return idRectificacion;
    }

    public void setIdRectificacion(String idRectificacion) {
        this.idRectificacion = idRectificacion;
    }

    public String getCodEstarecti() {
        return codEstarecti;
    }

    public void setCodEstarecti(String codEstarecti) {
        this.codEstarecti = codEstarecti;
    }

    public String getIdManifiesto() {
        return idManifiesto;
    }

    public void setIdManifiesto(String idManifiesto) {
        this.idManifiesto = idManifiesto;
    }

    public String getNumDoctransporte() {
        return numDoctransporte;
    }

    public void setNumDoctransporte(String numDoctransporte) {
        this.numDoctransporte = numDoctransporte;
    }

    public Date getFecRegulariza() {
        return fecRegulariza;
    }

    public void setFecRegulariza(Date fecRegulariza) {
        this.fecRegulariza = fecRegulariza;
    }

    public String getIndFueraplazo() {
        return indFueraplazo;
    }

    public void setIndFueraplazo(String indFueraplazo) {
        this.indFueraplazo = indFueraplazo;
    }

    public String getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(String codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    @Override
    public String toString() {
        return "DeclExpFacil{" +
                "idDef='" + idDef + '\'' +
                ", fecDeclaracion=" + fecDeclaracion +
                ", codEstdua='" + codEstdua + '\'' +
                ", fecAutlevante=" + fecAutlevante +
                ", idExportador='" + idExportador + '\'' +
                ", nomRazonsocial='" + nomRazonsocial + '\'' +
                ", cntTotbultos=" + cntTotbultos +
                ", cntPesobrutoTotal=" + cntPesobrutoTotal +
                ", codCanal='" + codCanal + '\'' +
                ", codPuerDesti='" + codPuerDesti + '\'' +
                ", mtoValoradu=" + mtoValoradu +
                ", idRectificacion='" + idRectificacion + '\'' +
                ", codEstarecti='" + codEstarecti + '\'' +
                ", idManifiesto='" + idManifiesto + '\'' +
                ", numDoctransporte='" + numDoctransporte + '\'' +
                ", fecRegulariza=" + fecRegulariza +
                ", indFueraplazo='" + indFueraplazo + '\'' +
                ", codFuncionario='" + codFuncionario + '\'' +
                '}';
    }
}
