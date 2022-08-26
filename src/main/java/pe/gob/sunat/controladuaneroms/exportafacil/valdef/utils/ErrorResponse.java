package pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils;

import java.util.List;

public class ErrorResponse {
    private String cod;
    private String msg;
    private List<ErrorMessage> errors;
    public ErrorResponse(HTTPErrorEnum httpErrorEnum) {
        this.cod = String.valueOf(httpErrorEnum.getCode());
        this.msg = httpErrorEnum.getMsg();
    }
    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }
    public List<ErrorMessage> getErrors() {
        return errors;
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
