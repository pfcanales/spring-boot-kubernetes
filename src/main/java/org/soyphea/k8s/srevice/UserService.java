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

        SecureRandom sr = new SecureRandom();
        //sr.setSeed(123456L); // Noncompliant
        //int v = sr.next(32);

        //sr = new SecureRandom("abcdefghijklmnop".getBytes("us-ascii")); // Noncompliant
        //v = sr.next(32);
        
        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }
    

}
