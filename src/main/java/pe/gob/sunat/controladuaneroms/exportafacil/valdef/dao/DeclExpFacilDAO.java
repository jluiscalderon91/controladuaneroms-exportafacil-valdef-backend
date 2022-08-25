/***********************************************************************
 * Module:  DeclExpFacilDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Interface DeclExpFacilDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain.DeclExpFacil;
import pe.gob.sunat.tecnologiams.arquitectura.framework.jpa.dao.BaseDao;

import java.util.Date;
import java.util.List;

public interface DeclExpFacilDAO extends BaseDao<DeclExpFacil, String> {


	List<DeclExpFacil> listarActas(String tipoActa,String placa);

	DeclExpFacil consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion,
												  String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta, Date fecSolicitudDesde,
												  Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti);
	DeclExpFacil consultarDetalladaDEF(String idDef);

}