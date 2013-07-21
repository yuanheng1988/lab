package cn.iscas.nfs.platform.coreservice.storage.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

import cn.iscas.nfs.platform.coreservice.storage.bean.ToolMap;
import cn.iscas.nfs.platform.coreservice.storage.utils.StringList;
import cn.iscas.nfs.platform.coreservice.storage.utils.ToolMapFromDB;


@Path("/toolmap")
public class GetToolMap {
	@POST
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public StringList getToolMap(@PathParam("userid") String uid) throws Exception{
		List<ToolMap> toolmaplist = ToolMapFromDB.getToolMap(uid);
		return new StringList(toolmaplist);
//		return toolmaplist.get(0);
		
		
	}
	

}
