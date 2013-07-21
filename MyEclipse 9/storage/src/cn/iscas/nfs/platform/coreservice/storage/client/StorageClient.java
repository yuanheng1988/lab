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
import org.json.JSONObject;

import sun.rmi.runtime.Log;


import cn.iscas.nfs.platform.coreservice.storage.utils.ClientWithResponseHandler;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class StorageClient {

	public static void main(String[] args) throws Exception {
//		String url = "http://192.168.12.9:8080/rest/api/2.0.alpha1/issue/NFS-1";
		String url = "http://192.168.8.52:8080/OSLC4JBugzilla/services/3/changeRequests/4";
		String data = ClientWithResponseHandler.GetResponseData(url);
		System.out.println(data);
		post(data);
		System.out.println("maindone");
	}
   
	public static void post(String data) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(
				"http://localhost:8080/storage/services/dbstore/bugzilla");
		HttpResponse response = null;
		try {
			post.addHeader("Content-Type", "application/json");
			post.setEntity(new StringEntity(data, "UTF-8"));
			response = client.execute(post);

			System.out.println(response.getStatusLine().getStatusCode());
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
		}

	}

}
