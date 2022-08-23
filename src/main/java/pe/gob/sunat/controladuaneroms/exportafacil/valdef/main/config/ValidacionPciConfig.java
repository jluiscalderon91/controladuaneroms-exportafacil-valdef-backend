/***********************************************************************
 * Module:  ValidacionPciConfig.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ValidacionPciConfig
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.main.config;

import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.config.MicroserviceConfig;

public class ValidacionPciConfig extends MicroserviceConfig {
	
	private static ValidacionPciConfig config;
	
	private String urlConsultaDeclaracion = "";
	
	public static ValidacionPciConfig getConfig() {
		return config;
	}
	
	public static void  loadConfig(ValidacionPciConfig newInstance) {
		ValidacionPciConfig.config = newInstance;
	}


	public String getUrlConsultaDeclaracion() {
		return urlConsultaDeclaracion;
	}

	public void setUrlConsultaDeclaracion(String urlConsultaDeclaracion) {
		this.urlConsultaDeclaracion = urlConsultaDeclaracion;
	}
	
	
	
}