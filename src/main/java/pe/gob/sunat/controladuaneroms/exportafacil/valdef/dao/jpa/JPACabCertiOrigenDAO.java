/***********************************************************************
 * Module:  JPACabCertiOrigenDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPACabCertiOrigenDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.CabCertiOrigenDAO;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;


public class JPACabCertiOrigenDAO implements CabCertiOrigenDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;



}