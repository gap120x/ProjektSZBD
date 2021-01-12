package szbd.licensemanagementsystemapp.softwares;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SoftwareService {
	
	@Autowired
	private SoftwareRepository repo;
	
	public List<Software> listAll(){
		return repo.findAll();
	}
	
	public void save(Software software) {
		repo.save(software);
	}
	
	public Software get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}	

}
