package szbd.licensemanagementsystemapp.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import szbd.licensemanagementsystemapp.customers.CustomerDto;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUserDto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
 
    @Query("SELECT u FROM User u WHERE u.nickname = :username")
    public User getUserByUsername(@Param("username") String username);

    @Query("SELECT new szbd.licensemanagementsystemapp.customers.CustomerDto(u.id,u.nickname,u.password,u.email,u.firstname,u.surname,u.role,"
    		+ "u.enabled,c.vat,c.nip,c.discount,c.companyName) "
			+ "FROM User u RIGHT JOIN u.customer c")
    public List<CustomerDto> viewCustomer();
    @Query("SELECT new szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUserDto(u.id,u.nickname,u.email,u.firstname,u.surname,u.role,"
    		+ "u.enabled,e.employmentDate,e.position,d.name,e.basicSalary,e.workingHours,c.salesTargetValue,c.salesTargetLicenses) "
			+ "FROM User u RIGHT JOIN u.employee e RIGHT JOIN e.customerServiceUser c INNER JOIN e.department d where u.role = :role")
    	public List<CustomerServiceUserDto> viewCustomerServiceUser(@Param("role") String role);
    
}