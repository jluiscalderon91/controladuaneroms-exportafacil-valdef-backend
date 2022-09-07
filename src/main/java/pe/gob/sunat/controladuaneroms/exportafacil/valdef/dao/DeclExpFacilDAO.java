/***********************************************************************
 * Module:  DeclExpFacilDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Interface DeclExpFacilDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.AceBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.ExpDetPDFBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.RiesgoBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.DeclExpFacil;
import pe.gob.sunat.tecnologiams.arquitectura.framework.jpa.dao.BaseDao;

import java.util.Date;
import java.util.List;

public interface DeclExpFacilDAO extends BaseDao<DeclExpFacil, String> {


	List<DeclExpFacil> listarActas(String tipoActa,String placa);

	DeclExpFacil consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion,
												  String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta, Date fecSolicitudDesde,
												  Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti);
	DeclExpFacil exportarResultadoDEF(String annPresen, String numDeclaracion,
									  String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta, Date fecSolicitudDesde,
									  Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti);

	DeclExpFacil consultarDetalladaDEF(String idDef);

	ExpDetPDFBean exportarDetalladaPDF(String idDef);

	RiesgoBean consultarDetalladaRiesgo(String idDef);

	AceBean consultarDetalladaACE(String idDef);
}