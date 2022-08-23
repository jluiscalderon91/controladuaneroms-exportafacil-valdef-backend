/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilRestService.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ConsultaDeclaracionExportaFacilRestService
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain.DeclExpFacil;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.model.bean.MensajeBean;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.ConstantesUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/v1/despaduanero/exportafacil")
public class ConsultaDeclaracionExportaFacilRestService extends PciAbstractRest {
	
	private static final String UTF_8 = "utf-8";

	@GET
	@Path("/e/prueba")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response prueba() {

		List<MensajeBean> lstMensajesValidacion = new ArrayList<>();

		try {

			MensajeBean mensaje = new MensajeBean();
			mensaje.setCod(1);
			mensaje.setMsg("Mensaje de prueba del sistema  VALDEF");

			lstMensajesValidacion.add(mensaje);

			return Response.status(COD_ERROR_VALIDACION).entity(lstMensajesValidacion)
					.type(MediaType.APPLICATION_JSON_TYPE.withCharset(UTF_8)).build();

		} catch( Exception ex ) {
			utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, "Error al consultar las actas", ex.getStackTrace());
			MensajeBean mensaje = new MensajeBean();
			mensaje.setCod(1);

			lstMensajesValidacion.clear();
			lstMensajesValidacion.add(mensaje);

			mensaje.setMsg("Ha ocurrido un error al obtener las actas para la placa ingresada");
			return Response.status(COD_ERROR_VALIDACION).entity(lstMensajesValidacion)
					.type(MediaType.APPLICATION_JSON_TYPE.withCharset(UTF_8)).build();
		}

	}
   @GET
   @Path("/e/acta/{coTipoActa}-{codPlaca}")
   @Produces({ MediaType.APPLICATION_JSON })
   public Response listarActas(@PathParam("codAduana") String codAduana,@PathParam("placa") String placa) {
	   
	   List<MensajeBean> lstMensajesValidacion = new ArrayList<>();

	   try {
		   
		   List<DeclExpFacil> lstActa = this.consultaDeclaracionExportaFacilService.listarActas(codAduana, placa);
		   
		   boolean hayData = lstActa != null && !lstActa.isEmpty();
		   
		   if ( hayData ) {
			   return Response.ok(lstActa).build();
		   } 
		   
		   MensajeBean mensaje = new MensajeBean();
		   mensaje.setCod(1);
		   mensaje.setMsg("No se ha encontrado actas para la placa ingresada");
		   
		   lstMensajesValidacion.add(mensaje);

		   return Response.status(COD_ERROR_VALIDACION).entity(lstMensajesValidacion)
			.type(MediaType.APPLICATION_JSON_TYPE.withCharset(UTF_8)).build();
		   
	   } catch( Exception ex ) {
		   utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, "Error al consultar las actas", ex.getStackTrace());
			MensajeBean mensaje = new MensajeBean();
			mensaje.setCod(1);
			
			lstMensajesValidacion.clear();
			lstMensajesValidacion.add(mensaje);

			mensaje.setMsg("Ha ocurrido un error al obtener las actas para la placa ingresada");
			return Response.status(COD_ERROR_VALIDACION).entity(lstMensajesValidacion)
			.type(MediaType.APPLICATION_JSON_TYPE.withCharset(UTF_8)).build();
	   }

   }

}