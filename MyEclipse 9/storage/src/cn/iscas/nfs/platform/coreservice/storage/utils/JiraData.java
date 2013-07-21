package cn.iscas.nfs.platform.coreservice.storage.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

class timetracking_val {
	private String timeoriginalestimate;
	private String timeestimate;

	public String getTimeoriginalestimate() {
		return timeoriginalestimate;
	}

	public void setTimeoriginalestimate(String timeoriginalestimate) {
		this.timeoriginalestimate = timeoriginalestimate;
	}

	public String getTimeestimate() {
		return timeestimate;
	}

	public void setTimeestimate(String timeestimate) {
		this.timeestimate = timeestimate;
	}

}

class issuetype_val {
	private String self;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSubtask() {
		return subtask;
	}

	public void setSubtask(boolean subtask) {
		this.subtask = subtask;
	}

	private String name;
	private boolean subtask;
}

class votes_val {
	private String self;
	private int votes;
	private boolean hasVoted;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public boolean isHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
}

class fixVersions_val {
	private String self;

}

class reporter_assignee_val {
	private String self;
	private String name;
	private String displayName;
	private boolean active;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}

class priority_val {
	private String self;
	private String name;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class status_val {
	private String self;
	private String name;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class watcher_val {
	private String self;
	private boolean isWatching;
	private int watchCount;

}

class project_val {
	private String self;
	private String name;
	private Role roles;
}

class NTVdesc_arrayval {
	private String name;
	private String type;
	private List<String> value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}
}

class NTVdesc_orig {
	private String name;
	private String type;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

class NTVdesc_valueisTimetracking {
	private String name;
	private String type;
	private timetracking_val value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public timetracking_val getValue() {
		return value;
	}

	public void setValue(timetracking_val value) {
		this.value = value;
	}
}

// 从issuetype开始省略，抽取最重要的信息，其余信息以后补上。

class bug_field {
	private NTVdesc_orig summary;

	public NTVdesc_orig getSummary() {
		return summary;
	}

	public void setSummary(NTVdesc_orig summary) {
		this.summary = summary;
	}

	public NTVdesc_orig getDescription() {
		return description;
	}

	public void setDescription(NTVdesc_orig description) {
		this.description = description;
	}

	public NTVdesc_arrayval getComment() {
		return comment;
	}

	public void setComment(NTVdesc_arrayval comment) {
		this.comment = comment;
	}

	private NTVdesc_orig description;
	private NTVdesc_arrayval comment;
}

@XmlRootElement
public class JiraData {
	private String key;
	private bug_field fields;
	private String transitions;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public bug_field getFields() {
		return fields;
	}

	public void setFields(bug_field fields) {
		this.fields = fields;
	}

	public String getTransitions() {
		return transitions;
	}

	public void setTransitions(String transitions) {
		this.transitions = transitions;
	}

}
