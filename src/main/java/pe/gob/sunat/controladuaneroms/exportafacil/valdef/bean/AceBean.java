/***********************************************************************
 * Module:  AceBean.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class AceBean
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AceBean {

}
