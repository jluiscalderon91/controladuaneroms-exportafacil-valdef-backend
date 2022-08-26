/***********************************************************************
 * Module:  ParticipanteDoc.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ParticipanteDoc
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class ParticipanteDoc {

    private static final long serialVersionUID = 8392420129257475535L;

    @Column(name = "idExportador")
    private String idExportador;

    @Column(name = "nomRazonsocial")
    private String nomRazonsocial;

    public String getIdExportador() {
        return idExportador;
    }

    public void setIdExportador(String idExportador) {
        this.idExportador = idExportador;
    }

    public String getNomRazonsocial() {
        return nomRazonsocial;
    }

    public void setNomRazonsocial(String nomRazonsocial) {
        this.nomRazonsocial = nomRazonsocial;
    }

    @Override
    public String toString() {
        return "ParticipanteDoc{" +
                "idExportador='" + idExportador + '\'' +
                ", nomRazonsocial='" + nomRazonsocial + '\'' +
                '}';
    }
}
