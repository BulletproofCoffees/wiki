package wikiVO;

import java.sql.Timestamp;

public class WikiVO {
	private int wseq;
	private String kind;
	private String title;
	private String content;	
	private String id;
	private String image;
	private Timestamp indate;
	
	public int getWseq() {
		return wseq;
	}
	public void setWseq(int wseq) {
		this.wseq = wseq;
	}
	public String getKind() {
		return kind;
	}
	public WikiVO setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public WikiVO setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public WikiVO setContent(String content) {
		this.content = content;
		return this;
	}
	public String getImage() {
		return image;
	}
	public WikiVO setImage(String image) {
		this.image = image;
		return this;
	}
	public String getId() {
		return id;
	}
	public WikiVO setId(String id) {
		this.id = id;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public WikiVO setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
}