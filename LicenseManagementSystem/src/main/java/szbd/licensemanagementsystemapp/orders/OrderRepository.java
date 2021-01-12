package szbd.licensemanagementsystemapp.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository  extends JpaRepository<Order, Long>  {
	
	@Query("select max(o.id) from Order o")
	long maxid();

}
