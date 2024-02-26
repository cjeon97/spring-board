package board.repository;

import java.time.LocalDateTime;

public class Board {
	private Long num;
	private String title;
	private String content;
	private LocalDateTime regdate;
	private Long readcnt;
	
	public Board(Long num, String title, String content, LocalDateTime regdate, Long readcnt) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.readcnt = readcnt;
	}
	
	public Board() {
		
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}

	public Long getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(Long readcnt) {
		this.readcnt = readcnt;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", readcnt="
				+ readcnt + "]";
	}
	
	
	
	
}
