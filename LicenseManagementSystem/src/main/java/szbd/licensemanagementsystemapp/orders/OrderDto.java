package szbd.licensemanagementsystemapp.orders;

import java.time.LocalDate;

import szbd.licensemanagementsystemapp.customers.Customer;

public class OrderDto {
	
	private Long orderird;
	private LocalDate orderDate;
 	private Float totalPrice;
 	private String status;
 	private Customer customer;
 	private String customername;
 	private String customersurname;
	public Long getOrderird() {
		return orderird;
	}
	
	
	
	
	public OrderDto(Long orderird, LocalDate orderDate, Float totalPrice, String status, Customer customer,
			String customername, String customersurname) {
		super();
		this.orderird = orderird;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.customer = customer;
		this.customername = customername;
		this.customersurname = customersurname;
	}

public Long getOrderid()
{
return orderird;	
}


	public void setOrderird(Long orderird) {
		this.orderird = orderird;
	}
	public LocalDate getOrderdate() {
		return orderDate;
	}
	public void setOrderdate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Float getTotalprice() {
		return totalPrice;
	}
	public void setTotalprice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomerid(Customer customer) {
		this.customer = customer;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomersurname() {
		return customersurname;
	}
	public void setCustomersurname(String customersurname) {
		this.customersurname = customersurname;
	}
 	
 	
 	

}
