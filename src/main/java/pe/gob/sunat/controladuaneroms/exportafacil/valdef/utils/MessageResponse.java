package pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils;

import java.util.List;

public class MessageResponse {
    private String cod;
    private String msg;
    private List<EnumErrores> errors;

    public MessageResponse(HTTPErrorEnum httpErrorEnum) {
        this.cod = String.valueOf(httpErrorEnum.getCode());
        this.msg = httpErrorEnum.getMsg();
    }
    public void setErrors(List<EnumErrores> errors) {
        this.errors = errors;
    }
    public List<EnumErrores> getErrors() {
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
