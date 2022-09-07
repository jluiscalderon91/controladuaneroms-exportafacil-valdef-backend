/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilService.java
 * Author:  jvillavicencio
 * Purpose: Defines the Interface ConsultaDeclaracionExportaFacilService
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.consultadeclaracion;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.DeclExpFacilBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.Ace;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.ExpDetPDF;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.Riesgo;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityException;

import java.util.List;

public interface ConsultaDeclaracionExportaFacilService {

	DeclExpFacilBean prueba() throws UnprocessableEntityException;

	/** @param codAduana */
	List<DeclExpFacilBean> listarActas(String codAduana, String placa) throws UnprocessableEntityException;

	List<DeclExpFacilBean> consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion,
												  String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde,
												  String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException;

	DeclExpFacilBean exportarResultadoDEF(String annPresen, String numDeclaracion,
									  String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde,
									  String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException;

	DeclExpFacilBean consultarDetalladaDEF(String idDef) throws UnprocessableEntityException;

	ExpDetPDF exportarDetalladaPDF(String idDef) throws UnprocessableEntityException;

	Riesgo consultarDetalladaRiesgo(String idDef) throws UnprocessableEntityException;

	Ace consultarDetalladaACE(String idDef) throws UnprocessableEntityException;
}