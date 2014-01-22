package android.sendbynfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;



import android.os.AsyncTask;
import android.util.Log;


public class SendHttpRequestClass  extends AsyncTask<String, Integer, String>{


	public SendHttpRequestClass() {
	
	}
	public void extraParams(String params){
		
	}

	@Override
	protected String doInBackground(String... arg0) {
		 StringBuilder builder = new StringBuilder();
		    HttpClient client = new DefaultHttpClient();
		    
		    try {
		    	
		    	HttpGet httpGet = new HttpGet(arg0[0]);
				HttpResponse response = client.execute(httpGet);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				if (statusCode == 200) {
				  HttpEntity entity = response.getEntity();
				  InputStream content = entity.getContent();
				  BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				  String line;
				  while ((line = reader.readLine()) != null) {
				    builder.append(line);
				  }
				} else {
					if (AppConst.ERROR)
						Log.e(SendHttpRequestClass.class.toString(), "Failed to download file");
				}
		    } 
		    catch (UnsupportedEncodingException e){
		    	e.printStackTrace();
		    }
		    catch (ClientProtocolException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (IllegalArgumentException  e) {
		    	e.printStackTrace();
		    }

		    return builder.toString();
		
	}

}
