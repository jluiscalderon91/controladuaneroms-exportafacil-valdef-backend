/***********************************************************************
 * Module:  JPADeclExpFacilDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPADeclExpFacilDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DeclExpFacilDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain.DeclExpFacil;
import pe.gob.sunat.tecnologiams.arquitectura.framework.common.util.ConstantesUtils;
import pe.gob.sunat.tecnologiams.arquitectura.framework.jpa.dao.AbstractDao;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class JPADeclExpFacilDAO extends AbstractDao<DeclExpFacil, String> implements DeclExpFacilDAO {

	@Inject
	private UtilLog utilLog;
	
	@Inject
	@Named("dsprad1")
	protected EntityManager dsprad1;
	
	@Override
	public List<DeclExpFacil> listarActas(String codAduana, String placa) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(
				"CADUA_PRECO, CPTOC_PRECO, FANNO_PRECO, NCORR_PRECO, CTIPO_ACTA, TO_DATE(FECHA_ACTA, 'YYYY/MM/DD')  FROM CAB_ACTAS WHERE CTIPO_ACTA= ? AND TMATR_EMTRA=? AND NELIM_REGIS='0'");
	
		List<DeclExpFacil> resultado = new java.util.ArrayList<>();
		
		try {
			Query query = dsprad1.createNativeQuery(sql.toString(), DeclExpFacil.class);
			query.setParameter(1, codAduana);
			query.setParameter(1, placa);
			resultado = findByQuery(query);
		} catch( Exception ex ) {
			utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, ex.getMessage());
		}
		
		return resultado;
	}

	@Override
	public EntityManager buildEntityManager() {
		return dsprad1;
	}

	@Override
	public Class<DeclExpFacil> provideEntityClass() {
		return DeclExpFacil.class;
	}
}