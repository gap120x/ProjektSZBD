package szbd.licensemanagementsystemapp.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import szbd.licensemanagementsystemapp.users.UserService;

 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/newaccount","/newaccount/manager","/accountlist","/newaccount/manager/save","/accountlist/manager","/manageaccount/manager","/manageaccount/manager/edit/{id}",
        				 "/manageaccount/manager/edit/{id}/save","/newdepartment","/newdepartment/save","/departmentlist","/manage/department","/manage/department/delete/{id}",
        				 "/manage/department/edit/{id}","/manage/department/edit/{id}/save","/manageaccount","/newdepartment","/newdepartment/save","/departmentlist",
        				 "/manage/department","/manage/department/delete/{id}","/manage/department/edit/{id}","/manage/department/edit/{id}/save","/viewraport") 
        	.hasRole("ADMIN")
        	.antMatchers("/newaccount/customerservice","/newaccount/customerserviceuser/save","/accountlist/customerservice","/manageaccount/customerservice",
        				 "/manageaccount/customerservice/delete/{id}","/manageaccount/customerservice/edit/{id}","/manageaccount/customerservice/edit/{id}/save",
        				 "/mydepartment/customerservicelist","/mydepartment/newcustomerserviceuser","mydepartment/newaccountcustomerserviceuser/save","mydepartment/manageaccount/customerservice")
        	.hasAnyRole("ADMIN","MANAGER")
        	.antMatchers("/accountlist/customer","/manageaccount/customer","/manageaccount/customer/delete/{id}","/manageaccount/customer/edit/{id}","/manageaccount/customer/edit/{id}/save"
        				 ,"/manageaccount/editpassword/{id}","/manageaccount/editpassword/{id}/save","/manageaccount/customer/editaddress/{id}","/manageaccount/customer/editaddress/{id}/save"
        				 ,"/newsoftware","/newsoftware/save","/newproduct","/newproduct/save","/softwarelist","/productlist","/managesoftware","/manageproduct",
        				  "/managesoftware/delete/{id}","/managesoftware/edit/{id}","/managesoftware/edit/save","/manageproduct/delete/{id}","/manageproduct/edit/{id}",
        				  "/manageproduct/edit/save","/newlicense","/license/view","/license/manage","/license/manage/delete/{id}","/license/manage/edit/{id}",
        				  "/license/manage/edit/{id}/save","/neworder/create","/neworder/create/save","/neworder/create/addproduct/{id}","/neworder/create/addproduct/{id}/save",
        				  "/neworder/create/addproduct/{id}/delete/{productid}","/neworder/create/addproduct/{id}/end","/order/view","/order/manage","/order/manage/delete/{id}",
        				  "/order/manage/setstatus/{id}","/order/manage/setstatus/{id}/save","/newarticle","/newarticle/save","/viewarticles","/viewarticle/details/{id}",
        				  "/editarticles","/editarticle/delete/{id}","/editarticle/edit/{id}","/editarticle/save","/newoffer","/newoffer/save","/customerserviceuser/viewoffers"
        				  ,"/customerserviceuser/manageoffers","/customerserviceuser/manageoffers/delete/{id}")
        	.hasAnyRole("ADMIN","MANAGER","CUSTOMERSERVICEUSER","/customerserviceuser/manageoffers/edit/{id}","/editoffer/save")
        	.antMatchers("/viewmylicense","/viewmyorders","/viemyoffers")
        	.hasAnyRole("CUSTOMER")
        	.antMatchers("/mydepartment/viewraport")
        	.hasRole("MANAGER")
          	.anyRequest().authenticated()
            .and()        
            .formLogin().permitAll()
            .and()
            .logout().permitAll()
        	 .and().exceptionHandling()
        	.accessDeniedPage("/403");
            
            
    }
}