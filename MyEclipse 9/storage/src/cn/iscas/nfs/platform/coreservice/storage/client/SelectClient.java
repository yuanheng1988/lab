package cn.iscas.nfs.platform.coreservice.storage.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sun.rmi.runtime.Log;


import cn.iscas.nfs.platform.coreservice.storage.utils.ClientWithResponseHandler;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class SelectClient {

	public static void main(String[] args) throws Exception {
		String userid = "nfs";
		post(userid);
		System.out.println("maindone");
	}
   
	public static void post(String userid) throws JSONException {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(
				"http://localhost:8080/storage/services/toolmap/" + userid);
		HttpResponse response = null;
		try {
			post.addHeader("Content-Type", "application/json");
			response = client.execute(post);

			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.toString());
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){  
				String result = EntityUtils.toString(response.getEntity());
	            //得到返回的字符串  
				System.out.println(result);
				JSONObject root = new JSONObject(result);
				JSONArray tool = root.getJSONArray("data");
	            System.out.println(tool.get(2)); 
	            
	            //打印输出  
	            //如果是下载文件,可以用response.getEntity().getContent()返回InputStream  
//	            return resultjson;
	        }  
			System.out.println("postdone");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
//		return null;
		

	}

}
