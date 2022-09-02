/***********************************************************************
 * Module:  JPACabDeclaraDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPACabDeclaraDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.CabDeclaraDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.CabDeclara;
import pe.gob.sunat.tecnologiams.arquitectura.framework.jpa.dao.AbstractDao;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.ConstantesUtils;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Date;


public class JPACabDeclaraDAO extends AbstractDao<CabDeclara, String> implements CabDeclaraDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;

    @Override
    public CabDeclara cabDeclara(String annPresen, String numDeclaracion, String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta, Date fecSolicitudDesde, Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) {
        utilLog.imprimirLog(ConstantesUtils.LEVEL_INFO, "Inicio CabDeclara - ObtenerDatosCabeceraDeclara");
        CabDeclara cabDeclara;
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT c.* FROM TABLITA c ");
        sql.append("WHERE c.ID = ? ");

        try {
            Query query = bdsigad.createNativeQuery(sql.toString(), CabDeclara.class);
            //query.setParameter(1, id);
            cabDeclara = (CabDeclara) query.getSingleResult();
        } catch (NoResultException nre) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, nre.getMessage());
            cabDeclara = null;
        } catch (Exception e) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, e.getMessage());
            cabDeclara = null;
        }
        return cabDeclara;
    }

    @Override
    public EntityManager buildEntityManager() {
        return bdsigad;
    }

    @Override
    public Class<CabDeclara> provideEntityClass() {
        return CabDeclara.class;
    }
}