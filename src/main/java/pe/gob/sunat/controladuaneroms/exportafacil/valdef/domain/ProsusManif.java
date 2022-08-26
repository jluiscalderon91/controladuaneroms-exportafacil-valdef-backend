/***********************************************************************
 * Module:  ProsusManif.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class ProsusManif
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.domain;

import javax.persistence.Column;

public class ProsusManif {

    private static final long serialVersionUID = 8392420129257475535L;

    @Column(name = "referencial")
    private String referencial;

    @Column(name = "idManifiesto")
    private String idManifiesto;

    public String getReferencial() {
        return referencial;
    }

    public void setReferencial(String referencial) {
        this.referencial = referencial;
    }

    public String getIdManifiesto() {
        return idManifiesto;
    }

    public void setIdManifiesto(String idManifiesto) {
        this.idManifiesto = idManifiesto;
    }

    @Override
    public String toString() {
        return "ProsusManif{" +
                "referencial='" + referencial + '\'' +
                ", idManifiesto='" + idManifiesto + '\'' +
                '}';
    }
}
