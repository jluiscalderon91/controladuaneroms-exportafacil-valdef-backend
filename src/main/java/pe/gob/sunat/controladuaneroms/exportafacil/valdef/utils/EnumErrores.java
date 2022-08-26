package pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils;

import org.apache.commons.lang3.StringUtils;

public enum EnumErrores {
    ERROR_VALIDACION_OBLIGATORIEDAD_1001("1001","RUC no se encuentra Activo o tiene condición de No habido"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1002("1002","Para el motivo Otros debe ingresar una descripción de mínimo 5 caractere"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1003("1003","Tipo de archivo no válido, solo se puede adjuntar archivos tipo pdf o jpg"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1005("1005","Por favor seleccione el archivo a adjuntar"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1006("1006","No es posible adjuntar más de 5 archivos a una DEF"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1007("1007", "Debe seleccionar la modalidad de declaraci\u00F3n: \u201CCon Fines Comerciales\u201D o \u201CSin Fines Comerciales\u201D"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1008("1008","Para registrar una DEF con fines comerciales el tipo de documento del exportador debe ser RUC"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1009("1009","Debe seleccionar instrucción que corresponda en caso no se efectúe la entrega: Devolver o Abandonar"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1010("1010","Número de RUC ingresado no existe"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1011("1011","RUC del exportador no se encuentra Activo o tiene condición de no habido"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1012("1012","DNI del exportador no se encuentra en RENIEC"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1013("1013","Para los tipos de documento PAS, CE y PTP, el número de documento del exportador debe tener al menos 1 caracteres"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1014("1014","Debe registrar el nombre o razón social del <exportador/importador> con un mínimo de 5 caracteres"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1015("1015","Debe registrar la dirección del <exportador/importador> con un mínimo de 5 caracteres"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1016("1016","Número de teléfono móvil del <exportador/importador> debe tener como mínimo 9 caracteres numéricos"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1017("1017","Debe registrar correctamente el correo electrónico del <exportador/importador>"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1018("1018","Correo electrónico del exportador y confirmación del correo electrónico no coinciden"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1019("1019","Tipo de documento del importador debe contener algún carácter diferente a espacio en blanco"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1020("1020","Número de documento del importador debe contener algún carácter diferente a espacio en blanco"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1021("1021","Código Postal Internacional debe tener como mínimo 3 caracteres alfanuméricos"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1022("1022","Departamento o estado del importador debe contener como mínimo 2 caracteres"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1023("1023","Provincia o ciudad del importador debe tener como mínimo 2 caracteres"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1024("1024","Elija valor de la lista de pais de importación"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1025("1025"," debe adjuntar documento del expedidor donde acepta la devolución del envío"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1026("1026","Antes de seleccionar una opción para mercancía restringida seleccione la SPN de la mercancía"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1027("1027", "Para el motivo de env\u00EDo \u201CMercanc\u00EDas devueltas\u201D debe ingresar por lo menos una declaraci\u00F3n precedente asociada a cualquiera de las series"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1028("1028","Sub Partida Nacional ingresada no se encuentra vigente"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1029("1029","Sub Partida Nacional ingresada no aplica para generar DEF Con Fines Comerciales"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1030("1030","Descripción de la mercancía debe tener como mínimo 3 caracteres"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1031("1031","Debe seleccionar la SPN que corresponde a la serie"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1032("1032","Valor de venta de la serie debe ser mayor a 0"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1033("1033","Valor total de la DEF no puede superar los 10 000 US$"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1034("1034", "Debe seleccionar la alternativa \u201CSi\u201D o \u201CNo\u201D para Mercanc\u00EDas restringida"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1035("1035","Debe registrar los datos de al menos un documento autorizante"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1036("1036","Cantidad de mercancía debe ser mayor a 0"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1037("1037","Valor de venta unitario de la serie debe ser mayor a 0"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1038("1038","El plazo máximo para devolver el envío postal a través de una DEF-CFC es de doce (12) meses a partir de la numeración de la declaración correspondiente a los regímenes de códigos 20, 21, 18"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1039("1039","Seleccione el régimen de la DAM precedente"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1040("1040","Por favor ingrese el número de la declaración precedente"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1041("1041","Por favor ingrese el número de serie de la declaración precedente"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1042("1042","Declaración de precedencia no existe"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1043("1043","Serie de la declaración de precedencia no existe"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1044("1044","La subpartida nacional declarada se encuentra dentro de la Lista de subpartidas nacionales excluidas de la restitución simplificada de derechos arancelarios, no se puede acoger al Drawback"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1045("1045","Número de certificado de origen debe ser mayor a 0"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1046("1046","Fecha del certificado de origen no puede ser mayor a la fecha de hoy"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1047("1047","Debe registrar ambos datos del certificado del origen"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1048("1048","Para el motivo del envío <motivo_envío> debe registrar por lo menos un comprobante de pago"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1049("1049","Debe ingresar al menos 3 dígitos para la partida o 4 caracteres en la descripción para buscar la partida."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1050("1050","No se encontró Partidas con los datos ingresados"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1051("1051","Debe ingresar el Número de la Declaración"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1052("1052","Debe ingresar el Número de la Guía Postal"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1053("1053","Debe ingresar el Número de la Guía Postal"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1054("1054","Debe ingresar el Número de la Guía Postal"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1055("1055","Debe ingresar el Número de la Guía Postal"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1056("1056","Debe ingresar el Número de la Guía Postal"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1057("1057","La Fecha Final no puede ser menor a la Fecha Inicial"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1058("1058","El rango de búsqueda no debe ser mayor a 7 días"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1059("1059","Debe seleccionar el Tipo de Documento del exportador"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1060("1060","Debe de ingresar el Número de Documento del exportador"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1061("1061","La Fecha Final no puede ser menor a la Fecha Inicial"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1062("1062","El rango de búsqueda no debe ser mayor a 7 días"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1063("1063","Debe seleccionar el Estado de la Rectificación"),
    ERROR_VALIDACION_INTEGRIDAD_1064("1064","40219 - RUC {numDocExpor} del Exportar no existe"),
    ERROR_VALIDACION_INTEGRIDAD_1065("1065","50097 - DNI {numDocExpor} no existe"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1066("1066","Año ingresado inválido, no puede ser menor a 2021 ni mayor a año actual."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1067("1067","El número de declaración debe ser mayor a 0."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1068("1068","Ingresar un número de documento de mínimo 3 caracteres."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1069("1069","Seleccione el tipo de documento del exportador asociado a la DEF que desea rectificar."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1070("1070","Ingrese el número de documento del exportador asociado a la DEF."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1071("1071","DEF {codAduana-annDef-codRegimen-numCorrdef} no existe."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1072("1072","Tipo y/o número de documento del exportador no corresponde al registrado en la DEF."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1073("1073","Código de verificación ingresado no coincide con el enviado a su correo o ya no se encuentra activo."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1074("1074","Debe ingresar el Código de Aduana."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1075("1075","Debe ingresar el Año de la declaración."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1076("1076","Debe ingresar el Código de Regimen."),
    ERROR_VALIDACION_OBLIGATORIEDAD_1077("1077","Debe ingresar el Número de la Declaración"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1078("1078","Se presentó error (HTTP 422)"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1079("1079","Código error y mensaje de error"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1080("1080","Año de la DEF no puede ser menor a 2022 ni mayor al año en curso"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1081("1081","Número de declaración debe ser mayor a 0"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1082("1082","Ingrese el año y número de DEF"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1083("1083","DEF <cod_aduana>-<año>-<cod_regimen>-<numero> no existe"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1084("1084","No se puede legajar la DEF en estado Regularizada, de corresponder, previamente solicitar a SERPOST que revierta la regularización"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1085("1085","No se encuentra autorizado para Legajar/Revertir legajo de la DEF <cod_aduana>-<año>-<cod_regimen>-<numero>"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1086("1086","No puede Legajar/Revertir legajo de la DEF porque no cuenta con mandato vigente"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1087("1087","o se puede legajar la DEF porque no cuenta con diligencia registrada"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1088("1088","No se puede Legajar/Revertir legajo de la DEF porque cuenta con Acción de Control Extraordinario <nro_ace> en ejecución"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1089("1089","No se puede Legajar/Revertir legajo de la DEF porque cuenta con la solicitud de rectificación N° <cod_aduana>-<año_sol>-<nro_sol> pendiente de atención"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1090("1090","Debe ingresar un sustento con mínimo 15 caracteres"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1091("1091","Ingrese el sustento por el que se <legajará/revertirá el legajo> de la DEF"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1092("1092","No es posible rectificar Declaraciones Exporta Fácil con RUC que no está Activo o tiene condición de No habido"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1093("1093","No se encuentra autorizado para rectificar la DEF <cod_aduana>-<año>-<cod_regimen>-<numero>"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1094("1094","No puede Rectificar la DEF porque no cuenta con mandato vigente"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1095("1095","DEF <cod_aduana>-<año>-<cod_regimen>-<numero> se encuentra en estado <estado>, no se puede rectificar"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1096("1096","No se puede rectificar la DEF porque cuenta con solicitud de rectificación <cod_aduana>-<año_sol>-<nro_sol> pendiente de atención"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1097("1097","No se puede rectificar DEF porque cuenta con Acción de Control Extraordinario <nro_ace> en ejecución"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1098("1098","Ingresar un número de documento de mínimo 3 caracteres"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1099("1099","Seleccione el tipo de documento del exportador asociado a la DEF que desea rectificar"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1100("1100","ngrese el número de documento del exportador asociado a la DEF que desea rectificar"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1101("1101","Tipo y/o número de documento del exportador no corresponde al registrado en la DEF"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1102("1102","Código de verificación ingresado no coincide con el enviado a su correo o ya no se encuentra activo"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1103("1103","No se ha modificado ningún dato de la DEF, por favor actualice los datos que requiere rectificar antes de grabar"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1104("1104","Debe registrar la información de la mercancía por lo menos para una serie de la DEF"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1105("1105","Peso recibido debe ser mayor a 0"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1106("1106","Cantidad de bultos recibido debe ser mayor a 0"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1107("1107","Debe ingresar datos en el campo monto de flete"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1108("1108","Fecha de recepción del envío debe ser mayor o igual a la fecha de numeración de la DEF"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1109("1109","Cantidad de guías no coincide con cantidad de bultos"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1110("1110","Opción no disponible para envíos con más de 5 guías postales asociadas"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1111("1111","Debe ingresar Año de solicitud"),
    ERROR_VALIDACION_OBLIGATORIEDAD_1112("1112","Debe ingresar Número de solicitud") ,
    ERROR_VALIDACION_OBLIGATORIEDAD("422","Ha ocurrido un error");

    private EnumErrores(String cod, String msg) {
        this.cod = cod;
        this.msg = msg;
    }

    private String cod;
    private String msg;

    public String getCodigo() {
        return cod;
    }

    public String getMensaje() {
        return msg;
    }

    public static String getMensaje(String cod) {
        String msg = StringUtils.EMPTY;
        for (EnumErrores enumHTTP : EnumErrores.values()) {
            if (enumHTTP.cod.equalsIgnoreCase(cod)) {
                msg = enumHTTP.msg;
                break;
            }
        }
        return msg;
    }

}
