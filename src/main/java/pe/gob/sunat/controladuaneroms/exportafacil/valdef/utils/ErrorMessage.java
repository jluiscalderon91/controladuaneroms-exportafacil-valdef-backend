package pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
    private boolean success;
    private String cod;
    private String msg;
    public ErrorMessage(boolean success, String cod, String msg) {
        this.success = success;
        this.cod = cod;
        this.msg = msg;
    }
    public ErrorMessage(String cod, String msg) {
        this.cod = cod;
        this.msg = msg;
    }
    public ErrorMessage(HTTPErrorEnum httpErrorEnum) {
        this.cod = httpErrorEnum.getCode();
        this.msg = httpErrorEnum.getMsg();
    }
    public ErrorMessage(EnumErrores unprocessableErrorEnum) {
        this.cod = unprocessableErrorEnum.getCodigo();
        this.msg = unprocessableErrorEnum.getMensaje();
    }
    
    public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
