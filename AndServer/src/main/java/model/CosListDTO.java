package model;

public class CosListDTO {

	String u_cos_id;
	String cos_id;
	String cos_name;
	String cos_brand;
	String cos_price;
	String cos_type;
	String cos_allergy;
	String u_cos_date;
	String state;
	String igt1;
	String igt2;
	String igt3;
	String igt4;
	String igt5;
	
	
	public CosListDTO(String cos_name, String cos_brand, String cos_type, String igt1, String igt2, String igt3,
			String igt4, String igt5) {
		this.cos_name = cos_name;
		this.cos_brand = cos_brand;
		this.cos_type = cos_type;
		this.igt1 = igt1;
		this.igt2 = igt2;
		this.igt3 = igt3;
		this.igt4 = igt4;
		this.igt5 = igt5;
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



	public String getU_cos_id() {
		return u_cos_id;
	}


	public void setU_cos_id(String u_cos_id) {
		this.u_cos_id = u_cos_id;
	}



	public String getCos_id() {
		return cos_id;
	}


	public void setCos_id(String cos_id) {
		this.cos_id = cos_id;
	}


	public String getCos_price() {
		return cos_price;
	}


	public void setCos_price(String cos_price) {
		this.cos_price = cos_price;
	}


	public String getCos_allergy() {
		return cos_allergy;
	}


	public void setCos_allergy(String cos_allergy) {
		this.cos_allergy = cos_allergy;
	}


	public String getCos_name() {
		return cos_name;
	}
	
	public void setCos_name(String cos_name) {
		this.cos_name = cos_name;
	}
	
	public String getU_cos_date() {
		return u_cos_date;
	}
	
	public void setU_cos_date(String u_cos_date) {
		this.u_cos_date = u_cos_date;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public String getCos_brand() {
		return cos_brand;
	}

	public void setCos_brand(String cos_brand) {
		this.cos_brand = cos_brand;
	}

	public String getCos_type() {
		return cos_type;
	}

	public void setCos_type(String cos_type) {
		this.cos_type = cos_type;
	}

	public String getIgt1() {
		return igt1;
	}

	public void setIgt1(String igt1) {
		this.igt1 = igt1;
	}

	public String getIgt2() {
		return igt2;
	}

	public void setIgt2(String igt2) {
		this.igt2 = igt2;
	}

	public String getIgt3() {
		return igt3;
	}

	public void setIgt3(String igt3) {
		this.igt3 = igt3;
	}

	public String getIgt4() {
		return igt4;
	}

	public void setIgt4(String igt4) {
		this.igt4 = igt4;
	}

	public String getIgt5() {
		return igt5;
	}

	public void setIgt5(String igt5) {
		this.igt5 = igt5;
	}
	
	
	
}
