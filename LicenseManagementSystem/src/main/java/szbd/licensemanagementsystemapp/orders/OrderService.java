package szbd.licensemanagementsystemapp.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.licenses.LicenseDto;
@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	public List<Order> listAll(){
		return repo.findAll();
	}
	
	public void save(Order order) {
		repo.save(order);
	}
	
	public Order get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	public long maxid()
	{
		return repo.maxid();
	}
	public List<OrderDto> viewOrderByCustomerr(Customer customer)
	{
		return repo.viewOrderByCustomerr(customer);
	}
	
}
