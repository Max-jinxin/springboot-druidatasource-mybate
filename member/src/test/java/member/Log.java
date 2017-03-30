package member;

import java.beans.Transient;

public class Log {
	private String tranceid;
	private String seqid;
	private String appName;
	private String date;
	private String level;
	private String pid;
	
	
	
	@Transient
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Log() {
		
	}

	public String getSeqid() {
		return seqid;
	}

	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}

	

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Log [tranceid=" + tranceid + ", seqid=" + seqid + ", appName="
				+ appName + ", date=" + date + ", level=" + level + "]";
	}
	@Transient
	public String getTranceid() {
		return tranceid;
	}
	@Transient
	public void setTranceid(String tranceid) {
		this.tranceid = tranceid;
	}

	protected Log(String tranceid, String seqid, String appName, String date,
			String level) {
		super();
		this.tranceid = tranceid;
		this.seqid = seqid;
		this.appName = appName;
		this.date = date;
		this.level = level;
	}

	
	
	
}
