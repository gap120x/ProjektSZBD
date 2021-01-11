package szbd.licensemanagementsystemapp.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import szbd.licensemanagementsystemapp.customers.CustomerDto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
 
    @Query("SELECT u FROM User u WHERE u.nickname = :username")
    public User getUserByUsername(@Param("username") String username);

    @Query("SELECT new szbd.licensemanagementsystemapp.customers.CustomerDto(u.id,u.nickname,u.password,u.email,u.firstname,u.surname,u.role,"
    		+ "u.enabled,c.vat,c.nip,c.discount,c.companyName) "
			+ "FROM User u RIGHT JOIN u.customer c")
    public List<CustomerDto> viewCustomer();
   
   
}