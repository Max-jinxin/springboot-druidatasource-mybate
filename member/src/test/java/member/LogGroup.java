package member;

import java.util.ArrayList;
import java.util.List;

public class LogGroup {
	private String minTime;
	private String maxTime;
	private boolean haveError;
	private String appName;
	private  List<Log> list=new ArrayList<Log>();
	public String getMinTime() {
		return minTime;
	}
	public void setMinTime(String minTime) {
		this.minTime = minTime;
	}
	public String getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(String maxTime) {
		this.maxTime = maxTime;
	}
	public boolean isHaveError() {
		return haveError;
	}
	public void setHaveError(boolean haveError) {
		this.haveError = haveError;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public List<Log> getList() {
		return list;
	}
	public void setList(List<Log> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "LogGroup [minTime=" + minTime + ", maxTime=" + maxTime
				+ ", haveError=" + haveError + ", appName=" + appName
				+ ", list=" + list + "]";
	}
	
	
	

}
