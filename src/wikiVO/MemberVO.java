package wikiVO;

import java.sql.Timestamp;

public class MemberVO {
	private String id;
	private String pwd;
	private String email;
	private String vandals;
	private String useyn;
	private Timestamp indate;
	
	public String getId() {
		return id;
	}
	public  MemberVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public MemberVO setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public MemberVO setEmail(String email) {
		this.email = email;
		return this;
	}	
	public String getVandals() {
		return vandals;
	}
	public void setVandals(String vandals) {
		this.vandals = vandals;
	}
	public String getUseyn() {
		return useyn;
	}
	public MemberVO setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public MemberVO setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
}