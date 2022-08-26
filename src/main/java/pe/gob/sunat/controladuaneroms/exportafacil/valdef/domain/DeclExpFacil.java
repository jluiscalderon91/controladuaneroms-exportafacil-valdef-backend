/***********************************************************************
 * Module:  DeclExpFacil.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class DeclExpFacil
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class DeclExpFacil implements java.io.Serializable {
	

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

	@Column(name = "idExportador")
	private String idExportador;

	@Column(name = "nomRazonsocial")
	private String nomRazonsocial;

	@Column(name = "cntTotbultos")
	private int cntTotbultos;

	@Column(name = "cntPesobrutoTotal")
	private int cntPesobrutoTotal;

	@Column(name = "codCanal")
	private String codCanal;

	@Column(name = "codPuerDesti")
	private String codPuerDesti;

	@Column(name = "mtoValoradu")
	private int mtoValoradu;

	@Column(name = "idRectificacion")
	private String idRectificacion;

	@Column(name = "codEstarecti")
	private String codEstarecti;

	@Column(name = "idManifiesto")
	private String idManifiesto;

	@Column(name = "numDoctransporte")
	private String numDoctransporte;

	@Column(name = "fecRegulariza")
	private Date fecRegulariza;

	@Column(name = "indFueraplazo")
	private String indFueraplazo;

	@Column(name = "codFuncionario")
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