package com.myOrg.myOtherTest;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Path("/text_to_speech")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Text_To_Speech {

	
	private static String urlToken = "https://stream.watsonplatform.net/authorization/api/v1/token?url=https://stream.watsonplatform.net/text-to-speech/api";
	private static String username = "a40922f0-4f6c-41fb-a213-440b72dae0c9";
	private static String password = "oOGJcUFP4qov";
	
	private HashMap<String,Object> tokenmap = new HashMap<String,Object>();
	
	@GET
	public HashMap<String,Object> getToken(){
		try {
			tokenmap.put("token", returnToken(urlToken));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tokenmap;
	}
	
	public static String returnToken(String url) throws IOException {
		OkHttpClient client1 = new OkHttpClient.Builder()
	    .addInterceptor(new BasicAuthInterceptor(username, password))
	    .build();
		
		
		  Request request = new Request.Builder()
		      .url(url)
		      .build();

		  Response response = client1.newCall(request).execute();
		  return response.body().string();
	}
	
	/**OkHttpClient client = new OkHttpClient();

	String run(String url) throws IOException {
	  Request request = new Request.Builder()
	      .url(url)
	      .build();

	  Response response = client.newCall(request).execute();
	  return response.body().string();
	}*/
	
	public static void main(String[] args){
		
		TextToSpeech service = new TextToSpeech();
		service.setUsernameAndPassword("a40922f0-4f6c-41fb-a213-440b72dae0c9", "oOGJcUFP4qov");
		
		//List<Voice> voices = service.getVoices().execute();
		//System.out.println(voices);
		
		/**Voice allison = service.getVoice("en-US_AllisonVoice").execute();
		System.out.println(allison);
		InputStream inputStream = service.synthesize("Hello World", allison).execute();
		System.out.println(inputStream);*/

		
		//"name": "en-US_AllisonVoice"
		
		//JSONParser jsonParse = new JSONParser(); gson simple json

		/*try {
		  String text = "Hello world";
		  InputStream stream = service.synthesize(text, Voice.EN_ALLISON,
		    AudioFormat.WAV).execute();
		  InputStream in = WaveUtils.reWriteWaveHeader(stream);
		  OutputStream out = new FileOutputStream("hello_world.wav");
		  byte[] buffer = new byte[1024];
		  int length;
		  while ((length = in.read(buffer)) > 0) {
		    out.write(buffer, 0, length);
		  }
		  out.close();
		  in.close();
		  stream.close();
		}
		catch (Exception e) {
		  e.printStackTrace();
		}
		
		InputStream inStream = service.synthesize("Hello world", Voice.EN_ALLISON,
				AudioFormat.OGG).execute();*/
		
		String url1 = "http://localhost:9080/myOtherTest/api/customers";
	
		String resp;
		try {
			resp = run(url1);
			System.out.println(resp);
			String resp2 = returnToken(urlToken);
			System.out.println(resp2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//OkHttpClient client = new OkHttpClient();
	
	
	
	public static String run(String url) throws IOException {
		OkHttpClient client = new OkHttpClient();
		  Request request = new Request.Builder()
		      .url(url)
		      .build();

		  Response response = client.newCall(request).execute();
		  return response.body().string();
	}
	
	
	/**JSONObject jsonObject = (JSONObject)jsonParser.parse(
		      new InputStreamReader(inputStream, "UTF-8"));*/
	
}