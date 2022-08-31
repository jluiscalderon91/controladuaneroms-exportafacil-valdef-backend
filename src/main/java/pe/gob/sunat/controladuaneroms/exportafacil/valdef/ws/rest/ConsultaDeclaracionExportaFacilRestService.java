/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilRestService.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ConsultaDeclaracionExportaFacilRestService
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.DeclExpFacilBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/despaduanero/exportafacil")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ConsultaDeclaracionExportaFacilRestService extends PciAbstractRest {

	// rest20 y 22
	@GET
	@Path("/e/consultadeclaracion/def")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarDeclaracionExportaFacil(@Context HttpServletRequest request,
													 @QueryParam("idDef") String idDef, @QueryParam("annPresen") String annPresen, @QueryParam("numDeclaracion") String numDeclaracion,
													 @QueryParam("numGuiapostal") String numGuiapostal, @QueryParam("fecDeclaracionDesde") String fecDeclaracionDesde,
													 @QueryParam("fecDeclaracionHasta") String fecDeclaracionHasta, @QueryParam("fecSolicitudDesde") String fecSolicitudDesde,
													 @QueryParam("fecSolicitudHasta") String fecSolicitudHasta, @QueryParam("codTipdoc") String codTipdoc,
													 @QueryParam("numDocident") String numDocident, @QueryParam("codEstdua") String codEstdua,
													 @QueryParam("codEstarecti") String codEstarecti) throws UnprocessableEntityException {
		boolean noHayidDef = idDef == null || idDef.trim().isEmpty();
		if (!noHayidDef) {
			DeclExpFacilBean declExpFacil = consultaDeclaracionExportaFacilService.consultarDetalladaDEF(idDef);
			return Response.ok(declExpFacil).build();
		} else {
			DeclExpFacilBean declExpFacil = consultaDeclaracionExportaFacilService.consultarDeclaracionExportaFacil(annPresen, numDeclaracion,
					numGuiapostal, fecDeclaracionDesde, fecDeclaracionHasta, fecSolicitudDesde, fecSolicitudHasta, codTipdoc, numDocident, codEstdua, codEstarecti);
			return Response.ok(declExpFacil).build();
		}
	}

	// rest21
	@GET
	@Path("/e/consultadeclaracion/exportarconsultaexcel/def")
	@Produces(MediaType.APPLICATION_JSON)
	public Response exportarResultadoDEF(@Context HttpServletRequest request,
										 @QueryParam("annPresen") String annPresen, @QueryParam("numDeclaracion") String numDeclaracion,
										 @QueryParam("numGuiapostal") String numGuiapostal, @QueryParam("fecDeclaracionDesde") String fecDeclaracionDesde,
										 @QueryParam("fecDeclaracionHasta") String fecDeclaracionHasta, @QueryParam("fecSolicitudDesde") String fecSolicitudDesde,
										 @QueryParam("fecSolicitudHasta") String fecSolicitudHasta, @QueryParam("codTipdoc") String codTipdoc,
										 @QueryParam("numDocident") String numDocident, @QueryParam("codEstdua") String codEstdua,
										 @QueryParam("codEstarecti") String codEstarecti) throws UnprocessableEntityException {

		DeclExpFacilBean declExpFacil = consultaDeclaracionExportaFacilService.exportarResultadoDEF(annPresen, numDeclaracion,
				numGuiapostal, fecDeclaracionDesde, fecDeclaracionHasta, fecSolicitudDesde, fecSolicitudHasta, codTipdoc, numDocident, codEstdua, codEstarecti);
		return Response.ok(declExpFacil).build();
	}

	@GET
	@Path("/e/prueba")
	@Produces(MediaType.APPLICATION_JSON)
	public Response prueba()  throws UnprocessableEntityException {
		DeclExpFacilBean declExpFacil = consultaDeclaracionExportaFacilService.prueba();
		return Response.ok(declExpFacil).build();
	}
   @GET
   @Path("/e/acta/{coTipoActa}-{codPlaca}")
   @Produces({ MediaType.APPLICATION_JSON })
   public Response listarActas(@PathParam("codAduana") String codAduana,@PathParam("placa") String placa) throws UnprocessableEntityException {

	   List<DeclExpFacilBean> lstActa = this.consultaDeclaracionExportaFacilService.listarActas(codAduana, placa);
	   return Response.ok(lstActa).build();

   }

}