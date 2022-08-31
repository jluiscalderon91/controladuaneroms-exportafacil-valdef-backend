/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilServiceImpl.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ConsultaDeclaracionExportaFacilServiceImpl
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.impl;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DeclExpFacilDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.ParticipanteDocDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.DeclExpFacil;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.DeclExpFacilBean;
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
import java.util.Objects;


public class ConsultaDeclaracionExportaFacilServiceImpl implements ConsultaDeclaracionExportaFacilService {

    @Inject
    private DeclExpFacilDAO declExpFacilDAO;
    @Inject
    private ParticipanteDocDAO participanteDocDAO;

    @Override
    public List<DeclExpFacilBean> listarActas(String codAduana, String placa) throws UnprocessableEntityException {

        List<DeclExpFacilBean> declExpFacilLista = new ArrayList<DeclExpFacilBean>();

        boolean noHayCodAduana = codAduana == null || codAduana.trim().isEmpty();

        if (noHayCodAduana) {
            return new ArrayList<DeclExpFacilBean>();
        }

        List<DeclExpFacil> declExpLista = declExpFacilDAO.listarActas(codAduana, placa);
        for (DeclExpFacil serie :declExpLista)
        {
            DeclExpFacilBean declExpFacil= new DeclExpFacilBean();
            //Asignar Valores DAO - BEAN
            declExpFacil.setIdDef(declExpFacil.getIdDef());


            declExpFacilLista.add(declExpFacil);
        }
        return declExpFacilLista;
    }

