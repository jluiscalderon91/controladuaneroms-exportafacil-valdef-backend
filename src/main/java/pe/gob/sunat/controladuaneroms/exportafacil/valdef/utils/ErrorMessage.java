package pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
    private boolean success;
    private String codError;
    private String desError;
    public ErrorMessage(boolean success, String codError, String desError) {
        this.success = success;
        this.codError = codError;
        this.desError = desError;
    }
    public ErrorMessage(String codError, String desError) {
        this.codError = codError;
        this.desError = desError;
    }
    public ErrorMessage(HTTPErrorEnum httpErrorEnum) {
        this.codError = httpErrorEnum.getCode();
        this.desError = httpErrorEnum.getMsg();
    }
    public ErrorMessage(EnumErrores unprocessableErrorEnum) {
        this.codError = unprocessableErrorEnum.getCodigo();
        this.desError = unprocessableErrorEnum.getMensaje();
    }
    
    public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getCodError() {
        return codError;
    }
    public void setCodError(String codError) {
        this.codError = codError;
    }
    public String getDesError() {
        return desError;
    }
    public void setDesError(String desError) {
        this.desError = desError;
    }
}
