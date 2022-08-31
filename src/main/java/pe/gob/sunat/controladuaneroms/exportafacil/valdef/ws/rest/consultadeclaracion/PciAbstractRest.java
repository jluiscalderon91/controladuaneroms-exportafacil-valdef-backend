/***********************************************************************
 * Module:  PciAbstractRest.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class PciAbstractRest
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest.consultadeclaracion;

import javax.inject.Inject;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.consultadeclaracion.ConsultaDeclaracionExportaFacilService;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

public abstract class PciAbstractRest {

    @Inject protected UtilLog utilLog;
   
   protected static final Integer COD_ERROR_VALIDACION = 422;
   
   @Inject
   protected ConsultaDeclaracionExportaFacilService consultaDeclaracionExportaFacilService;
   


}