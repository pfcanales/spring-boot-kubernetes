package org.soyphea.k8s.srevice;

import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {  
    
    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));
       
    public List<User> getUser(String containName) {

        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }
    
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .antMatchers("/resources/**", "/signup", "/about").permitAll() // Compliant
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/admin/login").permitAll() // Noncompliant; the pattern "/admin/login" should appear before "/admin/**"
        .antMatchers("/**", "/home").permitAll()
        .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") // Noncompliant; the pattern "/db/**" should occurs before "/**"
        .and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    }

}
