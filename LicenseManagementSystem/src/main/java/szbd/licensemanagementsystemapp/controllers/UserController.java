package szbd.licensemanagementsystemapp.controllers;



import szbd.licensemanagementsystemapp.config.PasswordGenerator;
import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customers.CustomerDto;
import szbd.licensemanagementsystemapp.customers.CustomerService;
import szbd.licensemanagementsystemapp.users.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		else if(choose.equalsIgnoreCase("manager"))
		{
			return "redirect:/newaccount/manager";
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
	
	@RequestMapping("/accountlist")
	public String ChooseAccountTypeToView(Model model) {		
		
	
		model.addAttribute("account",new AccountType());
		return "accountlist";        
}
	@RequestMapping(value="/accountlist",method=RequestMethod.POST)
	public String ChooseAccountTypetoViewPost(@ModelAttribute("account") AccountType accounttype) {
				
	
		String choose=accounttype.getRole();
		if(choose.equalsIgnoreCase("klient"))
		{			
			
			return "redirect:/accountlist/customer";
		}
		else if(choose.equalsIgnoreCase("sprzedawca"))
		{
			return "redirect:/accountlist/customerservice";
			
		}
		else if(choose.equalsIgnoreCase("manager"))
		{
			return "redirect:/accountlist/manager";
		}
		return null;	       
}
	
	@RequestMapping("/accountlist/customer")
	public String ViewCustomers(Model model) {		
		
		List<CustomerDto> customerlist =userservice.viewCustomer();
		model.addAttribute("customerlist",customerlist);
		
		return "customerlist";        
}
	
	@RequestMapping("/manageaccount")
	public String ChooseAccountTypetoEdit(Model model) {		
		
	
		model.addAttribute("account",new AccountType());
		return "manageaccount";        
}
	@RequestMapping(value="/manageaccount",method=RequestMethod.POST)
	public String ChooseAccountTypetoEditPost(@ModelAttribute("account") AccountType accounttype) {
				
	
		String choose=accounttype.getRole();
		if(choose.equalsIgnoreCase("klient"))
		{			
			
			return "redirect:/manageaccount/customer";
		}
		else if(choose.equalsIgnoreCase("sprzedawca"))
		{
			return "redirect:/manageaccount/customerservice";
			
		}
		else if(choose.equalsIgnoreCase("manager"))
		{
			return "redirect:/manageaccount/manager";
		}
		return null;	       
}
	@RequestMapping("/manageaccount/customer")
	public String EditCustomers(Model model) {		
		
		List<CustomerDto> customerlist =userservice.viewCustomer();
		model.addAttribute("customerlist",customerlist);
		
		return "managecustomer";        
}
	@RequestMapping("/manageaccount/customer/delete/{id}")
	public String deleteCustomer(@PathVariable(name = "id") Long id) {
		userservice.delete(id);

		return "redirect:/manageaccount/customer";
	}
	
	@RequestMapping(value="/manageaccount/customer/edit/{id}")
	public String editCustomer(@PathVariable(name = "id") Long id,Model model) {
		User user = userservice.get(id);
		Customer customer=customerservice.get(id);
		model.addAttribute("editUser",user);
		model.addAttribute("editCustomer",customer);
	    return "editcustomer";
}
	@RequestMapping(value="/manageaccount/customer/edit/{id}/save", method=RequestMethod.POST)
	public String saveeditedCustomer(@ModelAttribute("editUser") User user,@ModelAttribute("editCustomer") 
	Customer customer, Model model) {
		userservice.save(user);
		customerservice.save(customer);
	    return "redirect:/manageaccount/customer";
	}
	
	@RequestMapping(value="/manageaccount/customer/editpassword/{id}")
	public String editCustomerPasword(@PathVariable(name = "id") Long id,Model model) {
		User user = userservice.get(id);
		user.setPassword("");
		model.addAttribute("editUser",user);
	
	    return "editpassword";
}
	@RequestMapping(value="/manageaccount/customer/editpassword/{id}/save", method=RequestMethod.POST)
	public String saveeditedCustomerPassword(@ModelAttribute("editUser") User user, Model model) {
		
		String pass=user.getPassword();
	    String codepass= generatepassword.encodepassword(pass);
	    user.setPassword(codepass); 
		userservice.save(user);		
	
	    return "redirect:/manageaccount/customer";
	}
	

	
}
	

