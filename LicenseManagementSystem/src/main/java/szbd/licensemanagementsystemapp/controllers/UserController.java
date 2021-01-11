package szbd.licensemanagementsystemapp.controllers;



import szbd.licensemanagementsystemapp.adress.BillingAddress;
import szbd.licensemanagementsystemapp.adress.BillingAddressService;
import szbd.licensemanagementsystemapp.config.PasswordGenerator;
import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customers.CustomerDto;
import szbd.licensemanagementsystemapp.customers.CustomerService;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUserService;
import szbd.licensemanagementsystemapp.department.Department;
import szbd.licensemanagementsystemapp.department.DepartmentService;
import szbd.licensemanagementsystemapp.employees.Employee;
import szbd.licensemanagementsystemapp.employees.EmployeeService;
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
	@Autowired
	BillingAddressService adresservice;
	@Autowired
	EmployeeService employeeservice;
	@Autowired
	CustomerServiceUserService customerserviceuserservice;
	@Autowired
	DepartmentService departmentservice;
	

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
	
	@RequestMapping(value="/manageaccount/customer/editaddress/{id}")
	public String editCustomeraddres(@PathVariable(name = "id") Long id,Model model) {
	
		Customer customer = customerservice.get(id);
		customer.getBillingaddress();
		if(	customer.getBillingaddress()!=null)
		{
			model.addAttribute("address",customer.getBillingaddress());
		}
		else
		{
			model.addAttribute("address",new BillingAddress());
		}
		model.addAttribute("customerid",id);
	
	    return "editaddress";
}
	@RequestMapping(value="/manageaccount/customer/editaddress/{id}/save", method=RequestMethod.POST)
	public String SaveAddress(@PathVariable(name = "id") Long id,@ModelAttribute("address") BillingAddress billingAddress, Model model) {
		
		adresservice.save(billingAddress);
		Customer customer = customerservice.get(id);
		customer.setBillingaddress(billingAddress);
		customerservice.save(customer);
	
	    return "redirect:/manageaccount/customer";
	}
	@RequestMapping(value="/manageaccount/customer/viewaddress/{id}")
	public String viewCustomeraddres(@PathVariable(name = "id") Long id,Model model) {
	
		Customer customer = customerservice.get(id);
		BillingAddress billingAddress=customer.getBillingaddress();	
		model.addAttribute("customeradres",billingAddress);
	
	    return "viewaddress";
}
	
	@RequestMapping(value="/newaccount/customerservice")
public String newCustomerServiceUser(Model model) {
		
		model.addAttribute("newUser",new User());
		model.addAttribute("newEmployee",new Employee());
		model.addAttribute("newCustomerServiceUser",new CustomerServiceUser());
		List<Department> departmentlist =departmentservice.listAll();
		model.addAttribute("departmentlist",departmentlist);
		
	    return "newcustomerserviceuser";
	}
	
	@RequestMapping(value="/newaccount/customerserviceuser/save",method=RequestMethod.POST)
	public String saveCustomerServiceUser(@ModelAttribute("newUser") User user,@ModelAttribute("newEmployee") Employee employee,
			@ModelAttribute("newCustomerServiceUser")CustomerServiceUser customerserviceuser,Model model)
	{
		
		
		User userExists = userservice.getUserByUsername(user.getNickname());
		if(userExists != null)
		{
			model.addAttribute("newUser",user);
		    model.addAttribute("newEmployee",employee);
		    model.addAttribute("newCustomerServiceUser",customerserviceuser);
		    List<Department> departmentlist =departmentservice.listAll();
			model.addAttribute("departmentlist",departmentlist);
		    model.addAttribute("wrongusername","Nazwa Którą wpisałeś jest zajęta! Użyj innej.");
		    return "newcustomerserviceuser";
		}
		else
		{
			
		employee.setUser(user);
		customerserviceuser.setEmployee(employee);
		String pass=user.getPassword();
	    String codepass= generatepassword.encodepassword(pass);
	    user.setPassword(codepass); 
		userservice.save(user);		
		employeeservice.save(employee);
		customerserviceuserservice.save(customerserviceuser);
		return "redirect:/newaccount";
		}
	


}
	

	
}
	

