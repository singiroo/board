package kr.or.ddit.repl.model;

import java.sql.Date;

public class ReplVO {
	
	private String replid;
	private String postid;
	private String cont;
	private Date dates;
	private String title;
	private String status;
	private String userid;
	
		
	public ReplVO() {
	}
	
	
	public ReplVO(String replid, String postid, String cont, Date dates, String title, String status, String userid) {
		this.replid = replid;
		this.postid = postid;
		this.cont = cont;
		this.dates = dates;
		this.title = title;
		this.status = status;
		this.userid = userid;
	}
	
	public String getReplid() {
		return replid;
	}
	public void setReplid(String replid) {
		this.replid = replid;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cont == null) ? 0 : cont.hashCode());
		result = prime * result + ((dates == null) ? 0 : dates.hashCode());
		result = prime * result + ((postid == null) ? 0 : postid.hashCode());
		result = prime * result + ((replid == null) ? 0 : replid.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplVO other = (ReplVO) obj;
		if (cont == null) {
			if (other.cont != null)
				return false;
		} else if (!cont.equals(other.cont))
			return false;
		if (dates == null) {
			if (other.dates != null)
				return false;
		} else if (!dates.equals(other.dates))
			return false;
		if (postid == null) {
			if (other.postid != null)
				return false;
		} else if (!postid.equals(other.postid))
			return false;
		if (replid == null) {
			if (other.replid != null)
				return false;
		} else if (!replid.equals(other.replid))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReplVO [replid=" + replid + ", postid=" + postid + ", cont=" + cont + ", dates=" + dates + ", title="
				+ title + ", status=" + status + ", userid=" + userid + "]";
	}
	
	

}
