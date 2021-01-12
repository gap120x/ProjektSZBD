package szbd.licensemanagementsystemapp.productlists;

public class ProductListDto {
	
	private Long productlistid;
	private float price;
	private int quantity;
	private Float totalPrice;
	private String name;
	private String description;
	public ProductListDto(Long productlistid, float price, int quantity, Float totalPrice, String name,
			String description) {
		super();
		this.productlistid = productlistid;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.name = name;
		this.description = description;
	}
	public Long getProductlistid() {
		return productlistid;
	}
	public void setProductlistid(Long productlistid) {
		this.productlistid = productlistid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Float getTotalprice() {
		return totalPrice;
	}
	public void setTotalprice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
