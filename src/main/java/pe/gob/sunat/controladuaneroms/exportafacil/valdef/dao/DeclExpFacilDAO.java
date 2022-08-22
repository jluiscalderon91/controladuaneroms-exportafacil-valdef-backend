/***********************************************************************
 * Module:  DeclExpFacilDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Interface DeclExpFacilDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain.DeclExpFacil;
import pe.gob.sunat.tecnologiams.arquitectura.framework.jpa.dao.BaseDao;

import java.util.List;

public interface DeclExpFacilDAO extends BaseDao<DeclExpFacil, String> {


	List<DeclExpFacil> listarActas(String tipoActa,String placa);

}