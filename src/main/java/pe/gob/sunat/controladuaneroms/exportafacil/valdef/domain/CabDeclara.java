/***********************************************************************
 * Module:  CabDeclara.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class CabDeclara
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class CabDeclara {

    private static final long serialVersionUID = 8392420129257475535L;

    @Id
    @Column(name = "idDef")
    private String idDef;

    @Column(name = "fecDeclaracion")
    private Date fecDeclaracion;

    @Column(name = "codEstdua")
    private String codEstdua;

    @Column(name = "fecAutlevante")
    private Date fecAutlevante;

    @Column(name = "cntTotbultos")
    private int cntTotbultos;

    @Column(name = "cntPesobrutoTotal")
    private int cntPesobrutoTotal;

    @Column(name = "fecRegulariza")
    private Date fecRegulariza;

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

    public Date getFecRegulariza() {
        return fecRegulariza;
    }

    public void setFecRegulariza(Date fecRegulariza) {
        this.fecRegulariza = fecRegulariza;
    }

    @Override
    public String toString() {
        return "DetDeclara{" +
                "idDef='" + idDef + '\'' +
                ", fecDeclaracion=" + fecDeclaracion +
                ", codEstdua='" + codEstdua + '\'' +
                ", fecAutlevante=" + fecAutlevante +
                ", cntTotbultos=" + cntTotbultos +
                ", cntPesobrutoTotal=" + cntPesobrutoTotal +
                ", fecRegulariza=" + fecRegulariza +
                '}';
    }

}
