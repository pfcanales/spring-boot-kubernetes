package org.soyphea.k8s.srevice;

import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

@Service
public class UserService {

    // Using HttpPost from Apache HttpClient
    String encoding = Base64Encoder.encode ("login:passwd");
    org.apache.http.client.methods.HttpPost httppost = new HttpPost(url);
    httppost.setHeader("Authorization", "Basic " + encoding);  // Noncompliant
    
    
    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));
       
    public List<User> getUser(String containName) {

        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }

}
