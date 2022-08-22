/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilService.java
 * Author:  jvillavicencio
 * Purpose: Defines the Interface ConsultaDeclaracionExportaFacilService
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain.DeclExpFacil;

import java.util.List;

public interface ConsultaDeclaracionExportaFacilService {
	
	/** @param codAduana */
	List<DeclExpFacil> listarActas(String codAduana, String placa);


}