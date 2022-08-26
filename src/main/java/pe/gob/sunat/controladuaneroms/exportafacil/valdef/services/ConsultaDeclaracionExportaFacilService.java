/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilService.java
 * Author:  jvillavicencio
 * Purpose: Defines the Interface ConsultaDeclaracionExportaFacilService
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain.DeclExpFacil;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityException;

import java.util.List;

public interface ConsultaDeclaracionExportaFacilService {

	DeclExpFacil prueba() throws UnprocessableEntityException;
	/** @param codAduana */
	List<DeclExpFacil> listarActas(String codAduana, String placa) throws UnprocessableEntityException;

	DeclExpFacil consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion,
												  String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde,
												  String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException;

	DeclExpFacil exportarResultadoDEF(String annPresen, String numDeclaracion,
									  String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde,
									  String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException;
	DeclExpFacil consultarDetalladaDEF(String idDef) throws UnprocessableEntityException;

}