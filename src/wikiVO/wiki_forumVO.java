package wikiVO;

import java.sql.Timestamp;

public class wiki_forumVO {
	private int no; //글번호
	private String id; //아이디
	private String title;//제목
	private String text; //내용
	private String commen; //댓글
	private Timestamp indate; //시간
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCommen() {
		return commen;
	}
	public void setCommen(String commen) {
		this.commen = commen;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
}
