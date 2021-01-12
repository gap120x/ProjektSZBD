package szbd.licensemanagementsystemapp.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.products.Product;
import szbd.licensemanagementsystemapp.products.ProductService;
import szbd.licensemanagementsystemapp.softwares.Software;
import szbd.licensemanagementsystemapp.softwares.SoftwareService;
import szbd.licensemanagementsystemapp.users.User;


@Controller
public class ProductController {
	
	@Autowired
	SoftwareService softwareservice;
	@Autowired
	ProductService productservice;
	
	@RequestMapping(value="/newsoftware")
	public String newSoftware(Model model)
	
	{
		model.addAttribute("newSoftware",new Software());		
		return "newsoftware";
		
	}
	@RequestMapping(value="/newsoftware/save",method=RequestMethod.POST)
	public String saveNewSoftware(@ModelAttribute("newSoftware") Software software,
			Model model)
	{
			softwareservice.save(software);
			return "redirect:/newsoftware";		
		
	}
	
	@RequestMapping(value="/newproduct")
	public String newProduct(Model model)
	
	{
		model.addAttribute("newProduct",new Product());
		model.addAttribute("softwarelist", softwareservice.listAll());
		return "newproduct";
		
	}
	@RequestMapping(value="/newproduct/save",method=RequestMethod.POST)
	public String saveNewProduct(@ModelAttribute("newProduct") Product product,
			Model model)
	{
			productservice.save(product);
			return "redirect:/newproduct";		
		
	}
	@RequestMapping(value="/softwarelist")
	public String softwareList(Model model)
	
	{		
		model.addAttribute("softwarelist",softwareservice.listAll());		
		return "softwarelist";
		
	}
	@RequestMapping(value="/productlist")
	public String productList(Model model)
	
	{		
		model.addAttribute("productlist",productservice.viewAllProduct());		
		return "productlist";
		
	}

}
