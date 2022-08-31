/***********************************************************************
 * Module:  JPADocuPreceDuaDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPADocuPreceDuaDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DocuPreceDuaDAO;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;


public class JPADocuPreceDuaDAO implements DocuPreceDuaDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;



}