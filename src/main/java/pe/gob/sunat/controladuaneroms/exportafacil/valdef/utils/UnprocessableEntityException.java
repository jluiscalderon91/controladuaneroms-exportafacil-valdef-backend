package pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnprocessableEntityException extends Exception {
    private static final long serialVersionUID = -3473445221002823995L;
    private List<ErrorMessage> errors;
    public UnprocessableEntityException() {
        errors = new ArrayList<>();
    }

    public UnprocessableEntityException(List<ErrorMessage> errors) {
        this.errors = errors;
    }
    public UnprocessableEntityException(ErrorMessage... errors) {
        this.errors = Arrays.asList(errors);
    }
    public UnprocessableEntityException addError(String desError) {
        ErrorMessage errorDetail = new ErrorMessage(false, "999", desError);
        errors.add(errorDetail);
        return this;
    }
    public UnprocessableEntityException addError(boolean success, String codError, String desError) {
        ErrorMessage errorDetail = new ErrorMessage(success, codError, desError);
        errors.add(errorDetail);
        return this;
    }
    public UnprocessableEntityException addError(boolean success, EnumErrores errorEnum) {
        ErrorMessage errorDetail = new ErrorMessage(success, errorEnum.getCodigo(), errorEnum.getMensaje());
        errors.add(errorDetail);
        return this;
    }
    public UnprocessableEntityException addError(EnumErrores errorEnum) {
        ErrorMessage errorDetail = new ErrorMessage(false, errorEnum.getCodigo(), errorEnum.getMensaje());
        errors.add(errorDetail);
        return this;
    }
    public List<ErrorMessage> getErrors() {
        return errors;
    }
    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }
}