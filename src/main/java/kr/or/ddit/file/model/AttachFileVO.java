package kr.or.ddit.file.model;

public class AttachFileVO {
	
	private String fileid;
	private String filenm;
	private String realfilename;
	private String postid;
	
	
	public AttachFileVO() {
	}


	public AttachFileVO(String fileid, String filenm, String realfilename, String postid) {
		this.fileid = fileid;
		this.filenm = filenm;
		this.realfilename = realfilename;
		this.postid = postid;
	}


	public String getFileid() {
		return fileid;
	}


	public void setFileid(String fileid) {
		this.fileid = fileid;
	}


	public String getFilenm() {
		return filenm;
	}


	public void setFilenm(String filenm) {
		this.filenm = filenm;
	}


	public String getRealfilename() {
		return realfilename;
	}


	public void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}


	public String getPostid() {
		return postid;
	}


	public void setPostid(String postid) {
		this.postid = postid;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileid == null) ? 0 : fileid.hashCode());
		result = prime * result + ((filenm == null) ? 0 : filenm.hashCode());
		result = prime * result + ((postid == null) ? 0 : postid.hashCode());
		result = prime * result + ((realfilename == null) ? 0 : realfilename.hashCode());
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
		AttachFileVO other = (AttachFileVO) obj;
		if (fileid == null) {
			if (other.fileid != null)
				return false;
		} else if (!fileid.equals(other.fileid))
			return false;
		if (filenm == null) {
			if (other.filenm != null)
				return false;
		} else if (!filenm.equals(other.filenm))
			return false;
		if (postid == null) {
			if (other.postid != null)
				return false;
		} else if (!postid.equals(other.postid))
			return false;
		if (realfilename == null) {
			if (other.realfilename != null)
				return false;
		} else if (!realfilename.equals(other.realfilename))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AttachFileVO [fileid=" + fileid + ", filenm=" + filenm + ", realfilename=" + realfilename + ", postid="
				+ postid + "]";
	}
	
	
}
