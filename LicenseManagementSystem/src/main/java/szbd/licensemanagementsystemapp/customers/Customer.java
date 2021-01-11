package szbd.licensemanagementsystemapp.customers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import szbd.licensemanagementsystemapp.adress.BillingAddress;
import szbd.licensemanagementsystemapp.users.*;


@Entity
@Table(name="customer")
public class Customer {
		@Id
	    @Column(name = "ID")
	    private Long id;
	  	private String vat;
	  	private String nip;
	  	private float discount;
	  	private String companyName;	  	
	  	@OneToOne
	    @MapsId
	    @JoinColumn(name = "ID")
	    private User user;
	  	@OneToOne(fetch = FetchType.LAZY, optional = true)
	     @JoinColumn(name = "billing_address_id", nullable = true)
	  	private BillingAddress billingAddress;
	  	
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getVat() {
			return vat;
		}
		public void setVat(String vat) {
			this.vat = vat;
		}
		public String getNip() {
			return nip;
		}
		public void setNip(String nip) {
			this.nip = nip;
		}
		public float getDiscount() {
			return discount;
		}
		public void setDiscount(float discount) {
			this.discount = discount;
		}
		public String getCompanyname() {
			return companyName;
		}
		public void setCompanyname(String companyName) {
			this.companyName = companyName;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public BillingAddress getBillingaddress() {
			return billingAddress;
		}
		public void setBillingaddress(BillingAddress billingAddress) {
			this.billingAddress = billingAddress;
		}
		
	  	
	  	
		
	  	
	  	
	  	
}