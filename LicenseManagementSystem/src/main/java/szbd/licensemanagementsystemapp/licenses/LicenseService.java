package szbd.licensemanagementsystemapp.licenses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LicenseService {
	
	@Autowired
	private LicenseRepository repo;
	
	public List<License> listAll(){
		return repo.findAll();
	}
	
	public void save(License license) {
		repo.save(license);
	}
	
	public License get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}	

}
