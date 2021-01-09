package szbd.licensemanagementsystemapp.users;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

}