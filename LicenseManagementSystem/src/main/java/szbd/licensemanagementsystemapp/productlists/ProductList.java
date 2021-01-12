package szbd.licensemanagementsystemapp.productlists;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import szbd.licensemanagementsystemapp.orders.Order;
import szbd.licensemanagementsystemapp.products.Product;

@Entity
@Table(name = "product_list")
public class ProductList {
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;	
	private float price;
	private int quantity;
	private Float totalPrice;
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "product_id", nullable = false)
	private Product product;
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
	 public ProductList()
	 {
		 
	 }
	 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
	
	

}
