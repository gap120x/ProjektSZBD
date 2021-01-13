package szbd.licensemanagementsystemapp.articles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService {
	
	@Autowired
	private ArticleRepository repo;
	
	public List<Article> listAll(){
		return repo.findAll();
	}
	
	public void save(Article article) {
		repo.save(article);
	}
	
	public Article get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
