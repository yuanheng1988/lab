package com.jerrys.jerseyrest.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import nfs.bean.BugzillaData;
import nfs.bean.JiraData;
import nfs.bean.JiraToDB;
import nfs.io.*;
import nfs.utils.BugzillaToDB;

import com.google.gson.Gson;



@Path("/insert")
public class InsertDB {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String storageJiraData(@Context HttpServletRequest request) throws Exception{
		String tool = request.getParameter("tool");
		String data = request.getParameter("data");
		
		 if (tool.equals("jira")){
			 Gson gson = new Gson();
             JiraData jd = gson.fromJson(data, JiraData.class);
             System.out.println("show time~~~");
             JiraToDB.ImportIntoDB(jd); 
             String jiratoDash = gson.toJson(jd);
             return jiratoDash;
         }
         
         
         //½âÎöbugzillaÊý¾Ý 
         else if(tool.equals("bugzilla")){
//         	String trans_responseBody = BugzillaTransform.Trans(responseBody);
             BugzillaData bd = new  BugzillaData();
             JSONObject root = new JSONObject(data);
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
             return bugzillatoDash;
         }
		return null;
	}
    
}
