package org.soyphea.k8s.srevice;

import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {  

    public void run(javax.servlet.http.HttpServletRequest request) throws ClassNotFoundException {
        String name = request.getParameter("name");
        Class clazz = Class.forName(name);  // Noncompliant
    }
    
    
    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));
       
    public List<User> getUser(String containName) {
        
        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }
    
}
