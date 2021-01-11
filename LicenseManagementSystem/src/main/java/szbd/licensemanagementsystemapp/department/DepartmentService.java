package szbd.licensemanagementsystemapp.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentService {
	@Autowired
	private DepartmentRepository repo;
	
	public List<Department> listAll(){
		return repo.findAll();
	}
	
	public void save(Department department) {
		repo.save(department);
	}
	
	public Department get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}	
	

}
