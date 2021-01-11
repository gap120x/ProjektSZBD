package szbd.licensemanagementsystemapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.department.Department;
import szbd.licensemanagementsystemapp.department.DepartmentService;
import szbd.licensemanagementsystemapp.users.AccountType;
import szbd.licensemanagementsystemapp.users.User;
import szbd.licensemanagementsystemapp.users.UserService;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentservice;
	@RequestMapping("/newdepartment")
	public String newDepartment(Model model) {		
		
	
		model.addAttribute("newdepartment",new Department());
		return "newdepartment";        
}
	
	@RequestMapping(value="/newdepartment/save",method=RequestMethod.POST)
	public String saveDepartment(@ModelAttribute("newdepartment") Department department,Model model)
	{		
	
		Department departmentExists =departmentservice.getDepartmentByName(department.getName());
		if(departmentExists!=null)
		{
			model.addAttribute("newdepartment",department);
		    
		    model.addAttribute("wrongname","Istnieje już dział o podanej nazwie.");
		    return "newdepartment";
		}
		else
		{
			departmentservice.save(department);
			return "redirect:/newdepartment";
		}
}

	@RequestMapping("/departmentlist")
	public String DepartmentList(Model model) {		
		
		List <Department> departmentlist =departmentservice.listAll();
		model.addAttribute("departmentlist",departmentlist);
		return "departmentlist";        
}
	@RequestMapping("/manage/department")
	public String ManageDepartment(Model model) {		
		
		List <Department> departmentlist =departmentservice.listAll();
		model.addAttribute("departmentlist",departmentlist);
		return "managedepartment";        
}
	
	@RequestMapping("/manage/department/delete/{id}")
	public String deleteDepartment(@PathVariable(name = "id") Long id) {
		
		departmentservice.delete(id);
		return "redirect:/manage/department";
	}
	@RequestMapping(value="/manage/department/edit/{id}")
	public String editDepartment(@PathVariable(name = "id") Long id,Model model) {
	
		Department department=departmentservice.get(id);
		model.addAttribute("editDepartment",department);
	
	    return "editdepartment";
}
	@RequestMapping(value="/manage/department/edit/{id}/save", method=RequestMethod.POST)
	public String saveeditedCustomer(@ModelAttribute("editDepartment") Department department,Model model) {
		Department departmentExists =departmentservice.getDepartmentByName(department.getName());
		if(departmentExists!=null)
		{
			model.addAttribute("editDepartment",department);
		    
		    model.addAttribute("wrongname","Istnieje już dział o podanej nazwie.");
		    return "editdepartment";
		}
		else
		{
			departmentservice.save(department);
			return "redirect:/manage/department";
		}
	}
}
