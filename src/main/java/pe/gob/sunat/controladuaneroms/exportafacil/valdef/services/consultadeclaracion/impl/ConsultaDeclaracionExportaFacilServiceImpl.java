/***********************************************************************
 * Module:  ConsultaDeclaracionExportaFacilServiceImpl.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ConsultaDeclaracionExportaFacilServiceImpl
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.consultadeclaracion.impl;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.AceBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.ExpDetPDFBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.RiesgoBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.CabDeclaraDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DeclExpFacilDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.ParticipanteDocDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.*;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.DeclExpFacilBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.services.consultadeclaracion.ConsultaDeclaracionExportaFacilService;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.EnumErrores;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.ErrorMessage;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils.UnprocessableEntityException;

import javax.inject.Inject;
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
    private CabDeclaraDAO cabDeclaraDAO;
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
        for (DeclExpFacil serie : declExpLista) {
            DeclExpFacilBean declExpFacil = new DeclExpFacilBean();
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
            String idcad = "1";
            if (idcad == "1") {
                mostrarErrores(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1001.getCodigo(),
                        EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1001.getMensaje());
            }
            String id2cad = "2";
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
    public List<DeclExpFacilBean> consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion, String numGuiapostal, String fecDeclaracionDesde,
                                                             String fecDeclaracionHasta, String fecSolicitudDesde, String fecSolicitudHasta, String codTipdoc,
                                                             String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException {

        Date fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate, fecSolicitudHastaDate;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {

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

        try {
            validarDatosExportaFacil(numDeclaracion, numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate, fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);
        } catch (Exception ex) {
            validarDatosExportaFacil(numDeclaracion, numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate, fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);
        }

        List<DeclExpFacilBean> declExpFacilLista = new ArrayList<DeclExpFacilBean>();

        /*DeclExpFacil declExp = declExpFacilDAO.consultarDeclaracionExportaFacil(annPresen, numDeclaracion,
                numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate,
                fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);*/

        CabDeclara cabDeclara = cabDeclaraDAO.cabDeclara(annPresen, numDeclaracion,
                numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate,
                fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);

        DeclExpFacilBean declExpFacil[] = new DeclExpFacilBean[2];
        for (int i = 0; i < 2; i++) {
            declExpFacil[i] = new DeclExpFacilBean();
            //Asignar Valores DAO - BEAN
            //declExpFacil.setIdDef(cabDeclara.getIdDef());

            //Simulacion de Respuestas
            try {
                fecDeclaracionDesdeDate = format.parse("07/07/2022");
                fecDeclaracionHastaDate = format.parse("07/07/2022");
                fecSolicitudDesdeDate = format.parse("08/07/2022");
            } catch (ParseException e) {

            }
            declExpFacil[i].setIdDef("235-2022-EP-00000001");
            declExpFacil[i].setFecDeclaracion(fecDeclaracionDesdeDate);
            declExpFacil[i].setCodEstdua("01");
            declExpFacil[i].setFecAutlevante(fecDeclaracionHastaDate);
            declExpFacil[i].setIdExportador("1-20100055237");
            declExpFacil[i].setNomRazonsocial("ALICORP S.A.A.");
            declExpFacil[i].setCntTotbultos(10);
            declExpFacil[i].setCntPesobrutoTotal(100.3);
            declExpFacil[i].setCodCanal("V");
            declExpFacil[i].setCodPuerDesti("US");
            declExpFacil[i].setMtoValoradu(545.80);
            declExpFacil[i].setIdRectificacion("235-2022-2000");
            declExpFacil[i].setCodEstarecti("01");
            declExpFacil[i].setIdManifiesto("02-235-4-2021-000100");
            declExpFacil[i].setNumDoctransporte("05230496503PE");
            declExpFacil[i].setFecRegulariza(fecSolicitudDesdeDate);
            declExpFacil[i].setIndFueraplazo("01");
            declExpFacil[i].setCodFuncionario("5656");

            declExpFacilLista.add(declExpFacil[i]);
        }


        return declExpFacilLista;
    }

    @Override
    public DeclExpFacilBean exportarResultadoDEF(String annPresen, String numDeclaracion, String numGuiapostal, String fecDeclaracionDesde, String fecDeclaracionHasta, String fecSolicitudDesde, String fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) throws UnprocessableEntityException {
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

        try {
            validarDatosExportaFacil(numDeclaracion, numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate, fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);
        } catch (Exception ex) {
            validarDatosExportaFacil(numDeclaracion, numGuiapostal, fecDeclaracionDesdeDate, fecDeclaracionHastaDate, fecSolicitudDesdeDate, fecSolicitudHastaDate, codTipdoc, numDocident, codEstdua, codEstarecti);
        }

        DeclExpFacilBean declExpFacil = new DeclExpFacilBean();

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

        DeclExpFacilBean declExpFacil = new DeclExpFacilBean();

        DeclExpFacil declExp = declExpFacilDAO.consultarDetalladaDEF(idDef);

        //Asignar Valores DAO - BEAN
        declExpFacil.setIdDef(declExp.getIdDef());

        return declExpFacil;
    }

    @Override
    public ExpDetPDF exportarDetalladaPDF(String idDef) throws UnprocessableEntityException {
        try {
            validarDatosExportaFacilDetallada(idDef);
        } catch (Exception ex) {
            validarDatosExportaFacilDetallada(idDef);
        }

        ExpDetPDF expDetPDF = new ExpDetPDF();

        ExpDetPDFBean expDetPDFBean = declExpFacilDAO.exportarDetalladaPDF(idDef);

        expDetPDF.setNomArchivo(expDetPDFBean.getNomArchivo());
        expDetPDF.setDesMimeType(expDetPDFBean.getDesMimeType());
        expDetPDF.setArchivo(expDetPDFBean.getArchivo());

        return expDetPDF;
    }

    @Override
    public Riesgo consultarDetalladaRiesgo(String idDef) throws UnprocessableEntityException {

        try {
            validarDatosExportaFacilDetallada(idDef);
        } catch (Exception ex) {
            validarDatosExportaFacilDetallada(idDef);
        }

        Riesgo Riesgo = new Riesgo();
        InfoSeleccion infoSeleccion = new InfoSeleccion();
        List<InfoSeleccion> infoSeleccions = new ArrayList<>();
        RiesgoBean riesgoBean = declExpFacilDAO.consultarDetalladaRiesgo(idDef);
        //Asignar Valores BEAN - MODEL
        Riesgo.setIdDef(riesgoBean.getIdDef());
        Riesgo.setCodCanal(riesgoBean.getCodCanal());
        Riesgo.setCodMomentoRiesgo(riesgoBean.getCodMomentoRiesgo());
        Riesgo.setCodMotivoRiesgo(riesgoBean.getCodMotivoRiesgo());

        infoSeleccion.setSeleccionCodModelo(riesgoBean.getSeleccionCodModelo());
        infoSeleccion.setSeleccionCodSerie(riesgoBean.getSeleccionCodSerie());
        infoSeleccion.setSeleccionFraude(riesgoBean.getSeleccionFraude());
        infoSeleccion.setSeleccionDetalle(riesgoBean.getSeleccionDetalle());
        infoSeleccions.add(infoSeleccion);

        Riesgo.setInfoSeleccion(infoSeleccions);
        return Riesgo;
    }

    @Override
    public Ace consultarDetalladaACE(String idDef) throws UnprocessableEntityException {

        try {
            validarDatosExportaFacilDetallada(idDef);
        } catch (Exception ex) {
            validarDatosExportaFacilDetallada(idDef);
        }

        Ace ace = new Ace();
        InfoACE infoACE = new InfoACE();
        List<InfoACE> infoACES = new ArrayList<>();
        AceBean aceBean = declExpFacilDAO.consultarDetalladaACE(idDef);
        //Asignar Valores BEAN - MODEL
        ace.setIdDef(aceBean.getIdDef());
        ace.setCodCanal(aceBean.getCodCanal());
        infoACE.setNroAce(aceBean.getNroAce());
        infoACE.setFecAce(aceBean.getFecAce());
        infoACE.setCodEstadoAce(aceBean.getCodEstadoAce());
        infoACE.setNroActaInsp(aceBean.getNroActaInsp());
        infoACE.setFecActaInsp(aceBean.getFecActaInsp());
        infoACE.setNroActaIncInmHal(aceBean.getNroActaIncInmHal());
        infoACE.setFecActaIncInmHal(aceBean.getFecActaIncInmHal());
        infoACES.add(infoACE);
        ace.setInfoACES(infoACES);
        return ace;
    }

    private void validarDatosExportaFacil(String numDeclaracion, String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta,
                                          Date fecSolicitudDesde, Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua,
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

        if (!Objects.isNull(fecDeclaracionHasta) || !Objects.isNull(fecDeclaracionDesde)) {
            if (fecDeclaracionHasta.before(fecDeclaracionDesde)) {
                listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1057.getCodigo(),
                        EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1057.getMensaje()));
            }
            int dias = (int) ((fecDeclaracionHasta.getTime() - fecDeclaracionDesde.getTime()) / 86400000);
            if (dias > 7) {
                listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1058.getCodigo(),
                        EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1058.getMensaje()));
            }
        }

        if (!Objects.isNull(fecSolicitudHasta) || !Objects.isNull(fecSolicitudDesde)) {
            if (fecSolicitudHasta.before(fecSolicitudDesde)) {
                listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1057.getCodigo(),
                        EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1057.getMensaje()));
            }
            int dias = (int) ((fecSolicitudHasta.getTime() - fecSolicitudDesde.getTime()) / 86400000);
            if (dias > 7) {
                listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1058.getCodigo(),
                        EnumErrores.ERROR_VALIDACION_OBLIGATORIEDAD_1058.getMensaje()));
            }
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
                            EnumErrores.ERROR_VALIDACION_INTEGRIDAD_1065.getMensaje().replace("{numDocExpor}", numDocident)));
                } else if (codTipdoc.equals("06") || codTipdoc.equals("6")) {
                    listaErrores.add(new ErrorMessage(EnumErrores.ERROR_VALIDACION_INTEGRIDAD_1064.getCodigo(),
                            EnumErrores.ERROR_VALIDACION_INTEGRIDAD_1064.getMensaje().replace("{numDocExpor}", numDocident)));
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