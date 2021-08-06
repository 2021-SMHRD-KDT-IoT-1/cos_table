package model;

public class CosDetailDTO {
	private String cos_name;
	private String cos_brand;
	private String cos_type;
	private String cos_id;
	
	public CosDetailDTO(String cos_name, String cos_brand, String cos_type, String cos_id) {
		super();
		this.cos_name = cos_name;
		this.cos_brand = cos_brand;
		this.cos_type = cos_type;
		this.cos_id = cos_id;
	}
	
	public CosDetailDTO(String cos_name, String cos_brand, String cos_type) {
		super();
		this.cos_name = cos_name;
		this.cos_brand = cos_brand;
		this.cos_type = cos_type;
	}
	public CosDetailDTO() {
		
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
	public String getCos_type() {
		return cos_type;
	}
	public void setCos_type(String cos_type) {
		this.cos_type = cos_type;
	}
	public String getCos_id() {
		return cos_id;
	}
	public void setCos_id(String cos_id) {
		this.cos_id = cos_id;
	}
	
	
	
	
	
	
}
