package available;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JiraToDB {
	public static void ImportIntoDB(JiraData jd) throws Exception{
		Connection con = (Connection) DBOperation.getConnection();
		PreparedStatement stmt = con.prepareStatement("INSERT INTO jira" + 
			"(keyname,summary,description,comment,transitions)" +
			" VALUES (?,?,?,?,?)");
		
		stmt.setString(1, jd.getKey());
		stmt.setString(2, jd.getFields().getSummary().getValue());
		stmt.setString(3, jd.getFields().getDescription().getValue());
		String comments = null;
		for(int i=0;i<jd.getFields().getComment().getValue().size();i++)
			comments += jd.getFields().getComment().getValue().get(i) + ";";
		stmt.setString(4, comments);
		stmt.setString(5, jd.getTransitions());
		
		stmt.execute();
		System.out.println("stored in db successfully");
		
		con.close();
	}

}
