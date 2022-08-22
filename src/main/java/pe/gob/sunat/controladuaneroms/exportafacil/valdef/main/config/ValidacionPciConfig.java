/***********************************************************************
 * Module:  ValidacionDpmnConfig.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ValidacionDpmnConfig
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.main.config;

import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.config.MicroserviceConfig;

public class ValidacionPciConfig extends MicroserviceConfig {
	
	private static ValidacionPciConfig config;
	
	private String urlBuscarDeclaracion = "";
	
	private String urlWsConsultaCatalogo ="";
	
	public static ValidacionPciConfig getConfig() {
		return config;
	}
	
	public static void  loadConfig(ValidacionPciConfig newInstance) {
		ValidacionPciConfig.config = newInstance;
	}



	public String getUrlWsConsultaCatalogo() {
		return urlWsConsultaCatalogo;
	}

	public void setUrlWsConsultaCatalogo(String urlWsConsultaCatalogo) {
		this.urlWsConsultaCatalogo = urlWsConsultaCatalogo;
	}
	
	
	
}