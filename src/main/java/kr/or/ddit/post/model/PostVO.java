package kr.or.ddit.post.model;

import java.sql.Date;

public class PostVO {
	private String boardid;
	private String postid;
	private String parentid;
	private String title;
	private String cont;
	private Date dates;
	private String status;
	private String userid;
	
	
	public PostVO() {
	}


	public PostVO(String boardid, String postid, String parentid, String title, String cont, Date dates, String status,
			String userid) {
		this.boardid = boardid;
		this.postid = postid;
		this.parentid = parentid;
		this.title = title;
		this.cont = cont;
		this.dates = dates;
		this.status = status;
		this.userid = userid;
	}


	public String getBoardid() {
		return boardid;
	}


	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}


	public String getPostid() {
		return postid;
	}


	public void setPostid(String postid) {
		this.postid = postid;
	}


	public String getParentid() {
		return parentid;
	}


	public void setParentid(String parentid) {
		this.parentid = parentid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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
		result = prime * result + ((boardid == null) ? 0 : boardid.hashCode());
		result = prime * result + ((cont == null) ? 0 : cont.hashCode());
		result = prime * result + ((dates == null) ? 0 : dates.hashCode());
		result = prime * result + ((parentid == null) ? 0 : parentid.hashCode());
		result = prime * result + ((postid == null) ? 0 : postid.hashCode());
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
		PostVO other = (PostVO) obj;
		if (boardid == null) {
			if (other.boardid != null)
				return false;
		} else if (!boardid.equals(other.boardid))
			return false;
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
		if (parentid == null) {
			if (other.parentid != null)
				return false;
		} else if (!parentid.equals(other.parentid))
			return false;
		if (postid == null) {
			if (other.postid != null)
				return false;
		} else if (!postid.equals(other.postid))
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
		return "PostVO [boardid=" + boardid + ", postid=" + postid + ", parentid=" + parentid + ", title=" + title
				+ ", cont=" + cont + ", dates=" + dates + ", status=" + status + ", userid=" + userid + "]";
	}

}
