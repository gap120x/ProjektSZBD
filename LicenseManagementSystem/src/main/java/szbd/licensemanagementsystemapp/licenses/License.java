package szbd.licensemanagementsystemapp.licenses;

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
import szbd.licensemanagementsystemapp.products.Product;

@Entity
@Table(name = "license")
public class License {
	
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String licenseKey;
	 private LocalDate releaseDate;
	 private LocalDate expirationDate;
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "product_id", nullable = false)
	 private Product product;
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "customer_id", nullable = false)
	 private Customer customer;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLicensekey() {
		return licenseKey;
	}
	public void setLicensekey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	public LocalDate getReleasedate() {
		return releaseDate;
	}
	public void setReleasedate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public LocalDate getExpirationdate() {
		return expirationDate;
	}
	public void setExpirationdate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	 
	 
	 	

}
