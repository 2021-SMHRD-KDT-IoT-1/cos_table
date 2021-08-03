package model;

public class MemberDTO {
	
	private String id;
	private String pw;
	private String skintype;
	private String table_id;
	
	public MemberDTO(String id, String table_id, String pw, String skintype) {
		this.id = id;
		this.table_id = table_id;
		this.pw = pw;
		this.skintype = skintype;
	}
	
	
	public MemberDTO(String id, String pw, String skintype) {
		super();
		this.id = id;
		this.pw = pw;
		this.skintype = skintype;
	}


	public MemberDTO(String id, String pw) {
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
	
	public String getTable_id() {
		return table_id;
	}

	public void setTable_id(String table_id) {
		this.table_id = table_id;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", skintype=" + skintype + "]";
	}
}
