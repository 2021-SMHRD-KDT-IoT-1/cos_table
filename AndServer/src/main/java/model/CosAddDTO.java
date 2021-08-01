package model;

public class CosAddDTO {

	private String u_cos_id;
	private String id;
	private String cos_id;
	private String u_cos_date;
	private String amount;
	private String u_cos_dead;
	
	
	
	
	public CosAddDTO(String u_cos_id, String id, String cos_id, String u_cos_date, String amount, String u_cos_dead) {
		super();
		this.u_cos_id = u_cos_id;
		this.id = id;
		this.cos_id = cos_id;
		this.u_cos_date = u_cos_date;
		this.amount = amount;
		this.u_cos_dead = u_cos_dead;
	}
	public CosAddDTO(String u_cos_id, String id, String cos_id, String amount) {
		super();
		this.u_cos_id = u_cos_id;
		this.id = id;
		this.cos_id = cos_id;
		this.amount = amount;
	}

	public CosAddDTO(String u_cos_id, String amount) {
		super();
		this.u_cos_id = u_cos_id;
		this.amount = amount;
	}


	public String getU_cos_id() {
		return u_cos_id;
	}




	public void setU_cos_id(String u_cos_id) {
		this.u_cos_id = u_cos_id;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getCos_id() {
		return cos_id;
	}




	public void setCos_id(String cos_id) {
		this.cos_id = cos_id;
	}




	public String getU_cos_date() {
		return u_cos_date;
	}




	public void setU_cos_date(String u_cos_date) {
		this.u_cos_date = u_cos_date;
	}




	public String getAmount() {
		return amount;
	}




	public void setAmount(String amount) {
		this.amount = amount;
	}




	public String getU_cos_dead() {
		return u_cos_dead;
	}




	public void setU_cos_dead(String u_cos_dead) {
		this.u_cos_dead = u_cos_dead;
	}




	@Override
	public String toString() {
		return "CosAddDTO [u_cos_id="+u_cos_id+", id="+id+", cos_id="+cos_id+",u_cos_date="+u_cos_date+",amount="+amount+"u_cos_dead="+u_cos_dead+"]";
	}
	
}
