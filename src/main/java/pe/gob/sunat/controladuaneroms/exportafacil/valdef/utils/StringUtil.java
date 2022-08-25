package pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;*/

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StringUtil {
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String getJson(Object object) {
		String result = "";
		try {
			result = mapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	public static <T> List<T> jsonToList(String jsonString, Class<?> clazz) {
		List<T> result = null;
		try {
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
			result = mapper.readValue(jsonString, type);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	public static String getJsonNonNum(Object object) {
		String result = "";
		try {
			mapper.setSerializationInclusion(Include.NON_NULL);
			result = mapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof String) {
			return object.toString().trim().length() == 0;
		}
		if (object instanceof StringBuilder) {
			return object.toString().trim().length() == 0;
		}
		if (object instanceof List<?> || object instanceof ArrayList<?>) {
			return ((List<?>) object).isEmpty();
		}
		if (object instanceof Map<?, ?> || object instanceof HashMap<?, ?>) {
			return ((Map<?, ?>) object).isEmpty();
		}
		return false;
	}

	// Thymeleaf
	/*public static String procesarHMTLTemplate(String templateNombre, Map<String, Object> param) {
		TemplateEngine templateEngine = new TemplateEngine();
		ClassLoaderTemplateResolver  templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix(Constantes.HTML_TEMPLATE_PATH_MAIL);
		templateResolver.setSuffix(Constantes.HTML_TEMPLATE_SUFFIX_MAIL);
		templateResolver.setCharacterEncoding(Constantes.HTML_TEMPLATE_ENCODING_MAIL);
		templateResolver.setTemplateMode(Constantes.HTML_TEMPLATE_MODE_MAIL);
		templateResolver.setCacheable(false);
		templateEngine.setTemplateResolver(templateResolver);
		Context context = new Context();
		param.entrySet().stream().forEach(item -> context.setVariable(item.getKey(), item.getValue()));
		StringWriter stringWriter = new StringWriter();
		templateEngine.process(templateNombre, context, stringWriter);
		return tildesEnFormatoHtml(stringWriter.toString());
	}

	public static String tildesEnFormatoHtml(String str) {
		String strFormat = str;
		strFormat = strFormat.replace("\u00e1", "&aacute;");
		strFormat = strFormat.replace("\u00e9", "&eacute;");
		strFormat = strFormat.replace("\u00ed", "&iacute;");
		strFormat = strFormat.replace("\u00f3", "&oacute;");
		strFormat = strFormat.replace("\u00fa", "&uacute;");
		strFormat = strFormat.replace("\u00c1", "&Aacute;");
		strFormat = strFormat.replace("\u00c9", "&Eacute;");
		strFormat = strFormat.replace("\u00cd", "&Iacute;");
		strFormat = strFormat.replace("\u00d3", "&Oacute;");
		strFormat = strFormat.replace("\u00da", "&Uacute;");
		strFormat = strFormat.replace("\u00f1", "&ntilde;");
		strFormat = strFormat.replace("\u00d1", "&Ntilde;");
		strFormat = strFormat.replace("\u00B0", "&deg;");
		return strFormat;
	}*/

}
