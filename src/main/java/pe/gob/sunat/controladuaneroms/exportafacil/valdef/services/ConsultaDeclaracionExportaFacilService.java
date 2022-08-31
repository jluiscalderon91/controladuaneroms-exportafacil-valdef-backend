/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilService.java
 * Author:  jvillavicencio
 * Purpose: Defines the Interface ConsultaDeclaracionExportaFacilService
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.DeclExpFacilBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityException;

import java.util.List;

public interface ConsultaDeclaracionExportaFacilService {

	DeclExpFacilBean prueba() throws UnprocessableEntityException;

	/** @param codAduana */
	List<DeclExpFacilBean> listarActas(String codAduana, String placa) throws UnprocessableEntityException;

	DeclExpFacilBean consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion,
												  String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde,
												  String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException;

	DeclExpFacilBean exportarResultadoDEF(String annPresen, String numDeclaracion,
									  String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde,
									  String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException;

	DeclExpFacilBean consultarDetalladaDEF(String idDef) throws UnprocessableEntityException;

}