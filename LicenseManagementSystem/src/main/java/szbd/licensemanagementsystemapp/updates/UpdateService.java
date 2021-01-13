package szbd.licensemanagementsystemapp.updates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UpdateService {
	
	@Autowired
	private UpdateRepository repo;
	
	public List<Update> listAll(){
		return repo.findAll();
	}
	
	public void save(Update update) {
		repo.save(update);
	}
	
	public Update get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
