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

    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));
       
}
