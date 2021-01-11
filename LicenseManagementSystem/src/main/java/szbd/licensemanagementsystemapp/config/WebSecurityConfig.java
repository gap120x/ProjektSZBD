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
        	.antMatchers("/newaccount/manager","/newaccount/manager/save","/accountlist/manager","/manageaccount/manager","/manageaccount/manager/edit/{id}",
        				 "/manageaccount/manager/edit/{id}/save","/newdepartment","/newdepartment/save","/departmentlist","/manage/department","/manage/department/delete/{id}",
        				 "/manage/department/edit/{id}","/manage/department/edit/{id}/save") 
        	.hasRole("ADMIN")
        	.antMatchers()
        	.hasAnyRole("ADMIN","MANAGER")
          	.anyRequest().authenticated()
            .and()        
            .formLogin().permitAll()
            .and()
            .logout().permitAll()
        	 .and().exceptionHandling()
        	.accessDeniedPage("/403");
            
            
    }
}