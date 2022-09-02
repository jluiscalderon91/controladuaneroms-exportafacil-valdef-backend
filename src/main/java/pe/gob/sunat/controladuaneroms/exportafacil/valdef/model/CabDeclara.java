package pe.gob.sunat.controladuaneroms.exportafacil.valdef.model;

import java.util.Date;

public class CabDeclara {


    private String idDef;

    private Date fecDeclaracion;

    private String codEstdua;

    private Date fecAutlevante;

    private int cntTotbultos;

    private int cntPesobrutoTotal;

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
        return "CabDeclara{" +
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
