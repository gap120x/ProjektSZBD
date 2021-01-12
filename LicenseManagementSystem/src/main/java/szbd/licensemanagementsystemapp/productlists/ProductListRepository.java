package szbd.licensemanagementsystemapp.productlists;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import szbd.licensemanagementsystemapp.orders.Order;



public interface ProductListRepository extends JpaRepository<ProductList, Long> {

	@Query("SELECT new szbd.licensemanagementsystemapp.productlists.ProductListDto(pl.id,pl.price,pl.quantity,pl.totalPrice,s.name,s.description) from ProductList pl "
			+ "INNER JOIN pl.product p INNER JOIN p.software s where order_id = :order")
	List <ProductListDto> ProductListonOrder(@Param("order") Order order);
	
}
