package model;

public class CosDeleteDTO {
	
	private String u_cos_id;
	private String state;

	public CosDeleteDTO(String u_cos_id, String state) {
		super();
		this.u_cos_id = u_cos_id;
		this.state = state;
		
	}


	public String getU_cos_id() {
		return u_cos_id;
	}

	public void setU_cos_id(String u_cos_id) {
		this.u_cos_id = u_cos_id;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}




	@Override
	public String toString() {
		return "CosDeleteDTO [u_cos_id="+u_cos_id+",state="+state+"]";
	}

}
