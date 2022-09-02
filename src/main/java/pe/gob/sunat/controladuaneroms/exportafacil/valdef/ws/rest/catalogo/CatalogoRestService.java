/***********************************************************************
 * Module:  CatalogoRestService.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class CatalogoRestService
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest.catalogo;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.ws.rest.catalogo.PciCatalogoAbstractRest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/despaduanero/catalogo")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class CatalogoRestService extends PciCatalogoAbstractRest {

}