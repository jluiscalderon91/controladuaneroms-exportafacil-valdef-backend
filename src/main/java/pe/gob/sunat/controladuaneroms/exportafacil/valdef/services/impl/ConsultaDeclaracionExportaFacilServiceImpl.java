/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilServiceImpl.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ConsultaDeclaracionExportaFacilServiceImpl
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.impl;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DeclExpFacilDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain.DeclExpFacil;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.ConsultaDeclaracionExportaFacilService;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.EnumErrores;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.ErrorMessage;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityException;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ConsultaDeclaracionExportaFacilServiceImpl implements ConsultaDeclaracionExportaFacilService {

    @Inject
    private DeclExpFacilDAO declExpFacilDAO;

    @Override
    public List<DeclExpFacil> listarActas(String codAduana, String placa) throws UnprocessableEntityException {

        boolean noHayCodAduana = codAduana == null || codAduana.trim().isEmpty();

        if (noHayCodAduana) {
            return new ArrayList<>();
        }
        return declExpFacilDAO.listarActas(codAduana, placa);
    }

    @Override
    public DeclExpFacil prueba() throws UnprocessableEntityException {

        DeclExpFacil decla = new DeclExpFacil();
        try {
            //validacion mensaje
            String idcad="1";
            if (idcad == "1") {
                mostrarErrores(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1001.getCodigo(),
                        EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1001.getMensaje());
            }
            String id2cad="2";
            if (id2cad == "2") {
                mostrarErrores(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1002.getCodigo(),
                        EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1002.getMensaje());
            }

        } catch (Exception ex) {
            mostrarErrores(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD.getMensaje());
        }
        return decla;
    }

    @Override
    public DeclExpFacil consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion, String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde, String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException {

        Date fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate, fecSolicitudHastaDate;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            if(!(fecDeclaracionDesde==null))
            {
                fecDeclaracionDesdeDate = format.parse(fecDeclaracionDesde);
                fecDeclaracionHastaDate = format.parse(fecDeclaracionHasta);
                fecSolicitudDesdeDate = format.parse(fecSolicitudDesde);
                fecSolicitudHastaDate = format.parse(fecSolicitudHasta);
            }else{
                fecDeclaracionDesdeDate =null;
                fecDeclaracionHastaDate =null;
                fecSolicitudDesdeDate =null;
                fecSolicitudHastaDate =null;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        DeclExpFacil declExpFacil = declExpFacilDAO.consultarDeclaracionExportaFacil(annPresen, numDeclaracion,
                numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate,
                fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);
        return declExpFacil;
    }

    @Override
    public DeclExpFacil exportarResultadoDEF(String annPresen, String numDeclaracion, String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde, String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException {
        Date fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate, fecSolicitudHastaDate;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            fecDeclaracionDesdeDate = format.parse(fecDeclaracionDesde);
            fecDeclaracionHastaDate = format.parse(fecDeclaracionHasta);
            fecSolicitudDesdeDate = format.parse(fecSolicitudDesde);
            fecSolicitudHastaDate = format.parse(fecSolicitudHasta);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        DeclExpFacil declExpFacil = declExpFacilDAO.exportarResultadoDEF(annPresen, numDeclaracion,
                numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate,
                fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);
        return declExpFacil;
    }

    @Override
    public DeclExpFacil consultarDetalladaDEF(String idDef) throws UnprocessableEntityException {
        DeclExpFacil declExpFacil = declExpFacilDAO.consultarDetalladaDEF(idDef);
        return declExpFacil;
    }


    private void mostrarErrores(String cod, String msg) throws UnprocessableEntityException {
        List<ErrorMessage> listaErrores = new ArrayList<>();
        listaErrores.add(new ErrorMessage(cod, msg));
        throw new UnprocessableEntityException(listaErrores);
    }

}