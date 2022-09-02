/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilServiceImpl.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ConsultaDeclaracionExportaFacilServiceImpl
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.catalogo.impl;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.CatalogoAduanaDTO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.DeclExpFacilBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DeclExpFacilDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.ParticipanteDocDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.DeclExpFacil;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.Constants;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.EnumErrores;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.ErrorMessage;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityException;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.catalogo.CatalogoService;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class CatalogoServiceImpl implements CatalogoService {

    /*@Inject
    private UtilLog utilLog;

    @Override
    public List<CatalogoAduanaDTO> aduanas() throws UnprocessableEntityException {

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target(Constants.urlAduanas);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        @SuppressWarnings("rawtypes")
        List<CatalogoAduanaDTO> result = response.readEntity(ArrayList.class);

        return result;
    }*/

}