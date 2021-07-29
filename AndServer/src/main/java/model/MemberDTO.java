package model;

public class MemberDTO {
	
	private String id;
	private String pw;
	private String skintype;
	public MemberDTO(String id, String pw, String skintype) {
		super();
		this.id = id;
		this.pw = pw;
		this.skintype = skintype;
	}
	
	
	public MemberDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSkintype() {
		return skintype;
	}
	public void setSkintype(String skintype) {
		this.skintype = skintype;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", skintype=" + skintype + "]";
	}
}
