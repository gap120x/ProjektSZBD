package szbd.licensemanagementsystemapp.controllers;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customers.CustomerDto;
import szbd.licensemanagementsystemapp.customers.CustomerService;
import szbd.licensemanagementsystemapp.employees.Employee;
import szbd.licensemanagementsystemapp.orders.Order;
import szbd.licensemanagementsystemapp.orders.OrderService;
import szbd.licensemanagementsystemapp.productlists.ProductList;
import szbd.licensemanagementsystemapp.productlists.ProductListDto;
import szbd.licensemanagementsystemapp.productlists.ProductListService;
import szbd.licensemanagementsystemapp.products.Product;
import szbd.licensemanagementsystemapp.products.ProductDto;
import szbd.licensemanagementsystemapp.products.ProductService;
import szbd.licensemanagementsystemapp.users.UserService;
import szbd.licensemanagementsystemapp.users.User;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;

@Controller
public class OrderController {
	@Autowired
	UserService userservice;
	@Autowired
	CustomerService customerservice;
	@Autowired
	OrderService orderservice;
	@Autowired
	ProductService productservice;
	@Autowired
	ProductListService productlistservice;
	
	@RequestMapping(value="/neworder/create")
	public String addKlientOrder(Model model) {
	    model.addAttribute("newOrder", new Order());
	    List<CustomerDto> customer = userservice.viewCustomer();	   
	    model.addAttribute("customerlist",customer);
	   	    return "orderchoosecustomer";
	}
	
	 @RequestMapping(value = "/neworder/create/save")	 
	    public String saveOrder(@ModelAttribute("newOrder") Order order,HttpServletRequest request) 
	  {	        
		 Principal principal = request.getUserPrincipal();
	       User user =userservice.getUserByUsername(principal.getName());
	       Employee employee = user.getEmployee();
	       CustomerServiceUser customerserviceuser = employee.getCustomerservicesser();
		   order.setCustomerserviceuser(customerserviceuser);
	       order.setOrderdate(LocalDate.now());	     
	       order.setTotalprice(0.0f);
		  orderservice.save(order);
		  long id=orderservice.maxid();
	       return "redirect:/neworder/create/addproduct/"+id;	     
	        
	    }
	 
	 @RequestMapping(value = "/neworder/create/addproduct/{id}")	 
	    public String AddProducttoOrder(@PathVariable(name = "id") Long id,Model model) 
	  {	     
		  	Order order = orderservice.get(id);
		  	 List <ProductListDto> productlistonorder =productlistservice.ProductListonOrder(order);
		  	ProductList newProductList =new ProductList();
		  	newProductList.setOrder(order);
		  	List<ProductDto> productlist = productservice.viewAllProduct();
		  	model.addAttribute("productlist",productlist);
		    model.addAttribute("newProductList", newProductList);
		  model.addAttribute("productlistonorder",productlistonorder);		 
	       return "addproductorder";	     
	        
	    }
	 
	  @RequestMapping(value = "/neworder/create/addproduct/{id}/save",method=RequestMethod.POST)	 
	    public String SaveProduct(@PathVariable(name = "id") Long orderid,@ModelAttribute("newProductList") ProductList productList) 
	  {	        
		  
		  	productList.setId(null);
		  	Product p=productList.getProduct();	
		  	int quantity=productList.getQuantity();
		  	String currency = p.getCurrency();
			Order order = orderservice.get(orderid);			
		  	float price=p.getPrice();
		  	if(currency.equals("EUR"))
		  	{
		  		float totalprice=price*4.2f*quantity;
		  		productList.setPrice(price*4.2f);
		  		productList.setTotalprice(totalprice);		  		
		  		order.setTotalprice(order.getTotalprice()+totalprice);
		  	}
		  	else if(currency.equals("USD"))
		  	{
		  		float totalprice=price*3.27f*quantity;
		  		productList.setPrice(price*3.7f);
		  		productList.setTotalprice(totalprice);		  		
		  		order.setTotalprice(order.getTotalprice()+totalprice);
		  	}
		  	else if(currency.equals("PLN"))
		  	{
		  		float totalprice=price*quantity;
		  		productList.setPrice(price);
		  		productList.setTotalprice(totalprice);		  	
		  		order.setTotalprice(order.getTotalprice()+totalprice);
		  	} 
		  	productlistservice.save(productList);  	
		  	return "redirect:/neworder/create/addproduct/{id}";	 	
			        
	    }
	  
