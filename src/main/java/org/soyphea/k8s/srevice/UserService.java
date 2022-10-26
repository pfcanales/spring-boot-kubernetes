package org.soyphea.k8s.srevice;

import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {  
    
    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));
    
    byte[] salt = "notrandom".getBytes();
    PBEParameterSpec cipherSpec = new PBEParameterSpec(salt, 10000); // Noncompliant, predictable salt
    PBEKeySpec spec = new PBEKeySpec(chars, salt, 10000, 256); // Noncompliant, predictable salt
    
    public List<User> getUser(String containName) {

        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }

    

}
