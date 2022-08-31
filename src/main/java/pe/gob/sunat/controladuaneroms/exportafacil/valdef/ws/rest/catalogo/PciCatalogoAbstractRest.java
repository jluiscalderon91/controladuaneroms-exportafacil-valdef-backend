/***********************************************************************
 * Module:  PciAbstractRest.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class PciAbstractRest
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest.catalogo;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.catalogo.CatalogoService;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;

public abstract class PciCatalogoAbstractRest {

    @Inject protected UtilLog utilLog;
   
   protected static final Integer COD_ERROR_VALIDACION = 422;
   
   @Inject
   protected CatalogoService catalogoService;
   


}