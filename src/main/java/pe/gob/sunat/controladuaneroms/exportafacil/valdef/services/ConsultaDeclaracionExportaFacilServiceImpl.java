/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilServiceImpl.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ConsultaDeclaracionExportaFacilServiceImpl
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DeclExpFacilDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain.DeclExpFacil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class ConsultaDeclaracionExportaFacilServiceImpl implements ConsultaDeclaracionExportaFacilService {

	@Inject
	private DeclExpFacilDAO declExpFacilDAO;

	@Override
	public List<DeclExpFacil> listarActas(String codAduana, String placa) {

		boolean noHayCodAduana = codAduana == null || codAduana.trim().isEmpty();

		if (noHayCodAduana) {
			return new ArrayList<>();
		}

		return declExpFacilDAO.listarActas( codAduana, placa);
	}
	
}