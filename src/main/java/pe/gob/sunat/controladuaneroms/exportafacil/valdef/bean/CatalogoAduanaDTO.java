package pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean;

public class CatalogoAduanaDTO {

    private String codDatacatalogo;
    private String desDatacatalogo;

    public String getCodDatacatalogo() {
        return codDatacatalogo;
    }

    public void setCodDatacatalogo(String codDatacatalogo) {
        this.codDatacatalogo = codDatacatalogo;
    }

    public String getDesDatacatalogo() {
        return desDatacatalogo;
    }

    public void setDesDatacatalogo(String desDatacatalogo) {
        this.desDatacatalogo = desDatacatalogo;
    }

    @Override
    public String toString() {
        return "CatalogoAduanaDTO{" +
                "codDatacatalogo='" + codDatacatalogo + '\'' +
                ", desDatacatalogo='" + desDatacatalogo + '\'' +
                '}';
    }
}
