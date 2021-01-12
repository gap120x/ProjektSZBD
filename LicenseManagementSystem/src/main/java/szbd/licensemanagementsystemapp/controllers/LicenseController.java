package szbd.licensemanagementsystemapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customers.CustomerDto;
import szbd.licensemanagementsystemapp.customers.CustomerService;
import szbd.licensemanagementsystemapp.licenses.License;
import szbd.licensemanagementsystemapp.licenses.LicenseService;
import szbd.licensemanagementsystemapp.products.ProductService;
import szbd.licensemanagementsystemapp.users.User;
import szbd.licensemanagementsystemapp.users.UserService;


@Controller
public class LicenseController {
	@Autowired
	LicenseService licenseservice;
	@Autowired
	UserService userservice;
	@Autowired
	CustomerService customerservice;
	@Autowired
	ProductService productservice;
	
	@RequestMapping(value="/newlicense")
	public String newLicense(Model model)
	
	{
		model.addAttribute("newLicense",new License());		
		model.addAttribute("clientlist",userservice.viewCustomer());
		model.addAttribute("productlist",productservice.viewAllProduct());
		return "newlicense";
		
	}
	@RequestMapping(value="/newlicense/save",method=RequestMethod.POST)
	public String saveNewLicense(@ModelAttribute("newLicense") License license)
			
	{
		licenseservice.save(license);
		return "redirect:/newlicense";
	}
	@RequestMapping(value="/license/view")
	public String ViewLicense(Model model)
			
	{
		model.addAttribute("chooseclient",userservice.viewCustomer());
		model.addAttribute("customerdto",new CustomerDto(null, null, null, null, null, null, null, false, null, null, 0, null));		
		return "viewlicense";
	}
	@RequestMapping(value="/license/view",method=RequestMethod.POST)
	public String ViewLicensePost(@ModelAttribute("customerdto") CustomerDto customer,Model model)
			
	{
		model.addAttribute("chooseclient",userservice.viewCustomer());
		model.addAttribute("customerdto",customer);		
		model.addAttribute("licenselist",licenseservice.viewLicenseByCustomer(customerservice.get(customer.getUserid())));
		return "viewlicense";
	}
	@RequestMapping(value="/license/manage")
	public String manageLicense(Model model)
			
	{
		model.addAttribute("chooseclient",userservice.viewCustomer());
		model.addAttribute("customerdto",new CustomerDto(null, null, null, null, null, null, null, false, null, null, 0, null));		
		return "managelicense";
	}
	@RequestMapping(value="/license/manage",method=RequestMethod.POST)
	public String manageLicensePost(@ModelAttribute("customerdto") CustomerDto customer,Model model)
			
	{
		model.addAttribute("chooseclient",userservice.viewCustomer());
		model.addAttribute("customerdto",customer);		
		model.addAttribute("licenselist",licenseservice.viewLicenseByCustomer(customerservice.get(customer.getUserid())));
		return "managelicense";
	}
	@RequestMapping("/license/manage/delete/{id}")
	public String deleteCustomer(@PathVariable(name = "id") Long id) {
		licenseservice.delete(id);

		return "redirect:/license/manage";
	}
	
	@RequestMapping(value="/license/manage/edit/{id}")
	public String editLicense(@PathVariable(name = "id") Long id,Model model) {
	
		License license = licenseservice.get(id);		
		model.addAttribute("clientlist",userservice.viewCustomer());
		model.addAttribute("productlist",productservice.viewAllProduct());
		model.addAttribute("editLicense",license);
		
	    return "editlicense";
}
	@RequestMapping(value="/license/manage/edit/{id}/save", method=RequestMethod.POST)
	public String saveeditedLicense(@ModelAttribute("editLicense") License license) {
		
		licenseservice.save(license);
		return "redirect:/license/manage";
	}
	
	

	
	}