	  @RequestMapping(value = "/neworder/create/addproduct/{id}/delete/{productid}")	 
	    public String DeleteProduct(@PathVariable(name = "id") Long id,@PathVariable(name = "productid") long productid) 
	  {	        
		  ProductList product=productlistservice.get(productid);
		 Order order = orderservice.get(id);
		  float totalprice = product.getTotalprice();
		  order.setTotalprice(order.getTotalprice()-totalprice);
		  productlistservice.delete(productid);
	       return "redirect:/neworder/create/addproduct/{id}";	     
	        
	    }
	  @RequestMapping(value = "/neworder/create/addproduct/{id}/end")	 
	    public String endOrder(@PathVariable(name = "id") Long id) 
	  {	        
		  Order order = orderservice.get(id);		 
		  order.setStatus("Oczekiwanie na płatność");
		  orderservice.save(order);
	
	       return "redirect:/";	     
	        
	    }
	  
	  @RequestMapping(value="/order/view")
		public String ViewOrder(Model model)
				
		{
			model.addAttribute("chooseclient",userservice.viewCustomer());
			model.addAttribute("customerdto",new CustomerDto(null, null, null, null, null, null, null, false, null, null, 0, null));		
			return "vieworder";
		}
		@RequestMapping(value="/order/view",method=RequestMethod.POST)
		public String ViewOrderPost(@ModelAttribute("customerdto") CustomerDto customer,Model model)
				
		{
			model.addAttribute("chooseclient",userservice.viewCustomer());
			model.addAttribute("customerdto",customer);		
			model.addAttribute("orderlist",orderservice.viewOrderByCustomerr(customerservice.get(customer.getUserid())));
		
			return "vieworder";
		}
		  @RequestMapping(value="/order/view/details/{id}")
			public String ViewOrderdetails(Model model,@PathVariable(name = "id") Long id)
					
			{
			  Order order = orderservice.get(id);
			  List <ProductListDto> productlistonorder =productlistservice.ProductListonOrder(order);
			  model.addAttribute("productlistonorder",productlistonorder);
				return "vieworderdetails";
			}
		  
			@RequestMapping(value="/viewmyorders")
			public String viewOrderByCustomer(Model model,HttpServletRequest request)
					
			{
				Principal principal = request.getUserPrincipal();
				User client = userservice.getUserByUsername(principal.getName());
				Customer customer =client.getCustomer();
				model.addAttribute("orderlist",orderservice.viewOrderByCustomerr(customer));
				return "viewordersbycustomer";
			}
			
			 @RequestMapping(value="/order/manage")
				public String manageOrder(Model model)
						
				{
					model.addAttribute("chooseclient",userservice.viewCustomer());
					model.addAttribute("customerdto",new CustomerDto(null, null, null, null, null, null, null, false, null, null, 0, null));		
					return "manageorder";
				}
				@RequestMapping(value="/order/manage",method=RequestMethod.POST)
				public String manageOrderPost(@ModelAttribute("customerdto") CustomerDto customer,Model model)
						
				{
					model.addAttribute("chooseclient",userservice.viewCustomer());
					model.addAttribute("customerdto",customer);		
					model.addAttribute("orderlist",orderservice.viewOrderByCustomerr(customerservice.get(customer.getUserid())));
					return "manageorder";
				
				}
				
				@RequestMapping("/order/manage/delete/{id}")
				public String deleteOrder(@PathVariable(name = "id") Long id) {
					orderservice.delete(id);

					return "redirect:/order/manage";
				}
				
				@RequestMapping(value = "/order/manage/setstatus/{id}")	 
			    public String setStatusOrder(@PathVariable(name = "id") Long id,Model model) 
			  {	        
					Order order = orderservice.get(id);
					model.addAttribute("orderstatus",order);
					
			       return "setorderstatus";	     
			        
			  }
				
				@RequestMapping("/order/manage/setstatus/{id}/save")
				public String saveOrderStatus(@ModelAttribute("orderstatus") Order order) 
				{
					orderservice.save(order);
					
					 return "redirect:/order/manage";	   
			        
			}
	 
	 
	 

}
