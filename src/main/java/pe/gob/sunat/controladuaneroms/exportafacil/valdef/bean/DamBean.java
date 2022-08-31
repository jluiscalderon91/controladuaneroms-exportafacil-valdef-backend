/***********************************************************************
 * Module:  DamBean.java
 * Author:  jvillavicencio
 * Purpose: Defines the Class DamBean
 ***********************************************************************/

package pe.gob.sunat.controladuaneroms.exportafacil.valdef.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DamBean {

}
