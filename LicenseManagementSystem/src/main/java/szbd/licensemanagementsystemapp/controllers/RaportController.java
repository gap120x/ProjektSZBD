package szbd.licensemanagementsystemapp.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import antlr.collections.List;
import szbd.licensemanagementsystemapp.department.Department;
import szbd.licensemanagementsystemapp.department.DepartmentService;
import szbd.licensemanagementsystemapp.employees.Employee;
import szbd.licensemanagementsystemapp.users.DataBeetwen;
import szbd.licensemanagementsystemapp.users.User;
import szbd.licensemanagementsystemapp.users.UserService;
import szbd.licensemanagementsystemapp.customerserviceusers.EmployeeRaportDto;
@Controller
public class RaportController {
	
	
	@Autowired
	UserService userservice;
	@Autowired
	DepartmentService departmentservice;
	
	
	  @RequestMapping(value="/mydepartment/viewraport")
			public String ViewRaportByManager(@ModelAttribute("data") DataBeetwen databetween,Model model,HttpServletRequest request)
					
			{
			
		  Principal principal = request.getUserPrincipal();
		       User user =userservice.getUserByUsername(principal.getName());
		       Employee employee = user.getEmployee();
		       Department department = employee.getDepartment();  
		       model.addAttribute("data",new DataBeetwen());
				model.addAttribute("raportlist",userservice.getEmployeesRaport(databetween.getStart(),databetween.getEnd(),department.getName()));
				return "viewraportbymanager";
			}
	  
	  @RequestMapping(value="/viewraport")
		public String ViewRaportByAdmin(@ModelAttribute("data") DataBeetwen databetween,@ModelAttribute("department") Department department,Model model)
				
		{
		
		  model.addAttribute("departmentlist",departmentservice.listAll());
		  model.addAttribute("data",new DataBeetwen());
		  model.addAttribute("raportlist",userservice.getEmployeesRaport(databetween.getStart(),databetween.getEnd(),department.getName()));
		  return "viewraportbyadmin";
		}
		
	

}
