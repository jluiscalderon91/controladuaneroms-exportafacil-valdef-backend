/***********************************************************************
 * Module:  DeclExpFacil.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class DeclExpFacil
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class DeclExpFacil implements java.io.Serializable {
	
    /**
	 * 
	 */	
	private static final long serialVersionUID = 8392420129257475535L;

	@Id
	@Column(name = "CADUA_PRECO")
    private String codAduanaPreco;

	@Column(name = "CPTOC_PRECO")
    private String codPuestocontrolPreco;

	@Column(name = "FANNO_PRECO")
    private Integer annoPreco;

	@Column(name = "NCORR_PRECO")
    private String numcorrelativoPreco;
		
	
	@Column(name = "CTIPO_ACTA")
    private String codTipoActa;
	
	@Column(name = "FECHA_ACTA")
    private String fecActa;
	
	public String getCodAduanaPreco() {
		return codAduanaPreco;
	}

	public void setCodAduanaPreco(String codAduanaPreco) {
		this.codAduanaPreco = codAduanaPreco;
	}

	public String getCodPuestocontrolPreco() {
		return codPuestocontrolPreco;
	}

	public void setCodPuestocontrolPreco(String codPuestocontrolPreco) {
		this.codPuestocontrolPreco = codPuestocontrolPreco;
	}

	public Integer getAnnoPreco() {
		return annoPreco;
	}

	public void setAnnoPreco(Integer annoPreco) {
		this.annoPreco = annoPreco;
	}

	public String getNumcorrelativoPreco() {
		return numcorrelativoPreco;
	}

	public void setNumcorrelativoPreco(String numcorrelativoPreco) {
		this.numcorrelativoPreco = numcorrelativoPreco;
	}

	public String getCodTipoActa() {
		return codTipoActa;
	}

	public void setCodTipoActa(String codTipoActa) {
		this.codTipoActa = codTipoActa;
	}

	public String getFecActa() {
		return fecActa;
	}

	public void setFecActa(String fecActa) {
		this.fecActa = fecActa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
    
	
}