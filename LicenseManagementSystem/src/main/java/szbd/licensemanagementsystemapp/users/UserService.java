package szbd.licensemanagementsystemapp.users;
import org.springframework.stereotype.Service;

import szbd.licensemanagementsystemapp.customers.CustomerDto;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUserDto;
import szbd.licensemanagementsystemapp.customerserviceusers.EmployeeRaportDto;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Transactional
public class UserService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Nie Znaleziono Użytkownika");
        }
         
        return new MyUserDetails(user);
    }
  	
	public List<User> listAll(){
		return userRepository.findAll();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public User get(Long id) {
		return userRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	public User getUserByUsername(String username)
	{
		 User user = userRepository.getUserByUsername(username);
		 return user;
	}
	public List<CustomerDto> viewCustomer(){
		return userRepository.viewCustomer();
	}
	public List<CustomerServiceUserDto> viewCustomerServiceUser(String role){
		return userRepository.viewCustomerServiceUser(role);
	}
	public List<CustomerServiceUserDto> viewCustomerServiceUserByManager(String role,String name){
		return userRepository.viewCustomerServiceUserByManager(role,name);
	}
	 public List<EmployeeRaportDto> getEmployeesRaport(LocalDate datestart,LocalDate dateend,String name)
	 {
		return userRepository.getEmployeesRaport(datestart, dateend, name); 
	 }
	 
	 
}