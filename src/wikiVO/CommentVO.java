package wikiVO;

import java.sql.Timestamp;

public class CommentVO {
	private int no; //번호
	private int nno; //주제별 댓글번호
	private String fid; //작성자아이디
	private String title; //작성된 주제
	private String text; //작성된 내용
	private String id; //코멘아이디
	private String commen; //댓글
	private Timestamp indate; //시간
	
	public int getNo() {
		return no;
	}
	public CommentVO setNo(int no) {
		this.no = no;
		return this;
	}
	public int getNno() {
		return nno;
	}
	public CommentVO setNno(int nno) {
		this.nno = nno;
		return this;
	}
	public String getFid() {
		return fid;
	}
	public CommentVO setFid(String fid) {
		this.fid = fid;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public CommentVO setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getText() {
		return text;
	}
	public CommentVO setText(String text) {
		this.text = text;
		return this;
	}
	public String getId() {
		return id;
	}
	public CommentVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getCommen() {
		return commen;
	}
	public CommentVO setCommen(String commen) {
		this.commen = commen;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public CommentVO setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	
	
}