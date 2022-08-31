/***********************************************************************
 * Module:  JPADeclExpFacilDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPADeclExpFacilDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DeclExpFacilDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.DeclExpFacil;
import pe.gob.sunat.tecnologiams.arquitectura.framework.common.util.ConstantesUtils;
import pe.gob.sunat.tecnologiams.arquitectura.framework.jpa.dao.AbstractDao;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


public class JPADeclExpFacilDAO extends AbstractDao<DeclExpFacil, String> implements DeclExpFacilDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;

    @Override
    public List<DeclExpFacil> listarActas(String codAduana, String placa) {
        StringBuilder sql = new StringBuilder();
        sql.append(
                "CADUA_PRECO, CPTOC_PRECO, FANNO_PRECO, NCORR_PRECO, CTIPO_ACTA, TO_DATE(FECHA_ACTA, 'YYYY/MM/DD')  FROM CAB_ACTAS WHERE CTIPO_ACTA= ? AND TMATR_EMTRA=? AND NELIM_REGIS='0'");

        List<DeclExpFacil> resultado = new java.util.ArrayList<>();
        try {
            Query query = bdsigad.createNativeQuery(sql.toString(), DeclExpFacil.class);
            query.setParameter(1, codAduana);
            query.setParameter(1, placa);
            resultado = findByQuery(query);
        } catch (Exception ex) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, ex.getMessage());
        }

        return resultado;
    }

    @Override
    public DeclExpFacil consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion, String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta, Date fecSolicitudDesde, Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) {
        utilLog.imprimirLog(ConstantesUtils.LEVEL_INFO, "Inicio DeclExpFacilDAO - consultarDeclaracionExportaFacil");
        DeclExpFacil declExpFacil = null;
        StringBuilder sql = new StringBuilder();

        sql.append(
                "SELECT A.ID AS id, A.VALOR AS valor");
        sql.append("FROM TABLITA A");

        try {
            Query query = bdsigad.createNativeQuery(sql.toString(), DeclExpFacil.class);
            /*query.setParameter(1, annPresen);
            query.setParameter(2, numDeclaracion);
            query.setParameter(3, numGuiapostal);
            query.setParameter(4, fecDeclaracionDesde);
            query.setParameter(5, fecDeclaracionHasta);
            query.setParameter(6, fecSolicitudDesde);
            query.setParameter(7, fecSolicitudHasta);
            query.setParameter(8, codTipdoc);
            query.setParameter(9, numDocident);
            query.setParameter(10, codEstdua);
            query.setParameter(11, codEstarecti);*/
            //declExpFacil = (DeclExpFacil) StringUtil.jsonToList(StringUtil.getJson(query.getSingleResult()), DeclExpFacil.class);
        } catch (NoResultException nre) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, nre.getMessage());
            declExpFacil = null;
        } catch (Exception e) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, e.getMessage());
            declExpFacil = null;
        }
        return declExpFacil;
    }

    @Override
    public DeclExpFacil exportarResultadoDEF(String annPresen, String numDeclaracion, String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta, Date fecSolicitudDesde, Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) {
        return null;
    }

    @Override
    public DeclExpFacil consultarDetalladaDEF(String idDef) {
        return null;
    }

    @Override
    public EntityManager buildEntityManager() {
        return bdsigad;
    }

    @Override
    public Class<DeclExpFacil> provideEntityClass() {
        return DeclExpFacil.class;
    }
}