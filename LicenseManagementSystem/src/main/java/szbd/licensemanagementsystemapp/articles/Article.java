package szbd.licensemanagementsystemapp.articles;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import szbd.licensemanagementsystemapp.updates.Update;


@Entity
@Table(name="article")
public class Article {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String text;
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Update> update = new HashSet<Update>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Set<Update> getUpdate() {
		return update;
	}
	public void setUpdate(Set<Update> update) {
		this.update = update;
	}
	
	
	

}
