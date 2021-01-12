package szbd.licensemanagementsystemapp.products;

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

import szbd.licensemanagementsystemapp.licenses.License;
import szbd.licensemanagementsystemapp.productlists.ProductList;
import szbd.licensemanagementsystemapp.softwares.Software;

@Entity
@Table(name = "product")
public class Product {
	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private Float price;
    private String currency;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "software_id", nullable = false)
    private Software software;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
  	private Set<License> license = new HashSet<License>();
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<ProductList> productlist = new HashSet<ProductList>();
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Software getSoftware() {
		return software;
	}
	public void setSoftware(Software software) {
		this.software = software;
	}
	public Set<License> getLicense() {
		return license;
	}
	public void setLicense(Set<License> license) {
		this.license = license;
	}
	public Set<ProductList> getProductlist() {
		return productlist;
	}
	public void setProductlist(Set<ProductList> productlist) {
		this.productlist = productlist;
	}
	
    }
