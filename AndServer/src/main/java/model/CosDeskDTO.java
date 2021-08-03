package model;

public class CosDeskDTO {

	private String table_id;
	private String solddate;
	
	public CosDeskDTO(String table_id, String solddate) {
		super();
		this.table_id = table_id;
		this.solddate = solddate;
	}

	public CosDeskDTO(String table_id) {
		super();
		this.table_id = table_id;
	}

	public String getTable_id() {
		return table_id;
	}

	public void setTable_id(String table_id) {
		this.table_id = table_id;
	}

	public String getSolddate() {
		return solddate;
	}

	public void setSolddate(String solddate) {
		this.solddate = solddate;
	}
	
	
}
