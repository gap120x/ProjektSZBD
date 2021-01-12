package szbd.licensemanagementsystemapp.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/managesoftware")
	public String manageSoftware(Model model)
	
	{		
		model.addAttribute("softwarelist",softwareservice.listAll());		
		return "managesoftware";
		
	}
	@RequestMapping(value="/manageproduct")
	public String manageProduct(Model model)
	
	{		
		model.addAttribute("productlist",productservice.viewAllProduct());		
		return "manageproduct";
		
	}
	@RequestMapping("/managesoftware/delete/{id}")
	public String deleteSoftware(@PathVariable(name = "id") Long id) {
		softwareservice.delete(id);

		return "redirect:/managesoftware";
	}
	
	@RequestMapping(value="/managesoftware/edit/{id}")
	public String editSoftware(@PathVariable(name = "id") Long id,Model model) {
		Software software = softwareservice.get(id);	
		model.addAttribute("editSoftware",software);
	
	    return "editsoftware";
}
	
	@RequestMapping(value="/managesoftware/edit/save",method=RequestMethod.POST)
	public String saveEditSoftware(@ModelAttribute("editSoftware") Software software)
	{
			softwareservice.save(software);
			return "redirect:/managesoftware";		
		
	}
	@RequestMapping("/manageproduct/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		productservice.delete(id);

		return "redirect:/manageproduct";
	}
	
	@RequestMapping(value="/manageproduct/edit/{id}")
	public String editProduct(@PathVariable(name = "id") Long id,Model model) {
		Product product = productservice.get(id);	
		model.addAttribute("editProduct",product);
		model.addAttribute("softwarelist", softwareservice.listAll());
	    return "editproduct";
}
	
	@RequestMapping(value="/manageproduct/edit/save",method=RequestMethod.POST)
	public String saveEditProduct(@ModelAttribute("editProduct") Product product)
	{
			productservice.save(product);
			return "redirect:/manageproduct";		
		
	}

}
