/***********************************************************************
 * Module:  JPADeclExpFacilDAO.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class JPADeclExpFacilDAO
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.jpa;

import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.AceBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.ExpDetPDFBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean.RiesgoBean;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.dao.DeclExpFacilDAO;
import pe.gob.sunat.controladuaneroms.exportafacil.valdef.model.DeclExpFacil;
import pe.gob.sunat.tecnologiams.arquitectura.framework.common.util.ConstantesUtils;
import pe.gob.sunat.tecnologiams.arquitectura.framework.jpa.dao.AbstractDao;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;


public class JPADeclExpFacilDAO extends AbstractDao<DeclExpFacil, String> implements DeclExpFacilDAO {

    @Inject
    private UtilLog utilLog;

    @Inject
    @Named("bdsigad")
    protected EntityManager bdsigad;

    @Override
    public List<DeclExpFacil> listarActas(String codAduana, String placa) {
        StringBuilder sql = new StringBuilder();
        sql.append(
                "CADUA_PRECO, CPTOC_PRECO, FANNO_PRECO, NCORR_PRECO, CTIPO_ACTA, TO_DATE(FECHA_ACTA, 'YYYY/MM/DD')  FROM CAB_ACTAS WHERE CTIPO_ACTA= ? AND TMATR_EMTRA=? AND NELIM_REGIS='0'");

        List<DeclExpFacil> resultado = new java.util.ArrayList<>();
        try {
            Query query = bdsigad.createNativeQuery(sql.toString(), DeclExpFacil.class);
            query.setParameter(1, codAduana);
            query.setParameter(1, placa);
            resultado = findByQuery(query);
        } catch (Exception ex) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, ex.getMessage());
        }

        return resultado;
    }

    @Override
    public DeclExpFacil consultarDeclaracionExportaFacil(String annPresen, String numDeclaracion, String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta, Date fecSolicitudDesde, Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) {
        utilLog.imprimirLog(ConstantesUtils.LEVEL_INFO, "Inicio DeclExpFacilDAO - consultarDeclaracionExportaFacil");
        DeclExpFacil declExpFacil = null;
        StringBuilder sql = new StringBuilder();

        sql.append(
                "SELECT A.ID AS id, A.VALOR AS valor");
        sql.append("FROM TABLITA A");

        try {
            Query query = bdsigad.createNativeQuery(sql.toString(), DeclExpFacil.class);
            /*query.setParameter(1, annPresen);
            query.setParameter(2, numDeclaracion);
            query.setParameter(3, numGuiapostal);
            query.setParameter(4, fecDeclaracionDesde);
            query.setParameter(5, fecDeclaracionHasta);
            query.setParameter(6, fecSolicitudDesde);
            query.setParameter(7, fecSolicitudHasta);
            query.setParameter(8, codTipdoc);
            query.setParameter(9, numDocident);
            query.setParameter(10, codEstdua);
            query.setParameter(11, codEstarecti);*/
            //declExpFacil = (DeclExpFacil) StringUtil.jsonToList(StringUtil.getJson(query.getSingleResult()), DeclExpFacil.class);
        } catch (NoResultException nre) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, nre.getMessage());
            declExpFacil = null;
        } catch (Exception e) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, e.getMessage());
            declExpFacil = null;
        }
        return declExpFacil;
    }

    @Override
    public DeclExpFacil exportarResultadoDEF(String annPresen, String numDeclaracion, String numGuiapostal, Date fecDeclaracionDesde, Date fecDeclaracionHasta, Date fecSolicitudDesde, Date fecSolicitudHasta, String codTipdoc, String numDocident, String codEstdua, String codEstarecti) {
        return null;
    }

    @Override
    public DeclExpFacil consultarDetalladaDEF(String idDef) {
        return null;
    }

    @Override
    public ExpDetPDFBean exportarDetalladaPDF(String idDef) {
        utilLog.imprimirLog(ConstantesUtils.LEVEL_INFO, "Inicio DeclExpFacilDAO - consultarDetalladaRiesgo");
        ExpDetPDFBean riesgoBean = new ExpDetPDFBean();
        try {
            Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
            Path pdfPath = Paths.get(root.toString() + "/src/main/resources/document-test.pdf");
            byte[] pdf = Files.readAllBytes(pdfPath);
            String encodedString = Base64.getEncoder().encodeToString(pdf);
            riesgoBean.setNomArchivo("archivo.pdf");
            riesgoBean.setDesMimeType("application/pdf");
            riesgoBean.setArchivo(encodedString);

        } catch (NoResultException nre) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, nre.getMessage());
            riesgoBean = null;
        } catch (Exception e) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, e.getMessage());
            riesgoBean = null;
        }
        return riesgoBean;
    }

    @Override
    public RiesgoBean consultarDetalladaRiesgo(String idDef) {
        utilLog.imprimirLog(ConstantesUtils.LEVEL_INFO, "Inicio DeclExpFacilDAO - consultarDetalladaRiesgo");
        RiesgoBean riesgoBean = new RiesgoBean();
        try {
            riesgoBean.setIdDef("235-2022-EP-00000001");
            riesgoBean.setCodCanal("V1");
            riesgoBean.setCodMomentoRiesgo("EP11");
            riesgoBean.setCodMotivoRiesgo("05");
            riesgoBean.setSeleccionCodModelo("FMV");
            riesgoBean.setSeleccionCodSerie("1");
            riesgoBean.setSeleccionFraude("Valor FOB unitario menor a la referencia");
            riesgoBean.setSeleccionDetalle("Verificar valor, cantidad y descripción de la mercancía");

        } catch (NoResultException nre) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, nre.getMessage());
            riesgoBean = null;
        } catch (Exception e) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, e.getMessage());
            riesgoBean = null;
        }
        return riesgoBean;
    }

    @Override
    public AceBean consultarDetalladaACE(String idDef) {
        utilLog.imprimirLog(ConstantesUtils.LEVEL_INFO, "Inicio DeclExpFacilDAO - consultarDetalladaACE");
        AceBean aceBean = new AceBean();
        try {
            aceBean.setIdDef("235-2022-EP-00000001");
            aceBean.setCodCanal("F");
            aceBean.setNroAce("000133");
            aceBean.setFecAce("03/07/2022 10:10:00");
            aceBean.setCodEstadoAce("");
            aceBean.setNroActaInsp("");
            aceBean.setFecActaInsp("");
            aceBean.setNroActaIncInmHal("");
            aceBean.setFecActaIncInmHal("");

        } catch (NoResultException nre) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, nre.getMessage());
            aceBean = null;
        } catch (Exception e) {
            utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, e.getMessage());
            aceBean = null;
        }
        return aceBean;
    }

    @Override
    public EntityManager buildEntityManager() {
        return bdsigad;
    }

    @Override
    public Class<DeclExpFacil> provideEntityClass() {
        return DeclExpFacil.class;
    }
}