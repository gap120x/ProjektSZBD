package szbd.licensemanagementsystemapp.licenses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import szbd.licensemanagementsystemapp.customers.Customer;


public interface LicenseRepository extends JpaRepository<License, Long> {
	
	
	@Query("SELECT new szbd.licensemanagementsystemapp.licenses.LicenseDto(l.id,l.licenseKey,l.releaseDate,l.expirationDate,s.name) "
			+ "FROM License l INNER JOIN l.product p INNER JOIN p.software s where l.customer = :customer")
    	public List<LicenseDto> viewLicenseByCustomer(@Param("customer") Customer customer);

}
