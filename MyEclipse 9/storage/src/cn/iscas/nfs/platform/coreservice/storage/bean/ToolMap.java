package cn.iscas.nfs.platform.coreservice.storage.bean;

public class ToolMap {
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getToolName() {
		return toolName;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getRelateTask() {
		return relateTask;
	}
	public void setRelateTask(String relateTask) {
		this.relateTask = relateTask;
	}
	private String toolName;
	private String spName;
	private String projectName;
	private String relateTask;	
	

}
