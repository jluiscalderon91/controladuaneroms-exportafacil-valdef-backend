package pe.gob.sunat.controladuaneroms.exportafacil.valdef.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.ConstantesUtils;
import pe.gob.sunat.tecnologiams.arquitectura.framework.microservices.util.UtilLog;

public class CallRestUtil{
	
	private static UtilLog utilLog = new UtilLog();

	public static Object consumirREST(String urlREST) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		Object response = null;
		utilLog.imprimirLog(ConstantesUtils.LEVEL_INFO, "****iniciar consumirREST:" + urlREST + "****");
		try {
			HttpGet httpGetRequest = new HttpGet(urlREST);
			HttpResponse httpResponse = httpclient.execute(httpGetRequest);

			HttpEntity entity = httpResponse.getEntity();
			
			byte[] buffer = new byte[1024];
			if (entity != null){
				InputStream inputStream = entity.getContent();
				
				try {
					int bytesRead = 0;
					BufferedInputStream bis = new BufferedInputStream(inputStream);
					StringBuffer sb = new StringBuffer();
					while ((bytesRead = bis.read(buffer)) != -1) {
						String trama = new String(buffer, 0, bytesRead);
						sb.append(trama);
					}
					inputStream.close();
					
		        	ObjectMapper mapper = new ObjectMapper();
		        	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		        	mapper.setSerializationInclusion(Include.ALWAYS);
		        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		        	mapper.setDateFormat(sdf.getDateInstance());
		        	
			        if (httpResponse.getStatusLine().getStatusCode() == 200) {
			        	response = mapper.readValue(sb.toString(), Object.class);
			        } else {
			        	response = null;
			        }
			        
			        utilLog.imprimirLog(ConstantesUtils.LEVEL_INFO, "****finalizar consumirREST:" + urlREST + "****");
					
				} catch (Exception e) {
					utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, "Ocurrio un error al consumir servicio: " + urlREST, e.getStackTrace());
				}
			}
			
		} catch (Exception e) {
			utilLog.imprimirLog(ConstantesUtils.LEVEL_ERROR, "Ocurrio un error al consumir servicio: " + urlREST, e.getStackTrace());
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		
		return response;
	}
}
