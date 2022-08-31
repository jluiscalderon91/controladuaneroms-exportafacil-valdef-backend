/***********************************************************************
 * Module:  JPAIndicadorSerieDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPAIndicadorSerieDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.IndicadorSerieDAO;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;


public class JPAIndicadorSerieDAO implements IndicadorSerieDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;



}