package szbd.licensemanagementsystemapp.offer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;

@Service
@Transactional
public class OfferService {
	
	@Autowired
	private OfferRepository repo;
	
	public List<Offer> listAll(){
		return repo.findAll();
	}
	
	public void save(Offer offer) {
		repo.save(offer);
	}
	
	public Offer get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	public List<Offer> viewOfferByCustomerr(Customer customer)
	{
		
		return repo.viewOfferByCustomerr(customer);
	}
	public List<Offer> viewOfferByCustomerserviceuserr(CustomerServiceUser customerserviceuser)
	{
		return repo.viewOfferByCustomerserviceuserr(customerserviceuser);
	}
}
