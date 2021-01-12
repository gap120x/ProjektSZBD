package szbd.licensemanagementsystemapp.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ProductRepository extends JpaRepository<Product, Long>{
	
	 @Query("SELECT new szbd.licensemanagementsystemapp.products.ProductDto(p.id,s.name,s.releaseDate,s.description,p.price,p.currency) FROM Product p "
				+ "RIGHT JOIN p.software s")
	    public List<ProductDto> viewAllProduct();

}