    @Override
    public DeclExpFacilBean prueba() throws UnprocessableEntityException {

        DeclExpFacilBean decla = new DeclExpFacilBean();
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
    public DeclExpFacilBean consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion, String numGuiapostal, String fecDeclaracionDesde,
                                                         String fecDeclaracionHasta, String fecSolicitudDesde, String fecSolicitudHasta, String codTipdoc,
                                                         String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException {

        try {
            validarDatosExportaFacil(numDeclaracion, numGuiapostal, fecDeclaracionDesde, fecDeclaracionHasta, fecSolicitudDesde, fecSolicitudHasta, codTipdoc,
                    numDocident, codEstdua, codEstarecti);
        } catch (Exception ex) {
            validarDatosExportaFacil(numDeclaracion, numGuiapostal, fecDeclaracionDesde, fecDeclaracionHasta, fecSolicitudDesde, fecSolicitudHasta, codTipdoc,
                    numDocident, codEstdua, codEstarecti);
        }
        Date fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate, fecSolicitudHastaDate;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            if (!(fecDeclaracionDesde == null)) {
                fecDeclaracionDesdeDate = format.parse(fecDeclaracionDesde);
                fecDeclaracionHastaDate = format.parse(fecDeclaracionHasta);
                fecSolicitudDesdeDate = format.parse(fecSolicitudDesde);
                fecSolicitudHastaDate = format.parse(fecSolicitudHasta);
            } else {
                fecDeclaracionDesdeDate = null;
                fecDeclaracionHastaDate = null;
                fecSolicitudDesdeDate = null;
                fecSolicitudHastaDate = null;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        DeclExpFacilBean declExpFacil= new DeclExpFacilBean();

        DeclExpFacil declExp = declExpFacilDAO.consultarDeclaracionExportaFacil(annPresen, numDeclaracion,
                numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate,
                fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);

        //Asignar Valores DAO - BEAN
        declExpFacil.setIdDef(declExp.getIdDef());

        return declExpFacil;
    }

    @Override
    public DeclExpFacilBean exportarResultadoDEF(String annPresen, String numDeclaracion, String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde, String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException {
        Date fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate, fecSolicitudHastaDate;

        try {
            validarDatosExportaFacil(numDeclaracion, numGuiapostal, fecDeclaracionDesde, fecDeclaracionHasta, fecSolicitudDesde, fecSolicitudHasta, codTipdoc, numDocident, codEstdua, codEstarecti);
        } catch (Exception ex) {
            validarDatosExportaFacil(numDeclaracion, numGuiapostal, fecDeclaracionDesde, fecDeclaracionHasta, fecSolicitudDesde, fecSolicitudHasta, codTipdoc, numDocident, codEstdua, codEstarecti);
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            if (!(fecDeclaracionDesde == null)) {
                fecDeclaracionDesdeDate = format.parse(fecDeclaracionDesde);
                fecDeclaracionHastaDate = format.parse(fecDeclaracionHasta);
                fecSolicitudDesdeDate = format.parse(fecSolicitudDesde);
                fecSolicitudHastaDate = format.parse(fecSolicitudHasta);
            } else {
                fecDeclaracionDesdeDate = null;
                fecDeclaracionHastaDate = null;
                fecSolicitudDesdeDate = null;
                fecSolicitudHastaDate = null;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        DeclExpFacilBean declExpFacil= new DeclExpFacilBean();

        DeclExpFacil declExp = declExpFacilDAO.exportarResultadoDEF(annPresen, numDeclaracion,
                numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate,
                fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);

        //Asignar Valores DAO - BEAN
        declExpFacil.setIdDef(declExp.getIdDef());

        return declExpFacil;
    }

    @Override
    public DeclExpFacilBean consultarDetalladaDEF(String idDef) throws UnprocessableEntityException {

        try {
            validarDatosExportaFacilDetallada(idDef);
        } catch (Exception ex) {
            validarDatosExportaFacilDetallada(idDef);
        }

        DeclExpFacilBean declExpFacil= new DeclExpFacilBean();

        DeclExpFacil declExp = declExpFacilDAO.consultarDetalladaDEF(idDef);

        //Asignar Valores DAO - BEAN
        declExpFacil.setIdDef(declExp.getIdDef());

        return declExpFacil;
    }

    private void validarDatosExportaFacil(String numDeclaracion, String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta,
                                          String fecSolicitudDesde, String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua,
                                          String codEstarecti) throws UnprocessableEntityException {
        List<ErrorMessage> listaErrores = new ArrayList<>();
        if (Objects.isNull(numDeclaracion) || numDeclaracion.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1051.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1051.getMensaje()));
        }
        if (Objects.isNull(numGuiapostal) || numGuiapostal.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1052.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1052.getMensaje()));
        }
        if (Objects.isNull(fecDeclaracionDesde) || fecDeclaracionDesde.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1057.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1057.getMensaje()));
        }
        if (Objects.isNull(fecDeclaracionHasta) || fecDeclaracionHasta.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1058.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1058.getMensaje()));
        }
        if (Objects.isNull(fecSolicitudDesde) || fecSolicitudDesde.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1061.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1061.getMensaje()));
        }
        if (Objects.isNull(fecSolicitudHasta) || fecSolicitudHasta.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1062.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1062.getMensaje()));
        }
        if (Objects.isNull(codTipdoc) || codTipdoc.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1059.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1059.getMensaje()));
        }
        if (Objects.isNull(numDocident) || numDocident.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1060.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1060.getMensaje()));
        }
        if (Objects.isNull(codEstarecti) || codEstarecti.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1063.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1063.getMensaje()));
        }
        if (codTipdoc.equals("01") || codTipdoc.equals("1") || codTipdoc.equals("06") || codTipdoc.equals("6")) {
            Boolean consulta = participanteDocDAO.consultarDocumentIdent(numDocident);
            if (!consulta) {
                if (codTipdoc.equals("01") || codTipdoc.equals("1")) {
                    listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_INTEGRIDAD_1065.getCodigo(),
                            EnumErrores.ERROR_VALIDACION_INTEGRIDAD_1065.getMensaje()));
                } else if (codTipdoc.equals("06") || codTipdoc.equals("6")) {
                    listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_INTEGRIDAD_1064.getCodigo(),
                            EnumErrores.ERROR_VALIDACION_INTEGRIDAD_1064.getMensaje()));
                } else {
                    listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1072.getCodigo(),
                            EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1072.getMensaje()));
                }
            }
        } else {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1072.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1072.getMensaje()));
        }
        if (!listaErrores.isEmpty()) {
            throw new UnprocessableEntityException(listaErrores);
        }
    }

    private void validarDatosExportaFacilDetallada(String idDef) throws UnprocessableEntityException {
        List<ErrorMessage> listaErrores = new ArrayList<>();
        if (Objects.isNull(idDef) || idDef.isEmpty()) {
            listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1071.getCodigo(),
                    EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1071.getMensaje()));
        }

        if (!listaErrores.isEmpty()) {
            throw new UnprocessableEntityException(listaErrores);
        }
    }

    private void mostrarErrores(String cod, String msg) throws UnprocessableEntityException {
        List<ErrorMessage> listaErrores = new ArrayList<>();
        listaErrores.add(new ErrorMessage(cod, msg));
        throw new UnprocessableEntityException(listaErrores);
    }

}