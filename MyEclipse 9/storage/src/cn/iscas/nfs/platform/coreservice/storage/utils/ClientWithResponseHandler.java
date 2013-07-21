package cn.iscas.nfs.platform.coreservice.storage.utils;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import org.json.*;
/**
 * This example demonstrates the use of the {@link ResponseHandler} to simplify
 * the process of processing the HTTP response and releasing associated resources.
 */
public class ClientWithResponseHandler {

//    public static void main(String[] args) throws Exception {
	  public static String GetResponseData(String url) throws Exception {

        HttpClient httpclient = new DefaultHttpClient();
        String jiratoDash = null;
        try {
//            HttpGet httpget = new HttpGet("http://192.168.12.9:8080/rest/api/2.0.alpha1/issue/NFS-1");
//        	HttpGet httpget = new HttpGet("http://192.168.8.52:8080/OSLC4JBugzilla/services/2/changeRequests/6");
        	HttpGet httpget = new HttpGet(url);
            //返回网页版
            // httpget.setHeader("Accept", "text/html");
            //返回XML格式
            // httpget.setHeader("Accept", "application/xml");
            //返回json格式
             httpget.setHeader("Accept", "application/json");
            //返回rdf格式
           // httpget.setHeader("Accept", "application/rdf+xml");

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);
            return responseBody;
            

        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
		
    }

}

