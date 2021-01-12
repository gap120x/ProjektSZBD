package szbd.licensemanagementsystemapp.productlists;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import szbd.licensemanagementsystemapp.orders.Order;

@Service
@Transactional
public class ProductListService {
	
	
	@Autowired
	private ProductListRepository repo;
	
	public List<ProductList> listAll(){
		return repo.findAll();
	}
	
	public void save(ProductList productList) {
		repo.save(productList);
	}
	
	public ProductList get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	public List <ProductListDto> ProductListonOrder(Order order)
	{
		return repo.ProductListonOrder(order);
	}
}
