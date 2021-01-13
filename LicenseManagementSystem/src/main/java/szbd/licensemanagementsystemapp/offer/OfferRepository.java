package szbd.licensemanagementsystemapp.offer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;

public interface OfferRepository extends JpaRepository<Offer, Long>   {
	
	@Query("SELECT o FROM Offer o where o.customer = :customer ORDER BY o.date desc")
    	public List<Offer> viewOfferByCustomerr(@Param("customer") Customer customer);
	@Query("SELECT o FROM Offer o where o.customerserviceuser = :customerserviceuser ORDER BY o.date desc")
	public List<Offer> viewOfferByCustomerserviceuserr(@Param("customerserviceuser") CustomerServiceUser customerserviceuser);

}
