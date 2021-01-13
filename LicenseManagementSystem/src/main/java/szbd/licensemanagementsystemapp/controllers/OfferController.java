package szbd.licensemanagementsystemapp.controllers;

import java.security.Principal;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;
import szbd.licensemanagementsystemapp.employees.Employee;
import szbd.licensemanagementsystemapp.offer.Offer;
import szbd.licensemanagementsystemapp.offer.OfferService;
import szbd.licensemanagementsystemapp.users.User;
import szbd.licensemanagementsystemapp.users.UserService;


@Controller
public class OfferController {

	@Autowired
	OfferService offerservice;
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/newoffer")
	public String newLicense(Model model)
	
	{
		model.addAttribute("customerlist",userservice.viewCustomer());
		model.addAttribute("newoffer",new Offer());
		return "newoffer";
		
	}
	@RequestMapping(value = "/newoffer/save")	 
    public String saveOrder(@ModelAttribute("newoffer") Offer offer,HttpServletRequest request) 
  {	        
	 Principal principal = request.getUserPrincipal();
       User user =userservice.getUserByUsername(principal.getName());
       Employee employee = user.getEmployee();
       CustomerServiceUser customerserviceuser = employee.getCustomerservicesser();
       offer.setCustomerserviceuser(customerserviceuser);
       offer.setDate(LocalDate.now());
       offerservice.save(offer);       
	   
       return "redirect:/";	     
        
    }
	@RequestMapping(value="/viemyoffers")
	public String viewmyoffer(Model model,HttpServletRequest request)
	
	{
		
		 Principal principal = request.getUserPrincipal();
	       User user =userservice.getUserByUsername(principal.getName());
	      Customer customer =user.getCustomer();	    		  
	      model.addAttribute("offerlist",offerservice.viewOfferByCustomerr(customer));
	
		return "viewoffer";
		
	}
	@RequestMapping(value="/viewmyoffers/details/{id}")
	public String viewmyoffer(Model model,@PathVariable(name = "id") Long id)
	
	{
		
		 Offer offer = offerservice.get(id);
	      model.addAttribute("offer",offer);
	
		return "viewofferdetails";
		
	}
	
	@RequestMapping(value="/customerserviceuser/viewoffers")
	public String viewOfferbyEmployee(Model model,HttpServletRequest request)
	
	{
		
		 Principal principal = request.getUserPrincipal();
	       User user =userservice.getUserByUsername(principal.getName());
	     Employee employee = user.getEmployee();
	     CustomerServiceUser customerserviceuser = employee.getCustomerservicesser();	    		 
	      model.addAttribute("offerlist",offerservice.viewOfferByCustomerserviceuserr(customerserviceuser));
	
		return "viewofferemployee";
		
	}
	
	
}
