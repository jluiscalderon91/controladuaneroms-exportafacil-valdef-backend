package pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.utils;

import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.model.bean.MensajeBean;

public class MensajeUtil extends MensajeBean {

	private static final long serialVersionUID = 1L;

	public static MensajeBean addError(String msg) {
		MensajeBean bean = new MensajeBean();
		bean.setMsg(msg);
		return bean;
	}

}
