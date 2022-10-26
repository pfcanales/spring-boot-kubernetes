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
    
    // Set up the environment for creating the initial context
    Hashtable<String, Object> env = new Hashtable<String, Object>();
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

    // Use anonymous authentication
    env.put(Context.SECURITY_AUTHENTICATION, "none"); // Noncompliant

    // Create the initial context
    DirContext ctx = new InitialDirContext(env);

}
