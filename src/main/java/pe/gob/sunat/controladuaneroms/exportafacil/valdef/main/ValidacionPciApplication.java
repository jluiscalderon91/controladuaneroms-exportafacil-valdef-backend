/***********************************************************************
 * Module:  ValidacionDpmnApplication.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ValidacionDpmnApplication
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.main;

import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.main.config.ValidacionPciConfig;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityExceptionMapper;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest.ConsultaDeclaracionExportaFacilRestService;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest.PciAbstractRest;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.SunatApplication;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.exception.ConstraintViolationExceptionMapper;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.exception.GenericExceptionMapper;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.exception.ObjectNotFoundExceptionMapper;

public class ValidacionPciApplication extends SunatApplication<ValidacionPciConfig> {

	@Override
	public void onRun(ValidacionPciConfig configuration, Environment environment) throws Exception {
		environment.jersey().register(UnprocessableEntityExceptionMapper.class);
		environment.jersey().register(ConsultaDeclaracionExportaFacilRestService.class);
		environment.jersey().register(PciAbstractRest.class);
		ValidacionPciConfig.loadConfig(configuration);
	}
	
	 @Override
	 public  void onInitialize (Bootstrap<ValidacionPciConfig> bootstrap) {
	   bootstrap.addBundle(new ViewBundle<>());
	 }
	 
	 public static void main(String... params) throws Exception {
	    new ValidacionPciApplication().run(params);
	 }	
	
}