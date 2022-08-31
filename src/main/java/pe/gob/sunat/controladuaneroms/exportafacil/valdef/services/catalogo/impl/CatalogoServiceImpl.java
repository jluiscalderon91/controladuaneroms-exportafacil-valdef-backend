/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilServiceImpl.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ConsultaDeclaracionExportaFacilServiceImpl
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.catalogo.impl;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.DeclExpFacilBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DeclExpFacilDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.ParticipanteDocDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.DeclExpFacil;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.EnumErrores;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.ErrorMessage;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityException;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.catalogo.CatalogoService;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class CatalogoServiceImpl implements CatalogoService {

    private void mostrarErrores(String cod, String msg) throws UnprocessableEntityException {
        List<ErrorMessage> listaErrores = new ArrayList<>();
        listaErrores.add(new ErrorMessage(cod, msg));
        throw new UnprocessableEntityException(listaErrores);
    }

}