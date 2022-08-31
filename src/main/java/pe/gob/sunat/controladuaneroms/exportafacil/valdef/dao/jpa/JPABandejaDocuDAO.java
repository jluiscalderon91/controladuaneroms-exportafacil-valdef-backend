/***********************************************************************
 * Module:  JPABandejaDocuDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPABandejaDocuDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.BandejaDocuDAO;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


public class JPABandejaDocuDAO implements BandejaDocuDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;



}