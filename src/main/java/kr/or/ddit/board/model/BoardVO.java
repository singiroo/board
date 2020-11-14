package kr.or.ddit.board.model;

public class BoardVO {
	
	private String boardid;
	private String boardnm;
	private String boardstatus;
	private String userid;
	
	public BoardVO() {
	}
	
	public BoardVO(String boardid, String boardnm, String boardstatus, String userid) {
		this.boardid = boardid;
		this.boardnm = boardnm;
		this.boardstatus = boardstatus;
		this.userid = userid;
	}

	public String getBoardid() {
		return boardid;
	}

	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	public String getBoardnm() {
		return boardnm;
	}

	public void setBoardnm(String boardnm) {
		this.boardnm = boardnm;
	}

	public String getBoardstatus() {
		return boardstatus;
	}

	public void setBoardstatus(String boardstatus) {
		this.boardstatus = boardstatus;
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
		result = prime * result + ((boardnm == null) ? 0 : boardnm.hashCode());
		result = prime * result + ((boardstatus == null) ? 0 : boardstatus.hashCode());
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
		BoardVO other = (BoardVO) obj;
		if (boardid == null) {
			if (other.boardid != null)
				return false;
		} else if (!boardid.equals(other.boardid))
			return false;
		if (boardnm == null) {
			if (other.boardnm != null)
				return false;
		} else if (!boardnm.equals(other.boardnm))
			return false;
		if (boardstatus == null) {
			if (other.boardstatus != null)
				return false;
		} else if (!boardstatus.equals(other.boardstatus))
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
		return "BoardVO [boardid=" + boardid + ", boardnm=" + boardnm + ", boardstatus=" + boardstatus + ", userid="
				+ userid + "]";
	}
	
}
