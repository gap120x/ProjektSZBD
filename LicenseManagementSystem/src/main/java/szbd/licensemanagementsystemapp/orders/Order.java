package szbd.licensemanagementsystemapp.orders;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;
import szbd.licensemanagementsystemapp.employees.Employee;
import szbd.licensemanagementsystemapp.productlists.ProductList;

@Entity
@Table(name = "orders")
public class Order {
	
	 	@Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	private LocalDate orderDate;
	 	private Float totalPrice;
	 	private String status;
	 	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "customer_service_user_id", nullable = false)
	 	private CustomerServiceUser customerserviceuser;
	 	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "customer_id", nullable = false)
	 	private Customer customer;
	 	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
		private Set<ProductList> productlist = new HashSet<ProductList>();
	 	
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public Set<ProductList> getProductlist() {
			return productlist;
		}
		public void setProductlist(Set<ProductList> productlist) {
			this.productlist = productlist;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	 	
	 	

}
