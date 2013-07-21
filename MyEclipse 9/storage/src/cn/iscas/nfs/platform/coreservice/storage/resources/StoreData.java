package cn.iscas.nfs.platform.coreservice.storage.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import org.json.JSONException;
import org.json.JSONObject;

import cn.iscas.nfs.platform.coreservice.storage.bean.*;
import cn.iscas.nfs.platform.coreservice.storage.utils.*;

import com.google.gson.Gson;



@Path("/dbstore")
public class StoreData {
	// @Context
	// HttpServletRequest servletrequest;

	@POST
	@Path("/{type}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void storeData(String data, @PathParam("type") String type)
			throws Exception {
		// String data = servletrequest.getParameter("data");
		// String type = servletrequest.getParameter("type");
		System.out.println("123");

		if (type.equals("jira")) {
			Gson gson = new Gson();
			JiraData jd = gson.fromJson(data, JiraData.class);
			System.out.println("show time~~~");
			JiraToDB.ImportIntoDB(jd);
			System.out.println("doneDB");
		}

		else if (type.equals("bugzilla")) {
			BugzillaData bd = new BugzillaData();
			JSONObject root = new JSONObject(data);
			bd.setComponet(root.getString("bugz:component"));
			bd.setOperatingSystem(root.getString("bugz:operatingSystem"));
			bd.setPlatform(root.getString("bugz:platform"));
			bd.setPriority(root.getString("bugz:priority"));
			bd.setVersion(root.getString("bugz:version"));
			bd.setTitle(root.getString("dcterms:title"));
			bd.setServiceProvider(root.getJSONObject("oslc:serviceProvider")
					.getString("rdf:resource"));
			bd.setSeverity(root.getString("oslc_cm:severity"));
			bd.setStatus(root.getString("oslc_cm:status"));
			bd.setRdf_about(root.getString("rdf:about"));
			System.out.println("show time~~~~");
			BugzillaToDB.ImportIntoDB(bd);
			System.out.println("doneDB");
		}
//		return "woqu!!!";
	}

}
