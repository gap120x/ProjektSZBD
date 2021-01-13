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
import org.springframework.web.bind.annotation.RequestMethod;

import szbd.licensemanagementsystemapp.articles.Article;
import szbd.licensemanagementsystemapp.articles.ArticleService;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;
import szbd.licensemanagementsystemapp.department.DepartmentService;
import szbd.licensemanagementsystemapp.employees.Employee;
import szbd.licensemanagementsystemapp.updates.Update;
import szbd.licensemanagementsystemapp.updates.UpdateService;
import szbd.licensemanagementsystemapp.users.User;
import szbd.licensemanagementsystemapp.users.UserService;

@Controller
public class ArticleController {
	
	@Autowired
	ArticleService articleservice;
	@Autowired
	UpdateService updateservice;	
	@Autowired
	DepartmentService departmentservice;
	@Autowired
	UserService userservice;
	
	@RequestMapping("/newarticle")
	public String newArticle(Model model) {				
	
		model.addAttribute("newarticle",new Article());
		return "newarticle";        
}
	
	
	@RequestMapping(value="/newarticle/save",method=RequestMethod.POST)
	public String saveArticle(@ModelAttribute("newarticle") Article article,HttpServletRequest request)
	{		

		 Principal principal = request.getUserPrincipal();
	       User user =userservice.getUserByUsername(principal.getName());
	     Employee employee = user.getEmployee();
	     CustomerServiceUser customerserviceuser = employee.getCustomerservicesser();	   
		Update update = new Update();
		update.setDate(LocalDate.now());
		update.setCustomerserviceuser(customerserviceuser);
		update.setChanges("Stworzenie Artykułu");
		update.setArticle(article);		
		articleservice.save(article);
		updateservice.save(update);		
		return "redirect:/newarticle";	
		
	}
	
	@RequestMapping("/viewarticles")
	public String articleList(Model model) {				
	
		model.addAttribute("articlelist",articleservice.listAll());
		return "articlelist";        
}
	
	@RequestMapping("/viewarticle/details/{id}")
	public String articleList(Model model,@PathVariable(name = "id") Long id) {				
	
		Article article=articleservice.get(id);
		model.addAttribute("article",article);
		return "viewarticle";        
}
	
	@RequestMapping("/editarticles")
	public String editArticleList(Model model) {				
	
		model.addAttribute("articlelist",articleservice.listAll());
		return "editarticlelist";        
}
	
	@RequestMapping("/editarticle/delete/{id}")
	public String deleteArticle(@PathVariable(name = "id") Long id) {				
	
		articleservice.delete(id);
		return "redirect:/editarticles";        
}
	@RequestMapping("/editarticle/edit/{id}")
	public String editArticle(Model model,@PathVariable(name = "id") Long id) {				
	
		Article article =articleservice.get(id);
		model.addAttribute("editarticle",article);
		model.addAttribute("update",new Update());
		return "editarticle";        
}
	@RequestMapping(value="/editarticle/save",method=RequestMethod.POST)
	public String saveEditedArticle(@ModelAttribute("editarticle") Article article,@ModelAttribute("update") Update update,HttpServletRequest request)
	{		

		 Principal principal = request.getUserPrincipal();
	       User user =userservice.getUserByUsername(principal.getName());
	     Employee employee = user.getEmployee();
	     CustomerServiceUser customerserviceuser = employee.getCustomerservicesser();
		update.setDate(LocalDate.now());
		update.setCustomerserviceuser(customerserviceuser);	
		update.setArticle(article);		
		articleservice.save(article);
		updateservice.save(update);		
		return "redirect:/editarticles";	
		
	}



}
