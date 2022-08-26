package pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils;

import pe.gob.sunat.tecnologiams.arquitectura.framework.common.util.ConstantesUtils;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UnprocessableEntityExceptionMapper implements ExceptionMapper<UnprocessableEntityException> {
    @Inject
    private UtilLog utilLog;
    public Response toResponse(UnprocessableEntityException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HTTPErrorEnum.HTTP_ERROR_422);
        errorResponse.setErrors(ex.getErrors());
        utilLog.imprimirLog(ConstantesUtils.LEVEL_WARN, ex.getErrors().toString(),
                Thread.currentThread().getStackTrace());
        return Response.status(Integer.parseInt(errorResponse.getCod())).entity(errorResponse).build();
    }
}
