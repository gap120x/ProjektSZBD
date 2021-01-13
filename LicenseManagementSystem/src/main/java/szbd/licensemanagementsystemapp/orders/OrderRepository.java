package szbd.licensemanagementsystemapp.orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.licenses.LicenseDto;

public interface OrderRepository  extends JpaRepository<Order, Long>  {
	
	@Query("select max(o.id) from Order o")
	long maxid();
	
	@Query("SELECT new szbd.licensemanagementsystemapp.orders.OrderDto(o.id,o.orderDate,o.totalPrice,o.status,o.customer,u.firstname,u.surname) "
			+ "FROM Order o INNER JOIN o.customer c INNER JOIN c.user u where o.customer = :customer")
    	public List<OrderDto> viewOrderByCustomerr(@Param("customer") Customer customer);

}
