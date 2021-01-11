package szbd.licensemanagementsystemapp.customerserviceusers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceUserService {

	@Autowired
	private CustomerServiceUserRepository repo;
	
	public List<CustomerServiceUser> listAll(){
		return repo.findAll();
	}
	
	public void save(CustomerServiceUser customerserviceuser) {
		repo.save(customerserviceuser);
	}
	
	public CustomerServiceUser get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}	
	
}
