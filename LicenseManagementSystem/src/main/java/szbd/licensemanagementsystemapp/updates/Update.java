package szbd.licensemanagementsystemapp.updates;

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

import szbd.licensemanagementsystemapp.articles.Article;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;
@Entity
@Table(name="updates")
public class Update {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String changes;
	private LocalDate date;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "article_id", nullable = false)
	private Article article;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_service_user_id", nullable = false)
	private CustomerServiceUser customerserviceuser;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChanges() {
		return changes;
	}
	public void setChanges(String changes) {
		this.changes = changes;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public CustomerServiceUser getCustomerserviceuser() {
		return customerserviceuser;
	}
	public void setCustomerserviceuser(CustomerServiceUser customerserviceuser) {
		this.customerserviceuser = customerserviceuser;
	}
	
	

}
