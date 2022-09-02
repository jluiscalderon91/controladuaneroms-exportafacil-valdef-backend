/***********************************************************************
 * Module:  CatalogoRestService.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class CatalogoRestService
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest.catalogo;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.CatalogoAduanaDTO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.DeclExpFacilBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.catalogo.CatalogoService;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityException;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest.catalogo.PciCatalogoAbstractRest;
import pe.gob.sunat.tecnologiams.arquitectura.framework.common.util.ConstantesUtils;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/v1/despaduanero/catalogo")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class CatalogoRestService extends PciCatalogoAbstractRest {

    @Inject
    private UtilLog utilLog;

    /*@GET
    @Path("t/modusoperandi/catalogo/aduanas")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response aduanas(@QueryParam("ruta") String ruta) throws UnprocessableEntityException {
        utilLog.imprimirLog(ConstantesUtils.LEVEL_DEBUG, "Inicio - CatalogoRestService.paises");
        List<CatalogoAduanaDTO> list = new ArrayList<CatalogoAduanaDTO>();

        try {
           // list = catalogoService.aduanas();
        } catch (Exception e) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, "Error - CatalogoRestService.paises");
        }

        return Response.status(Response.Status.OK).entity(list).build();
    }*/


}