package szbd.licensemanagementsystemapp.products;

import java.time.LocalDate;

public class ProductDto {
	private Long productid;
	private String name;
    private LocalDate releaseDate;
    private String Description;
    private Float price;
    private String currency;
	public ProductDto(Long productid, String name, LocalDate releaseDate, String description, Float price,
			String currency) {
		super();
		this.productid = productid;
		this.name = name;
		this.releaseDate = releaseDate;
		Description = description;
		this.price = price;
		this.currency = currency;
	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getReleasedate() {
		return releaseDate;
	}
	public void setReleasedate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
    
    
}
