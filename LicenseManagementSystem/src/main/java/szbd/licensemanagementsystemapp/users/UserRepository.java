package szbd.licensemanagementsystemapp.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import szbd.licensemanagementsystemapp.customers.CustomerDto;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUserDto;
import szbd.licensemanagementsystemapp.customerserviceusers.EmployeeRaportDto;

import java.time.LocalDate;
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
    @Query("SELECT new szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUserDto(u.id,u.nickname,u.email,u.firstname,u.surname,u.role,"
    		+ "u.enabled,e.employmentDate,e.position,d.name,e.basicSalary,e.workingHours,c.salesTargetValue,c.salesTargetLicenses) "
			+ "FROM User u RIGHT JOIN u.employee e RIGHT JOIN e.customerServiceUser c INNER JOIN e.department d where u.role = :role and d.name = :name")
    	public List<CustomerServiceUserDto> viewCustomerServiceUserByManager(@Param("role") String role,@Param("name") String name);
    
    @Query("SELECT new szbd.licensemanagementsystemapp.customerserviceusers.EmployeeRaportDto(u.firstname , u.surname , SUM(o.totalPrice) , COUNT(o.id) , SUM(pl.quantity))"
    		+ "FROM User u INNER JOIN u.employee e INNER JOIN e.customerServiceUser csu INNER JOIN csu.order o INNER JOIN o.productlist pl INNER JOIN e.department d "
    		+ "where d.name= :name AND o.orderDate BETWEEN :datestart AND :dateend GROUP BY u.id ORDER BY SUM(o.totalPrice) desc")    	
    public List<EmployeeRaportDto> getEmployeesRaport(@Param("datestart") LocalDate datestart,@Param("dateend") LocalDate dateend,@Param("name") String name);
    
}