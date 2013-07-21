package cn.iscas.nfs.platform.coreservice.storage.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;

import cn.iscas.nfs.platform.coreservice.storage.bean.ToolMap;
import cn.iscas.nfs.platform.coreservice.storage.io.DBOperation;

import com.google.gson.Gson;


public class ToolMapFromDB {
	
	public static List<ToolMap> getToolMap(String uid) throws Exception{
		List<ToolMap> toolmapList = new ArrayList<ToolMap>();
		Gson gson = new Gson();
		
		Connection con = (Connection) DBOperation.getConnection();
		CallableStatement cStmt = con.prepareCall("{CALL select_toolmap(?)}");
		cStmt.setString(1, uid);
		cStmt.execute();
		ResultSet rs = cStmt.getResultSet();
		while(rs.next()){
			ToolMap toolmap = new ToolMap();
			toolmap.setUserId(rs.getString(1));
			toolmap.setToolName(rs.getString(2));
			toolmap.setSpName(rs.getString(3));
			toolmap.setProjectName(rs.getString(4));
			toolmap.setRelateTask(rs.getString(5));
			System.out.println(gson.toJson(toolmap) + new Date());
//			toolmapList.add(gson.toJson(toolmap));
			toolmapList.add(toolmap);
		}
		return toolmapList;
		
	}
}
