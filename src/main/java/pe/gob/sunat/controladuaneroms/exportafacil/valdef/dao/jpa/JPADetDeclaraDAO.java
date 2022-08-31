/***********************************************************************
 * Module:  JPADetDeclaraDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPADetDeclaraDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DetDeclaraDAO;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;


public class JPADetDeclaraDAO implements DetDeclaraDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;



}