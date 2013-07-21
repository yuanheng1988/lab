package nfs.bean;

public class BugzillaData {
	private String componet;
	private String operatingSystem;
	private String platform;
	private String priority;
	private String version;
	public String getComponet() {
		return componet;
	}
	public void setComponet(String componet) {
		this.componet = componet;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRdf_about() {
		return rdf_about;
	}
	public void setRdf_about(String rdf_about) {
		this.rdf_about = rdf_about;
	}
	private String title;
	private String serviceProvider;
	private String severity;
	private String status;
	private String rdf_about;
}
