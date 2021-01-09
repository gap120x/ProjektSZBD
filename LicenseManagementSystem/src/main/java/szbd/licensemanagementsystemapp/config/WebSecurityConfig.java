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
        	.antMatchers("/produkt","/wyczerpaneproduktlist","/produkt/delete/{id}","/newprodukt","/newprodukt/save","/produkt/edit/{id}",
        			     "/produkt/edited/save","/produkt/editilosc","/produkt/editilosc/{id}","/produkt/editedilosc/save","/newdostawca",
        			     "/newdostawca/save","/dostawca","/dostawca/delete/{id}","/dostawca/edit/{id}","/dostawca/edited/save","/newkategoria",
        			     "/newkategoria/save","/kategoria","/kategoria/delete/{id}","/kategoria/edit/{id}","/kategoria/edited/save",
        			     "/neworder/create","/neworder/create/add","/neworder/create/add/save","/neworder/create/addprodukt/{id}","/neworder/create/addprodukt/{id}/save",
        			     "/neworder/create/addprodukt/{id}/delete/{produktid}","/neworder/create/addprodukt/{id}/error","/order/{id}/setstatusaswtrakcierealizacji",
        			     "/zamowienialist","/zamowienialist/getklient/{id}","/zamowienialist/getadres/{id}","/zamowienialist/getproduktlist/{id}","/zamowienia/manage",
        			     "/zamowienia/manage/delete/{id}","/zamowienia/manage/setstatus/{id}","/zamowienia/manage/setstatus/{id}/save","/pracowniklist",
        			     "/user/editpassword/{id}","/user/editedpassword/save","/klientlist","/newklient","/newklient/save","/klient","/klient/delete/{id}","/klient/edit/{id}",
        			     "/klient/edited/save","/klient/newadres/{id}","/newklient/saveadres","/klient/{id}/viewaddresses","/klient/deleteddresses/{id}","/klient/editadresses/{id}",
        			     "/klient/editadresses/{id}/save/{klientid}") 
        	.hasAnyRole("ADMIN","PRACOWNIK")
        	.antMatchers("/newpracownik","/newpracownik/save","/pracownik","/pracownik/edit/{id}","/pracownik/edited/save","/produktraport","/pracownikraport")
        	.hasRole("ADMIN")
        	.antMatchers("/klient/viewmyorders","/zamowienialist/myorders/getadres/{id}","/zamowienialist/myorders/getproduktlist/{id}","/klient/viewmyaccount","/klient/viewmyaddresses")
        	.hasRole("KLIENT")
          	.anyRequest().authenticated()
            .and()        
            .formLogin().permitAll()
            .and()
            .logout().permitAll()
        	 .and().exceptionHandling()
        	.accessDeniedPage("/403");
            
            
    }
}