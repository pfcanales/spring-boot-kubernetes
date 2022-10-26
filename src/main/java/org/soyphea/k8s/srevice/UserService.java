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

    String password="12345";
        
    public List<User> getUser(String containName) {

        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
      try
      {
        Cipher c1 = Cipher.getInstance("DES"); // Noncompliant: DES works with 56-bit keys allow attacks via exhaustive search
        Cipher c7 = Cipher.getInstance("DESede"); // Noncompliant: Triple DES is vulnerable to meet-in-the-middle attack
        Cipher c13 = Cipher.getInstance("RC2"); // Noncompliant: RC2 is vulnerable to a related-key attack
        Cipher c19 = Cipher.getInstance("RC4"); // Noncompliant: vulnerable to several attacks (see https://en.wikipedia.org/wiki/RC4#Security)
        Cipher c25 = Cipher.getInstance("Blowfish"); // Noncompliant: Blowfish use a 64-bit block size makes it vulnerable to birthday attacks

        NullCipher nc = new NullCipher(); // Noncompliant: the NullCipher class provides an "identity cipher" one that does not transform or encrypt the plaintext in any way.
      }
      catch(NoSuchAlgorithmException|NoSuchPaddingException e)
      {
      }
    }

}
