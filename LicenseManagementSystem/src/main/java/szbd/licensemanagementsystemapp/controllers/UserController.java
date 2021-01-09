package szbd.licensemanagementsystemapp.controllers;



import szbd.licensemanagementsystemapp.config.PasswordGenerator;
import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customers.CustomerService;
import szbd.licensemanagementsystemapp.users.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	@Autowired
	CustomerService customerservice;
	@Autowired
	PasswordGenerator generatepassword;
	

	@RequestMapping("/newaccount")
	public String ChooseAccountType(Model model) {		
		
	
		model.addAttribute("account",new AccountType());
		return "newaccount";        
}
	@RequestMapping(value="/newaccount",method=RequestMethod.POST)
	public String ChooseAccountTypePost(@ModelAttribute("account") AccountType accounttype) {
				
	
		String choose=accounttype.getRole();
		if(choose.equalsIgnoreCase("klient"))
		{			
			
			return "redirect:/newaccount/customer";
		}
		else if(choose.equalsIgnoreCase("sprzedawca"))
		{
			return "redirect:/newaccount/customerservice";
			
		}
		else if(choose.equalsIgnoreCase("menedzer"))
		{
			return "redirect:/newaccount/menager";
		}
		return null;	       
}
	@RequestMapping(value="/newaccount/customer")
	public String newClient(Model model)
	
	{
		model.addAttribute("newUser",new User());
		model.addAttribute("newCustomer",new Customer());
		return "newclient";
		
	}
	@RequestMapping(value="/newaccount/customer/save",method=RequestMethod.POST)
	public String saveCustomerAccount(@ModelAttribute("newUser") User user,@ModelAttribute("newCustomer") Customer customer,
			Model model)
	{
		
		customer.setUser(user);
		User userExists = userservice.getUserByUsername(user.getNickname());
		if(userExists != null)
		{
			model.addAttribute("newUser",user);
		    model.addAttribute("newCustomer", customer);
		    model.addAttribute("wrongusername","Nazwa Którą wpisałeś jest zajęta! Użyj innej.");
		    return "newclient";
		}
		else
		{
			
		customer.setUser(user);
		String pass=user.getPassword();
	    String codepass= generatepassword.encodepassword(pass);
	    user.setPassword(codepass); 
		userservice.save(user);		
		customerservice.save(customer);	 
		return "redirect:/newaccount";
		}
	


}
}
	

