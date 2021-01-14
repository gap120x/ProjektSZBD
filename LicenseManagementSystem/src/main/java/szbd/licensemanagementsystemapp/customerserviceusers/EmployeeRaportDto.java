package szbd.licensemanagementsystemapp.customerserviceusers;

import java.text.DecimalFormat;

public class EmployeeRaportDto {
	
	private String firstname;
	private String surname;
	private Double orderssum;
	private Long ordersquantity;
	private Long productsum;
	 private static DecimalFormat df = new DecimalFormat("0.00");
	public EmployeeRaportDto(String firstname, String surname, Double orderssum, Long ordersquantity, Long productsum) {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.orderssum = orderssum;
		this.ordersquantity = ordersquantity;
		this.productsum = productsum;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getOrderssum() {
		return df.format(orderssum);
	}
	public void setOrderssum(Double orderssum) {
		this.orderssum = orderssum;
	}
	public Long getOrdersquantity() {
		return ordersquantity;
	}
	public void setOrdersquantity(Long ordersquantity) {
		this.ordersquantity = ordersquantity;
	}
	public Long getProductsum() {
		return productsum;
	}
	public void setProductsum(Long productsum) {
		this.productsum = productsum;
	}
	
	
	
	
	

}
