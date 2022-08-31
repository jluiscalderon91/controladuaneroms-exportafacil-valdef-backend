/***********************************************************************
 * Module:  JPAParticipanteDocDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPAParticipanteDocDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.ParticipanteDocDAO;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.ConstantesUtils;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


public class JPAParticipanteDocDAO implements ParticipanteDocDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;

    @Override
    public Boolean consultarDocumentIdent(String numDoc) {

        Boolean consulta = false;
        utilLog.imprimirLog(ConstantesUtils.LEVEL_INFO, "Inicio DocumentoIndent - Obtener Documento de Identidad");
        StringBuilder sql = new StringBuilder();

        sql.append("Select C.NUM_DOCIDENT as numDoc from PARTICIPANTE_DOC C ");
        sql.append("WHERE C.num_docident = ? AND ROWNUM <= 1");

        try {
            Query query = bdsigad.createNativeQuery(sql.toString());
            query.setParameter(1, numDoc);
            if (query.getResultList().isEmpty()) {
                consulta = false;
            } else {
                consulta = true;
            }
        } catch (NoResultException nre) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, nre.getMessage());
            consulta = false;
        } catch (Exception e) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, e.getMessage());
            consulta = false;
        }
        return consulta;
    }

}