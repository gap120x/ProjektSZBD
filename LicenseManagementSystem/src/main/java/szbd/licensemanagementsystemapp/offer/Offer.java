package szbd.licensemanagementsystemapp.offer;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;
@Entity
@Table(name = "offer")
public class Offer {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate expirationDate;
	private String description;
	private LocalDate date;
	private String status;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_service_user_id", nullable = false)
	private CustomerServiceUser customerserviceuser;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getExpirationdate() {
		return expirationDate;
	}
	public void setExpirationdate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CustomerServiceUser getCustomerserviceuser() {
		return customerserviceuser;
	}
	public void setCustomerserviceuser(CustomerServiceUser customerserviceuser) {
		this.customerserviceuser = customerserviceuser;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
