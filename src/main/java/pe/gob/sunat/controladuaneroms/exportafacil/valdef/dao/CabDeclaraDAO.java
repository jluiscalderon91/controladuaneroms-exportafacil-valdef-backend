/***********************************************************************
 * Module:  CabDeclaraDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Interface CabDeclaraDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.CabDeclara;
import pe.gob.sunat.tecnologiams.arquitectura.framework.jpa.dao.BaseDao;

import java.util.Date;

public interface CabDeclaraDAO extends BaseDao<CabDeclara, String> {

        CabDeclara cabDeclara(String annPresen, String numDeclaracion,
                          String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta, Date fecSolicitudDesde,
                          Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti);

}
