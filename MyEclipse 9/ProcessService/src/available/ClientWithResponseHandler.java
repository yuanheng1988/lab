package available;
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
	  public static String GetResponseData(String url,String tool) throws Exception {

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
            System.out.println(responseBody);
            
            //解析jira数据
            if (tool.equals("jira")){
            	Gson gson = new Gson();
                JiraData jd = gson.fromJson(responseBody, JiraData.class);
                System.out.println("show time~~~");
                JiraToDB.ImportIntoDB(jd); 
                jiratoDash = gson.toJson(jd);
//                jiratoDash = "key:" + jd.getKey() + "" + jd.getFields().getSummary()
//                System.out.println(jiratoDash);                
                return jiratoDash;
            }
            
            
            //解析bugzilla数据 
            else if(tool.equals("bugzilla")){
//            	String trans_responseBody = BugzillaTransform.Trans(responseBody);
                BugzillaData bd = new  BugzillaData();
                JSONObject root = new JSONObject(responseBody);
                bd.setComponet(root.getString("bugz:component"));
                bd.setOperatingSystem(root.getString("bugz:operatingSystem"));
                bd.setPlatform(root.getString("bugz:platform"));
                bd.setPriority(root.getString("bugz:priority"));
                bd.setVersion(root.getString("bugz:version"));
                bd.setTitle(root.getString("dcterms:title"));
                bd.setServiceProvider(root.getJSONObject("oslc:serviceProvider").getString("rdf:resource"));
                bd.setSeverity(root.getString("oslc_cm:severity"));
                bd.setStatus(root.getString("oslc_cm:status"));
                bd.setRdf_about(root.getString("rdf:about"));
                System.out.println("show time~~~~");
                BugzillaToDB.ImportIntoDB(bd);
                Gson gson = new Gson();
                String bugzillatoDash = gson.toJson(bd);
//                String bugzillatoDash = "component:" + bd.getComponet() + ";operatingSystem:" + bd.getOperatingSystem() + ";platform:" + 
//                		bd.getPlatform() + ";priority:" + bd.getPriority() + ";version:" + bd.getVersion() + ";title:" + 
//                		bd.getTitle() + ";resource:" + bd.getServiceProvider() + ";severity:" + bd.getSeverity() + ";status:" +
//                		bd.getStatus() + ";rdf_about:" + bd.getRdf_about(); 
//                System.out.println(bugzillatoDash);
                return bugzillatoDash;
            }
                       
            System.out.println("Done.");

        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
		return null;
		
    }

}

