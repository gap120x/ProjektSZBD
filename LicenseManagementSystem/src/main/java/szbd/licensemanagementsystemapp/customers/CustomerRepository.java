package szbd.licensemanagementsystemapp.customers;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	

}
