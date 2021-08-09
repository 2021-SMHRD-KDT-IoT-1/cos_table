package model;

public class CosListDTO {

	String cos_id;
	String cos_name;
	String cos_brand;
	String cos_price;
	String cos_type;
	String cos_allergy;
	String u_cos_id;
	String id;
	String u_cos_date;
	String amount;
	String u_cos_dead;
	String state;
	
	
	

	public CosListDTO(String u_cos_id, String cos_id, String u_cos_dead, String cos_name) {
		super();
		this.u_cos_id = u_cos_id;
		this.cos_id = cos_id;
		this.cos_name = cos_name;
		this.u_cos_dead = u_cos_dead;
	}


	public CosListDTO(String cos_name, String u_cos_date, String state) {
		this.cos_name = cos_name;
		this.u_cos_date = u_cos_date;
		this.state = state;
	}
	
	
	public CosListDTO(String u_cos_id, String state) {
		this.u_cos_id = u_cos_id;
		this.state = state;
	}


	public String getCos_id() {
		return cos_id;
	}


	public void setCos_id(String cos_id) {
		this.cos_id = cos_id;
	}


	public String getCos_name() {
		return cos_name;
	}


	public void setCos_name(String cos_name) {
		this.cos_name = cos_name;
	}


	public String getCos_brand() {
		return cos_brand;
	}


	public void setCos_brand(String cos_brand) {
		this.cos_brand = cos_brand;
	}


	public String getCos_price() {
		return cos_price;
	}


	public void setCos_price(String cos_price) {
		this.cos_price = cos_price;
	}


	public String getCos_type() {
		return cos_type;
	}


	public void setCos_type(String cos_type) {
		this.cos_type = cos_type;
	}


	public String getCos_allergy() {
		return cos_allergy;
	}


	public void setCos_allergy(String cos_allergy) {
		this.cos_allergy = cos_allergy;
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


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	
}