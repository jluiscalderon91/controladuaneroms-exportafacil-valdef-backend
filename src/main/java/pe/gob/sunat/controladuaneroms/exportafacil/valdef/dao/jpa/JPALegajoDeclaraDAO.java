/***********************************************************************
 * Module:  JPALegajoDeclaraDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPALegajoDeclaraDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.LegajoDeclaraDAO;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;


public class JPALegajoDeclaraDAO implements LegajoDeclaraDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;



}