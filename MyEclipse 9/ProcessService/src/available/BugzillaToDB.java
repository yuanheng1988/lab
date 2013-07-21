package available;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class BugzillaToDB {
	
	public static void ImportIntoDB(BugzillaData bd) throws Exception{
		Connection con = (Connection) DBOperation.getConnection();
		PreparedStatement stmt = con.prepareStatement("INSERT INTO bugzilla" + 
			"(component,operatingSystem,platform,priority,version,title,serviceProvider,severity,status,rdf_about)" +
			" VALUES (?,?,?,?,?,?,?,?,?,?)");
		
		stmt.setString(1, bd.getComponet());
		stmt.setString(2, bd.getOperatingSystem());
		stmt.setString(3, bd.getPlatform());
		stmt.setString(4, bd.getPriority());
		stmt.setString(5, bd.getVersion());
		stmt.setString(6, bd.getTitle());
		stmt.setString(7, bd.getServiceProvider());
		stmt.setString(8, bd.getSeverity());
		stmt.setString(9, bd.getStatus());
		stmt.setString(10, bd.getRdf_about());
		
		stmt.execute();
		System.out.println("stored in db successfully");
		
		con.close();
	}

}
